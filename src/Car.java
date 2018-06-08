
public class Car {
	private String carName;
	private int carMiles = 0;
	private int fuelCon = 0;
	
	public Car(){
		
	}
	public Car(String newCarName){
		this.carName = newCarName;
	}
	public Car(String newCarName, int newCarMiles, int newFuelCon){
		this.carName = newCarName;
		this.carMiles = newCarMiles;
		this.fuelCon = newFuelCon;
	}
	public int getMiles() {
		return carMiles;
	}
	public int getFuelUsed() {
		return fuelCon;
	}
	public String getIdentifier() {
		return carName;
	}
	public double getMPG() {
		
		return (double)carMiles / fuelCon;
		
		
	}
	public  int compareMPG(Car otherCar) {
		
		if (this.getMPG() < otherCar.getMPG()) {
			return -1;}
		if (this.getMPG() > otherCar.getMPG()) {
			return 1;
		}
		else   {
			return 0;
		}
		}
	public String toString() {
		return "Car identifier =" + carName + " ,miles ="+carMiles+" ,fuelUsed ="+fuelCon+"\n";
		
	}
	
	public boolean equals(Object obj){
		   if (this==obj) return true;
		   if (obj==null) return false;
		   if (this.getClass()!=obj.getClass()) return false;
		   final Car other = (Car)obj;
		   if ((this.getIdentifier().equals(other.getIdentifier()) &&
		       this.getMPG()==other.getMPG()))
		         return true;
		       return false;
		 }
	public void setMiles(int newMiles) {
		this.carMiles = (newMiles >= 0) ? newMiles : carMiles;
	}
	public void setFuelUsed(int fuelUsed) {
		this.fuelCon = (fuelUsed >= 0) ? fuelUsed : fuelCon;
	}
	public void setIdentifier(String carsNewName) {
		this.carName = carsNewName;
	}
	public void addFuel(int moreFuel) {
		fuelCon += moreFuel;
	}
	public void addMiles(int moreMiles) {
		carMiles += moreMiles;
	}
}
