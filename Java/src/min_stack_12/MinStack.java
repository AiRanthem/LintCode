package src.min_stack_12;

public class MinStack {
    private int[] num_stack;
    private int[] min_stack;
    int num_top;
    int min_top;
    public MinStack() {
        num_stack = new int[10000];
        min_stack = new int[10000];
        num_top = min_top = 0;
        min_stack[0] = 100000;
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        num_stack[++num_top] = number;
        if(number <= min()){
            min_stack[++min_top] = number;
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        int pop = num_stack[num_top--];
        if(pop == min()){
            min_top--;
        }
        return pop;
    }

    /*
     * @return: An integer
     */
    public int min() {
        return min_stack[min_top];
    }
}
