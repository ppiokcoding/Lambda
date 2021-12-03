package Lambda;


public class Lambda01 {

	public static void main(String[] args) {
		
		//[Lambda01] 
		//- 람다식 + 스트림
		
		//람다식, Lambda Expression
		// - 함수형 프로그래밍 지원 표현식
		// - 람다식을 사용하면 코드가 간결해진다.
		// - 컬렉션을 조작하기 쉬워진다. > 컬렉션을 조작하는 기능 일부 > 람다식을 사용
		
		// - 자바의 메소드 표현과 유사
		// - 람다식은 매개변수를 가지는 코드블럭이다.
		// - 자바의 람다식은 인터페이스를 사용해서 만들어진다.(***)
		// - 자바의 람다식은 익명 객체를 만드는 방법을 간소화시킨 기술이다.(****)
		
		
		//람다식 코드 형식
		// - 인터페이스 변수 = 람다식;
		// ex) MyInterface m1 = () -> {};
		// - 					(매개변수) -> { 실행코드; }
		//a. (매개변수): 메소드의 매개변수 리스트와 동일한 역할
		//b. -> : 화살표(Arrow), 코드블럭을 호출하는 역할
		//c. 실행코드: 메소드의 구현부와 동일한 역할 
		
		//================================================================
		//요구사항] MyInterface를 구현하는 객체 만들기
		MyInterface m1 = new MyClass();
		
		//case 1. 클래스 구현 (사용 多) - 자주만들때 쓰기
		m1.test();
		
		
		//case 2. 익명 객체 - 1회용 클래스 만들기, 한번만 만들때 써라
		MyInterface m2 = new MyInterface() {//생성자로 인터페이스 이름을 적는다 -> 구현부를 만든다.
			@Override
			public void test() {
				System.out.println("익명 객체에서 구현한 메소드");
			}
		};
		m2.test();
		
		//case 3. 람다식 : () = test() 이고, 나머지 case2 와 똑!같은 코드임
		MyInterface m3 = () -> {
			System.out.println("람다식으로 구현한 메소드");
		}; //객체가 만들어짐, 이 메소드는 이름이 없지만 
		m3.test(); //자동으로 test()라는 이름이 생김
		
		//================================================================
		
		
	}//main
	

}

interface MyInterface {
	void test(); //추상메소드
}

class MyClass implements MyInterface{

	@Override
	public void test() {
		System.out.println("실명 객체에서 구현한 메소드");
	}
	
	
}