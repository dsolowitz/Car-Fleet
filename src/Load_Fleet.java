import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Load_Fleet {
private Fleet fleet;
private String x;
	
	public Load_Fleet(Fleet fleetCopy) throws java.io.IOException{
		File file = new File("Fleet.txt");
		Scanner input = new Scanner(file);
		this.fleet = fleetCopy;
		
		
		
	while(input.hasNext()) {
		
			
			String x = input.nextLine();	
			String [] args = x.split(" ");
			Car car = new Car(args[2], Integer.parseInt(args[4]), Integer.parseInt(args[6]));
			fleet.add(car);
			
			
	}
			input.close();
			
			
	}
			
}




