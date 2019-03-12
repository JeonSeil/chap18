package test0311;
/* ������ ���õ� StudentŬ������ Comparable �������̽��� �����ϵ��� �����ؼ�
�̸�(name)�� �⺻ ���� ������  �ǵ��� �Ͻÿ�
��ȣ�� ������ �ǵ��� NoDesc Ŭ������ �ۼ��Ͻÿ�.
*/

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Student implements Comparable<Student>{
	String name; // �̸�
	int ban; // ��
	int no; // ��ȣ
	int kor, eng, math; // ����, ����, ���� ����

	public Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	int getTotal() {
		return kor + eng + math;
	}

	float getAverage() {
		return (int) ((getTotal() / 3f) * 10 + 0.5) / 10f;
	}

	public String toString() {
		return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + getTotal() + "," + getAverage();
	}
	@Override
	public int compareTo(Student s) {
		return name.compareTo(s.name);
	}
}

public class Test1 {
	static class NoDesc implements Comparator<Student>{
		@Override
		public int compare(Student s1, Student s2) {
			return s2.no - s1.no;
		}
	}
	public static void main(String[] args) {
		Student[] st = { new Student("ȫ�浿", 1, 1, 100, 100, 100), new Student("���", 1, 2, 90, 70, 80),
				new Student("�̸���", 1, 3, 80, 80, 90), new Student("�Ӳ���", 1, 4, 70, 90, 70),
				new Student("������", 1, 5, 60, 100, 80) };
		Set set1 = new TreeSet<Student>();
		Set set2 = new TreeSet<Student>(new NoDesc());
		for (Student s : st) {
			set1.add(s);
			set2.add(s);
		}
		System.out.println(set1); // �̸� ������ ����
		System.out.println(set2);// ��ȣ�� �������� ����
	}
}
