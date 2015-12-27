import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class Tests {

	@Test
	public void test() {
		try {
			Item ref = new Item("/stats/Unique/Refined%20Metal/Tradable/Craftable");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
