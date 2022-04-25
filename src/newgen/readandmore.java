package newgen;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.lang.Math;

public class readandmore{
	public static void main(String[] args) {
		List<cab> cabs = readCabsFromFile("C:/sts-projects/newgen/resources/file.txt");
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER YOUR LOCATION ID");
		int i=sc.nextInt();
	    HashMap<Long, cab> compute = new HashMap<Long, cab>();
		for(cab c:cabs) {
			compute.put(Math.abs(i-c.getLocationId()), c);
		}
		 
		TreeMap<Long, cab> sorted = new TreeMap<>();
		// Copy all data from hashMap into TreeMap
	    sorted.putAll(compute);
	    long firstCar=-1,firstBike=-1,firstAuto=-1;
	    for (Map.Entry<Long, cab> entry : sorted.entrySet()) {
	       if(entry.getValue().getAvailability().equals("yes") && entry.getValue().getVehicleCategory().equals("car") && firstCar==-1) {
	    	   firstCar=entry.getKey();
	       }
	       if(entry.getValue().getAvailability().equals("yes") && entry.getValue().getVehicleCategory().equals("bike") && firstBike==-1) {
	    	   firstBike=entry.getKey();
	       }
	       if(entry.getValue().getAvailability().equals("yes") && entry.getValue().getVehicleCategory().equals("auto") && firstAuto==-1) {
	    	   firstAuto=entry.getKey();
	       }
	     }
	    System.out.println(sorted.get(firstCar));
	    System.out.println(sorted.get(firstAuto));
	    System.out.println(sorted.get(firstBike));
	}
	public static List<cab> readCabsFromFile(String file){
		List<cab> cabs=new ArrayList<>();
		Path pathToFile = Paths.get(file);
		 try (BufferedReader br = Files.newBufferedReader(pathToFile,StandardCharsets.US_ASCII)) {
			 String line = br.readLine();
			 while (line != null) {
				 String[] cabDetails = line.split(",");
				 cab cab = createCab(cabDetails);
				 cabs.add(cab);
				 line=br.readLine();
			 }
		 }catch (IOException ioe) {
	           ioe.printStackTrace();}
		 return cabs;
	}
	public static cab createCab(String [] data) {
		int locationId=Integer.parseInt(data[0]);
		String vehicleNo = data[1];
		String vehicleCategory = data[2];
		String availability = data[3];
		long contactNumber=Long.parseLong(data[4]);
		return new cab(locationId,vehicleNo,vehicleCategory,availability,contactNumber);
		
		
	}
}
