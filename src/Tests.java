import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import ItemQualities.*;

public class Tests {

	@Test
	public void test() {
		try {
			ItemFetcher ref = new ItemFetcher("/stats/Collector%27s/Conniver%27s%20Kunai/Tradable/Craftable");
//			Item n = new ItemFetcher("").getItem();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Error");
			
		}
	}

}
