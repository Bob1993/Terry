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

    public static void print(char operation) {
        if (operation == '-') {
            re -= gen.get(k + 1);
            System.out.print("-" + gen.get(k + 1));
        } else if (operation == '+') {
            re += gen.get(k + 1);
            System.out.print("+" + gen.get(k + 1));
        }
    }

    public static void descMove() {
        if (i == j) {
            gen.add(gen.get(i) + 1);
        } else {
            gen.add(gen.get(i) + gen.get(j));
        }
        print('-');
        j = k + 1;
        System.out.printf("current k %d \t\t i %d\t j %d \n", k + 1, i, j);
    }

    public static void addMove() {
        if (i == j) {//发现
            gen.add(gen.get(i) + 1);
            print('+');
            resetGen();
        } else {
            gen.add(gen.get(i) + gen.get(j));
            print('+');
            i++;
            j--;
        }
        System.out.printf("current k %d \t\t i %d\t j %d \n", k + 1, i, j);
    }

    public static void resetGen() {
        gen.clear();
        gen.add(0);
        gen.add(1);
        i = 1;
        j = 1;
    }

    public static void operate(String str) {
        resetGen();
        cs = str.toCharArray();
        if (cs[0] == '+') {
            System.out.println("+" + gen.get(1));
        } else {
            System.out.println("-" + gen.get(1));
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
