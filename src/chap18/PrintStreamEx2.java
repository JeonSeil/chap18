package chap18;
/* PrintStream 클래스
 *     printf 메서드 : 서식지정 문자 사용. jdk5.0 이후 버전 
 */
public class PrintStreamEx2 {
	public static void main(String[] args) {
		//char 서식 지정 문자 : %c, %n==\n
		System.out.printf("%c%n",'A');   //'A'문자 출력
		System.out.printf("%5c%n",'A');  //5자리 확보. 'A'출력. 우측정렬
		System.out.printf("%-5c%n",'A'); //5자리 확보. 'A'출력.  좌측정렬 
		//정수 출력 : %d, %o, %x, %X
		System.out.printf("%d%n",12345); //10진수 출력
		System.out.printf("%,d%n",12345); //10진수 세자리마다 , 출력
		System.out.printf("%10d%n",12345); //10자리를 확보하고 10진수 출력
		System.out.printf("%3d%n",12345);  //3자리를 확보하고 10진수 출력
		System.out.printf("%010d%n",12345);//10자리를 확보하고 10진수 출력. 빈자리 0으로
		System.out.printf("%-10d%n",12345);//10자리를 확보하고 10진수 출력. 좌측정렬
		System.out.printf("%,10d%n",12345);//10자리를 확보하고 10진수 출력. 세자리마다 ,
		System.out.printf("%-,10d%n",12345);//10자리를 확보하고. 좌측정렬. 세자리마다 ,
		System.out.printf("%,010d%n",12345);//10자리를 확보하고. 빈자리 0으로 세자리마다 ,
		
		System.out.printf("%o%n",12345); //8진수 출력
		System.out.printf("%x%n",255); //16진수 출력. 소문자로
		System.out.printf("%X%n",255); //16진수 출력. 대문자로
		
		//실수 출력 : %f,%e,%g
		System.out.printf("%f%n",12345.12345);
		System.out.printf("%.2f%n",12345.12345);//소숫점이하 2자리까지만 출력
		System.out.printf("%10.2f%n",12345.12345);//10자리 확보. 소숫점이하 2자리까지만 출력
		//10자리 확보. 소숫점이하 2자리까지만 출력. 세자리마다 , 
		System.out.printf("%,10.2f%n",12345.12345);
		//10자리 확보. 소숫점이하 2자리까지만 출력. 세자리마다 , 좌측정렬
		System.out.printf("%-,10.2f%n",12345.12345);
		//10자리 확보. 빈자리 0으로 채우기. 소숫점이하 2자리까지만 출력. 세자리마다 ,
		System.out.printf("%,010.2f%n",12345.12345);
		
		System.out.printf("%e%n",12345.12345); //지수형태로 출력 1.234512 * 10 ** 4
		System.out.printf("%g%n",12345.12345); //근사실수출력
		
		//논리형 (boolean) : %b
		System.out.printf("%b != %b%n",true,false);
		
		//문자열 : %s
		System.out.printf("%s는 %s다%n","홍길동","남자");
		System.out.printf("%10s는 %10s다%n","홍길동","남자");
		
		//문제 : 10진수 255는 8진수 377이다 => printf로 출력하기
		System.out.printf("%d진수 %d는 %d진수 %o이다%n",10,255,8,255);
		//문제 : 10진수 255는 16진수 FF이다 => printf로 출력하기
		System.out.printf("%d진수 %d는 %d진수 %X이다%n",10,255,16,255);
		//문제 : 홍길동의 급여는    1,500,000만원이다. 출력하기
		// 단 1500000은 10자리 확보하고 세자리마다 , 출력. 우측정렬하기.
		System.out.printf("%s의 %s는 %,10d만원이다.%n","홍길동","급여",1500000);
	}
}
