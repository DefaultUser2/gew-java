import java.util.*;

public class Distance {
  
	public static void main(String[] args) {
		//get system input 
		Scanner in = new Scanner(System.in);
    	int ValX = in.nextInt();
		int ValY = in.nextInt();
		System.out.println("ECHO: "+ValX+" "+ValY);	
		DoCalculations(ValX, ValY);
	}
	
	public static void DoCalculations(int ValX, int ValY)
	{
		//create distance table as arrays 
		int[] LocationA = {0,   365, 381, 220, 1325, 808, 673};
		int[] LocationB = {365, 0  , 225, 575, 995,  730, 320};
		int[] LocationC = {381, 225, 0,   590, 970,  948, 415};
		int[] LocationD = {220, 575, 590, 0,   1540, 890, 890};
		int[] LocationE = {1325,995, 970, 1540,0,    1462,710};
		int[] LocationF = {808, 730, 948, 890, 1462, 0,   810};
		int[] LocationG = {673, 320, 415, 890, 710,  810, 0};
		int[] CurrentArray = null;
		String test = "";
		//Determine destination
		switch(ValY) {
		  case 1:
			  CurrentArray = LocationA;
		    break;
		  case 2:
			  CurrentArray = LocationB;
		    break;
		  case 3:
			  CurrentArray = LocationC;
			break;
		  case 4:
			  CurrentArray = LocationD;
			  break;
		  case 5:
			  CurrentArray = LocationE;
		  	break;
		  case 6:
			  CurrentArray = LocationF;
			  break;
		  case 7:
			  CurrentArray = LocationG;
			  break;
			
		  default:
		    System.out.println("invalid value");
		}
		//Use origin index with destination array to determine distance.
		System.out.println(CurrentArray[ValX - 1]);
		
	}
}