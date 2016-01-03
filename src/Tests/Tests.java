package Tests;

import static org.junit.Assert.*;

import java.io.IOException;
import API.*;
import org.junit.Test;

public class Tests {

	@Test
	public void test() {
		try {
			ItemFetcher ref = new ItemFetcher(MarketConstants.REF_URL);
			Item conniver = ref.getItem();
			System.out.println("Price in ref:" + conniver.getRefPrice() + " Price in keys" + conniver.getKeyPrice() + " Dollar Price" + conniver.getDollarPrice());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Error");	
		}
	}
	

	
}
