package guess_number_game_1299

import "fmt"

/**
 * @param secret: An string
 * @param guess: An string
 * @return: An string
 */
func getHint(secret string, guess string) string {
	var a, b int
	var (
		smap  = make(map[byte]int)
		glist []byte
	)

	for i := 0; i < len(secret); i++ {
		if secret[i] == guess[i] {
			a++
		} else {
			smap[secret[i]]++
			glist = append(glist, guess[i])
		}
	}
	for _, k := range glist {
		if get := smap[k]; get != 0 {
			b++
			smap[k]--
		}
	}
	return fmt.Sprintf("%dA%dB", a, b)
}
