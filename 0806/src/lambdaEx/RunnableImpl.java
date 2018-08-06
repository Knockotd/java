package lambdaEx;

public class RunnableImpl implements Runnable {

	@Override
	public void run() {
		//1초마다 쉬면 토마토 게임 하기 10회
		int i=0;
		while(i<10) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i%2 == 0) {
			System.out.println("토");
			}else{
			System.out.println("마");
			}
			i=i+1;
		}
		
		
		
	}

}
