package huawei;

import java.util.Stack;

public class Badd {
    public String add(String a, String b){
        Stack<Integer> stack = new Stack<Integer>();
        if (a.length() > b.length()) return add(b,a);
        int tmp = 0;
        for(int i = a.length()-1; i >= 0; i--){
            int ca = a.charAt(i)=='0'?0:1;
            int cb = b.charAt(i)=='0'?0:1;
            int c = ca + cb + tmp;
            if (c>1){
                c = 0;
                tmp = 1;
            }
            stack.push(c);
        }
        for(int i = b.length() - a.length(); i >= 0; i--){
            int cb = b.charAt(i)=='0'?0:1;
            int c = cb + tmp;
            if (c>1){
                c = 0;
                tmp = 1;
            }
            stack.push(c);
        }
        if (tmp == 1) stack.push(1);
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()){
            sb.append(stack.pop()==0?'0':'1');
        }
        return sb.toString();
    }
}
