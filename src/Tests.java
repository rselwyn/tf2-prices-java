import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import MarketData.*;

public class Tests {

	@Test
	public void test() {
		try {
			ItemFetcher ref = new ItemFetcher("/stats/Unique/Refined%20Metal/Tradable/Craftable");
//			Item n = new ItemFetcher("").getItem();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Error");
			
		}
	}

}
