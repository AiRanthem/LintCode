package basic_caculator_iv_981

import (
	"bufio"
	"container/list"
	"fmt"
	"sort"
	"strconv"
	"strings"
	"sync"
)

// Visitor will return a Node simplified with Visit
type Visitor interface {
	Visit(node Node) *Bracket
	VisitAdd(node *AddBracket) *Bracket
	VisitMult(node *MultBracket) *Bracket
	VisitBracket(node *Bracket) *Bracket
}

type Node interface {
	Accept(visitor Visitor) *Bracket // Accept will call visitor.Visit(Node)
	Children() []Node
	Len() int
	Negate()
}

// Term is a simple expression like | "-a" | "3" | "3b" | "5c^2" |
type Term struct {
	Const int      // non zero
	Vars  []string // Vars are sorted
}

func (t *Term) IsHomogenousOf(another *Term) bool {
	if len(t.Vars) != len(another.Vars) {
		return false
	}
	for i := 0; i < len(t.Vars); i++ {
		if t.Vars[i] != another.Vars[i] {
			return false
		}
	}
	return true
}

func (t *Term) MultWith(another *Term) *Term {
	var result Term
	result.Vars = append(result.Vars, t.Vars...)
	result.Vars = append(result.Vars, another.Vars...)
	sort.Strings(result.Vars)
	result.Const = t.Const * another.Const
	return &result
}

func (t *Term) Before(another *Term) bool {
	if len(t.Vars) != len(another.Vars) {
		return len(t.Vars) > len(another.Vars)
	}
	for i := 0; i < len(t.Vars); i++ {
		if t.Vars[i] != another.Vars[i] {
			return t.Vars[i] < another.Vars[i]
		}
	}
	return false
}

func (t *Term) String() string {
	vars := []string{strconv.Itoa(t.Const)}
	vars = append(vars, t.Vars...)
	return strings.Join(vars, "*")
}

// Bracket is a set of additive Terms like | "3 + 2a" | "4 - 3b^2" | "5 + 3a - 4a" |
type Bracket struct {
	Terms []*Term // Terms are sorted by Vars
}

func (b *Bracket) Negate() {
	for _, term := range b.Terms {
		term.Const = -term.Const
	}
}

func (b *Bracket) Children() []Node {
	return []Node{}
}

func (b *Bracket) Len() int {
	return 0
}

func (b *Bracket) Accept(visitor Visitor) *Bracket {
	return visitor.VisitBracket(b)
}

// Simplify is called only when b.Terms are sorted
func (b *Bracket) Simplify() *Bracket {
	if len(b.Terms) == 0 {
		return b
	}
	sort.Slice(b.Terms, func(i, j int) bool {
		return b.Terms[i].Before(b.Terms[j])
	})
	if len(b.Terms) == 1 {
		return b
	}
	var results []*Term
	cur := b.Terms[0]
	for _, next := range b.Terms[1:] {
		if cur.IsHomogenousOf(next) {
			cur.Const += next.Const
		} else {
			if cur.Const != 0 {
				results = append(results, cur)
			}
			cur = next
		}
	}
	if cur.Const != 0 {
		results = append(results, cur)
	}
	return &Bracket{results}
}

func (b *Bracket) ApplyParams(param map[string]int) []string {
	for _, term := range b.Terms {
		newConst := term.Const
		var newVars []string
		i := 0
		for ; i < len(term.Vars); i++ {
			applied := false
			for j := len(term.Vars); j > i; j-- {
				evalparam := strings.Join(term.Vars[i:j], "")
				if evalval, ok := param[evalparam]; ok {
					newConst *= evalval
					i = j - 1
					applied = true
					break
				}
			}
			if !applied {
				newVars = append(newVars, term.Vars[i])
			}
		}
		term.Const = newConst
		term.Vars = newVars
	}
	result := make([]string, 0)
	for _, term := range b.Simplify().Terms {
		result = append(result, term.String())
	}
	return result
}

func (b *Bracket) MultWithTerm(another *Term) []*Term {
	var result []*Term
	if another.Const != 0 {
		for _, term := range b.Terms {
			result = append(result, term.MultWith(another))
		}
	}
	return result
}

func (b *Bracket) MultWithBracket(another *Bracket) *Bracket {
	var result Bracket
	for _, term := range another.Terms {
		result.Terms = append(result.Terms, b.MultWithTerm(term)...)
	}
	return &result
}

// MultBracket is a set of multiplication Node, which must have at least 2 ChildrenNodes
type MultBracket struct {
	ChildrenNodes []Node
}

func (m *MultBracket) Negate() {
	for _, node := range m.ChildrenNodes {
		node.Negate()
	}
}

func (m *MultBracket) Children() []Node {
	return m.ChildrenNodes
}

func (m *MultBracket) Len() int {
	return len(m.ChildrenNodes)
}

func (m *MultBracket) Accept(visitor Visitor) *Bracket {
	return visitor.VisitMult(m)
}

// AddBracket is a set of addition Node, which must have at least 1 ChildrenNodes
type AddBracket struct {
	ChildrenNodes []Node
}

func (a *AddBracket) Negate() {
	for _, node := range a.ChildrenNodes {
		node.Negate()
	}
}

func (a *AddBracket) Children() []Node {
	return a.ChildrenNodes
}

func (a *AddBracket) Len() int {
	return len(a.ChildrenNodes)
}

func (a *AddBracket) Accept(visitor Visitor) *Bracket {
	return visitor.VisitAdd(a)
}

type SolutionVisitor struct{}

func (v *SolutionVisitor) VisitChildrenConcurrently(node Node) []*Bracket {
	brackets := make([]*Bracket, node.Len())
	var wg sync.WaitGroup
	wg.Add(node.Len())
	for i, child := range node.Children() {
		go func(i int, child Node) {
			defer wg.Done()
			brackets[i] = v.Visit(child)
		}(i, child)
	}
	wg.Wait()
	return brackets
}

func (v *SolutionVisitor) Visit(node Node) *Bracket {
	return node.Accept(v)
}

func (v *SolutionVisitor) VisitAdd(node *AddBracket) *Bracket {
	var result Bracket
	simplified := v.VisitChildrenConcurrently(node)
	for _, bracket := range simplified {
		result.Terms = append(result.Terms, bracket.Terms...)
	}
	return result.Simplify()
}

func (v *SolutionVisitor) VisitMult(node *MultBracket) *Bracket {
	simplified := v.VisitChildrenConcurrently(node)
	result := simplified[0]
	for _, next := range simplified[1:] {
		result = result.MultWithBracket(next)
	}
	return result.Simplify()
}

func (v *SolutionVisitor) VisitBracket(node *Bracket) *Bracket {
	return node.Simplify()
}

type Operator struct {
	Priority int
}

var (
	ADD  = &Operator{0}
	SUB  = &Operator{0}
	MUL  = &Operator{1}
	LEFT = &Operator{-1}
)

type Stack[T any] struct {
	list *list.List
}

func NewStack[T any]() *Stack[T] {
	return &Stack[T]{list: list.New()}
}

func (s *Stack[T]) Top() T {
	return s.list.Back().Value.(T)
}

func (s *Stack[T]) Push(elem T) {
	s.list.PushBack(elem)
}

func (s *Stack[T]) Pop() T {
	back := s.list.Back()
	s.list.Remove(back)
	return back.Value.(T)
}

func (s *Stack[T]) Empty() bool {
	return s.list.Len() == 0
}

type Compiler struct {
	expression  string
	nodeStack   *Stack[Node]
	symbolStack *Stack[*Operator]
}

func NewCompiler(expression string) *Compiler {
	return &Compiler{
		expression:  expression,
		nodeStack:   NewStack[Node](),
		symbolStack: NewStack[*Operator](),
	}
}

// Compile will compile a bracketed expression into a Node tree
func (c *Compiler) Compile() Node {
	scanner := bufio.NewScanner(strings.NewReader(c.expression))
	scanner.Split(bufio.ScanWords)
	for scanner.Scan() {
		c.ProcessToken(scanner.Text())
	}
	return c.nodeStack.Pop()
}

func (c *Compiler) ProcessToken(token string) {
	switch token[0] {
	case '(':
		c.symbolStack.Push(LEFT)
		c.ProcessToken(token[1:])
	case ')':
		for c.symbolStack.Top() != LEFT {
			c.Reduce()
		}
		c.symbolStack.Pop()
	case '+':
		c.PushSymbol(ADD)
	case '-':
		c.PushSymbol(SUB)
	case '*':
		c.PushSymbol(MUL)
	default: // letters
		i := len(token) - 1
		for ; i > 0; i-- {
			if token[i] != ')' {
				break
			}
		}
		c.PushNode(token[:i+1])
		for j := 0; j < len(token)-1-i; j++ {
			c.ProcessToken(")")
		}
	}
}

func (c *Compiler) PushSymbol(symbol *Operator) {
	for !c.symbolStack.Empty() && symbol.Priority <= c.symbolStack.Top().Priority {
		c.Reduce()
	}
	c.symbolStack.Push(symbol)
}

func (c *Compiler) PushNode(token string) {
	var node *Bracket
	if token[0] >= '0' && token[0] <= '9' {
		con, _ := strconv.Atoi(token)
		node = &Bracket{Terms: []*Term{
			{Const: con, Vars: []string{}},
		}}
	} else {
		node = &Bracket{Terms: []*Term{
			{Const: 1, Vars: []string{token}},
		}}
	}
	c.nodeStack.Push(node)
}

func (c *Compiler) Reduce() {
	b := c.nodeStack.Pop()
	a := c.nodeStack.Pop()
	o := c.symbolStack.Pop()
	switch o {
	case SUB:
		b.Negate()
		fallthrough
	case ADD:
		c.nodeStack.Push(&AddBracket{ChildrenNodes: []Node{a, b}})
	case MUL:
		c.nodeStack.Push(&MultBracket{ChildrenNodes: []Node{a, b}})
	}
}

func BasicCalculatorIV(expression string, evalvars []string, evalints []int) []string {
	params := make(map[string]int)
	for i := 0; i < len(evalvars); i++ {
		params[evalvars[i]] = evalints[i]
	}
	compiler := NewCompiler("(" + expression + ")")
	root := compiler.Compile()
	bracket := root.Accept(&SolutionVisitor{})
	fmt.Println(bracket.Terms)
	return bracket.ApplyParams(params)
}
