import java.util.*;

class complex{
	Scanner sc = new Scanner(System.in);
	String input1,input2;
	complex(){
		System.out.println("Enter first number");
		input1 = sc.nextLine();
		
		if(input1.charAt((input1.length())-1)=='i'&&input1.contains("+")) {
			System.out.println("Entered number is complex number");
		}else if(input1.charAt((input1.length())-1)=='i'&&(input1.contains("+")==false)){
			System.out.println("Entered number is imaginary number");
		}else {
			System.out.println("Entered number is real");
		}
	}
	
}

public class display {
	public static void main(String[]args) {
		complex c = new complex();
		
	}

}
