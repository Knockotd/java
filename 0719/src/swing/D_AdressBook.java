package swing;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class D_AdressBook extends JFrame {
	//컬럼 이름 배열
	String [] columns = {
			"이름","전화번호","주소"
	};
	String [][] data = {
			{"안정은","01054720094","인천광역시 계양구"},
			{"박보검","01000010001","대한민국 어딘가"},
			{"제임스맥어보이","01022002030","외국 어딘가"},
			{"앤해서웨이","01087839202","외국 멀리 어딘가"}
	};
	public D_AdressBook() {
		this.setBounds(100,100,400,400);
		this.setTitle("연락처");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//테이블 모델을 이용해서 테이블을 만들기
		DefaultTableModel model = new DefaultTableModel(data, columns);
		
		//테이블 모델을 이용해서 테이블 만들기
		// (1)처음에 데이터가 있을 때
		JTable table = new JTable(model);
		
		// (2)처음에 데이터가 없었을 때
		table.setModel(model); 
		
		//출력영역의 크기보다 테이블이 커지더라도 스크롤바를 이용할 수 있도록 스크롤 생성
		JScrollPane scrollpane = new JScrollPane(table);
		
		//스크롤 패인을 프레임에 부착
		add(scrollpane);
		
		this.setVisible(true);
	}
}
