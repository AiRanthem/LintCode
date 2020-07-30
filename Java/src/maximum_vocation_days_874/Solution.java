package src.maximum_vocation_days_874;

public class Solution {
    private int[][] flights, days, memo;
    int n_weeks, n_cities, max_days;
    /**
     * memo[i][j] = 第j周到城市i记录到的最长假期天数
     * @param flights: the airline status from the city i to the city j
     * @param days: days[i][j] represents the maximum days you could take vacation in the city i in the week j
     * @return the maximum vacation days you could take during K weeks
     */
    public int maxVacationDays(int[][] flights, int[][] days) {
        this.flights = flights;
        this.days = days;
        n_cities = days.length;
        n_weeks = days[0].length;
        memo = new int[n_cities][n_weeks];

        max_days = 0;
        dfs(0, 0, 0);
        return max_days;
    }

    /**
     * 决定这周去哪个城市
     * @param cur_week 现在是第几周
     * @param cur_city 现在在哪个城市，也就是上周选择去的城市
     * @param cur_days 已经休假几天了，也就是到上周为止休假了几天
     */
    public void dfs(int cur_week, int cur_city, int cur_days){
        if(cur_week == n_weeks){
            if(max_days < cur_days) max_days = cur_days;
            return;
        }

        // 如果这周留在当前城市搜索历史上休假更少
        int next_days = cur_days + days[cur_city][cur_week];
        if(memo[cur_city][cur_week] <= next_days){
            memo[cur_city][cur_week] = next_days;
            dfs(cur_week + 1, cur_city, cur_days + days[cur_city][cur_week]);
        }
        // 尝试搜索其他城市
        for (int i = 0; i < n_cities; i++) {
            next_days = cur_days + days[i][cur_week];
            if(flights[cur_city][i] == 1 && memo[i][cur_week] < next_days) {
                memo[i][cur_week] = next_days;
                dfs(cur_week + 1, i, cur_days + days[i][cur_week]);
            }
        }
    }
}