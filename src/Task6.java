import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 本次任务描述：根据上次的代码结构来根据四行b or o输入转移后的＋—来操作源数据
 *第一条：b为＋，o为－
 *第二条：b为－，o为＋
 *第三条：与前一符号不同为＋，相同为－
 *第四条：相同为＋，不同为－
 * source[i][j];  为指针所在的下一个预测值
 * 
 * @author Bob
 *
 */
public class Task6 extends Task2Base {
    static List<String> inputSource;
    static List<String> result1204= new ArrayList<>();
    static List<String> resultNegative= new ArrayList<>();
    static String translatedString= "";
    static char[] inputChars;

    public static void translate(String inputStr){
        inputChars= inputStr.toCharArray();
        setSource(new int[][]{
                {2, 3 ,4, 5, 7, 9, 12, 18, 24, 30, 42, 54, 72, 96, 128, 170, 228, 300},
                {4,6,8,10,14,18,24, 36, 48, 60, 84, 108, 144, 192, 256, 340, 456, 600}
        });

        for (char c : inputChars) {
            if (c == '1')//这里规定1为+, 0为-
                translatedString+= '+';
            else translatedString+= '-';
        }

        operate(translatedString);
        System.out.println(" = "+re);

        if (re< 0){
            resultNegative.add(translatedString);
        }else if (re== 1204){
            result1204.add(translatedString);
        }

        resetParams();
    }

    public static void resetParams(){
        re= 0; i= 0; j= 0;	k= 0; descReset= false;
        translatedString= "";
    }

    public static void generate64(){
        List<int []> combination = Utils.combine(1000, 60);
        for (int[] ints : combination) {
            System.out.println("\n\n\n");
            //System.out.println(result1204.get(0));
            System.out.println(Arrays.toString(ints));
        }
    }

    public static void main(String[] args) {
       /* inputSource= Utils.getData(18);
        for (String s : inputSource) {
            translate(s);
        }
        System.out.println("1204 count is "+ result1204.size()+" \n"+"negative count is "+ resultNegative.size());
*/        generate64();
    }
}
