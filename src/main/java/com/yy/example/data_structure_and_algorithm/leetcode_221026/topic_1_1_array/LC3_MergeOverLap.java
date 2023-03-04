package com.yy.example.data_structure_and_algorithm.leetcode_221026.topic_1_1_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 合并区间
 * <pre>
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 链接：https://leetcode.cn/leetbook/read/array-and-string/c5tv3/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC3_MergeOverLap {

    /**
     * 思路：
     * 1. 将数组中的区间按照左端点升序排序
     * 2. 创建一个新列表(二维数组) merged，将第一个区间放入merged，之后的每个区间走一下逻辑
     *    如果当前区间的左端点 大于 merged的最后一个区间的右端点，则没有重合，直接将这个区间添加到merged的末尾
     *    否则有重合，比较当前区间的右端点和 merged的最后一个区间的右端点，较大的值作为merged的最后一个区间的右端点
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1) return intervals;
        // 为啥要排序呢？试问[[1,4],[0,4]] 这种情况咋办呢，所以要先按左端点排升序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int L = intervals[i][0];
            int R = intervals[i][1];
            if(merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            }else {
                merged.get(merged.size() - 1)[1] = Math.max(R, merged.get(merged.size() - 1)[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }


    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,3},{5,8},{2,10},{15,18}};
        LC3_MergeOverLap mergeOverLap = new LC3_MergeOverLap();
        int[][] merged = mergeOverLap.merge(arr);
        Arrays.stream(merged).forEach(a -> System.out.println(a[0] + "," + a[1]));
    }
}
