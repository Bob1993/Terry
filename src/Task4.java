import java.util.*;

/**
 * 本次任务描述：
 * 	此次给出了46条规则序列，输入bo串之后，和已经给出的某条
 * 	规则进行对比，相同翻译为'+',不同翻译为'-',如果输入的序列
 * 	长于规则，那么将规则从头开始重新比对，这里使用％取余的方式
 * 	来对规则进行循环操作
 * @author Bob
 */
public class Task4 extends Task7 {
	static String inputString, translatedString;
	static int total;
	static char[] inputChars;
	
	private static Map<Integer, String> resource= new java.util.HashMap<>();
	static{
		resource.put(1, "bbbbooboboooobbbobobbbbb");	resource.put(2, "bbbobboobooboobbbboooboo");
		resource.put(24, "ooobboobbbooobbooboboooo");	resource.put(3, "booboboobooobobboobboobo");
		resource.put(25, "obobbbbbobobbboobbooobob");	resource.put(4, "bboooobobbobbbboobbobooo");
		resource.put(26, "oobboobobboobooboobboobo");	resource.put(5, "bbbboobboobbbbooooooboob");
		resource.put(27, "obbobbooboboobbooboboboo");	resource.put(6, "bbboooobooboobbbbooooooo");
		resource.put(28, "obobbobbbboobbbbbboobbob");	resource.put(7, "boboboooobbbbbooobbobobb");
		resource.put(29, "obobbobbobobbbbobbooobob");	resource.put(8, "bbobooobobooobbooobobbob");
		resource.put(30, "ooobobbobbbbbbooobobobbb");	resource.put(9, "booboobbbbbboobobobbbbbo");
		resource.put(31, "obobbboobobbbbbobbbboooo");	resource.put(10, "bbbbobboooobobboboobobbb");
		resource.put(32, "oooobbboboooobbobooooobo");	resource.put(11, "bobobobboboooooobobooooo");
		resource.put(33, "oboobbboooboobbbobbbobob");	resource.put(12, "bbboooobobobbboboooobbbb");
		resource.put(34, "oobbbbbobobbooobbbobboob");	resource.put(13, "booboboobbobbboboooooooo");
		resource.put(35, "oobobooobbboobobbobboobb");	resource.put(14, "bbooboooboooobbboooobbob");
		resource.put(36, "ooboobbobooooboboobobbbo");	resource.put(15, "bboobbbboboooooobboboobb");
		resource.put(37, "obobooboobbobobobbbobboo");	resource.put(16, "boboobboboboobbobbobbbob");
		resource.put(38, "oooboobobooobbobbobobbob");	resource.put(17, "bbbbbbobbbbbooobooobbobb");
		resource.put(39, "oboobobobobobobbobbooobo");	resource.put(18, "bobbboobbbbooobbooboooob");
		resource.put(40, "oooooooobbbbbbbbobbooobb");	resource.put(19, "bobboboobobooooobbbobbob");
		resource.put(41, "obbbbbobbbboboobboobobbb");	resource.put(20, "bboooobboooobbbbboobbobo");
		resource.put(42, "obobbbbobbbooobobbbooooo");	resource.put(21, "bbobobboboobbbbbobobboob");
		resource.put(43, "bboobboobboobboobboobboo");	resource.put(22, "oobbbobobooobobbobobbobo");
		resource.put(44, "oobboobboobboobboobboobb");	resource.put(23, "oobobbobooooobbbboobooob");
		resource.put(45, "bobobobobobobobobobobobo");	resource.put(46, "obobobobobobobobobobobob");
	}
	
	public static void rules(char[] rule){
		for(int i= 0; i< inputChars.length; i++){
			if (inputChars[i]== rule[i%rule.length]) {
				translatedString+= '+';
			}else translatedString+= '-';
		}
		System.out.println(translatedString);
		operate(translatedString);
//		printFormat();
	}
	
	public static void translate(){
		inputChars= inputString.toCharArray();
		
		for (int i = 1; i <= 46; i++) {
			resetParams();
			System.out.printf("\n规则%d\n", i);
			char[] rule= resource.get(i).toCharArray();
			//System.out.println(Arrays.toString(rule));
			rules(rule);
			total+= re;
		}
		System.out.println("\n总和"+(total));
		total= 0;
	}
	
	public static void resetParams(){
		re= 0; i= 0; j= 0;	k= 0; //descReset= false;
		translatedString= "";
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
