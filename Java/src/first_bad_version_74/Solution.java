package src.first_bad_version_74;

import utils.SVNRepo;

/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether
 * the kth code version is bad or not.
 */
public class Solution {
    /**
     * @param n: An integer
     * @return An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        long l = 1, r = n;
        while (l<=r){
            int mid = (int) ((l+r)/2);
            if (SVNRepo.isBadVersion(mid)){
                if(l == r) return (int) l;
                else r = mid;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
