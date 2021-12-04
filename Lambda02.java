package Lambda;

import java.util.Random;

public class Lambda02 {
	
	public static void main(String[] args) {
		
		//[Lambda02]
		
		//자바의 람다식
		// - 람다식 스스로 존재할 수 없다.
		// - 반드시 인터페이스 변수에 저장을 한 후에 사용이 가능하다.
		// - 익명 객체를 만드는 방법을 최소화 한다.
		
		/*
		num -> System.out.println("pr");
		
		new ParameterNoReturn()	{
		public void call(int num) {
			System.out.println("pr");
		};
		
		
		*/
		//1.
		NoParameterNoReturn pr1 = new NoParameterNoReturn() {
			 @Override
			public void call() {
				 System.out.println("pr1");
			}
		};
		pr1.call();
		
		
		//2.
		NoParameterNoReturn pr2 = () -> {
			System.out.println("pr2");
		};
		pr2.call();
		
		//-------------------------------------------
		//3.
		ParameterNoReturn pr3 = (int num) -> {
			System.out.println(num);
		};
		pr3.call(100);
		pr3.call(200);
		
		//4.
		//매개변수가 유일할 때
		ParameterNoReturn pr4 = num -> {
			System.out.println(num*2);
		};
		pr4.call(300);
		pr4.call(400);
		
		//5.
		//실행블럭이 1줄일때
		ParameterNoReturn pr5 = num -> System.out.println(num * 3);
		pr5.call(1000);
		pr5.call(2000);
		
		
		//6.
		MultiParameterNoReturn pr6 = (String name, int age) -> {
			System.out.printf("%s님은 %d세입니다.\r\n", name, age);
		};
		pr6.call("박아무개", 20);
		
		
		//7.
		//매개변수는 2개 이상일 때
		MultiParameterNoReturn pr7 = (name, age) -> System.out.printf("%s님은 %d세입니다.\r\n", name, age);
		pr7.call("김아무개", 22);
		
		
		//8.
		NoParameterReturn pr8 = () -> {
			return 10;
		};
		System.out.println(pr8.call());
		
		
		//9.
		NoParameterReturn pr9 = () -> {
			Random rnd = new Random();
			return rnd.nextInt(100);
		};
		System.out.println(pr9.call());
		
		
		//10.
		//실행블럭이 1줄일때
		NoParameterReturn pr10 = () -> 10; //return문일게 100%확신되면 return이라는 표현도 안쓴다.
		System.out.println(pr10.call());
		
		
		//11.
		NoParameterReturn pr11 = () -> (int)(Math.random() * 100);
		System.out.println(pr11.call());
		
		
		//12.
		//생략전 표현
//		ParameterReturn pr12 = (int a, int b) -> {
//			return a + b;
//		};
		
		//생략후 표현
		ParameterReturn pr12 = (a, b) -> a + b;
		System.out.println(pr12.call(10, 20));
		
		
		//13.
		ParameterReturn pr13 = (a, b) -> a - b;
		ParameterReturn pr14 = (a, b) -> a * b;
		ParameterReturn pr15 = (a, b) -> a / b;

		
		System.out.println(pr12.call(10, 20));
		System.out.println(pr12.call(10, 20));
		System.out.println(pr12.call(10, 20));
		
		
		//14. 여기부터 에러나서 필기 참고하기
		ParameterReturn pr16 = (int age) -> {
			return age >= 19? "어른":"아이";
		};
		System.out.println(pr16.call(20));
		
		
		//15.
		ParameterReturn pr17 = age -> age >= 19 ? "어른" : "아이";
		System.out.println(pr17.call(10));
		
			
		
		
	}//main
	
	

}

interface NoParameterNoReturn {
	void call();
}

interface ParameterNoReturn {
	void call(int num); //void = 반환값!
}

interface MultiParameterNoReturn {
	void call(String name, int age); //void = 반환값!
}

interface NoParameterReturn {
	int call();
}

interface ParameterReturn {
	int call(int a, int b);
}

interface ParameterReturn2 {
	String call(int age);
}