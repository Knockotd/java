package studentSemple;

public class T {
	public static void f1(String msg, int n) {
		int i = 0;
		while(i<n) {
			System.out.println(msg);
			i = i + 1;
		}
	}
	
	public int sum(int n) {
		int tot = 0;
		if(n > 1) {
			int i = 0;
			while(i <= n) {
				tot = tot + i;
				i = i+1;
			}
		}
		return tot;
	}
}
