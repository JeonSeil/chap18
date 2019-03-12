package test0311;
/* 다음에 제시된 Student클래스를 Comparable 인터페이스를 구현하도록 변경해서
이름(name)이 기본 정렬 기준이  되도록 하시오
번호의 역순이 되도록 NoDesc 클래스를 작성하시오.
*/

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Student implements Comparable<Student>{
	String name; // 이름
	int ban; // 반
	int no; // 번호
	int kor, eng, math; // 국어, 영어, 수학 점수

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
		Student[] st = { new Student("홍길동", 1, 1, 100, 100, 100), new Student("김삿갓", 1, 2, 90, 70, 80),
				new Student("이몽룡", 1, 3, 80, 80, 90), new Student("임꺽정", 1, 4, 70, 90, 70),
				new Student("성춘향", 1, 5, 60, 100, 80) };
		Set set1 = new TreeSet<Student>();
		Set set2 = new TreeSet<Student>(new NoDesc());
		for (Student s : st) {
			set1.add(s);
			set2.add(s);
		}
		System.out.println(set1); // 이름 순으로 정렬
		System.out.println(set2);// 번호의 역순으로 정렬
	}
}
