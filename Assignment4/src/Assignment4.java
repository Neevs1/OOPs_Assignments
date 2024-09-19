import java.util.Scanner;

/*
 * Author : Neevan Redkar
 */

abstract class shape{ //defined an abstract class shape
	Scanner sc = new Scanner(System.in);
	double l,b; //parameters for length and breadth, common to both base classes
	abstract double compute_area(); //abstract method, to be overriden
}

class rectangle extends shape{ //derived class of shape
	void getdata() { //getting input
		do {
			System.out.println("Enter length of rectangle");
			l = sc.nextDouble();
			if(l<=0) { //validation for input
				System.out.println("Invalid input, please re-enter");
			}
		}while(l<=0);
		do {
			System.out.println("Enter breadth of rectangle");
			b = sc.nextDouble();
			if(b<=0) { //validation for input
				System.out.println("Invalid input, please re-enter");
			}
		}while(b<=0);
	}


	double compute_area() { //expansion of abstract function
		
		return l*b;
	}
	
}

class triangle extends shape{ //derived class from shape
	void getdata() { //get input
		do {
			System.out.println("Enter height of triangle");
			l = sc.nextDouble();
			if(l<=0) { //validation for input
				System.out.println("Invalid input, please re-enter");
			}
		}while(l<=0);
		do {
			System.out.println("Enter length of base of triangle");
			b = sc.nextDouble();
			if(b<=0) { //validation for input
				System.out.println("Invalid input, please re-enter");
			}
		}while(b<=0);
		
	}


	double compute_area() { //overriding abstract function
		
		return 0.5*l*b;
	}
	
	
}
public class Assignment4 { //main class

	public static void main(String[] args) { //main method
		Scanner sc = new Scanner(System.in); //scanner class for choice selection
		rectangle r = new rectangle(); //rectangle object 
		triangle t = new triangle(); //triangle object
		int choice; //int for choice
		do { //area calculation
			System.out.println("Area of which shape would you like to calculate?");
			System.out.println("1.Rectangle\n2.Triangle");
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				r.getdata();
				System.out.println("Area is "+r.compute_area()); //area of rectangle
				break;
			case 2:
				t.getdata(); 
				System.out.println("Area is "+t.compute_area()); //area of triangle
				break;
			default: //input validations
				System.out.println("Invalid input");
				break;
			}
			System.out.println("Press 1 to continue,any other number to exit");
			choice = sc.nextInt();
		}while(choice==1); //loop till user wants too
		
	}

}
