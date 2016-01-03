import static org.junit.Assert.*;

import java.io.IOException;

import API.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)

public class Tests {

	@Test
	public void testMain() {
		try {
			System.out.println(new ItemFetcher(MarketConstants.KEY_URL).getItem().getDollarPrice());
			ItemFetcher ref = new ItemFetcher("/stats/Collector%27s/Conniver%27s%20Kunai/Tradable/Craftable");
			Item conniver = ref.getItem();
			System.out.println("Price in ref:" + conniver.getRefPrice() + " Price in keys" + conniver.getKeyPrice() + " Dollar Price" + conniver.getDollarPrice());
		} catch (IOException e) {
			e.printStackTrace();
			fail("Error");	
		}
	}
	

	
}
