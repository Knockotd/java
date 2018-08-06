

package lambdaEx;

import java.util.ArrayList;
import java.util.List;

interface T{
public void method(int n);

}

interface V{
	public int add(int n1, int n2);
}


public class LamdaMain {

	public static void main(String[] args) {
		// 위와 같은 인터페이스 T를 구현해서 사용해야 하는 경우
		T t = n ->{
			System.out.println("n:"+n);
		};
		t.method(10);
		//인터페이스 V를 구현해서 사용해야 하는 경우
		V v = (n1, n2) ->{
			return n1+n2;
		};
		System.out.println(v.add(100, 300));
		
		//배열은 [인덱스]를 통해서 각각의 데이터에 접근합니다.
		int [] ar = {10,30,20};
		for(int i=0; i<ar.length; i++) {
			System.out.print(ar[i]+",");
		}
		System.out.printf("\n===================\n");
		
		//List는 get(인덱스)를 통해서 각각의 데이터에 덥근합니다.
		List<Integer> list = new ArrayList<>();
		list.add(30);
		list.add(70);
		list.add(40);
		
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i)+",");
		}
		System.out.printf("\n===================\n");
		//ar의 모든 요소를 key에 대입해서 하나씩 수행합니다.
		//for-each를 이용한 배열의 데이터 접근 이터레이터라고도 합니다.
		//사용방법이 동일하여 더 추천!
		for(Integer key : ar) {
			System.out.print(key+",");
		}
		System.out.printf("\n===================\n");
		for(int key : list) {
			System.out.print(key+",");
		}
	}

}
