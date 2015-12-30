import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class Tests {

	@Test
	public void test() {
		try {
			ItemFetcher ref = new ItemFetcher("/stats/Genuine/Anger/Tradable/Craftable");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Error");
		}
	}

}
