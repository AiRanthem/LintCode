package sparse_matrix_multiply_654

/**
 * @param A: a sparse matrix
 * @param B: a sparse matrix
 * @return: the result of A * B
 */
func multiply(A [][]int, B [][]int) [][]int {

	nRow, nCol := len(A), len(B[0])
	aEle, bEle := make([]Element, 0), make(map[int][]Element)
	findElements(A, func(element Element) {
		aEle = append(aEle, element)
	})
	findElements(B, func(element Element) {
		bEle[element.row] = append(bEle[element.row], element)
	})

	ans := make([][]int, nRow)
	for i := 0; i < len(A); i++ {
		ans[i] = make([]int, nCol)
	}

	for _, ea := range aEle {
		for _, eb := range bEle[ea.col] {
			ans[ea.row][eb.col] += ea.val * eb.val
		}
	}

	return ans
}

func findElements(matrix [][]int, hancler func(element Element)) {
	for i := 0; i < len(matrix); i++ {
		for j := 0; j < len(matrix[0]); j++ {
			if matrix[i][j] != 0 {
				hancler(Element{
					row: i,
					col: j,
					val: matrix[i][j],
				})
			}
		}
	}
}

type Element struct {
	row int
	col int
	val int
}
