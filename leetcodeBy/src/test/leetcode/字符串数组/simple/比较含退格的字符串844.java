package test.leetcode.字符串数组.simple;

/**
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，
 * 判断二者是否相等，并返回结果。 # 代表退格字符。
 * <p>
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 * <p>
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/backspace-string-compare
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author https://github.com/wujiahui1023
 * @date 2020/10/19 10:20
 */
public class 比较含退格的字符串844 {


    public static void main(String[] args) {

        String S = "ab#c", T = "ad#c";
        backspaceCompare1(S, T);
    }


    // 思路 -> 一般比较2个字符串  通常可以联想到 栈 和 双指针
    // 双指针比较哪想到，可以试着通过逆序遍历

    public static boolean backspaceCompare(String S, String T) {

        System.out.println(build(S).equals(build(T)));
        return build(S).equals(build(T));
    }

    private static String build(String Str) {

        StringBuilder stringBuffer = new StringBuilder(Str);
        int len = stringBuffer.length();

        for (int i = 0; i < len; i++) {

            char charAt = Str.charAt(i);
            if (charAt != '#') {
                stringBuffer.append(charAt);
            } else {
                if (stringBuffer.length() > 0) {
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                }
            }
        }

        return stringBuffer.toString();
    }



    // 双指针 通过逆序遍历

    public static boolean backspaceCompare1(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }



}
