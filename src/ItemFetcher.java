import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import ItemQualities.*;


public class ItemFetcher {
	
	/*
	 * Jsoup Variables
	 */
	private Document doc;
	private Element price;
	private final String userAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36";
	
	/*
	 * Item Variables
	 */
	private HashMap<String,Float> priceInCurrency = new HashMap<String,Float>();//A map containg the price in several real life currencys priceInCurrency["USD"] or priceInCurrency["GBP"]
	private float priceInRef;
	private float priceInKeys;
	private float valueInUSD;
	private Item item;
	private String name;
	private Quality itemQuality; //Item Quality
	
	//Url
	private String url;
	public ItemFetcher(String url) throws IOException{
		//Set doc.  Set the userAgen
		doc = Jsoup.connect("http://backpack.tf"+url).userAgent(userAgent).timeout(1000).get();
		//Get the string inside of the area for price
		price = doc.getElementsByClass("item-panel-btns").first().child(0);
		//Just print the result
		System.out.println(price.text());
		//Decide the primary listing currency
		decidePrimaryCurrency(price.text());
		//Print the value
		System.out.println(valueInUSD);
		//Set the url
		this.url = java.net.URLDecoder.decode(url, "UTF-8");;
		this.name = this.url.split("/")[3];
		itemTypeToEnumeration(this.url.split("/")[2]);
		//Construct a new item
		item = new Item(this.priceInRef, this.priceInKeys, this.valueInUSD, null, this.name);
	}
	
	/*
	 * Takes a string and decides whether the price 
	 */
	private void decidePrimaryCurrency(String which){

		if(which.contains("$")){
			
			System.out.println(which.substring(1));
			this.valueInUSD = convertDollars(which.substring(1));
			return;
		}
		try{
			switch(which.split(" ")[1]){
			case "ref": this.priceInRef = convertDashSeperated(which,true) ; break;
			case "keys": this.priceInKeys = Float.parseFloat(which.split(" ")[0]) ; break;
			}
		}
		catch(Exception e){
			//any other exception is unexpected
			e.printStackTrace();
		}
	}
	
	public Item getItem(){
		return this.item;
	}
	
	/*
	 * Takes two numbers seperated by a - and gets the average
	 * @param	refVal: THe expression to parse
	 * @return	the average of the two numbers
	 */
	private float convertDashSeperated(String refVal, boolean roundOr){
		
		//Two cases, one if it is a range, one if there is 1 val

		if (refVal.contains("–")){
			String[] vals = refVal.split(" ")[0].split("–");
			float val = Float.parseFloat(vals[0])+Float.parseFloat(vals[1]);
			val/=2;
			if (roundOr) val = round((double) val, .11f);
			return val;	
		}
		else{
			return Float.parseFloat(refVal.split(" ")[0]);
		}
		
	}
	
	//Round i to the nearest v
	private float round(double i, float v){
	    return Math.round(i/v) * v;
	}
	
	/*
	 * Takes a character and sees if it is in a string
	 * @param	c: the value to look for
	 * @param	s: the string to look in
	 * @return	True or false, if c is in s
	 */
	private Boolean containsChar(char c, String s){
		for (char ch : s.toCharArray()){
			if(ch == c){
				return true;
			}
		}
		return false;
	}
	
	
	/*
	 * @param exprWithDollars:  The expression in the form of $XY-AB
	 * @return the average of the two monetary values
	 */
	private float convertDollars(String exprWithDollars){
		exprWithDollars = exprWithDollars.substring(1);
		return convertDashSeperated(exprWithDollars,false);
	}
	
	/*
	 * Parse the text to the quality enumeration
	 * @param	text: the text to be converted to an enum
	 */
	private void itemTypeToEnumeration(String type){
		if (type.equalsIgnoreCase("unique")) this.itemQuality = Quality.UNIQUE;
		else if (type.equalsIgnoreCase("strange")) this.itemQuality = Quality.STRANGE;
		else if (type.equalsIgnoreCase("Unusual")) this.itemQuality = Quality.UNUSUAL;
		else if (type.equalsIgnoreCase("collector's")) this.itemQuality = Quality.COLLECTORS;
		else if (type.equalsIgnoreCase("Haunted")) this.itemQuality = Quality.HAUNTED;
		else if (type.equalsIgnoreCase("vintage")) this.itemQuality = Quality.VINTAGE;
		else System.out.println("Error parsing enumeration");
	}
	
}
