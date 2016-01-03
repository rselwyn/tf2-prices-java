package API;

import java.io.*;

public class MarketConstants {
	//The URLs on bp.tf for keys and refined metal
	private static final String KEY_URL = "";	
	private static final String REF_URL = "";
	
	/*
	 * All the conversion values that are needed.
	 */
	private static float keysToRef;
	private static float keysToDollars;
	
	private static float refToKeys;
	private static float refToDollars;
	
	private static float dollarsToRef;
	private static float dollarsToKeys;
	
	static{
		try{
			keysToRef = new ItemFetcher(KEY_URL).getItem().getRefPrice();
			refToKeys = 1/keysToRef;
			
			refToDollars = (new ItemFetcher(KEY_URL).getItem().getDollarPrice());
			dollarsToRef = 1/refToDollars;
			dollarsToKeys = dollarsToRef * refToKeys;
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
}
