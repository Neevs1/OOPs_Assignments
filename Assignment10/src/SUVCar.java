
public class SUVCar implements Car {
		 
	 String model;
	 String wheel;
	 String engine;
	 String fuel;
	 String variant;
	 String colour;
		
	    SUVCar(String model, String wheel, String engine,String colour,String variant,String fuel) {
	    	this.model = model;
			this.wheel = wheel;
			this.engine = engine;
			this.fuel = fuel;
			this.variant = variant;
			this.colour = colour;
	    } 
		
		public String getModel()
		{
			return model;
		}

			
		public void setWheel(String wheel)
		{
			this.wheel = wheel;
		}

		public String getWheel()
		{
			return wheel;
		}
		
		public void setEngine(String engine)
		{
			this.engine = engine;
		}

		public String getEngine()
		{
			return engine;
		}

		@Override
		public String getColour() {
			
			return colour;
		}

		@Override
		public void setColour(String colour) {
			this.colour = colour;
			
		}

		@Override
		public String getVariant() {
			
			return variant;
		}

		@Override
		public void setVariant(String variant) {
			this.variant = variant;
			
		}

		@Override
		public String getFuel() {
			
			return fuel;
		}

		@Override
		public void setFuel(String fuel) {
			this.fuel = fuel;
			
		}

		@Override
		public String getdata() {
			if(model.equals("NA")) {
				return "Car not built";
			}
			String data = "Car is assembled and painted now. Car specs :\n"+ model +" "+ variant + " having "+engine+" "+fuel+" engine, in "+colour+" colour"+" with "+wheel+" tyres";
			return data;
		}

		
	}

