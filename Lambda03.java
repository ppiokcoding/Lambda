package Lambda;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lambda03 {
	
	public static void main(String[] args) {
		
		//[Lambda03].java
		
		//익명 객체의 활용 예 > 배열, 컬렉션 정렬 > 람다식으로 전환 가능
		
		
		List<Integer> nums = new ArrayList<Integer>();
		List<String> names = new ArrayList<String>();
		List<String> users = new ArrayList<User>();
		
		nums.add(200);
		nums.add(500);
		nums.add(300);
		nums.add(400);
		nums.add(100);
		
		
		names.add("홍길동");
		names.add("아무개");
		names.add("유재석");
		names.add("강호동");
		names.add("테스트");
		
		users.add(new User("홍길동", 20));
		users.add(new User("아무", 25));
		users.add(new User("유재석짱", 23));
		users.add(new User("강호동입니다", 22));
		users.add(new User("테", 28));
		
		//1. 개입X > 단일 타입(숫자, 문자, 날짜) + 오름차순 
		Collections.sort(nums); //개입 x
		//nums.sort(개입O); 이건 못쓰는 메소드
		System.out.println(nums);
	
		Collections.sort(names); //개입x
		System.out.println(names);
		
		//Collections.sort(users); //객체 배열은 개발자의 개입이 필수!!
		//System.out.println(users);
		
		
		//2. 개입O > 단일 타입 + 복합 타입(객체) + 오름차순 + 내림차순 > 모든 정렬!!!
		//nums -> 내림 차순
		//Collections.sort(배열, 기준구현);
		//배열.sort(정렬기준구현);
		
		nums.sort(new Comparator<Integer>() {
			//필기못함
			@Override
			public int compare(Integer o1, Integer o2) {
				
				//retunr o1 - o2; //오름차순
				return o1 - o2;
			}
		});
		System.out.println(nums);
		
		names.sort((o1, o2) -> o2.compareTo(o1));
		System.out.println(names);
		
		
		names.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				//return o1.compareTo(o2);
				return o2.compareTo(o1);
			}
		});
		System.out.println(names);
		
		
		
		users.sort(new Comparator<User>() {
			@Override
			public int compare(User o1, User o2) {
				//return o1.getAge() - o2.getAge();
				//return o2.getAge() - o1.getAge();
				//return o1.getName().compareTo(o2.getName());
				//return o2.getName().compareTo(o1.getName());
				return o1.getName().length() - o2.getName().length();
			
			}
		});
		
		users.sort((o1, o2) -> o1.getAge() - o2.getAge());
		
		System.out.println(users);
		
		
	}//main

}

class User {
	private String name;
	private int age;

	
	//Constructor
	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}


	//Getter, Setter
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	
	
}