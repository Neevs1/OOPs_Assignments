import java.util.*;

class complex{
	Scanner sc = new Scanner(System.in);
	String input1,input2,type;
	complex(){
		System.out.println("Enter first number");
		input1 = sc.nextLine();
		if(input1.charAt((input1.length())-1)=='i'&&input1.contains("+")) {
			System.out.println("Entered number is complex number");
			int real = Integer.parseInt(input1.substring(0, input1.indexOf("+")));
			int imaginary = Integer.parseInt(input1.substring(input1.indexOf("+")+1,input1.length()-1));
			System.out.println("Real part is "+real+" and imaginary part is "+imaginary);
			type = "Imaginary";
		}else if(input1.charAt((input1.length())-1)=='i'&&(input1.contains("+")==false)){
			System.out.println("Entered number is imaginary number");
			int real = 0;
			int imaginary = Integer.parseInt(input1.substring(0,input1.length()-1));
			System.out.println("Real part is "+real+" and imaginary part is "+imaginary);
		}else {
			System.out.println("Entered number is real");
			int real = Integer.parseInt(input1);
			int imaginary = 0;
			System.out.println("Real part is "+real+" and imaginary part is "+imaginary);
		}
	}
	complex(String input2){
		
		if(input2.charAt((input2.length())-1)=='i'&&input2.contains("+")) {
			System.out.println("Entered number is complex number");
			int real = Integer.parseInt(input2.substring(0, input2.indexOf("+")));
			int imaginary = Integer.parseInt(input2.substring(input2.indexOf("+")+1,input2.length()-1));
			System.out.println("Real part is "+real+" and imaginary part is "+imaginary);
		}else if(input2.charAt((input2.length())-1)=='i'&&(input2.contains("+")==false)){
			System.out.println("Entered number is imaginary number");
			int real = 0;
			int imaginary = Integer.parseInt(input2.substring(0,input2.length()-1));
			System.out.println("Real part is "+real+" and imaginary part is "+imaginary);
			
		}else {
			System.out.println("Entered number is real");
			int real = Integer.parseInt(input2);
			int imaginary = 0;
			System.out.println("Real part is "+real+" and imaginary part is "+imaginary);
		}
		
	}
	
}

public class display {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		complex c = new complex();
		System.out.println("Enter second number");
		String input2 = sc.nextLine();
		complex c2 = new complex(input2);
		
	}

}
