package demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Split {
    public List<String> split(String s){
        ArrayList<String> strings = new ArrayList<>();
        HashSet<Character> set = new HashSet<>(26 * 2 + 10);
        for(char c = '0'; c<='9'; c++){
            set.add(c);
        }
        for(char c = 'a'; c<='z'; c++){
            set.add(c);
        }
        for(char c = 'A'; c<='Z'; c++){
            set.add(c);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)){
                sb.append(c);
            }else if (sb.length()!=0){
                strings.add(sb.toString());
                sb = new StringBuffer();
            }
        }
        if (sb.length()!=0){
            strings.add(sb.toString());
        }
        return strings;
    }
}
