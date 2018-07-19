package swing;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

//frame이나 Jframe을 상속하면 윈도우 클래스가 만들어집니다.
public class B_SwingJListPractice extends JFrame {
	// 자료는 보통 여기서 만듭니다.
	String[] data = { "Encapsulation", "Inheritance", "Polymorphism", "Information Hiding" };

	public B_SwingJListPractice() {
		
		// 메소드가 찾기 어려우면 어차피 JFrame에서 가져오는 메소드이기 때문에 this.으로 메소드를 찾아도 됩니다.
		// 이름이 겹치지 않는다면 나중에 this.은 제거해도 괜찮습니다.
		this.setBounds(100, 100, 400, 400);
		this.setTitle("Swing");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		// 만들 때 제너릭을 조정하세요 제너릭=<String>
		JList<String> list = new JList<>(data);
		JComboBox<String> combo = new JComboBox<>(data);
		
		// 패널 설치
		JPanel p = new JPanel();
		p.add(list);
		p.add(combo);
		
		add(p);
		setVisible(true);
	}
}
