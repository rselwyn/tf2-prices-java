import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class Tests {

	@Test
	public void test() {
		try {
			ItemFetcher ref = new ItemFetcher("/stats/Strange/Silver%20Botkiller%20Minigun%20Mk.I/Tradable/Craftable");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Error");
		}
	}

}
