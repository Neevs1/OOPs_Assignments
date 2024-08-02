import java.util.*;

class complex{
	Scanner sc = new Scanner(System.in);
	String input1,input2,type;
	int real,imaginary;
	complex(){
		System.out.println("Enter first number");
		input1 = sc.nextLine();
		if(input1.charAt((input1.length())-1)=='i'&&input1.contains("+")) {
			System.out.println("Entered number is complex number");
			 real = Integer.parseInt(input1.substring(0, input1.indexOf("+")));
			 imaginary = Integer.parseInt(input1.substring(input1.indexOf("+")+1,input1.length()-1));
			System.out.println("Real part is "+real+" and imaginary part is "+imaginary);
			type = "Imaginary";
		}else if(input1.charAt((input1.length())-1)=='i'&&(input1.contains("+")==false)){
			System.out.println("Entered number is imaginary number");
			real = 0;
			imaginary = Integer.parseInt(input1.substring(0,input1.length()-1));
			System.out.println("Real part is "+real+" and imaginary part is "+imaginary);
		}else {
			System.out.println("Entered number is real");
			 real = Integer.parseInt(input1);
			 imaginary = 0;
			System.out.println("Real part is "+real+" and imaginary part is "+imaginary);
		}
	}
	complex(String input2){
		
		if(input2.charAt((input2.length())-1)=='i'&&input2.contains("+")) {
			System.out.println("Entered number is complex number");
			 real = Integer.parseInt(input2.substring(0, input2.indexOf("+")));
			 imaginary = Integer.parseInt(input2.substring(input2.indexOf("+")+1,input2.length()-1));
			System.out.println("Real part is "+real+" and imaginary part is "+imaginary);
		}else if(input2.charAt((input2.length())-1)=='i'&&(input2.contains("+")==false)){
			System.out.println("Entered number is imaginary number");
			 real = 0;
			 imaginary = Integer.parseInt(input2.substring(0,input2.length()-1));
			System.out.println("Real part is "+real+" and imaginary part is "+imaginary);
			
		}else {
			System.out.println("Entered number is real");
			 real = Integer.parseInt(input2);
			 imaginary = 0;
			System.out.println("Real part is "+real+" and imaginary part is "+imaginary);
		}
		
	}
	void addition(complex b) {
		real = real+b.real;
		imaginary = imaginary+b.imaginary;
		System.out.println("Sum is "+real+"+"+imaginary+"i");
	}
	
}

public class display {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		complex c = new complex();
		System.out.println("Enter second number");
		String input2 = sc.nextLine();
		complex c2 = new complex(input2);
		System.out.println("Enter operation of choice");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			c.addition(c2);
		default:
			System.out.println("Invalid operation");
		}
		
	}

}