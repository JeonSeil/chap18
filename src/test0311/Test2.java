package test0311;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
2. ���� keys , values , entry ��ü�� Iterator ��ü�� �����Ͽ� ����ϱ� 
[���]
���=4567
ȫ�浿=1234
�̸���=2350
�Ӳ���=9870
4567
1234
2350
9870
���=4567
ȫ�浿=1234
�̸���=2350
�Ӳ���=9870
*/
public class Test2 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		String[] names = { "ȫ�浿", "���", "�̸���", "�Ӳ���" };
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