

public class HatchbackCarFactory implements CarFactory {
	  @Override
		public Car buildCar(String model, String wheel, String engine,String colour,String variant,String fuel) {
	               
	        Car car = new HatchbackCar(model, wheel, engine,colour,variant,fuel);
			//Can declare and call internal method to assemble parts here
	        //System.out.println("%s car is assembled with wheels from %s and engine from %s"+ car.model+ car.wheel+ car.engine);
	        return car;  
		}
	}



