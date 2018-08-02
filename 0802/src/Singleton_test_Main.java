
public class Singleton_test_Main {

	public static void main(String[] args) {
		// 생성자를 이용해서 객체를 생성
		/*T obj1 = new T();
		T obj2 = new T(); //외부에서 생성자를 만들 수 없게 됨.
*/		
		//싱글톤 패턴을 적용할 클래스의 객체 만들기
		Singleton_test obj1 = Singleton_test.getInstance();
		Singleton_test obj2 = Singleton_test.getInstance();
		
		// 해시코드 출력
		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));
		
		int a =10 ;
		int b =10 ;
		System.out.println(System.identityHashCode(a));
		System.out.println(System.identityHashCode(b));
		// 같은 상수는 같은 주소
		// 문자도 마찬가지
		int c =20 ;
		System.out.println(System.identityHashCode(c));
	}

}
