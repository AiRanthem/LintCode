package add_and_search_716

import (
	"sort"
)

type HashSet map[int]struct{}

func (s HashSet) Contains(i int) (ok bool) {
	_, ok = s[i]
	return
}

func (s HashSet) Put(i int) {
	s[i] = struct{}{}
}

func AddAndSearch(inputs []int, tests []int) bool {
	if len(inputs) <= 1 {
		return false
	}
	set := HashSet{}
	for _, i := range tests {
		set.Put(i)
	}
	sort.Ints(inputs)
	var compressedInputs []int
	for i := 0; i < len(inputs); {
		largest := inputs[i]
		compressedInputs = append(compressedInputs, largest)
		if i+1 < len(inputs) && inputs[i+1] == largest {
			compressedInputs = append(compressedInputs, largest)
			i++
		}
		for i < len(inputs) && inputs[i] <= largest {
			i++
		}
	}

	foundChan := make(chan struct{}, len(compressedInputs))
	finishChan := make(chan struct{})
	for i := 0; i < len(compressedInputs); i++ {
		i := i
		go func() {
			for j := i + 1; j < len(compressedInputs); j++ {
				if set.Contains(compressedInputs[i] + compressedInputs[j]) {
					foundChan <- struct{}{}
					break
				}
			}
			finishChan <- struct{}{}
		}()
	}

	finished := 0
	for {
		select {
		case <-foundChan:
			return true
		case <-finishChan:
			finished++
			if finished >= len(compressedInputs) {
				return false
			}
		}
	}
}
