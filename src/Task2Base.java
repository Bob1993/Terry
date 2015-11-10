import java.util.Scanner;
/**
 * +的时候指針一直往右移动,(第一行)直到12个码完成(12个+),再重头开始。
 * 当第一行出现-的时候指針往下移动,当出现连续2个-,-时候都重头开始,
 * 当第二行出现+时指針返回第一行右邉第一个数字
 * @author Bob
 */
public class Task2Base {
	static int i,j,k,re;//i,j定义当前指针位置,	k操作符数组当前所在位置,	re返回结果值
	static boolean descReset= false;//控制双－号出现是是否重置的标记量
	static char[] cs;//接收输入符
	static int[][] source= {//源数据
			{2, 3 ,4,  5, 7, 9, 12, 18, 24, 30, 42, 54},
			{4, 6, 8, 10, 14 ,18, 24, 36, 48, 60, 84, 108}
			};
	
	public static void descMove()//-操作的移动规则
	{		
			if (!descReset ) {
				i++;
				if (k< cs.length-1&&cs[k+1]=='-') {
					descReset= !descReset;
				}
			}else {
				reset();
				descReset= !descReset;
			}
	}
	
	public static void addMove()//+操作的移动规则
	{
		if ( j == source[0].length-1) {
			reset();
		}else if ( i == 1){
			j++;	i--;
		}else j++;	
	}
	
	public static void reset(){
		i= 0; j= 0;
	}
	
	/**
	 * 暂时先处理掉所有的空格，因为java里，会将空格和回车作为输入结束的标识
	 * @param str
	 */
	public static void filter(String str){
		str.replace(" ", "");
	}
	
	public static void operate(String str)
	{
		filter(str);
		cs= str.toCharArray();
		for (;k < cs.length; k++) {
			if(cs[k]== '-'){	
				System.out.printf("-%d", source[i][j]);
				re-= source[i][j];
				descMove();
			}else if(cs[k]== '+'){
				System.out.printf("+%d", source[i][j]);
				re+= source[i][j];
				addMove();
			}
			else{
				 System.out.println("\nERROR_INPUT");
				 return ;
			}
		}
	}

    public static void printFormat(char b, char o){
        System.out.printf("\n= %d\t Next:\tb%s%d   o%s%d", re, b,  source[i][j], o , source[i][j]);
    }

    public static void printFormat(){
        System.out.printf("\n= %d\t Next:\t%d", re,source[i][j]);
    }
	
	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		String str= null;
		while((str= input.next())!= null)
		{
			re= 0; i= 0; j= 0;	k= 0; descReset= false;//再次输入时，将六个参数置0；
			operate(str);
		}
		input.close();
	}
}