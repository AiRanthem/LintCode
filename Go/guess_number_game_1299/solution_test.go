package guess_number_game_1299

import "testing"

func Test_getHint(t *testing.T) {
	type args struct {
		secret string
		guess  string
	}
	tests := []struct {
		name string
		args args
		want string
	}{
		{name: "test1", args: args{"1807", "7810"}, want: "1A3B"},
		{name: "test2", args: args{"1123", "0111"}, want: "1A1B"},
		{name: "err1", args: args{"487494469893237973", "992932992248847541"}, want: "1A11B"},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := getHint(tt.args.secret, tt.args.guess); got != tt.want {
				t.Errorf("getHint() = %v, want %v", got, tt.want)
			}
		})
	}
}
