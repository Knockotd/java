package swing;

public class A_ObjectPracticeMain {

	public static void main(String[] args) {
		Object obj = new Object();
		// obj인스턴스의 toString 결과 출력
		// 직접 호출하나 인스턴스 이름만 설정하나 결과는 같음.
		System.out.println(obj.toString());
		System.out.println(obj);

		Integer i = 100;
		// toString의 결과가 저장하고 있는 데이터인 100입니다.
		System.out.println(i.toString());
		System.out.println(i);

		// 상위 클래스 타입의 참조형 변수에
		// 하위 클래스 타입의 인스턴스 참조를 대입할 수 있다.
		Object str = "Hello world";
		System.out.print(str);
		// 출력만 할 때는 형변환없이 사용해도 됩니다.
		// 왜냐하면 toString()은 Object가 가지고 있으므로 호출할 수 있기 때문입니다.
		//오브젝트에 랭스가 없어서 오류가 난다. 따라서 형변환을 꼭 해주고 사용해야 합니다.

		// for(int i=0; i<str.length(); i++) {}

		
		String imsi = (String) str;
		for (int j = 0; j < imsi.length(); j++) {
		char ch = imsi.charAt(j);
		System.out.println(ch);
		}
		//Object 타입의 변수는 출력 할 때는 제외하고 위 처럼 원래 자료형으로 강제 형 변환해서 사용해야 합니다.
	}

}
