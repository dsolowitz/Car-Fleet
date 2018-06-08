import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class Fleet extends ArrayList<Car> {
	
	
	public Fleet() {
		
	}
	

	public boolean add(Car carToAdd) {
		if (super.add(carToAdd)== true) {
			return true;
		}
		return false;
	}
	
	public int size() {
		int size = super.size();
		return size;
	}
	
	public double getCarAverageMPG() {
		if( super.size() >= 1) {
			double totalMPG = 0.00;
			
			
			for(int i = 0; i< super.size(); i++) {
				totalMPG +=(double) super.get(i).getMPG();
				
			}
			double carMPG = totalMPG/(double)super.size();
			return carMPG;
		}
		else {
			return -1;
		}
	}
	
	public String getFleetAverageMPG() {
		if(super.size() >=1) {
			double totalMiles = 0;
			double totalFuel = 0;
			for(int i = 0; i< super.size(); i++) {
				totalMiles += super.get(i).getMiles();
				totalFuel += super.get(i).getFuelUsed();
			}
			double fleetMPG = (double)(totalMiles / totalFuel);
			return String.format("%.02f", fleetMPG);
		}
		else {
			return null;
		}
	}
	
	public int getTotalMiles() { 
		int totalMiles = 0;
		for(int i = 0; i< super.size(); i++) {
			totalMiles += super.get(i).getMiles();
		}
		return totalMiles;
	}
	public int getTotalFuel() {
		int totalFuel = 0;
		for(int i = 0; i < super.size(); i++) {
			totalFuel += super.get(i).getFuelUsed();
		}
			return totalFuel;
	}
	public void delete(String carId) {
		for(int i =0; i< super.size(); i++) {
			
			if(super.get(i).getIdentifier().equals(carId)) {
				 super.remove(super.get(i));
		}
		}
	}
	public void editName(String carId, String carsNewName) {
		for(int i =0; i< super.size(); i++) {
			if(super.get(i).getIdentifier().equals(carId)) {
				super.get(i).setIdentifier(carsNewName);
			}
		}
	
	}
	
	public void editMiles(String carId, int newMiles) {
		for(int i =0; i< super.size(); i++) {
			if(super.get(i).getIdentifier().equals(carId)) {
				super.get(i).setMiles(newMiles);
			}
		}
	
	}
	
	public void editFuel(String carId, int newFuel) {
		for(int i =0; i< super.size(); i++) {
			if(super.get(i).getIdentifier().equals(carId)) {
				super.get(i).setFuelUsed(newFuel);
			}
		}
	
	}
	public String getBestMPG() {
		Car x = null;
		x = super.get(0);
		for (int i = 0; i < super.size(); i++) {
			if (x.getMPG() < super.get(i).getMPG()) {
				x = super.get(i);
			}
		}
		
		return (x.getIdentifier() + " " + String.format("%.02f", x.getMPG()));
	}
	
	public String getHighMiles() {
		Car x = null;
		x = super.get(0);
		for (int i = 0; i < super.size(); i++) {
			if (x.getMiles() < super.get(i).getMiles()) {
				x = super.get(i);
			}
		}
		
		return (x.getIdentifier() + " " + String.valueOf(x.getMiles()));
	}
	public Car get(int position) {
		return super.get(position);
		
	}
	public String toString() {
		return super.toString();
	}
	
	
	
	public ArrayList<Car> getSortedByMPG(){
		ArrayList<Car> carSort = new ArrayList<>(this);
		
		 
		Collections.sort(carSort, Comparator.comparingDouble(Car::getMPG));;
		
		
		 return carSort;
	
	}
	
	
}
