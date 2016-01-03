package API;

import java.io.*;

public class MarketConstants {
	//The URLs on bp.tf for keys and refined metal
	public static final String KEY_URL = "/stats/Unique/Mann%20Co.%20Supply%20Crate%20Key/Tradable/Craftable";	
	public static final String REF_URL = "/stats/Unique/Refined%20Metal/Tradable/Craftable";
	
	/*
	 * All the conversion values that are needed.
	 */
	public static float keysToRef;
	public static float keysToDollars;
	
	public static float refToKeys;
	public static float refToDollars;
	
	public static float dollarsToRef;
	public static float dollarsToKeys;
	
	static{
		try{
			keysToRef = new ItemFetcher(KEY_URL).getItem().getRefPrice(); //working
			refToKeys = 1/keysToRef; //working
			
			refToDollars = 1/(new ItemFetcher(REF_URL).getItem().getDollarPrice());
			dollarsToRef = 1/refToDollars;
			
			dollarsToKeys = 1/(refToDollars * refToKeys); //
			keysToDollars = 1/dollarsToKeys;
			//System.out.println(dollarsToKeys + " " + keysToDollars);
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
}
