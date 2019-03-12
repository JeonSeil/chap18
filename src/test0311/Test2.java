package test0311;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
2. ´ÙÀ½ keys , values , entry °´Ã¼¸¦ Iterator °´Ã¼·Î º¯°æÇÏ¿© Ãâ·ÂÇÏ±â 
[°á°ú]
±è»ñ°«=4567
È«±æµ¿=1234
ÀÌ¸ù·æ=2350
ÀÓ²©Á¤=9870
4567
1234
2350
9870
±è»ñ°«=4567
È«±æµ¿=1234
ÀÌ¸ù·æ=2350
ÀÓ²©Á¤=9870
*/
public class Test2 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		String[] names = { "È«±æµ¿", "±è»ñ°«", "ÀÌ¸ù·æ", "ÀÓ²©Á¤" };
		int[] nums = { 1234, 4567, 2350, 9870 };
		for (int i = 0; i < names.length; i++) {
			map.put(names[i], nums[i]);
		}
		Set<String> keys = map.keySet();
		Iterator<String> it1 = keys.iterator();
		while(it1.hasNext()) {
			String k = it1.next();
			System.out.println(k + "=" + map.get(k));
		}
		Collection<Integer> values = map.values();
		Iterator<Integer> it2 = values.iterator();
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}
		Set<Map.Entry<String, Integer>> entry = map.entrySet();
		Iterator<Map.Entry<String, Integer>> it3 = entry.iterator();
		while(it3.hasNext()) {
			System.out.println(it3.next());
		}
	}

}