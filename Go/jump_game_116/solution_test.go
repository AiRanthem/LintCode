package jump_game_116

import "testing"

func Test_canJump(t *testing.T) {
	type args struct {
		A []int
	}
	tests := []struct {
		name string
		args args
		want bool
	}{
		{name: "test1", args: args{[]int{2, 3, 1, 1, 4}}, want: true},
		{name: "test2", args: args{[]int{3, 2, 1, 0, 4}}, want: false},
		{name: "err1", args: args{[]int{0, 8, 2, 0, 9}}, want: false},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := canJump(tt.args.A); got != tt.want {
				t.Errorf("canJump() = %v, want %v", got, tt.want)
			}
		})
	}
}
