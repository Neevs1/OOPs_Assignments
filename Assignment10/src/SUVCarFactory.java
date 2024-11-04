
public class SUVCarFactory implements CarFactory{
    @Override
	public Car buildCar(String model, String wheel, String engine,String colour,String variant,String fuel) {
               
        Car car = new SUVCar(model, wheel, engine,colour,variant,fuel);
          
        return car;   
}
}