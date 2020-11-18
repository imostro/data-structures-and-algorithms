package algorithms.leetcode.daily.year20.november;

/**
 * 134. 加油站
 * 
 * @author Gray
 * @date 2020/11/18 10:28
 */
public class Day18 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int curr = 0;
        int start = 0;
        for (int i=0; i<gas.length; i++){
            int residue = gas[i] - cost[i];
            curr += residue;
            total += residue;
            if (curr < 0){
                start = i+1;
                curr = 0;
            }
        }
        return total < 0 ? -1 : start;
    }
}
