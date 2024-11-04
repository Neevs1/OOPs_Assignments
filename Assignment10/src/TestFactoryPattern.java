import java.util.Scanner;


public class TestFactoryPattern {

	CarFactory carBuilder;
	Car car;
    public static void main(String[] args) {
    	TestFactoryPattern client = new TestFactoryPattern();
       client.buildCarMethod();
    }
    public void buildCarMethod() {
    	Scanner sc = new Scanner (System.in);
    	System.out.println("Welcome to car dealership, please enter your choice of car");
    	System.out.println("1.Hatchback\n2.Sedan\n3.SUV");
    	int choice = sc.nextInt();
    	switch(choice) {
    	case 1:
    		carBuilder = new HatchbackCarFactory();
    		System.out.println("Choice of hatckback is\n1.Suzuki Baleno\n2.VW Polo\n3.Hyundai i20");
    		choice=sc.nextInt();
    		switch(choice) {
    		case 1:
    			car = carBuilder.buildCar("Suzuki Baleno", "Apollo", "1.2 VVT","Nexa Blue","Zeta AGS","Petrol");
    			break;
    		case 2:
    			car = carBuilder.buildCar("VW Polo", "Michelin", "1.2 TSI","Orange","GT","Petrol");
    			break;
    		case 3:
    			car = carBuilder.buildCar("Hyundai i20", "Bridgestone", "1.2 VTVT","Abyss Black","N8","Petrol");
    			break;
    		default:
    			System.out.println("Invalid option");
    			car = carBuilder.buildCar("NA", "NA", "NA","NA","NA","NA");
    			break;
    		}
    		break;
    	case 2:
    		carBuilder = new SedanCarFactory();
    		System.out.println("Choice of Sedan is\n1.Suzuki Dzire\n2.Honda City\n3.Toyota Corolla");
    		choice=sc.nextInt();
    		switch(choice) {
    		case 1:
    			car = carBuilder.buildCar("Suzuki Dzire", "Apollo", "1.3 DDiS","Golden","VDi","Diesel");
    			break;
    		case 2:
    			car = carBuilder.buildCar("Honda City", "Continental", "1.5 eHEV","Obsidian Blue Pearl","ZX","Petrol + Electric Hybrid");
    			break;
    		case 3:
    			car = carBuilder.buildCar("Toyota Corolla", "Bridgestone", "1.8 VVT-i","Metallic Silver","VX CVT","Petrol");
    			break;
    		default:
    			System.out.println("Invalid option");
    			car = carBuilder.buildCar("NA", "NA", "NA","NA","NA","NA");
    			break;
    		}
    		break;
    	case 3:
    		carBuilder = new SUVCarFactory();
    		System.out.println("Choice of SUV is\n1.Suzuki Brezza\n2.Honda Elevate\n3.Toyota Fortuner");
    		choice=sc.nextInt();
    		switch(choice) {
    		case 1:
    			car = carBuilder.buildCar("Suzuki Brezza", "Apollo", "1.5 VVT","Magma Grey","VXI CNG","Petrol+CNG");
    			break;
    		case 2:
    			car = carBuilder.buildCar("Honda Elevate", "Continental", "1.5 iVTEC","Lunar Silver Metallic","ZX","Petrol");
    			break;
    		case 3:
    			car = carBuilder.buildCar("Toyota Fortuner", "Bridgestone", "2.8 D4D","Platinum White Pearl","Legender 4x4","Diesel");
    			break;
    		default:
    			System.out.println("Invalid option");
    			car = carBuilder.buildCar("NA", "NA", "NA","NA","NA","NA");
    			break;
    		}
    		break;
    		
    	}
        System.out.println(car.getdata());

//Tomorrow if we want to build new type say MUV then we just hv to create new subclass of Car class and new subclass of CarFactory. No need to update exixtsing class.
//This is beauty of factory method. Consumer always uses factory interface instead of implementation
    }
}
