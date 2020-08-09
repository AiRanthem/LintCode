package src.longest_common_prefix_78;

public class Solution {
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            StringBuilder builder = new StringBuilder();
            String str = strs[i];
            for (int j = 0; j < Math.min(prefix.length(), str.length()); j++) {
                char pc = prefix.charAt(j);
                char sc = str.charAt(j);
                if (pc == sc) builder.append(pc);
                else break;
            }
            prefix = builder.toString();
            if (prefix.length() == 0) return "";
        }
        return prefix;
    }
}