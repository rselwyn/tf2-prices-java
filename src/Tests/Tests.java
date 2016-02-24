package src.Tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


import src.API.*;

import org.junit.runners.Suite;


@RunWith(JUnit4.class)

public class Tests {

	@Test
	public void testMain() {
		try {
//			System.out.println(new ItemFetcher("/stats/Unique/Purity%20Fist/Tradable/Craftable").getItem().getDollarPrice());
			ItemFetcher ref = new ItemFetcher("/stats/Unique/Purity%20Fist/Tradable/Craftable");
			Item conniver = ref.getItem();
			System.out.println("Price in ref:" + conniver.getRefPrice() + " Price in keys" + conniver.getKeyPrice() + " Dollar Price" + conniver.getDollarPrice());
		} catch (IOException e) {
			e.printStackTrace();
			fail("Error");	
		}
	}
	

	
}
