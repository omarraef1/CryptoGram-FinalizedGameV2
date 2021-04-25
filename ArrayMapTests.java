import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import java.util.AbstractMap.SimpleEntry;
import java.util.Iterator;
import java.util.Map.Entry;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class ArrayMapTests<K, V> {

	@Test
	void test() {
		ArrayMap<String, Integer> hashOne = new ArrayMap<String, Integer>();
	//	System.out.println(hashOne.keyArray[0]);
		hashOne.put("A", 1); //entries 1 length 1;
		hashOne.put("B", 2); //entries 2 length 2;
		hashOne.put("C", 3); //entries 3 length 3;
		hashOne.put("A", 2); //entries 3 length 3;
		assertEquals(2, hashOne.valArray[0]);
		assertEquals(3, hashOne.entries);
		//assertEquals(3, hashOne.get("C"));
		
		System.out.println(hashOne.get("C"));

		hashOne.put("A", 1); //entries 1 length 1;
		Set<Entry<String, Integer>> set = hashOne.entrySet();
	//	System.out.println(set);
		SimpleEntry<K, V> simpleEntry = new SimpleEntry("A", hashOne.get("A")); //TODO type arguments?
		assertTrue(set.contains(simpleEntry));
		SimpleEntry<K, V> simpleEntry2 = new SimpleEntry("A", 2); //TODO type arguments?
		assertFalse(set.contains(simpleEntry2));
		assertEquals(3, set.size());
		assertEquals(3, hashOne.size());
		
		
	}
	
	@Test
	void testExpansion() {
		ArrayMap<String, Integer> hashOne = new ArrayMap<String, Integer>();
		hashOne.put("A", 1); //entries 1 length 1;
		hashOne.put("B", 2); //entries 2 length 2;
		hashOne.put("C", 3); //entries 3 length 3;
		hashOne.put("D", 1); //entries 1 length 1;
		hashOne.put("E", 2); //entries 2 length 2;
		Set<Entry<String, Integer>> set2 = hashOne.entrySet();
	//	System.out.println(set2);

	//	System.out.print("[");
		for(int i = 0; i<hashOne.size();i++) {

//			System.out.print(hashOne.keyArray[i] + "= " +hashOne.valArray[i]+" ");
		}
	//	System.out.print("]");
	//	System.out.println("\n");
//TODO		set2.iterator().remove();
	//	System.out.println(set2);

	//	System.out.print("[");
		for(int i = 0; i<hashOne.size();i++) {

	//		System.out.print(hashOne.keyArray[i] + "= " +hashOne.valArray[i]+" ");
		}
	//	System.out.print("]");
	//	System.out.println();
		hashOne.put("F", 3); //entries 3 length 3;
		hashOne.put("G", 1); //entries 1 length 1;
		hashOne.put("H", 2); //entries 2 length 2;
		hashOne.put("I", 3); //entries 3 length 3;
		hashOne.put("J", 1); //entries 1 length 1;
		hashOne.put("K", 2); //entries 2 length 2;
		hashOne.put("L", 3); //entries 3 length 3;
		hashOne.put("M", 1); //entries 1 length 1;
		hashOne.put("N", 2); //entries 2 length 2;
		hashOne.put("O", 3); //entries 3 length 3;
		hashOne.put("P", 1); //entries 1 length 1;
		hashOne.put("Q", 2); //entries 2 length 2;
		hashOne.put("R", 3); //entries 3 length 3;
		hashOne.put("S", 1); //entries 1 length 1;
		hashOne.put("T", 2); //entries 2 length 2;
		hashOne.put("U", 3); //entries 3 length 3;
		hashOne.put("V", 1); //entries 1 length 1;
		hashOne.put("W", 2); //entries 2 length 2;
		hashOne.put("X", 3); //entries 3 length 3;
		hashOne.put("Y", 1); //entries 1 length 1;
		hashOne.put("Z", 2); //entries 2 length 2;
	//	Set<Entry<K, V>> set = hashOne.entrySet();
	//	System.out.println(set2);
		
	}
	

	@Test
	void testNextError() {
		ArrayMap<String, Integer> hashOne = new ArrayMap<String, Integer>();
		hashOne.put("A", 1); //entries 1 length 1;
		hashOne.put("B", 2); //entries 2 length 2;
		hashOne.put("C", 3); //entries 3 length 3;
		hashOne.put("D", 1); //entries 1 length 1;
		hashOne.put("E", 2); //entries 2 length 2;
		Set<Entry<String, Integer>> set2 = hashOne.entrySet();
	//	System.out.println(set2);

	//	System.out.print("[");
		
	//	System.out.print("]");
	//	System.out.println("\n");
		Iterator<Entry<String, Integer>> itr = set2.iterator();
		while(itr.hasNext()) {
			itr.next();
		}
		itr.next();

		System.out.println(set2);

		Iterator<Entry<String, Integer>> itr2 = set2.iterator();
		while(itr2.hasNext()) {
			SimpleEntry<K, V> simpleEntry = new SimpleEntry("A", hashOne.get("A")); //TODO type arguments?
			if(itr2.next().equals(simpleEntry)) {
				itr2.remove();
			}
			
		}
		itr2.remove();
		System.out.println(set2);
	//	itr2.remove();
		assertThrows(IllegalStateException.class, () -> {
			itr2.remove();
		});
		
		
		
	}

}
