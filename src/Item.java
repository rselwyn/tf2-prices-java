import java.io.IOException;
import java.util.HashMap;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
public class Item {
	
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
	
	
	public Item(String url) throws IOException{
		//Set doc.  Set the userAgen
		doc = Jsoup.connect("http://backpack.tf"+url).userAgent(userAgent).timeout(1000).get();
		//Get the string inside of the area for price
		price = doc.getElementsByClass("item-panel-btns").first().child(0);
		System.out.println(price.text());
	}
	
	/*
	 * Takes a string and decides whether the price 
	 */
	private void decidePrimaryCurrency(String which){
		switch(which.split(" ")[1]){
		case "ref": this.priceInRef = convertDashSeperated(which) ; break;
		case "keys": this.priceInKeys = Float.parseFloat(which.split(" ")[0]) ; break;
		default: this.valueInUSD = convertDollars(which.split(" ")[0]); break;
		}
	}
	
	/*
	 * Takes two numbers seperated by a - and gets the average
	 * @param	refVal: THe expression to parse
	 * @return	the average of the two numbers
	 */
	private float convertDashSeperated(String refVal){
		String[] vals = refVal.split(" ")[0].split("-");
		return Float.parseFloat((vals[0]+vals[1]))/2;
	}
	
	
	/*
	 * @param exprWithDollars:  The expression in the form of $XY-AB
	 * @return the average of the two monetary values
	 */
	private float convertDollars(String exprWithDollars){
		exprWithDollars = exprWithDollars.substring(1);
		return convertDashSeperated(exprWithDollars);
	}
	
}
