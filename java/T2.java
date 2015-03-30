import java.util.*;


public class T2 {

	public static void main(String[] args) {
		if (args.length <= 0) {
			System.out.println("Please input the arguments, and run again!\nIf you have some question you can input [-h] to get help.");
			return ;
		}

		if (args[0].equals("-h")) {
			System.out.println("You should input like as [Numbers] [x-y](10-2|10-8|10-16)");
			return ;
		}
		
		String input = args[0];
		System.out.println("The number is:\t"+ input);

		for(int i = 1; i < args.length; i++) {

			if (args[i].equals("10-2")) { 

				String[] num = input.split("\\.");
				String zs = Integer.toBinaryString(Integer.parseInt(num[0]));
				String xs = "";
				if (num.length >1) {
					xs = Xs(num[1], 2);
				}
				System.out.println("Binary:\t\t"+zs+xs);
			}
			if (args[i].equals("10-8")) {
			
				String[] num = input.split("\\.");
				String zs = Integer.toOctalString(Integer.parseInt(num[0]));
				String xs = "";
				if (num.length >1) {
					xs = Xs(num[1], 8);
				}
				System.out.println("Octal:\t\t" + zs + xs);
			}
			if (args[i].equals("10-16")) {
				
				String[] num = input.split("\\.");
				String zs = Integer.toHexString(Integer.parseInt(num[0]));
				String xs = "";
				if (num.length>1) {
					xs = Xs(num[1], 16);
				}
				String result = (zs+xs).toUpperCase();
				System.out.println("Hex:\t\t" + result);
			}
			if (args[i].equals("2-10")) {
				String[] num = input.split("\\.");
				int zs = Integer.parseInt(num[0], 2);
				Double xs = 0d;
				if (num.length>1) {			
					xs = XsT10(num[1],2);
				}
				System.out.println("decimalism:\t"+ (zs + xs));	
			}
			if (args[i].equals("8-10")) {
				String[] num = input.split("\\.");
				int zs = Integer.parseInt(num[0], 8);
				Double xs = 0d;
				if (num.length>1) {
					xs = XsT10(num[1],8);
				}
				System.out.println("decimalism:\t"+(zs+xs));
			}
			if (args[i].equals("16-10")) {
				String[] num = input.split("\\.");
				int zs = Integer.parseInt(num[0], 16);
				Double xs = 0d;
				if (num.length>1) {
					xs = XsT10(num[1],16);
				}	
				System.out.println("decimalism:\t"+(zs+xs));
			}
			if (args[i].equals("-tf")){
				
			}
		}
		
	}
	
	
	public static Double XsT10(String num, int jz) {
		if (16 == jz) {
			int sw = num.length();
			double result = 0;
			for (int i = 0; i<sw;i++) {
				char c  = num.charAt(i);
				int temp = 0;
				if ( c > 'A' && c < 'Z') {
					temp = c - 'A' + 10;
				} else if (c > 'a' && c < 'z') {
					temp = c - 'a' + 10;
				} else if (c > '0' && c < '9') {
					temp = c - '0';
				}
				result += temp*(Math.pow(jz,-(i+1)));
			}
			return result;
		}

		int sw = num.length();
		int tempNum = Integer.parseInt(num);
		double result = 0;
		while (tempNum != 0) {
			int temp = tempNum % 10;
			result += temp*(Math.pow(jz,-sw));
	 		sw--;
			tempNum = tempNum / 10;
		}
		return result;
	}

	public static String Xs(String num, int jz) {
		
		int xsLength = num.length();
		int xs = Integer.parseInt(num);
		int tempSw = 1;
		int time = 0;
		while (xsLength != 0) {
			tempSw *= 10;
			xsLength--;
		} 
		String result = "";
		while (xs != 0) {
			xs *= jz;
			int temp = xs / tempSw;
			result += temp;
			xs = xs % tempSw;
			time++;
			if (time > 100) {
				break;
			}
		}
		
		return "." + result;
	}
}
