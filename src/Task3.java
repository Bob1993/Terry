import java.util.Scanner;
/**
 * 本次任务描述：根据上次的代码结构来根据四行b or o输入转移后的＋—来操作源数据
 *第一条：b为＋，o为－
 *第二条：b为－，o为＋
 *第三条：与前一符号不同为＋，相同为－
 *第四条：相同为＋，不同为－
 * source[i][j];  为指针所在的下一个预测值
 * 
 * @author Bob
 */
public class Task3  extends Task2Base {
	static String inputString, translatedString;
	static int total;
	static char[] cs;
	static boolean isPredict;
	
	public static char rule1(char c){
		if (c== 'b') {
			translatedString+= '+';
			return '+';
		}else {
			translatedString+= '-';
			return '-';
		}
	}
	
	public static char rule2(char c){
		if (c== 'o') {
			translatedString+= '+';
			return '+';
		}else{
			translatedString+= '-';
			return '-';
		} 
	}
	
	public static char rule3(int i, char c){
		if (isPredict) {
			if (c== cs[cs.length-1]) {
				return '-';
			}else return '+';
		}
		
		if (i>  cs.length-1) {
			return ' ';
		}
		if (cs[i-1]!= cs[i]) {
			translatedString+= '+';
			return '+';
		}else {
			translatedString+= '-';
			return '-';
		}
	}
	
	public static char rule4(int i, char c){
		if (isPredict) {
			if (c== cs[cs.length-1]) {
				return '+';
			}else return '-';
		}
		
		if (i > cs.length-1) {
			return ' ';
		}
		if (cs[i]== cs[i-1]) {
			translatedString+= '+';
			return '+';
		}else {
			translatedString+= '-';
			return '-';
		}
	}
	
	public static char predict(int rule, char c){
		isPredict= true;
		switch (rule) {
		case 1:
			return rule1(c);
		case 2:
			return rule2(c);
		case 3:
			return rule3(0, c);
		case 4:
			return rule4(0, c);
		default: return ' ';
		}
	}
	
	public static void rules(int rule){
		resetParams();
		System.out.printf("\n规则%d\n", rule);
		for(int i= 0; i< cs.length; i++ ){
			switch (rule) {
			case 1:
				rule1(cs[i]);
				break;
			case 2:
				rule2(cs[i]);
				break;
			case 3:
				rule3(i+1, ' ');
				break;
			case 4:
				rule4(i+1, ' ');
				break;
			default: break;
			}
		}
		System.out.println(translatedString);
		operate(translatedString);
        printFormat(predict(rule, 'b'), predict(rule, 'o'));
	}
	
	public static void translate(){
		cs= inputString.toCharArray();
		for (int i = 1; i < 5; i++) {
			rules(i);
			total+= re;
		}
		System.out.println("\n总和"+(total));
		total= 0;
	}
	
	public static void resetParams(){
		re= 0; i= 0; j= 0;	k= 0; descReset= false;
		translatedString= ""; isPredict= false;
	}

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		while((inputString= input.next())!= null)
		{
			translate();
		}
		input.close();
	}
}
