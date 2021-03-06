package src.API;
import src.API.ItemQualities.Quality;

public class Item {
	private float refPrice;
	private float keyPrice;
	private float dollarPrice;
	
	
	private Quality itemQuality;

	private String itemName;
	
	public Item(float refPrice, float keyPrice, float dollarPrice, Quality q, String itemName){
		this.refPrice = refPrice;
		this.keyPrice = keyPrice;
		this.dollarPrice = dollarPrice;
		this.itemQuality = q;
		this.itemName = itemName;
	}
	
	public float getRefPrice(){
		return this.refPrice;
	}
	
	public float getKeyPrice(){
		return this.keyPrice;
	}
	
	public float getDollarPrice(){
		return this.dollarPrice;
	}
	
	public String getType(){
		return String.valueOf(itemQuality);
	}
	
	public String getName(){
		return this.itemName;
	}
	
}
