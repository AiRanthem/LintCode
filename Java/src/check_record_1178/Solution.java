package src.check_record_1178;

public class Solution {
    /**
     * 给定一个字符串表示学生出勤记录，记录仅由下列三个字符组成：
     * 'A' : 缺席（Absent）.
     * 'L' : 迟到（Late）.
     * 'P' : 到场（Present）.
     * 如果学生的出勤情况不包含 超过一个'A'(缺席) 或者 超过连续两个'L'(迟到) ，那么他就应该受到奖励。
     * 返回该学生是否会受到奖励。
     *
     * @param s: a string
     * @return whether the student could be rewarded according to his attendance record
     */
    public boolean checkRecord(String s) {
        int lateConsecutively = 0;
        boolean absented = false;
        for (char c : s.toCharArray()) {
            if (c == 'L'){
                if (lateConsecutively == 2) {
                    return false;
                }
                lateConsecutively++;
            } else {
                if (c == 'A'){
                    if (absented) {
                        return false;
                    }
                    absented = true;
                }
                lateConsecutively = 0;
            }
        }
        return true;
    }
}
