package algorithms.leetcode.year20.daily.november;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1030. 距离顺序排列矩阵单元格
 *
 * @author Gray
 * @date 2020/11/17 23:33
 */
public class Day17 {

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Math.abs(o1[0] - r0) + Math.abs(o1[1] - c0) - (Math.abs(o2[0] - r0) + Math.abs(o2[1] - c0));
            }
        });

        for (int i=0; i<R; i++){
            for (int j=0; j<C; j++){
                heap.add(new int[]{i, j});
            }
        }

        int[][] res = new int[R * C][2];
        for (int i=0; i<res.length; i++){
            res[i] = heap.poll();
        }

        return res;
    }
}
