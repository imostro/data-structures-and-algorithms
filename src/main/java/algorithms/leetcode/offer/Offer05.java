package algorithms.leetcode.offer;

/**
 * leetcode
 * 剑指 Offer 05. 替换空格
 *
 * @author Gray
 * @date 2020/11/19 22:41
 */
public class Offer05 {

    /**
     * 通过StringBuilder遍历字符串构建
     */
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' '){
                sb.append(s.charAt(i));
            }else{
                sb.append("%20");
            }
        }

        return sb.toString();
    }

    /**
     * 直接使用String的API
     */
    public String replaceSpace_api(String s) {
            return s.replaceAll(" ", "%20");
    }
}
