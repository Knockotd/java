package eventHandling;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Frame;

public class Bclass extends Frame {
	 public Bclass() {
         setBounds(200, 200, 600, 600);
         setTitle("Bclass_키보드 이벤트");
         setLayout(null);
         Label lb1 = new Label("@");
         lb1.setBounds(10, 40, 50, 50);
         add(lb1);
         KeyListener key = new KeyListener() {
             // 키보드를 눌렀을 때
             @Override
             public void keyPressed(KeyEvent e) {
                  int x = lb1.getLocation().x;
                  int y = lb1.getLocation().y;
                  // 열거형은 switch를 못 씀
                  if (e.getKeyCode() == e.VK_LEFT) {
                       x = x - 10;
                  }
                  if (e.getKeyCode() == e.VK_RIGHT) {
                       x = x + 10;
                  }
                  if (e.getKeyCode() == e.VK_UP) {
                       y = y - 10;
                  }
                  if (e.getKeyCode() == e.VK_DOWN) {
                       y = y + 10;
                  }
                  // @ 위치 바꾸기 //y값이 위로 못 움직이게 하려면 -한 만큼 아래에서 + 해주면 된다.
                  lb1.setLocation(x, y);
                  // Modifiers는 같이 누른 조합키 값을 리턴
                  if (e.getModifiers() == KeyEvent.ALT_MASK && e.getKeyCode() == KeyEvent.VK_F1) {
                       System.exit(0);
                  }
                  if(e.getKeyCode() == KeyEvent.VK_SPACE){
                       Label lb2 = new Label("+");
                       lb2.setBounds(lb1.getLocation().x,lb1.getLocation().y-30, 30,30);
                       add(lb2);
                       Thread th = new Thread() {
                            public void run() {
                                 try {
                                     while(true) {
                                     Thread.sleep(50);
                                     int x = lb2.getLocation().x;
                                     int y = lb2.getLocation().y;
                                      lb2.setLocation(x,y-5);
                                     if(y < 100) {break;}
                                     }
                                      lb2.setVisible(false);
                                 } catch (InterruptedException e) {
                                     // TODO Auto-generated catch block
                                      e.printStackTrace();
                                 }
                            }
                       };
                       th.start();
                  }
             }
             // 키보드에서 손을 뗐을 때
             @Override
             public void keyReleased(KeyEvent e) {
             }
             // 문자 키를 눌렀을 때
             @Override
             public void keyTyped(KeyEvent e) {
             }
         };
         addKeyListener(key); //frame에 키보드 이벤트 연결
         setVisible(true);
    }
}
