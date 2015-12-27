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
	private float priceInBuds;
	private String primaryInGameCurrency;
	
	public Item(String url) throws IOException{
		//Set doc.  Set the userAgen
		doc = Jsoup.connect("http://backpack.tf"+url).userAgent(userAgent).timeout(1000).get();
		//Get the string inside of the area for price
		price = doc.getElementsByClass("item-panel-btns").first().child(0);
		System.out.println(price.text());
	}
	
	public void decidePrimaryCurrency(){
		
	}
}
