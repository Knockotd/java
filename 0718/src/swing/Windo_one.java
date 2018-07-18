package swing;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
//윈도우 클래스
public class Windo_one extends JFrame {
	 public Windo_one() {
         // 위치, 크기 설정
         setBounds(200, 200, 600, 600);
         // 제목 설정
         setTitle("Swing one Project");
         // 종료 버튼 이벤트 처리
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         // 패널 생성
         JPanel panel = new JPanel();
         ImageIcon icon = new ImageIcon("C:\\Users\\503-26\\Downloads\\1.jpg");
         JLabel label = new JLabel(icon);
         JLabel label0 = new JLabel("    ");
         JLabel label1 = new JLabel("액션토끼 졸귀");
         JLabel label2 = new JLabel();
         label2.setIcon(icon);
         label.setToolTipText("얍~! *");
         /*
          * TitledBorder border = new TitledBorder("경계선"); label.setBorder(border);
          */
         EtchedBorder border = new EtchedBorder(Color.RED, Color.pink);
         label.setBorder(border);
         panel.add(label2);
         
         
         JButton btn = new JButton("Button");
         panel.add(btn);
         
         panel.add(label);
         panel.add(label0);
         panel.add(label1);
         
         
         
         // 패널 프레임에 부착
         add(panel);
         // 화면 출력
         setVisible(true);
         
           //그림 파일 이름을 배열로 만들기. 배열은 만들면 크기 변경이 안 됩니다.
         String [] images = { "1.jpg",
           "2.jpg", "3.jpg", "4.png","5.gif","6.gif","7.gif" };
         
         // 리스트는 만들어도 크기 변경이 가능합니
         ArrayList<String> list = new ArrayList<String>();
         list.add("1.jpg");
         list.add("2.jpg");
         list.add("3.jpg");
         list.add("4.png");
         list.add("5.gif");
         list.add("6.gif");
         list.add("7.gif");
         // 이미지가 변경되는 동안에도 다른 작업을 할 수 있도록 해야 하므로 이미지 변경은 스레드로 생성
         Thread th = new Thread() {
             public void run() {
                  int idx = 0;
                  while (true) {
                       try {
                            Thread.sleep(1000);
                            
                            ImageIcon icon = new ImageIcon("C:\\Users\\503-26\\Downloads\\"+list.get(idx%list.size())); //images[idx%images.length]
                            label.setIcon(icon);
                            idx = idx + 1;
                       } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                       }
                  }
             }
         };
         th.start();
	 }}
