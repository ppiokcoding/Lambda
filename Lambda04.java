package Lambda;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lambda04 {
	
	public static void main(String[] args) {
		
		//[Lambda04]
		//직원, 부서 데이터
		
		//----------------------------------------------------------------------
		//부서 N개, 직원 N명
		//영업부
		Employee e1 = new Employee("홍길동", "과장");
		Employee e2 = new Employee("아무개", "대리");
		Employee e3 = new Employee("하하하", "사원");
	
		List<Employee> l1 = new ArrayList<Employee>();
		l1.add(e1);
		l1.add(e2);
		l1.add(e3);
		
		Department d1 = new Department("영업부", "100", l1);
	
		
		//총무부
		Employee e4 = new Employee("가가가", "과장");
		Employee e5 = new Employee("나나나", "사원");
		Employee e6 = new Employee("다다다", "사원");
		
		List<Employee> l2 = new ArrayList<Employee>();
		l2.add(e5);
		l2.add(e4);
		l2.add(e6);
		
		Department d2 = new Department("총무부", "200", l2);
	
		
		//개발부
		Employee e7 = new Employee("아아아", "부장");
		Employee e8 = new Employee("야야야", "과장");
		Employee e9 = new Employee("어어어", "대리");
		Employee e10 = new Employee("여여여", "사원");
		
		List<Employee> l3 = new ArrayList<Employee>();
		l3.add(e7);
		l3.add(e9);
		l3.add(e8);
		l3.add(e10);
		
		Department d3 = new Department("개발부", "300", l3);
		
		List<Department> dlist = new ArrayList<Department>();
		
		dlist.add(d1);
		dlist.add(d3);
		dlist.add(d2);
		
		
		//2차원 배열
		// - 1차원 : 부서 배열
		// - 2차원 : 직원 배열

		// 부서명으로 오름차순 정렬
		dlist.sort(new Comparator<Department>() {
			@Override
			public int compare(Department o1, Department o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});

		// 부서명으로 오름차순 2 (줄여놓은 코드)
		dlist.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
		
		
		for (Department d : dlist) {

			// 각 부서 직원 명단 > 정렬
			d.getList().sort(new Comparator<Employee>() {
				@Override
				public int compare(Employee o1, Employee o2) {
					// 1. 이름 정렬
					// return o1.getName().compareTo(o2.getName());

					// 2.직급 정렬
					// - 부장 > 과장 > 대리 > 사원

					// 직접 우위 비교!!!
					if (o1.getPosition().equals("부장") && o2.getPosition().equals("과장")) {
						return -1;
					} else if (o1.getPosition().equals("부장") && o2.getPosition().equals("대리")) {
						return -1;
					} else if (o1.getPosition().equals("부장") && o2.getPosition().equals("사원")) {
						return -1;
					} else if (o1.getPosition().equals("사원") && o2.getPosition().equals("부장")) {
						return -1;
					} else if (o1.getPosition().equals("사원") && o2.getPosition().equals("부장")) {
						return 1;
					} else if (o1.getPosition().equals("사원") && o2.getPosition().equals("대리")) {
						return 1;
					} else if (o1.getPosition().equals("대리") && o2.getPosition().equals("부장")) {
						return 1;
					} else if (o1.getPosition().equals("과장") && o2.getPosition().equals("부장")) {
						return 1;
					} else {
						return 0;
					}

				}

			});//sort
			
			d.getList().sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
			
		}//for
		
		
		output(dlist);
		
		
		
		
		//----------------------------------------------------------------------
		
	}//main

	private static void output(List<Department> dlist) {

		for (Department d : dlist) {
			System.out.printf("[%s]\r\n", d.getName()); //부서명 찍기
			
			for (Employee e : d.getList()) {	//직원명 찍기
				System.out.println("  " +e.toString());
			}
		}
		
		
		
	}

}

//부서 
class Department {
	private String name;	 		//부서명
	private String tel;		 		//내선번호
	private List<Employee> list; 	//직원 명단
	
	public Department(String name, String tel, List<Employee> list) {
		this.name = name;
		this.tel = tel;
		this.list = list;
	}

	//getter, setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public List<Employee> getList() {
		return list;
	}

	public void setList(List<Employee> list) {
		this.list = list;
	}
	
	
	
	
}

class Employee {
	
	private String name;	 		//이름
	private String position; 		//직급(직위)
	private int positionIndex;		//직급별 순서(부장(1), 과장(2), 대리(3), 사원(4)
	
	public Employee(String name, String position) {
		this.name = name;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	//toString => source로 만들기
	@Override
	public String toString() {
		return String.format("[name=%s, position=%s]", name, position);
	}
	
	
	
	
	
}