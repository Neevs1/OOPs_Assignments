/*
 * Name:- Neevan Abhijit Redkar
 * Roll no:- 3069
 * CRN no:- 23013069
 * Division :- Second Year(S.E.)
 * Batch :- S3
 */


import java.util.*;

class complex{
	Scanner sc = new Scanner(System.in);
	String input1,input2,type;
	int real,imaginary;
	complex(){ //default constructor 
		System.out.println("Enter first number (Enter 0-(number)i if negative imaginary)");
		input1 = sc.nextLine();//takes string input
		if(input1.charAt((input1.length())-1)=='i'&&(input1.contains("+")||(input1.contains("-")))) { //checks whether input is complex
			System.out.println("Entered number is complex number");
			if(input1.contains("+")) { //checks if complex number has a positive imaginary part
				if((input1.charAt(0)!='-')) {//checks whether entered input has negative real part
			 real = Integer.parseInt(input1.substring(0, input1.indexOf("+")));//parses substring before '+' sign as real part
			 imaginary = Integer.parseInt(input1.substring(input1.indexOf("+")+1,input1.length()-1)); // parses substring after '+' as imaginary part
				}else { //if input is negative
					real = Integer.parseInt(input1.substring(1, input1.indexOf("+")))*-1;//parses before '+' substring as real part, multiplies by -1
					imaginary = Integer.parseInt(input1.substring(input1.indexOf("+")+1,input1.length()-1));//parses substring after '+' as imaginary part
				}
			}else {//if entered number has negative imaginary part
				if((input1.charAt(0)!='-')) { //if number has  real part 
					 real = Integer.parseInt(input1.substring(0, input1.indexOf("-")));//parses substring till '-' sign as real
					 imaginary = Integer.parseInt(input1.substring(input1.indexOf("-")+1,input1.length()-1))*-1;//parses substring after '-' as imaginary
				}else {
					real = Integer.parseInt(input1.substring(1, input1.indexOf("-",input1.indexOf("-")+1)))*-1;//parses substring till '-' sign as real, multiply by -1
					imaginary = Integer.parseInt(input1.substring(input1.indexOf("-",input1.indexOf("-")+1)+1,input1.length()-1))*-1;//parses substring after '-' as imaginary
				}
						
			}
			
		}else if(input1.charAt((input1.length())-1)=='i'&&(input1.contains("+")==false)){ //checks if imaginary number entered
			System.out.println("Entered number is imaginary number");
			 real = 0;//sets real to zero
			 imaginary = Integer.parseInt(input1.substring(0,input1.length()-1));//parses imaginary number
			
			
		}else { //for real number
			System.out.println("Entered number is real"); 
			 real = Integer.parseInt(input1);//parses real number
			 imaginary = 0;//sets imaginary to zero
			
		}
		
		System.out.println("Real part is "+real+" and imaginary part is "+imaginary);
	}
	complex(String input2){ //parameterised constructor used
		/*
		 * Operations in this constructor are similar to the ones written above
		 * If there are any doubts, refer to code written above
		 */
		
		if(input2.charAt((input2.length())-1)=='i'&&(input2.contains("+")||(input2.contains("-")))) {
			System.out.println("Entered number is complex number");
			if(input2.contains("+")) {
				if((input2.charAt(0)!='-')) {
			 real = Integer.parseInt(input2.substring(0, input2.indexOf("+")));
			 imaginary = Integer.parseInt(input2.substring(input2.indexOf("+")+1,input2.length()-1));
				}else {
					real = Integer.parseInt(input2.substring(1, input2.indexOf("+")))*-1;
					imaginary = Integer.parseInt(input2.substring(input2.indexOf("+")+1,input2.length()-1));
				}
			}else {
				if((input2.charAt(0)!='-')) {
					 real = Integer.parseInt(input2.substring(0, input2.indexOf("-")));
					 imaginary = Integer.parseInt(input2.substring(input2.indexOf("-")+1,input2.length()-1))*-1;
				}else {
					real = Integer.parseInt(input2.substring(1, input2.indexOf("-",input2.indexOf("-")+1)))*-1;
					imaginary = Integer.parseInt(input2.substring(input2.indexOf("-",input2.indexOf("-")+1)+1,input2.length()-1))*-1;
				}
						
			}
			
		}else if(input2.charAt((input2.length())-1)=='i'&&(input2.contains("+")==false)){
			System.out.println("Entered number is imaginary number");
			 real = 0;
			 imaginary = Integer.parseInt(input2.substring(0,input2.length()-1));
			
			
		}else {
			System.out.println("Entered number is real");
			 real = Integer.parseInt(input2);
			 imaginary = 0;
			
		}
		
		System.out.println("Real part is "+real+" and imaginary part is "+imaginary);
		
	}
	void addition(complex b) { //method for addition of numbers, passes object created by parameterized constructor
		real = real+b.real; //performs addition of real
		imaginary = imaginary+b.imaginary; //performs addition of imaginary
		if (imaginary<0) { //for negative imaginary part
			System.out.println("Sum is "+real+""+imaginary+"i");	
		}else if(real==0){ //if sum is purely imaginary
		System.out.println("Sum is "+imaginary+"i");
		}else if(imaginary==0){ //if sum is purely real
			System.out.println("Sum is "+real+"-"+imaginary+"i");			
		}else { //if sum is complex and imaginary part is positive
			System.out.println("Sum is "+real+"+"+imaginary+"i");
		}
	}
	void subtraction(complex b) { //for subtraction of numbers, passes object created by parameterized constructor
		real = real-b.real; //performs subtraction of real part
		imaginary = imaginary-b.imaginary; //performs subtraction of imaginary
		if (imaginary<0) { //if imaginary part is negative
			System.out.println("Sum is "+real+""+imaginary+"i");	
		}else if(real==0){ //if real part is zero and purely imaginary output
		System.out.println("Sum is "+imaginary+"i");
		}else if(imaginary==0){ //if imaginary part is zero and purely real output
			System.out.println("Sum is "+real+"-"+imaginary+"i");			
		}else {//if complex and imaginary 
			System.out.println("Sum is "+real+"+"+imaginary+"i");
		}
		
	}
	void multiplication(complex b) {
		if(((real*b.imaginary)+(b.real*imaginary))<0) {
			System.out.println("Product is " +((real*b.real)-imaginary*b.imaginary)+((real*b.imaginary)+(b.real*imaginary)+"i"));
		}else if(((real*b.imaginary)+(b.real*imaginary))==0) {
			System.out.println("Product is " +((real*b.real)-imaginary*b.imaginary));			
	    }else if((((real*b.real)-imaginary*b.imaginary))==0) {
			System.out.println("Product is " +((real*b.imaginary)+(b.real*imaginary)+"i"));			
	    }else{
			System.out.println("Product is " +((real*b.real)-imaginary*b.imaginary)+"+"+((real*b.imaginary)+(b.real*imaginary)+"i"));
		}
		
	}
    void division(complex b) {
		if(b.real==0&&b.imaginary==0) {
			System.out.println("Math error: Division by 0 not possible");
		}else {
			float realTerm = (((real*b.real)+(imaginary*b.imaginary))/(((float)(Math.pow(b.real, 2))+((float)(Math.pow(b.imaginary, 2))))));
			float imagTerm = (((imaginary*b.real)-(real*b.imaginary))/(((float)(Math.pow(b.real, 2))+((float)(Math.pow(b.imaginary, 2))))));
			if(imagTerm<0) {
				System.out.println("Quotient is "+realTerm+""+imagTerm+"i");
			}else if(realTerm==0){
				System.out.println("Quotient is "+imagTerm+"i");
			}else if(imagTerm==0) {
				System.out.println("Quotient is "+realTerm);
			}else {
				System.out.println("Quotient is "+realTerm+"+"+imagTerm+"i");
			}
		}
	}
}

public class display {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		String repeat;
		do {
		complex c = new complex();
		System.out.println("Enter second number(Enter 0-(number)i if negative imaginary)");
		String input2 = sc.next();
		complex c2 = new complex(input2);
		System.out.println("Enter operation of choice");
		System.out.println("1.Addition\n2.Subtraction\n3.Multiplication\n4.Division");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			c.addition(c2);
			break;
		case 2:
			c.subtraction(c2);
			break;
		case 3:
			c.multiplication(c2);
			break;
		case 4:
			c.division(c2);
			break;
			
		default:
			System.out.println("Invalid operation");
		}
		System.out.println("Do you wish to use the calculator again\nType Yes to confirm\nPress any other key to exit");
		repeat = sc.next();
		repeat = repeat.toLowerCase();
		//System.out.print(repeat);
		}while(repeat.equals("yes"));
		
	}

}