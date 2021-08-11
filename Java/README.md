# Java版本刷题目录
工具类都在[utils](utils)目录

题目都在[src](src)目录

其余目录是企业笔试、给同学讲解等用到的目录，意义不大
1. [427. 生成括号](src/generate_parentheses_427) pythoned
2. [428. x的n次幂](src/pow_x_n_428) pythoned
3. [7. 二叉树的序列化和反序列化](src/serialize_binary_tree_7) pythoned
4. [434. 岛屿的个数II](src/number_of_islands2_434) pythoned
5. [1401. 抽搐数](src/twitch_words_1401) pythoned
6. [1368. 相同数字](src/same_number_1368) pythoned
7. [1314. 2的幂](src/is_pow_of_2_1314) pythoned
8. [1294. 3的幂](src/is_pow_of_3_1294) pythoned
9. [1282. 翻转字符串中的元音字母](src/reverse_vowels_of_a_string) pythoned
10. [1266. 找不同](src/find_diff_1266) pythoned
11. [1256. 第n个数位](src/nth_digit_1256) 
12. [480. 二叉树的所有路径](src/binary_tree_paths_480) pythoned
13. [433. 岛屿的个数](src/number_of_islands1_433) BFS
14. [1298. 最小高度树](src/minimum_height_trees_1298) 拓扑排序思想，BFS
15. [104. 合并k个排序链表](src/merge_k_sorted_lists_104) 归并排序
16. [29. 交叉字符串](src/interleaving_string_29) pythoned
17. [75. 寻找峰值](src/find_peak_element_75) 高中导数题的套路 pythoned
18. [76. 最长上升子序列](src/longest_increasing_subsequence_76) 子序列题目要考虑去重 pythoned UPDATE: 通过Treeset可以快速完并且有二分优化
19. [108. 分割回文串](src/palindrome_partitioning_ii_108) 回文串也要通过DP来判断 pythoned
20. [140. 快速幂](src/fast_pow_140) 对于涉及int的乘法，需要用long来计算 pythoned
21. [156. 合并区间](src/merge_intervals_156) pythoned
22. [407. 加一](src/plus_one_407) pythoned
23. [423. 有效的括号序列](src/valid_parantheses_423) pythoned
24. [514. 栏杆染色](src/paint_fence_514) pythoned
25. [553. 炸弹袭击](src/bomb_attack_553) pythoned
26. [991. 灯泡切换](src/bulb_switcher_991)
27. [3. 统计数字](src/stat_number_3)
28. [154. 正则表达式匹配](src/regex_match_154) **重要** 记忆化搜索，DP
29. [1223. 环绕字符串中的唯一子串](src/unique_substrings_in_wraparound_string_1223) **重要** UNIQUE DP
30. [1065. 日程安排](src/my_calendar_1065)
31. [1064. 日程安排2](src/my_calendar_ii_1064) **重要** 连续转离散
32. [904. 加一链表](src/plus_one_linked_list_904)
33. [886. 凸多边形](src/convex_polygon_886)
34. [617. 子数组的最大平均值2](src/maximum_average_subarray_617) **重要** 二分查找，对解空间进行二分而不是对序列进行二分
35. [178. 图是否是树](src/graph_valid_tree_178)
36. [460. 在排序数组中找最接近的K个数](src/find_k_cloest_elements_460) 注意逻辑表达式
37. [12. 带最小值操作的栈](src/min_stack_12)
38. [1293. 区间和的个数](src/count_of_range_sum_1293) **重要** 归并排序：序列的有序只需要一定程度上有序即可
39. [874. 最大假期天数](src/maximum_vocation_days_874) **重要** DFS，记忆化剪枝
40. [602. 俄罗斯套娃信封](src/russian_doll_envelopes_602) **重要** 通过排序抽象为上升子序列
41. [600. 包裹黑色像素点的最小矩形](src/smallest_rectangle_enclosing_black_pixels_600) DFS
42. [24. LFU缓存](src/lfu_cache_24) **重要** 复杂的映射关系
43. [134. LRU缓存](src/lru_cache_134) 链表
44. [86. 二叉查找树迭代器](src/binary_search_tree_iterator_86) **重要** 最右指向上一层
45. [1227. 重复的子串模式](src/repeated_substring_pattern_1227) todooc
46. [65. 两个排序数组的中位数](src/median_of_two_sorted_arrays_65) **重要** 适当的进行二分，需要转换目标
47. [14. 二分查找](src/first_position_of_target_14) **重要** 二分查找的模板
48. [61. 搜索区间](src/search_for_a_range_61)
49. [62. 搜索旋转排序数组](src/search_in_rotated_sorted_array_62) **重要** 对于序列，可以尝试画出函数曲线以制定二分策略
50. [74. 第一个错误版本](src/first_bad_version_74)
51. [159. 寻找旋转排序数组中的最小元素](src/find_minimun_in_rotated_sorted_array_159)
52. [53. 翻转字符串中的单词](src/reverse_words_in_a_string_53)
53. [78. 最长公共前缀](src/longest_common_prefix_78)
54. [107. 单词拆分](src/word_break_107)
55. [119. 编辑距离](src/edit_distance_119) 长序列在前
56. [171. 乱序字符串](src/anagrams_171) 数组的哈希方法
57. [1251. 拆分最大和子数组](src/split_array_largest_sum_1251) **重要** 解空间二分，序列求和reset的小技巧
58. [244. 删除字符](src/delete_chat_244) 贪心
59. [124. 最长连续序列](src/longest_consecutive_sequence_124) **重要** O(n)不只是一遍，Set的用法在于放入元素后remove元素
60. [102. 带环链表](src/linked_list_cycle_102) **重要** 快慢指针
61. [35. 翻转链表](src/reverse_linked_list_35)
62. [36. 翻转链表2](src/reverse_linked_list_ii_36)
63. [96. 链表划分](src/partition_list_96)
64. [98. 链表排序](src/sort_list_98)
65. [105. 拷贝带随机指针的链表](src/coly_list_with_random_pointer_105) 
66. [103. 带环链表2](src/linked_list_cycle_ii_103)
67. [92. 背包问题](src/backpack_92)
68. [480. 分割字符串](src/split_string_680)
69. [5. 第k大元素](src/kth_largest_element_5) **重要** 快速选择
70. [41. 最大子数组](src/maximum_subarray_41)
71. [46. 主元素](src/majority_element_46) **重要** 抵消法
72. [56. 两数之和](src/two_sum_56) **重要** 巧用Hashmap
73. [60. 搜索插入位置](src/search_insert_position_60)
74. [64. 合并排序数组](src/merge_sorted_array_64)
75. [82. 落单的数](src/single_number_82) **重要** 异或运算来判断是否相等，异或运算具有交换律和结合律
76. [100. 删除排序数组中的重复数字](src/remove_duplicate_from_sorted_array_100)
77. [111. 爬楼梯](src/climbing_stairs_111)
78. [141. 对x开根](src/sqrt_x_141)
79. [175. 翻转二叉树](src/reverse_binary_tree_175)
80. [384. 最长无重复字符子串](src/longest_substring_without_repeating_characters_384)
81. [1291. 运动会](src/sports_meeting_1291) **重要** 贪心
82. [15. 全排列](src/permutations_15) **重要** 迭代和递归两种排列树的实现
83. [408. 二进制求和](src/add_binary_408)
84. [1579. 字母串计算](src/alphabetic_string_calculation_1579)
85. [872. 终止进程](src/terminate_process_872)
86. [1237. 回旋镖的数量](src/number_of_boomerangs_1237)
87. [39. 恢复旋转排序数组](src/recover_rotated_sorted_array_39)
88. [1178. 学生出勤记录 I](src/check_record_1178)
89. [97. 二叉树最大深度](src/max_depth_97)
90. [1649. 超级棒棒糖](src/lollipop_1649)
91. [496. 玩具工厂](src/toy_factory_496)
92. [1116. 函数执行时间](src/exclusive_time_1116)
93. [1197. 寻找树中最左下节点的值](src/buttom_left_value_1197)
94. [1883. 前K个高频关键词](src/top_k_keywords_1883) **重要** KMP算法
95. [1914. 聪明的销售](src/min_item_1914)
96. [1915. 举重](src/weight_capacity_1915) **重要** 背包问题的优化实现方式
97. [1899. 取物资II](src/fetch_supplies_ii_1899) **重要** 三分法，适用于求区间内唯一极值
98. [1343. 合并字符串](src/sum_of_two_strings_1343)
99. [1904. 放置小球](src/put_balls_1904) **重要** 背包问题的总结，二分搜索+背包DP
100. [109. 数字三角形](src/trangle_minimum_total_109) **重要** 记忆搜索