package add_and_search_716

import "testing"

func TestAddAndSearch(t *testing.T) {
	tests := []struct {
		name     string
		inputs   []int
		tests    []int
		expected bool
	}{
		{
			name:     "case 1",
			inputs:   []int{-3, 5, 3},
			tests:    []int{-1, 0, 1, 2},
			expected: true,
		},
		{
			name:     "case 2",
			inputs:   []int{3, 4, 5},
			tests:    []int{1, 3, 6},
			expected: false,
		},
		{
			name:     "case wrong",
			inputs:   []int{-10, 1, -4, -2, 10, 0, -7, -3, -7, 9},
			tests:    []int{7, 3, -1, 2, -10, 4, -2, -2, 6, -6},
			expected: true,
		},
		{
			name:     "case wrong2",
			inputs:   []int{-62, 56, -33, 89, 38, -87, -13, -36, -32, 87, 26, 22, -18, 36, 59, -97, 47, -51, -69, -8, 36, -8, -59, -20, 57, -98, -57, 81, -15, -37, -2, -90, 20, -70, -74, 31, -76, -69, -77, 64, 51, -77, 89, -22, 51, -32, -1, 77, 87, -72},
			tests:    []int{1, 2, 4, -53, 28, 78, -46, 84, 27, 60},
			expected: true,
		},
		{
			name:     "case wrong3",
			inputs:   []int{-3, 4},
			tests:    []int{1},
			expected: true,
		},
	}
	for _, test := range tests {
		t.Run(test.name, func(t *testing.T) {
			actural := AddAndSearch(test.inputs, test.tests)
			if actural != test.expected {
				t.Fatalf("actural %v \t\t expected %v\n", actural, test.expected)
			}
		})
	}
}
