package basic_caculator_iv_981

import (
	"fmt"
	"testing"
)

func TestTerm_MultWith(t *testing.T) {
	tests := []struct {
		name   string
		a      Term
		b      Term
		result Term
	}{
		{
			name: "normal",
			a: Term{
				Const: 3,
				Vars:  []string{"a", "b", "c"},
			},
			b: Term{
				Const: -5,
				Vars:  []string{"d", "a", "c"},
			},
			result: Term{
				Const: -15,
				Vars:  []string{"a", "a", "b", "c", "c", "d"},
			},
		},
		{
			name: "const",
			a: Term{
				Const: 3,
				Vars:  []string{},
			},
			b: Term{
				Const: -5,
				Vars:  []string{"a", "b", "c"},
			},
			result: Term{
				Const: -15,
				Vars:  []string{"a", "b", "c"},
			},
		},
	}
	for _, test := range tests {
		t.Run(test.name, func(t *testing.T) {
			c := test.a.MultWith(&test.b)
			if c.Const != test.result.Const || !c.IsHomogenousOf(&test.result) {
				t.Fatalf("actural %s \n\n expected %s", c, &test.result)
			}
		})
	}
}

func TestBracket_Simplify(t *testing.T) {
	tests := []struct {
		name    string
		bracket Bracket
		result  []*Term
	}{
		{
			name: "case 1",
			bracket: Bracket{Terms: []*Term{
				{Const: 1, Vars: []string{}},
				{Const: 8, Vars: []string{}},
				{Const: 5, Vars: []string{}},
				{Const: -1, Vars: []string{"a"}},
			}},
			result: []*Term{
				{Const: -1, Vars: []string{"a"}},
				{Const: 14, Vars: []string{}},
			},
		},
		{
			name: "case 2",
			bracket: Bracket{Terms: []*Term{
				{Const: 1, Vars: []string{}},
				{Const: -8, Vars: []string{}},
				{Const: 12, Vars: []string{}},
				{Const: -1, Vars: []string{"pressure"}},
			}},
			result: []*Term{
				{Const: -1, Vars: []string{"pressure"}},
				{Const: 5, Vars: []string{}},
			},
		},
		{
			name: "case 4",
			bracket: Bracket{Terms: []*Term{
				{Const: 7, Vars: []string{}},
				{Const: -7, Vars: []string{}},
			}},
		},
	}
	for _, test := range tests {
		t.Run(test.name, func(t *testing.T) {
			terms := test.bracket.Simplify().Terms
			if len(terms) != len(test.result) {
				t.Fatalf("actural: %s \n\n expected: %s", terms, test.result)
			}
			for i := 0; i < len(terms); i++ {
				if terms[i].String() != test.result[i].String() {
					t.Fatalf("actural: %s \n\n expected: %s", terms, test.result)
				}
			}
			fmt.Println(terms)
		})
	}
}

func TestBracket_MultWithBracket(t *testing.T) {
	tests := []struct {
		name   string
		a      Bracket
		b      Bracket
		result []*Term
	}{
		{
			name: "case 3",
			a: Bracket{Terms: []*Term{
				{Const: 1, Vars: []string{"e"}},
				{Const: 8, Vars: []string{}},
			}},
			b: Bracket{Terms: []*Term{
				{Const: 1, Vars: []string{"e"}},
				{Const: -8, Vars: []string{}},
			}},
			result: []*Term{
				{Const: 1, Vars: []string{"e", "e"}},
				{Const: -64, Vars: []string{}},
			},
		},
	}
	for _, test := range tests {
		t.Run(test.name, func(t *testing.T) {
			terms := test.a.Simplify().MultWithBracket(test.b.Simplify()).Simplify().Terms
			if len(terms) != len(test.result) {
				t.Fatalf("actural: %s \n\n expected: %s", terms, test.result)
			}
			for i := 0; i < len(terms); i++ {
				if terms[i].String() != test.result[i].String() {
					t.Fatalf("actural: %s \n\n expected: %s", terms, test.result)
				}
			}
			fmt.Println(terms)
		})
	}
}

func TestFullTest(t *testing.T) {
	bracket := MultBracket{ChildrenNodes: []Node{
		&AddBracket{ChildrenNodes: []Node{
			&MultBracket{ChildrenNodes: []Node{
				&AddBracket{ChildrenNodes: []Node{
					&Bracket{Terms: []*Term{
						{Const: 1, Vars: []string{"a"}},
					}},
					&Bracket{Terms: []*Term{
						{Const: -1, Vars: []string{"b"}},
					}},
				}},
				&AddBracket{ChildrenNodes: []Node{
					&Bracket{Terms: []*Term{
						{Const: 1, Vars: []string{"b"}},
					}},
					&Bracket{Terms: []*Term{
						{Const: -1, Vars: []string{"c"}},
					}},
				}},
			}},
			&AddBracket{ChildrenNodes: []Node{
				&Bracket{Terms: []*Term{
					{Const: 1, Vars: []string{"c"}},
				}},
				&Bracket{Terms: []*Term{
					{Const: -1, Vars: []string{"a"}},
				}},
			}},
		}},
		&AddBracket{ChildrenNodes: []Node{
			&AddBracket{ChildrenNodes: []Node{
				&Bracket{Terms: []*Term{
					{Const: 1, Vars: []string{"a"}},
				}},
				&Bracket{Terms: []*Term{
					{Const: -1, Vars: []string{"b"}},
				}},
			}},
			&MultBracket{ChildrenNodes: []Node{
				&AddBracket{ChildrenNodes: []Node{
					&Bracket{Terms: []*Term{
						{Const: 1, Vars: []string{"b"}},
					}},
					&Bracket{Terms: []*Term{
						{Const: -1, Vars: []string{"c"}},
					}},
				}},
				&AddBracket{ChildrenNodes: []Node{
					&Bracket{Terms: []*Term{
						{Const: 1, Vars: []string{"c"}},
					}},
					&Bracket{Terms: []*Term{
						{Const: -1, Vars: []string{"a"}},
					}},
				}},
			}},
		}},
	}}

	result := bracket.Accept(&SolutionVisitor{})
	var actural []string
	expected := []string{"-1*a*a*b*b", "2*a*a*b*c", "-1*a*a*c*c", "1*a*b*b*b", "-1*a*b*b*c", "-1*a*b*c*c", "1*a*c*c*c", "-1*b*b*b*c", "2*b*b*c*c", "-1*b*c*c*c", "2*a*a*b", "-2*a*a*c", "-2*a*b*b", "2*a*c*c", "1*b*b*b", "-1*b*b*c", "1*b*c*c", "-1*c*c*c", "-1*a*a", "1*a*b", "1*a*c", "-1*b*c"}
	for _, term := range result.Terms {
		actural = append(actural, term.String())
	}
	for i := 0; i < len(actural); i++ {
		if actural[i] != expected[i] {
			t.Fatalf("actural: %s \n\n expected: %s", actural, expected)
		}
	}
}

func TestBasicCalculatorIV(t *testing.T) {
	tests := []struct {
		name       string
		expression string
		evalvars   []string
		evalints   []int
		expect     []string
	}{
		{
			name:       "case 1",
			expression: "e + 8 - a + 5",
			evalvars:   []string{"e"},
			evalints:   []int{1},
			expect:     []string{"-1*a", "14"},
		},
		{
			name:       "case 2",
			expression: "e - 8 + temperature - pressure",
			evalvars:   []string{"e", "temperature"},
			evalints:   []int{1, 12},
			expect:     []string{"-1*pressure", "5"},
		},
		{
			name:       "case 3",
			expression: "(e + 8) * (e - 8)",
			evalvars:   []string{},
			evalints:   []int{},
			expect:     []string{"1*e*e", "-64"},
		},
		{
			name:       "case 4",
			expression: "7 - 7",
			evalvars:   []string{},
			evalints:   []int{},
			expect:     []string{},
		},
		{
			name:       "case 5",
			expression: "a * b * c + b * a * c * 4",
			evalvars:   []string{},
			evalints:   []int{},
			expect:     []string{"5*a*b*c"},
		},
		{
			name:       "case 6",
			expression: "((a - b) * (b - c) + (c - a)) * ((a - b) + (b - c) * (c - a))",
			evalvars:   []string{},
			evalints:   []int{},
			expect:     []string{"-1*a*a*b*b", "2*a*a*b*c", "-1*a*a*c*c", "1*a*b*b*b", "-1*a*b*b*c", "-1*a*b*c*c", "1*a*c*c*c", "-1*b*b*b*c", "2*b*b*c*c", "-1*b*c*c*c", "2*a*a*b", "-2*a*a*c", "-2*a*b*b", "2*a*c*c", "1*b*b*b", "-1*b*b*c", "1*b*c*c", "-1*c*c*c", "-1*a*a", "1*a*b", "1*a*c", "-1*b*c"},
		},
		{
			name:       "case wrong",
			expression: "((bm - bq - 8 - 3) * (by - 0 - 0) + (ae + ch) + 9) - (bq - cv) * (0 - bg * 5) - cv * (n + (q + 2) * (ag + 0 - 4) + 1)",
			evalvars:   []string{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "aa", "ab", "ac", "ad", "ae", "af", "ag", "ah", "ai", "aj", "ak", "al", "am", "an", "ao", "ap", "aq", "ar", "as", "at", "au", "av", "aw", "ax", "ay", "az", "ba", "bb", "bc", "bd", "be", "bf", "bg", "bh", "bi", "bj", "bk", "bl", "bm", "bn", "bo", "bp", "bq", "br", "bs", "bt", "bu", "bv", "bw", "bx", "by", "bz", "ca", "cb", "cc", "cd", "ce", "cf", "cg", "ch", "ci", "cj", "ck", "cl", "cm", "cn", "co", "cp", "cq", "cr", "cs", "ct", "cu", "cv"},
			evalints:   []int{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 5, 6, 7, 8, 9, 10, 11, 12, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 0, 1, 2, 3, 4, 10, 11, 12, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
			expect:     []string{"-499"},
		},
	}
	for _, test := range tests {
		t.Run(test.name, func(t *testing.T) {
			actural := BasicCalculatorIV(test.expression, test.evalvars, test.evalints)
			for i := 0; i < len(actural); i++ {
				if actural[i] != test.expect[i] {
					t.Fatalf("actural: %s \n\n expected: %s", actural, test.expect)
				}
			}
			fmt.Printf("%s: %s\n", test.name, actural)
		})
	}
}
