import java.io.IOException;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
public class Item {
	
	private Document doc;
	private Elements price;
	
	public Item(String url) throws IOException{
		doc = Jsoup.connect("http://backpack.tf"+url).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36").timeout(1000).get();
		price = doc.getElementsByClass("item-panel-btns");
		System.out.println(price.text());
	}
}
