


	public class SedanCarFactory implements CarFactory{
	    @Override
		public Car buildCar(String model, String wheel, String engine,String colour, String variant,String fuel) {
	               
	        Car car = new SedanCar(model, wheel, engine,colour,variant,fuel);
			
	          
	        return car;  
		}
	}
