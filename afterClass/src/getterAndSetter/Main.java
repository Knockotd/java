package getterAndSetter;

public class Main {

	public static void main(String[] args) {
		GetterAndSetter gas = new GetterAndSetter();
		System.out.println(gas.getAge());
		System.out.println(gas.isNum());
			//VO클래스에서 변수들의 데이터가 없는데 결과를 출력 시 숫자는 0, boolean는 false를 리턴한다.
	}

}
