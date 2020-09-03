package src.add_binary_408;

public class Solution {
    int ca, cb, cf;

    /**
     * @param a: a number
     * @param b: a number
     * @return: the result
     */
    public String addBinary(String a, String b) {
        if (a.length() > b.length()) return addBinary(b, a);
        StringBuffer sb = new StringBuffer();
        int la = a.length() - 1;
        int lb = b.length() - 1;
        cf = 0;
        for (int i = 0; i <= la; i++) {
            ca = a.charAt(la - i) == '0' ? 0 : 1;
            cb = b.charAt(lb - i) == '0' ? 0 : 1;
            cacu(sb);
        }
        for (int i = la + 1; i <= lb; i++) {
            ca = 0;
            cb = b.charAt(lb - i) == '0' ? 0 : 1;
            cacu(sb);
        }
        if (cf == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public void cacu(StringBuffer sb) {
        int s = ca + cb + cf;
        if (s < 2) {
            sb.append(s);
            cf = 0;
        } else {
            sb.append(s - 2);
            cf = 1;
        }
    }
}
