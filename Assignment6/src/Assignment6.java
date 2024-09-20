import java.util.*;

class ArrayLengthException extends Exception{ //custom exception for array length
	public ArrayLengthException(){ //constructor
		
	}
}

public class Assignment6 { //main class
	public static void main(String[]args) { //main method
		int num1,num2,length=0; //declared variables
		Scanner sc = new Scanner(System.in); //Scanner class for input
		System.out.println("Enter length of integer array");
		do{ //do while for correct index of array
		 try {
		   length = Integer.parseInt(sc.next()); //takes string input and parses it as integer
		   if(length<=0) { //custom exception for 0 and negative, as those indexes do not exist
			   length=0;
			   throw new ArrayLengthException();
		   }
		 }catch(NumberFormatException | ArrayLengthException e){ //Catching either exception(Not an integer/Not suitable for array)
			System.out.println("Invalid input, please re-enter");			
		}
	   }while(length==0); //continue till length is 0, exits when a proper length is given
	   int []arr = new int[length]; //array declared
	   for(int i=0;i<length;i++) { //for loop for array input
		   System.out.println("Enter "+(i+1)+" element of array");
			   try {
				   arr[i]=Integer.parseInt(sc.next());
			   }catch(NumberFormatException ex) { //only integer input allowed
				   System.out.println("Invalid input,re-enter ONLY INTEGER VALUE");
				   try { //nested try catch to give user second chance
				     arr[i]=Integer.parseInt(sc.next());
				   }catch(NumberFormatException e) { 
					  System.out.println("Warning ignored by user, element will be considered 1"); 
					  arr[i]=1; //i th index of array filled with value 1
				   }
			   }
	   }
	   
	   String cont; //string for continuation
	   do {
		   int choice=0; //int for choice
		   System.out.println("Please enter choice of operation\n1.Division of two integers\n2.Accessing element in array");
		   do {
		    try {
			    choice=Integer.parseInt(sc.next());
		    }catch(NumberFormatException e){ //checks if choice is correctly entered as an integer
			    System.out.println("Please enter number in front of your desired choice");			   
		    }
		   }while(choice==0); 
		   switch(choice) {
		   case 1: //division
			   try {
				   System.out.println("Enter 1st integer");
				   num1=Integer.parseInt(sc.next());
				   System.out.println("Enter second integer");
				   num2=Integer.parseInt(sc.next());
				   int res = num1/num2;
				   System.out.println("Quotient of two numbers is "+res);
			   }catch(NumberFormatException e) { //invalid format of input
				   System.out.println("Invalid input -> Input not in integer form\nExiting");
			   }catch(ArithmeticException a) { //error upon division by 0
				   System.out.println("Not possible to divide by zero\nExiting");
			   }
			 break;
		   case 2:
			   System.out.println("Enter index of element in array");
			   try{
				   int index = Integer.parseInt(sc.next()); //takes integer input
				   System.out.println("Element at index "+index+" is "+arr[index]);
			   }catch(NumberFormatException n) { //if input is not an integer
				   System.out.println("Invalid input, exiting");
			   }catch(ArrayIndexOutOfBoundsException e) { //if index is out of bounds
				   System.out.println("Invalid index,please re-check.Exiting");
			   }finally { //prints entire array finally
				   System.out.println("Printing entire array");
				   System.out.print("[ ");
				   for(int i=0;i<length;i++) {
					   System.out.print(arr[i]+" ");
				   }
				   System.out.print("]\n");
			   }
			   break;
		   default: //if choice is not 1 or 2
			   System.out.println("Invalid input");
			   break;
		   }
		  System.out.println("Do you wish to continue? Type yes to continue");
		  cont = sc.next().toLowerCase(); //continue only if yes,regardless of case
	   }while(cont.equals("yes"));
		
	}

}
