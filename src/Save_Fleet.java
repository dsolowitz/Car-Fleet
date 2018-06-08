import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
public class Save_Fleet {
	private Fleet fleet;
	
	public Save_Fleet(Fleet fleetCopy) throws java.io.IOException{
		java.io.File file = new java.io.File("Fleet.txt");
		this.fleet = fleetCopy;
		
		
	
	try (java.io.PrintWriter output = new java.io.PrintWriter(file)) {
		
		
		for (int i = 0; i< fleet.size(); i++) {
			output.println(fleet.get(i).toString().replaceAll(",|=", "").trim());
		}
		output.close();
	}
}
	
}