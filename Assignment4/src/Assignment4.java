import java.util.Scanner;

/*
 * Author : Neevan Redkar
 */

abstract class shape{
	Scanner sc = new Scanner(System.in);
	double l,b;
	abstract double compute_area();
}

class rectangle extends shape{
	void getdata() {
		do {
			System.out.println("Enter length of rectangle");
			l = sc.nextDouble();
			if(l<=0) {
				System.out.println("Invalid input, please re-enter");
			}
		}while(l<=0);
		do {
			System.out.println("Enter breadth of rectangle");
			b = sc.nextDouble();
			if(b<=0) {
				System.out.println("Invalid input, please re-enter");
			}
		}while(b<=0);
	}


	double compute_area() {
		
		return l*b;
	}
	
}

class triangle extends shape{
	void getdata() {
		do {
			System.out.println("Enter height of triangle");
			l = sc.nextDouble();
			if(l<=0) {
				System.out.println("Invalid input, please re-enter");
			}
		}while(l<=0);
		do {
			System.out.println("Enter length of base of triangle");
			b = sc.nextDouble();
			if(b<=0) {
				System.out.println("Invalid input, please re-enter");
			}
		}while(b<=0);
		
	}


	double compute_area() {
		
		return 0.5*l*b;
	}
	
	
}
public class Assignment4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		rectangle r = new rectangle();
		triangle t = new triangle();
		int choice;
		do {
			System.out.println("Area of which shape would you like to calculate?");
			System.out.println("1.Rectangle\n2.Triangle");
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				r.getdata();
				System.out.println("Area is "+r.compute_area());
				break;
			case 2:
				t.getdata();
				System.out.println("Area is "+t.compute_area());
				break;
			default:
				System.out.println("Invalid input");
				break;
			}
			System.out.println("Press 1 to continue,any other number to exit");
			choice = sc.nextInt();
		}while(choice==1);
		
	}

}
