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
	boolean hasGear;
	int gearValue;
	bicycle() {
		System.out.println(" -------- __@      __@       __@       __@      __~@\r\n"
				+ " ----- _`\\<,_    _`\\<,_    _`\\<,_     _`\\<,_    _`\\<,_\r\n"
				+ " ---- (*)/ (*)  (*)/ (*)  (*)/ (*)  (*)/ (*)  (*)/ (*)\r\n"
				+ " ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	 System.out.println("Enter enter whether cycle has changeable gears(yes/no)");
	 String gear = sc.next();
	 if(gear.equals("yes")) {
		 hasGear=true;
	 }else {
		 hasGear=false;
	 }
	 
	}

	
	public void gearChange() {
		
		
	}

	
	public void speedUp() {
		// TODO Auto-generated method stub
		
	}

	
	public void applyBrakes() {
		// TODO Auto-generated method stub
		
	}
	
}

class motorCycle implements vehicle{

	motorCycle(){
		
	}
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
	boolean isAuto,gasPressed,clutchPressed,brakePressed,stalled,isNeutral;
	int speed=0,gearValue =0,gears;
	char currentGear='p';
	String auto;
	car() {
		do {
		System.out.println("                   .--------.\r\n"
				+ "              ____/_____|___ \\___\r\n"
				+ "             O    _   - |   _   ,*\r\n"
				+ "              '--(_)-------(_)--'");	
		System.out.println("Enter whether your car is Automatic(true/false)");
		auto = sc.next().toLowerCase();
		if(auto.equals("true")==false&&auto.equals("false")==false){
			System.out.println("Invalid input");		
		}else {
			isAuto = Boolean.parseBoolean(auto);
		}
		}while(!auto.equals("true")&&!auto.equals("false"));
		do {
			System.out.println("Enter number of gears");
			gears = sc.nextInt();
			if(gears<0||(isAuto == false && gears>7)) {
				System.out.println("Invalid input");				
			}
			}while(gears<0||(isAuto == false && gears>6));
			
	}
	public void gearChange() {
		if(isAuto==true) {
			System.out.println("Car is currently in gear "+currentGear+"\nPlease type which gear you want to change to\nP R N D");
			char newgear = sc.next().toLowerCase().charAt(0);	
			switch(newgear) {
			case 'p':
				System.out.println("Car is in p i.e. Park");
				currentGear=newgear;
				break;
			case 'r':
				System.out.println("Car is in reverse");
				currentGear=newgear;
				break;
			case 'n':
				System.out.println("Car is in neutral");
				currentGear=newgear;
				break;
			case 'd':
				System.out.println("Car is in drive");
				currentGear=newgear;
				break;
				}
		}else {
			System.out.println("Type PRESS to press clutch");
			String input = sc.next().toUpperCase();
			if(input.equals("PRESS")) {
				clutchPressed = true;
				System.out.println("Do you want to upshift(1) or downshift(2)?");
				int choice = sc.nextInt();
				if(choice==1) {
					if(gearValue==gears) {
						System.out.println("Cannot upshift further");
					}else {
						gearValue++;
						System.out.println("Car is now in gear "+gearValue+" 🚗");
					}
				}else if(choice==2) {
					if(gearValue==0) {
						System.out.println("Car is in neutral,cannot downshift further");
					}else if(gearValue==1) {
						gearValue--;
						System.out.println("Car is now in neutral 🚗");
						isNeutral=true;
					}
				}else {
					System.out.println("Invalid choice.Operation terminated");
				}
			}else {
				System.out.println("Clutch not pressed. Cannot change gears.Operation terminated");
			}
		}
	}

	@Override
	public void speedUp() {
		if(isAuto==false&&clutchPressed==true) {
			System.out.println("Please release clutch(type release)");
			String pressed = sc.next();
			if(pressed.equals("release")) {
				clutchPressed=false;
			}
		}
		
		System.out.println("To speed up, press accelerator(type press)");
		String pressed = sc.next();
		if(pressed.equals("press")&&isAuto==false) {
			if(clutchPressed==true) {
				System.out.println("Cannot speed up while clutch is pressed. Operation terminated");
			}else {
				switch(gearValue) {
				case 0:
					System.out.println("Cannot speed up in neutral");
					speed=0;
					break;
				case 1:
					if(speed>=25) {
						System.out.println("Cannot increase speed. Please upshift to increase speed");
					}else if(speed==20){
						speed = speed+5;
						System.out.println("Speed now increased to "+speed+".");
						System.out.println("Please upshift before increaing speed again");
					}else {
						speed = speed+5;
						System.out.println("Speed now increased to "+speed+".");
						
					}
				    break;
				case 2:
					if(speed>=40) {
						System.out.println("Cannot increase speed. Please upshift to increase speed");
					}else if(speed==35){
						speed = speed+5;
						System.out.println("Speed now increased to "+speed+".");
						System.out.println("Please upshift before increaing speed again");
					}else {
						speed = speed+5;
						System.out.println("Speed now increased to "+speed+".");
					}
				    break;
				   
				case 3:
					if(speed==60) {
						System.out.println("Cannot increase speed. Please upshift to increase speed");
					}else if(speed==20){
						speed = speed+5;
						System.out.println("Speed now increased to "+speed+".");
						System.out.println("Please upshift before increaing speed again");
					}else {
						speed = speed+5;
						System.out.println("Speed now increased to "+speed+".");
					}
				    break;
					
				case 4:
					if(speed>=80) {
						System.out.println("Cannot increase speed. Please upshift to increase speed");
					}else if(speed==75){
						speed = speed+5;
						System.out.println("Speed now increased to "+speed+".");
						System.out.println("Please upshift before increaing speed again");
					}else {
						speed = speed+5;
						System.out.println("Speed now increased to "+speed+".");
					}
				    break;
					
				case 5:
					if(speed>=100) {
						System.out.println("Cannot increase speed. Please upshift to increase speed");
					}else if(speed==95){
						speed = speed+5;
						System.out.println("Speed now increased to "+speed+".");
						System.out.println("Please upshift before increaing speed again");
					}else {
						speed = speed+5;
						System.out.println("Speed now increased to "+speed+".");
					}
				    break;
					
				case 6:
					if(speed>=120) {
						System.out.println("Cannot increase speed. Please upshift to increase speed");
					}else if(speed==115){
						speed = speed+5;
						System.out.println("Speed now increased to "+speed+".");
						System.out.println("Please upshift before increaing speed again");
					}else {
						speed = speed+5;
						System.out.println("Speed now increased to "+speed+".");
					}
				    break;
					
			
				
				}
			}
		}else if(pressed.equals("press")&&isAuto==true) {
			if (currentGear != 'd'){
					System.out.println("Put Car in drive to accelerate");
			}else {
				if(speed<200) {
					speed=speed+5;
					System.out.println("Speed of car is now"+speed);
				}else {
					System.out.println("Cannot speed up further");
				}
			}
		}
		
	}

	@Override
	public void applyBrakes() {
		// TODO Auto-generated method stub
		
	}
	
}

public class Assignment5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		car c=new car();
		String cont;
		
		do {
		 
		 System.out.println("Enter operation to be done on car");
		 int choice = sc.nextInt();
		 switch(choice) {
		 case 1:
			 c.gearChange();
			 break;
		 case 2:
			 c.speedUp();
			 break;
		 case 3:
			 c.applyBrakes();
			 break;
	     default:
	    	 System.out.println("Invalid input");
		 }
		 System.out.println("Do you wish to continue?(type yes to continue)");
		 cont = sc.next().toLowerCase();		

	  }while(cont.equals("yes"));

}
}
