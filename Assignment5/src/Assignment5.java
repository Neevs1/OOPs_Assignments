/*
 * 
 */
import java.util.*;

interface vehicle{
	Scanner sc = new Scanner(System.in);
	void gearChange();
	void speedUp();
	void applyBrakes();
	
	
}

class bicycle implements vehicle{
	int gearValue;
	void getdata() {
		System.out.println(" -------- __@      __@       __@       __@      __~@\r\n"
				+ " ----- _`\\<,_    _`\\<,_    _`\\<,_     _`\\<,_    _`\\<,_\r\n"
				+ " ---- (*)/ (*)  (*)/ (*)  (*)/ (*)  (*)/ (*)  (*)/ (*)\r\n"
				+ " ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	
	public void gearChange() {
		// TODO Auto-generated method stub
		
	}

	
	public void speedUp() {
		// TODO Auto-generated method stub
		
	}

	
	public void applyBrakes() {
		// TODO Auto-generated method stub
		
	}
	
}

class motorCycle implements vehicle{

	@Override
	public void gearChange() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void speedUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void applyBrakes() {
		// TODO Auto-generated method stub
		
	}
	
}

class car implements vehicle{
	boolean isAuto,gasPressed,clutchPressed,brakePressed;
	int speed,gearValue =0,gears;
	String auto;
	void getData() {
		do {
		System.out.println("        .--------.\r\n"
				+ "              ____/_____|___ \\___\r\n"
				+ "             O    _   - |   _   ,*\r\n"
				+ "              '--(_)-------(_)--'");	
		System.out.println("Enter whether your car is Automatic(true/false)");
		auto = sc.next().toLowerCase();
		if(!auto.equals("true")||!auto.equals("false")){
			System.out.println("Invalid input");		
		}else {
			isAuto = Boolean.parseBoolean(auto);
		}
		}while(!auto.equals("true")||!auto.equals("false"));
		do {
			System.out.println("Enter number of gears");
			gears = sc.nextInt();
			if(gears<0||(isAuto == false && gears>7)) {
				System.out.println("Invalid input");				
			}
			}while(gears<0||(isAuto == false && gears>7));
			
	}
	public void gearChange() {
		if(isAuto==true) {
			System.out.println("Manual override not available");
			
		}else {
			System.out.println("Type PRESS to press clutch");
			String input = sc.next().toUpperCase();
			if(input.equals("PRESS")) {
				System.out.println("Do you want to upshift(1) or downshift(2)?");
				int choice = sc.nextInt();
				if(choice==1) {
					if(gearValue==gears) {
						System.out.println("Cannot upshift further");
					}else {
						gearValue++;
						System.out.println("Car is now in gear "+gearValue+" 🚗");
					}
				}
			}
		}
	}

	@Override
	public void speedUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void applyBrakes() {
		// TODO Auto-generated method stub
		
	}
	
}

public class Assignment5 {

	public static void main(String[] args) {
		
		

	}

}
