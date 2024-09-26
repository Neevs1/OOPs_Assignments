/*
 * 
 */
import java.util.*; //imported scanner class

interface vehicle{ //implemented vehicle interface with common methods
	Scanner sc = new Scanner(System.in); //created object in interface to be used by all
	void gearChange(); //Declared gearchange function
	void speedUp(); //declared function for speeding up
	void applyBrakes(); //declared function to apply brakes
	
	
}

class bicycle implements vehicle{ //declared bicycle class
	boolean hasGear;
	int gearValue=1,speed,gear;
	bicycle() { //constructor for input
		System.out.println(" -------- __@      __@       __@       __@      __~@\r\n"
				+ " ----- _`\\<,_    _`\\<,_    _`\\<,_     _`\\<,_    _`\\<,_\r\n"
				+ " ---- (*)/ (*)  (*)/ (*)  (*)/ (*)  (*)/ (*)  (*)/ (*)\r\n"
				+ " ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	 System.out.println("Enter enter whether cycle has changeable gears(yes/no)");
	 String gear = sc.next(); //to determin whether cycle has single/multiple gears
	 if(gear.equals("yes")) {
		 hasGear=true;
		 do {
			 System.out.println("Please enter number of gears");
			 this.gear = sc.nextInt();
			 if(this.gear>0&&this.gear<=27) {
				 System.out.println("Invalid input");
			 }
		 }while(this.gear>0&&this.gear<=27); //cycles cannot have 0 or absurdly high amount of gears
		 
	 }else {
		 hasGear=false;
	 }
	 
	}

	
	public void gearChange() { //method to change gears
		if(hasGear==true) { //only if gears exist
			System.out.println("Do you want to upshift(1)/downshift(2)");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				if(gearValue==this.gear) { //cannot shift further in max gear
					System.out.println("Cannot upshift further");
				}else {
					gearValue++;
					System.out.println("Gear value is now"+gearValue);
				}
				break;
			case 2:
				if(gearValue==1) { //cannot shift lower than 1st gear
					System.out.println("Cannot downshift further");
				}else {
					gearValue--;
					System.out.println("Gear value is now"+gearValue);
				}
				break;
			default: //to handle invalid input
				System.out.println("Invalid input");
				break; 
				
				
			}
		}else { //non changeable gears
			System.out.println("Your cycle does not have changeable gears");
		}
		
		
	}

	
	public void speedUp() { //increase speed
		if(speed==80) {
			System.out.println("Cannot speed up further. Dangerous");		
		}else {
			speed=speed+5;
			System.out.println("Speed is now "+speed);
		}
		
	}

	
	public void applyBrakes() { //apply brakes
		if(speed==0) {
			System.out.println("Cannot decrease speed further. You are at a standstill");		
		}else {
			speed=speed-5;
			System.out.println("Speed is now "+speed);
		}
		
		
		
	}
	
}

class motorCycle implements vehicle{ //motorcycle class
	boolean isAuto,gasPressed,clutchPressed,brakePressed,stalled,isNeutral;
	int speed=0,gearValue =0,gears;
	String auto;	

	motorCycle(){ //constructor for input
		do {
			System.out.println("  r==\r\n"
					+ "        _  //\r\n"
					+ "       |_)//(''''':\r\n"
					+ "         //  \\_____:_____.-----.P\r\n"
					+ "        //   | ===  |   /        \\\r\n"
					+ "    .:'//.   \\ \\=|   \\ /  .:'':.\r\n"
					+ "   :' // ':   \\ \\ ''..'--:'-.. ':\r\n"
					+ "   '. '' .'    \\:.....:--'.-'' .'\r\n"
					+ "    ':..:'                ':..:'");	
			System.out.println("Enter whether your bike is Automatic(true/false)");
			auto = sc.next().toLowerCase(); //whether motorcycle is manual or automatic
			if(auto.equals("true")==false&&auto.equals("false")==false){
				System.out.println("Invalid input");		
			}else {
				isAuto = Boolean.parseBoolean(auto);
			}
			}while(!auto.equals("true")&&!auto.equals("false")); //takes number of gears if motorcycle is manual
			do {
				System.out.println("Enter number of gears");
				gears = sc.nextInt();
				if(gears<0||(isAuto == false && gears>6)) { //cannot have gears less than zero or high amount of gears
					System.out.println("Invalid input");				
				}
				}while(gears<0||(isAuto == false && gears>6));
		
	}
	public void gearChange() { //changing gears
		if(isAuto==true) {
			System.out.println("Cannot change gears in CVT two wheelers");
			//you cannot change gears of a auto two wheeler. It changes by itself
		}else { //only for manual bikes
			System.out.println("Type PRESS to press clutch");
			String input = sc.next().toUpperCase();
			if(input.equals("PRESS")) {
				clutchPressed = true;
				System.out.println("Do you want to upshift(1) or downshift(2)?");
				int choice = sc.nextInt();
				if(choice==1) {
					if(gearValue==gears) { //cannot change if bike in highest gear
						System.out.println("Cannot upshift further");
					}else {
						gearValue++;
						System.out.println("Bike is now in gear "+gearValue+" 🏍️");
					}
				}else if(choice==2) {
					if(gearValue==0) { //cannot chage if bike is in lowest gear
						System.out.println("Bike is in neutral,cannot downshift further");
					}else if(gearValue==1) {
						gearValue--;
						System.out.println("Bike is now in neutral 🏍️");
						isNeutral=true;
					}
				}else { //handles invalid input
					System.out.println("Invalid choice.Operation terminated");
				}
			}else { //cannot change gears without pressing clutch
				System.out.println("Clutch not pressed. Cannot change gears.Operation terminated");
			}
		}
		
	}

	@Override
	public void speedUp() { //speeding up
		if(isAuto==false&&clutchPressed==true) {
			System.out.println("Please release clutch(type release)");
			String pressed = sc.next(); //cannot speed up if clutch is pressed
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
				switch(gearValue) { //you can only achieve certain speeds in certain gears
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
		}else if(pressed.equals("press")&&isAuto==true) { //for automatic, you can increase speed linearly
			
				if(speed<150) {
					speed=speed+5;
					System.out.println("Speed of bike is now"+speed);
				}else {
					System.out.println("Cannot speed up further");
				}
			
		}
		
	}

	@Override
	public void applyBrakes() { //applying brakes
		if(isAuto && speed!=5) { //decreases speed by 5
			speed=speed-5;
			System.out.println("Speed is now "+speed);
		}else if(isAuto&&speed==5) {
			speed=0;
			System.out.println("Car has stopped now");
		}else if(isAuto==false) {
			switch(gearValue) {
			case 0:
				System.out.println("Car already stopped");
				speed=0;
				break;
			case 1:
				if(speed==5) { //prevents stalling
					System.out.println("Car is stopping please press clutch type press");
					String pressed = sc.next();
					if(pressed.equals("press")) {
						clutchPressed = true;
						speed=0;
						System.out.println("Your bike has stopped, shifting to neutral");
						gearValue--;						
					}else {
						System.out.println("Your bike has stalled");
						System.exit(0); //exits if stalled
					}
				}else {
					speed = speed-5;
					System.out.println("Speed now decreased to "+speed+".");
					
				}
			    break;
			case 2:
				if(speed==20) {
					System.out.println("Please downshift");
				
				}else {
					speed = speed-5;
					System.out.println("Speed now decreased to "+speed+".");
				}
			    break;
			   
			case 3:
				if(speed==40) {
					System.out.println("Please downshift");
				
				}else {
					speed = speed-5;
					System.out.println("Speed now decreased to "+speed+".");
				}
			    break;
				
			case 4:
				if(speed==60) {
					System.out.println("Please downshift");
				
				}else {
					speed = speed-5;
					System.out.println("Speed now decreased to "+speed+".");
				}
			    break;
				
			case 5:
				if(speed==80) {
					System.out.println("Please downshift");
				
				}else {
					speed = speed-5;
					System.out.println("Speed now decreased to "+speed+".");
				}
			    break;
				
			case 6:
				if(speed==100) {
					System.out.println("Please downshift");
				
				}else {
					speed = speed-5;
					System.out.println("Speed now decreased to "+speed+".");
				}
			    break;
				
		
			
			}
		}
	}
	
}

class car implements vehicle{ //car class
	boolean isAuto,gasPressed,clutchPressed,brakePressed,stalled,isNeutral;
	int speed=0,gearValue =0,gears;
	char currentGear='p';
	String auto;
	car() { //constructor used for input
		do {
		System.out.println("                   .--------.\r\n"
				+ "              ____/_____|___ \\___\r\n"
				+ "             O    _   - |   _   ,*\r\n"
				+ "              '--(_)-------(_)--'");	
		System.out.println("Enter whether your car is Automatic(true/false)");
		auto = sc.next().toLowerCase();
		if(auto.equals("true")==false&&auto.equals("false")==false){ //checks whether car is auto or manual
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
	public void gearChange() { //change gears
		if(isAuto==true) {
			System.out.println("Car is currently in gear "+currentGear+"\nPlease type which gear you want to change to\nP R N D");
			char newgear = sc.next().toLowerCase().charAt(0);	
			switch(newgear) { //handles gears for automatic car
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
		}else { //handles gears for manual cars
			System.out.println("Type PRESS to press clutch");
			String input = sc.next().toUpperCase();
			if(input.equals("PRESS")) {
				clutchPressed = true;
				System.out.println("Do you want to upshift(1) or downshift(2)?");
				int choice = sc.nextInt();
				if(choice==1) { //upshifting
					if(gearValue==gears) {
						System.out.println("Cannot upshift further");
					}else {
						gearValue++;
						System.out.println("Car is now in gear "+gearValue+" 🚗");
					}
				}else if(choice==2) { //downshifting
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
	public void speedUp() { //function to increase speed
		/*
		 * Manual car needs clutch to be released
		 * Every gear has certain speed it can go to
		 * Cannot speed up/down in neutral
		 */
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
			//automatic car needs to be shifted into drive
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
		/*
		 * In manual cars, downshifting is required as per speed
		 * To stop completely, you need both clutch and break
		 * In automatic cars, only brake is required
		 * 
		 */
		if(isAuto && speed!=5) {
			speed=speed-5;
			System.out.println("Speed is now "+speed);
		}else if(isAuto&&speed==5) {
			speed=0;
			System.out.println("Car has stopped now");
		}else if(isAuto==false) {
			switch(gearValue) {
			case 0:
				System.out.println("Car already stopped");
				speed=0;
				break;
			case 1:
				if(speed==5) {
					System.out.println("Car is stopping please press clutch type press");
					String pressed = sc.next();
					if(pressed.equals("press")) {
						clutchPressed = true;
						speed=0;
						System.out.println("Your car has stopped, shifting to neutral");
						currentGear--;						
					}else {
						System.out.println("Your car has stalled");
						System.exit(0);
					}
				}else {
					speed = speed-5;
					System.out.println("Speed now decreased to "+speed+".");
					
				}
			    break;
			case 2:
				if(speed==20) {
					System.out.println("Please downshift");
				
				}else {
					speed = speed-5;
					System.out.println("Speed now decreased to "+speed+".");
				}
			    break;
			   
			case 3:
				if(speed==40) {
					System.out.println("Please downshift");
				
				}else {
					speed = speed-5;
					System.out.println("Speed now decreased to "+speed+".");
				}
			    break;
				
			case 4:
				if(speed==60) {
					System.out.println("Please downshift");
				
				}else {
					speed = speed-5;
					System.out.println("Speed now decreased to "+speed+".");
				}
			    break;
				
			case 5:
				if(speed==80) {
					System.out.println("Please downshift");
				
				}else {
					speed = speed-5;
					System.out.println("Speed now decreased to "+speed+".");
				}
			    break;
				
			case 6:
				if(speed==100) {
					System.out.println("Please downshift");
				
				}else {
					speed = speed-5;
					System.out.println("Speed now decreased to "+speed+".");
				}
			    break;
				
		
			
			}
		}
		
	}
	
}

public class Assignment5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    String cont;
		System.out.println("Please select your vehicle");
		System.out.println("1.Bicycle\n2.Motorcycle\n3.Car");
		int vchoice = sc.nextInt();
		switch(vchoice) {//choice of vehicle offered to user
		case 3: 
			car c=new car(); //creates car object
			do {
				 System.out.println("Enter operation to be done on car");
				 System.out.println("1.Change Gear\n2.Increase speed\n3.Apply brakes");
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
					break;
		case 2:
			motorCycle m = new motorCycle(); //creates motorcycle object
			do {
			System.out.println("Enter operation to be done on Motorbike");
			 int choice = sc.nextInt();
			 switch(choice) {
			 case 1:
				 m.gearChange();
				 break;
			 case 2:
				 m.speedUp();
				 break;
			 case 3:
				 m.applyBrakes();
				 break;
		     default:
		    	 System.out.println("Invalid input");
			 }
			 System.out.println("Do you wish to continue?(type yes to continue)");
			 cont = sc.next().toLowerCase();		

		  }while(cont.equals("yes"));
			break;
		case 1:
			bicycle b = new bicycle(); //creates bicylce object
			do {
				 System.out.println("Enter operation to be done on cycle");
					 int choice = sc.nextInt();
					 switch(choice) {
					 case 1:
						 b.gearChange();
						 break;
					 case 2:
						 b.speedUp();
						 break;
					 case 3:
						 b.applyBrakes();
						 break;
				     default:
				    	 System.out.println("Invalid input");
					 }
					 System.out.println("Do you wish to continue?(type yes to continue)");
					 cont = sc.next().toLowerCase();		

				  }while(cont.equals("yes"));
					break;
				default:
					System.out.println("Invalid input");
				    break;
			
		}

}
}
