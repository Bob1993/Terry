/*
   Information:
       //将NUM设置为待排列数组的长度即实现选择排列
        private static int NUM = 3;//待排的数组长度,或者说是一个排列的数字的个数A...
        //Num既是树的深度,也是排列的数量,当和数据总长度一致时,也就是全排列
        */

/**
 * 递归算法：将数据分为两部分，递归将数据从左侧移右侧实现选择排列
 *
 * @param datas
 * @param target target是已经排出来的部分数据,也就是说已经排到树的某一个分支上
 *//*

        private static void sort(List datas, List target) {
            if (target.size() == NUM) {//说明递归已经到所要求的深度,也是终止递归的条件
                for (Object obj : target)//遍历输出一组结果
                    System.out.print(obj);
                System.out.println();
                return;
            }
            for (int i = 0; i < datas.size(); i++) {//data是当前剩余需要排列的数据,这里做遍历.第一次是原数据,后边就全都是newDatas了
                List newDatas = new ArrayList(datas);
                List newTarget = new ArrayList(target);
                newTarget.add(newDatas.get(i));//将当前待排的第一个元素加入已排好的元素数组中
                newDatas.remove(i);
                sort(newDatas, newTarget);
            }
        }

        public static void main(String[] args) {
            String[] datas = new String[] { "a", "b", "c", "d" };
            sort(Arrays.asList(datas), new ArrayList());
        }*/

/**
 * Created by Bob on 15/11/24.
 */
import sun.tools.jstat.Literal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {

    /**
     * 以二进制的形式,数出length次方的01数据
     * @param length
     * @return
     */
    public static List<String> getData(int length) {
        String temp= "";
        List<String> result= new ArrayList<>();
        for (int i= 0; i< (1 << length); i++){
            String itemString = Integer.toBinaryString(i);
            if (itemString.length()< length) {
                for (int j= 0; j< length-itemString.length(); j++)
                    temp+= '0';
                itemString= temp+ itemString;
                temp= "";
            }
            result.add(itemString);
        }
        return result;
    }


    private static List<int []> result= new ArrayList<>();

    /**
     * 其中a为源数据长度,n为组合数长度.我们在这里直接对下标进行组合,这样的话,就不需要考虑具体的源数据
     * 结束之后,只需要根据组合出来的下标在源数据中取数即可
     * @param a
     * @param n
     * @return
     */
    public static List<int []> combine(int a, int n) {

        if( a == 0 || n <= 0 || n > a)
            return null;

        int[] b = new int[n];//辅助空间，保存待输出组合数
        getCombination(a, n , 0, b, 0);
        return result;
    }

    private static void getCombination(int a, int n, int begin, int[] b, int index) {

        if(n == 0){//如果够n个数了，输出b数组
            result.add(new int[]{b[0], b[1]});
            return;
        }

        for(int i = begin; i < a; i++){

            b[index] = i;
            getCombination(a, n-1, i+1, b, index+1);
        }
    }
}
