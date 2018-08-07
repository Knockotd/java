package opensource;

import org.junit.Test;

public class TestJUnit {
	@Test
	public void yam() {
		int i = 0;
		while(1==1) {
			System.out.println("안뇽!" + i);
			i = i + 1;
			if(i == 10) break;
		}
	}
}
