package utils;

public interface SVNRepo {
    static boolean isBadVersion(int k) {
        return k>=2147483647;
    }
}
