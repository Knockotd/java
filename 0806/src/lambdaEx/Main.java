package lambdaEx;

public class Main {

	public static void main(String[] args) {
		/*
		 * //별도의 클래스를 만들어서 이용 : 재사용 할 경우 많이 사용
		 * RunnableImpl r = new RunnableImpl();
		 * Thread th = new Thread(r);
		 * th.start();
		 * //2개 째
		 * RunnableImpl r1 = new
		 * RunnableImpl();
		 * Thread th1 = new Thread(r);
		 * th1.start();
		 */

		/*
		 * // 익명 클래스 이용하기 : 클래스를 안 만드는 만큼 메모리 사용을 줄일 수는 있지만 재사용하기에는 불편.
		Runnable r = new Runnable() {

			@Override
			public void run() {
				// 1초마다 쉬면 토마토 게임 하기 10회
				int i = 0;
				while (i < 10) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (i % 2 == 0) {
						System.out.println("토");
					} else {
						System.out.println("마");
					}
					i = i + 1;
				}
			}
		};
		Thread th = new Thread(r);
		th.start();
		*/
		
		
		// 익명 클래스 이용하기 : 클래스를 안 만드는 만큼 메모리 사용을 줄일 수는 있지만 재사용하기에는 불편.
				Runnable r = () ->{

				
						// 1초마다 쉬면 토마토 게임 하기 10회
						int i = 0;
						while (i < 10) {
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if (i % 2 == 0) {
								System.out.println("토");
							} else {
								System.out.println("마");
							}
							i = i + 1;
						}
				};
				Thread th = new Thread(r);
				th.start();
		
		
	}

}
