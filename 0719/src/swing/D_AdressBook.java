package swing;

import java.awt.event.*;

import javax.swing.*;
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
		this.setBounds(100,100,1000,400);
		this.setTitle("연락처");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//테이블 모델을 이용해서 테이블을 만들기
		DefaultTableModel model = new DefaultTableModel(data, columns);
		
		//테이블 모델을 이용해서 테이블 만들기
		// (1)처음에 데이터가 있을 때
		JTable table = new JTable(model);
		
		// (2)처음에 데이터가 없었을 때
		//table.setModel(model); 
		
		//출력영역의 크기보다 테이블이 커지더라도 스크롤바를 이용할 수 있도록 스크롤 생성
		JScrollPane scrollpane = new JScrollPane(table);
		
		//스크롤 패인을 프레임에 부착
		add(scrollpane);
		//메뉴를 만들고 싶다면 항상 메뉴바부터 생성
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("파일(a)");
		//단축키 설정
		file.setMnemonic('a');
		
		JMenuItem item1 =new JMenuItem("열기");
		file.add(item1);
		
		JCheckBoxMenuItem item2 =new JCheckBoxMenuItem("저장");
		file.add(item2);
		
		JRadioButtonMenuItem item3 =new JRadioButtonMenuItem("편집");
		file.add(item3);
		
		menuBar.add(file);
		
		/////////////////////////사용자 입력에 따른 데이터 삽입 삭제/////////////////////////////////////
		
		JLabel lbName = new JLabel("이름");
		JTextField tfName = new JTextField(10);
		JLabel lbPhone = new JLabel("전화번호");
		JTextField tfPhone = new JTextField(15);
		JLabel lbAdress = new JLabel("주소");
		JTextField tfAdress = new JTextField(30);
		
		JButton btnInsert = new JButton("삽입");
		JButton btnDelete = new JButton("삭제");
		
		JPanel southPanel = new JPanel();
		southPanel.add(lbName);
		southPanel.add(tfName);
		southPanel.add(lbPhone);
		southPanel.add(tfPhone);
		southPanel.add(lbAdress);
		southPanel.add(tfAdress);
		southPanel.add(btnInsert);
		southPanel.add(btnDelete);
		
		add("South",southPanel);
		
		
		this.setVisible(true);
		
	/*	//메시지 다이얼로그 출력
		JOptionPane.showMessageDialog(null, "메시지 다이얼로그", "대화상자",
		JOptionPane.QUESTION_MESSAGE);*/
		
	/*	//선택 다이얼로그 출력
		int r = JOptionPane.showConfirmDialog(null, "메시지 다이얼로그","대화상자",JOptionPane.YES_NO_OPTION);
		System.out.println(r);
	*/	
	/*	//한 줄 입력받는 다이얼로그 출력
		String s = JOptionPane.showInputDialog(null,"메시지 다이얼로그","대화상자",JOptionPane.YES_NO_OPTION);
		System.out.println(s);*/
		
		///////////////////삽입 버튼의 클릭 이벤트(ActionListener)처리////////////////////////////
		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//텍스트 필드에 입력된 내용 모두 가져오기
				String name = tfName.getText();
				String phone = tfPhone.getText();
				String adress = tfAdress.getText();
				
				//좌우공백제거
				name = name.trim();
				phone = phone.trim();
				adress = adress.trim();
				
				//name의 필수입력
				//이름이 입력되지 않은 경우 길이가 0 /null이 아닙니다.
				//name은 textfield의 데이터를 가지고 왔다. textfield는 만들어지면서 ""로 초기화를 시키기 때문에 null은 정말 아무것도
				//없는 것을 뜻하므로 null이라고 하면 안 되는 것이다.
				if(name.length()==0) {
					JOptionPane.showMessageDialog(null, "이름은 필수 입력", "이름	", JOptionPane.WARNING_MESSAGE);
					//아래쪽을 더이상 수행하지 않도록 리턴
					return; //함수 밖으로 벗어난다. -->
				}
				if(phone.length()==0) {
					JOptionPane.showMessageDialog(null, "번호 필수 입력", "번호", JOptionPane.WARNING_MESSAGE);
					//아래쪽을 더이상 수행하지 않도록 리턴
					return; //함수 밖으로 벗어난다. -->
				}
				if(adress.length()==0) {
					JOptionPane.showMessageDialog(null, "주소 필수 입력", "주소", JOptionPane.WARNING_MESSAGE);
					//아래쪽을 더이상 수행하지 않도록 리턴
					return; //함수 밖으로 벗어난다. -->
				}
				
				//테이블에 추가 - 데이터 모델을 가져옵니다.
				DefaultTableModel model = (DefaultTableModel)table.getModel(); //이 작업을 왜 하는지 물어보기
				//JTable은 view의 역할만 할 수 있다.
				//그래서 추가 삭제는 DefaultTableModel을 다시 생성해서 작업을 하는 것이다.
				
				//데이터를 추가하기 위해서 추가할 데이터 배열을 생성
				String [] row = {name, phone, adress};
				//모델에 추가
				model.addRow(row);
				//테이블을 갱신
				table.updateUI();
				
				//텍스트 필드 클리어
				tfName.setText("");
				tfPhone.setText("");
				tfAdress.setText("");
				
				//메시지 박스 출력
				JOptionPane.showMessageDialog(null, "데이터 삽입 성공", "삽입작업", JOptionPane.PLAIN_MESSAGE);
			}};
		btnInsert.addActionListener(al);
		
		ActionListener deleteListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//어떤 걸 선택했는지 알 수 있어야 한다.
				
				int idx = table.getSelectedRow();
				//진짜로 선택을 햇는지도 확인해야 한다.-데이터를 선택하지 않았다면
				if(idx<0 || idx>=table.getRowCount()) {
					JOptionPane.showMessageDialog(null, "행을 선택하세요.", "삭제 실패	", JOptionPane.WARNING_MESSAGE);
					return;
				}
				//테이블의 모델 가져오기
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				//선택한 행에 해당하는 데이터 지우기
				model.removeRow(idx);
				table.updateUI();
				JOptionPane.showMessageDialog(null, "데이터 삭제 성공", "삭제", JOptionPane.WARNING_MESSAGE);
			}
			
		};
		btnDelete.addActionListener(deleteListener);
		

		
		//메뉴바를 윈도우에 부착
		setJMenuBar(menuBar);
	}
}
