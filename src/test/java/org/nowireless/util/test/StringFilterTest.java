package org.nowireless.util.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.nowireless.utilities.util.StringFilter;

public class StringFilterTest {

	@Test
	public void test() {
		StringFilter filter = new StringFilter("bo2");
		List<String> in = new ArrayList<String>();
		in.add("bo2_d.schematic");
		in.add("bo2AThing.schematic");
		in.add("BO2_ds.schematic");
		in.add("BO2Asd.schematic");
		in.add("Txt.txt");
		in.add("tbo2.schematic");
		
		List<String> out = filter.filter(in);
		
		assertEquals(4, out.size());
		assertTrue(out.contains(in.get(0)));
		assertTrue(out.contains(in.get(1)));
		assertTrue(out.contains(in.get(2)));
		assertTrue(out.contains(in.get(3)));
		assertFalse(out.contains(in.get(4)));
		assertFalse(out.contains(in.get(5)));
	}

}
