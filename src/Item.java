import java.io.IOException;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
public class Item {
	
	/*
	 * Jsoup Variables
	 */
	private Document doc;
	private Elements price;
	private final String userAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36";
	
	/*
	 * Item Variables
	 */
	private float priceInRef;
	private float priceInKeys;
	private float priceInBuds;
	
	
	public Item(String url) throws IOException{
		//Set doc.  Set the userAgen
		doc = Jsoup.connect("http://backpack.tf"+url).userAgent(userAgent).timeout(1000).get();
		price = doc.getElementsByClass("item-panel-btns");
		System.out.println(price.text());
	}
}
