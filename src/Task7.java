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
    static boolean isAddedTop= false;
    static int pointer = 0;//pointer 表示当前应该计算的数字的游标....和k是独立的
    /**
     * 计算re,输出结果
     *
     * @param operation
     * @param isReset
     */
    public static boolean print(char operation, boolean isReset) {
        if (isReset) {
           // re += 1;
            System.out.print("+" + 1);
            return false;
        } else if (operation == '-') {
            re -= gen.get(pointer);
            System.out.print("-" + gen.get(pointer));
        } else if (operation == '+') {
            re += gen.get(pointer);
            System.out.print("+" + gen.get(pointer));
        }

        if (re >= 0 || re == -200 || (re < -200 && re + gen.get(pointer) > -200)) {
            return true;//需要重置
        }
        return false;
    }

    public static void descMove() {
        if (i == j) {
            if (i == 1 && !isAddedTop){
                isAddedTop = true;
                re -= 1;
                System.out.print("-"+ 1);
//                System.out.printf("current k %d \t\t i %d\t j %d \t re %d\n", k + 1, i, j, re);
                return;
            }else {
                gen.add(gen.get(i) + 1);
            }

        } else {
            gen.add(gen.get(i) + gen.get(j));
        }

        if (print('-', false)) {
            resetGen();
        } else {
            j = pointer;
        }
//        System.out.printf("current k %d \t\t i %d\t j %d \t re %d\n", k + 1, i, j, re);
    }

    public static void addMove() {
        if (i == j) {//发现此时首尾指针重合,就加上本数+1后重置
            if (i == 1 && !isAddedTop) {//如果在初始位置,就直接加打印自己
                print('+', true);
                pointer = 0;
            } else {//否则自增1,然后重置
                gen.add(gen.get(i) + 1);
//                System.out.printf("else is execute %d", gen.get(i+1));
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
//        System.out.printf("current k %d \t\t i %d\t j %d \t re %d\n", k + 1, i, j, re);
    }

    public static void resetGen() {
        gen.clear();
        gen.add(0);
        gen.add(1);
        isAddedTop = false;
        pointer = 0;
        i = 1;
        j = 1;
        re = 0;
    }

    public static void operate(String str) {
        resetGen();
        cs = str.toCharArray();

        for (k = 0; k < cs.length; k++) {
            pointer++;
            if (cs[k] == '+') {
                addMove();
            } else if (cs[k] == '-') {
                descMove();
            }
        }
        System.out.println();
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

/**
 *
 * example1:
 * -1-2-3-4-5+6+6-4+7+1+1-1-2+3-1-2+3+1+1+1+1+1-1+2+1-1-2-3-4+5+5+1+1+1-1+2-1-2-3-4+5+5+1-1-2-3-4-5-6-7+8+8+8+4+1-1+2+1
 * -----++-+++--+--++++++-++----+++++-+----+++-------+++++-++
 *
 * example2:
 * -1+2+1-1-2-3-4+5+5+1+1+1-1+2-1-2-3-4+5+5+1-1-2-3-4-5-6-7+8+8+8+4+1-1+2+1
 * -++----+++++-+----+++-------+++++-++
 */
