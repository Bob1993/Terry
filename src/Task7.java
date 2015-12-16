import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Bob on 15/12/14.
 */
public class Task7 {
    static char[] cs;//用来保存输入字符(converted from String)
    static List<Integer> gen = new ArrayList<>();
    static int i = 1, j = 1, k, re;//i为指向首元素的标记,j为指向尾元素的标记, k为当前输入数据中的游标

    /**
     * 计算re,输出结果
     *
     * @param operation
     * @param isReset
     */
    public static boolean print(char operation, boolean isReset) {
        if (isReset) {
            re += 1;
            System.out.println("+" + 1);
            return false;
        } else if (operation == '-') {
            re -= gen.get(k + 1);
            System.out.print("-" + gen.get(k + 1));
        } else if (operation == '+') {
            re += gen.get(k + 1);
            System.out.print("+" + gen.get(k + 1));
        }

        if (re == 0 || re == -200 || (re < -200 && re + gen.get(k + 1) > -200)) {
            return true;//需要重置
        }
        return false;
    }

    public static void descMove() {
        if (i == j) {
            gen.add(gen.get(i) + 1);
        } else {
            gen.add(gen.get(i) + gen.get(j));
        }
        if (print('-', false)) {
            resetGen();
        } else {
            j = k + 1;
        }
        System.out.printf("current k %d \t\t i %d\t j %d \t re %d\n", k + 1, i, j, re);
    }

    public static void addMove() {
        if (i == j) {//发现此时首尾指针重合,就加上本数+1后重置
            if (i == 1) {//如果在初始位置,就直接加自己,重置
                gen.add(1);
                print('+', true);
            } else {//否则自增1,然后重置
                gen.add(gen.get(i) + 1);
                print('+', false);
                resetGen();
            }
        } else {
            gen.add(gen.get(i) + gen.get(j));

            if (print('+', false)) {
                resetGen();
            } else {
                i++;
                j--;
            }
        }
        System.out.printf("current k %d \t\t i %d\t j %d \t re %d\n", k + 1, i, j, re);
    }

    public static void resetGen() {
        gen.clear();
        gen.add(0);
        gen.add(1);
        i = 1;
        j = 1;
        re = 0;
    }

    public static void operate(String str) {
        resetGen();
        cs = str.toCharArray();
        if (cs[0] == '+') {
            System.out.println("+" + gen.get(1));
            re+= 1;
        } else {
            System.out.println("-" + gen.get(1));
            re-= 1;
        }

        for (k = 1; k < cs.length; k++) {

            if (cs[k] == '+') {
                addMove();
            } else if (cs[k] == '-') {
                descMove();
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = null;
        while ((str = input.next()) != null) {

            operate(str);
        }
        input.close();
    }

}
