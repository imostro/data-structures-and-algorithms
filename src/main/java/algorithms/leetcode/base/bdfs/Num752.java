package algorithms.leetcode.base.bdfs;

import java.util.*;

/**
 * 752. 打开转盘锁
 *
 * @author Gray
 * @date 2020/11/26 15:19
 */
public class Num752 {

    public static void main(String[] args) {
        Num752 num752 = new Num752();
        int lock = num752.openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888");
        System.out.println(lock);
    }
    /**
     * bfs
     */
    public int openLock(String[] deadends, String target) {
        HashSet<String> set = new HashSet<>(Arrays.asList(deadends));
        if (set.contains("0000"))   return -1;
        LinkedList<String> queue = new LinkedList<>();
        set.add("0000");
        queue.add("0000");

        int cnt = 0;
        while (!queue.isEmpty()){
            int size = queue.size();

            for (int i=0; i<size; i++){
                String password = queue.pollFirst();
                if (Objects.equals(target, password)){
                    return cnt;
                }

                for (int j = 0; j<8; j++){
                    String change = change(password, j/2, j);
                    if (!set.contains(change)){
                        set.add(change);
                        queue.offer(change);
                    }
                }
            }
            cnt++;
        }

        return -1;
    }


    private String change(String source, int idx, int change){
        char[] array = source.toCharArray();
        char c = array[idx];
        if (change%2 == 0){
            if (c == '9') c = '0';
            else c++;
        }else{
            if (c == '0') c = '9';
            else c--;
        }

        array[idx] = c;

        return String.valueOf(array);
    }
}
