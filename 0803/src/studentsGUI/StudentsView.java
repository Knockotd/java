package studentsGUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class StudentsView extends JFrame {

	// 필요한 UI 변수 선언
	JLabel lblPart, lblPhone, lblEmergency, lblBirthday; // 레이블 변수
	JTextField tfName, tfPart, tfPhone, tfEmergency, tfBirthday; // 입력 텍스트 필드 변수
	JButton btnFirst, btnLast, btnPrev, btnNext; // 버튼변수
	JButton btnInsert, btnUpdate, btnDelete, btnSearch, btnClear;
	JLabel lblIndex, lblName;// 인덱스 표시할 레이블

	// 데이터베이스 작업을 위한 Dao 변수
	DAO_test dao = new DAO_testImpl();
	// 데이터베이스에서 가져온 결과를 저장하기 위한 List
	List<DTO_test> list;
	// 현재 출력 중인 데이터의 인덱스를 저장할 변수
	int idx;

	// idx번째 데이터를 화면에 출력해주는 메소드
	// 맨 처음 한번 호출하고 데이터에 작업이 발생하면 호출하는 메소드
	private void printData() {
		// 읽을 데이터가 없다면 메시지 박스를 출력하고 return
		if (list.size() == 0) {
			JOptionPane.showMessageDialog(null, "읽을 데이터가 없습니다.", "데이터 없음", JOptionPane.ERROR_MESSAGE);
			return;
		}
		// List 에서 idx번째 데이터를 가져옵니다.
		DTO_test dto = list.get(idx);
		tfName.setText(dto.getName());
		tfPart.setText(dto.getPart());
		tfPhone.setText(dto.getPhone());
		tfEmergency.setText(dto.getEmergency());
		// 생일은 Date 타입이므로 toString을 호출해서 String으로 변환해서 출렵합니다.
		tfBirthday.setText(dto.getBirthday().toString());
		// 레이블에 현재 인덱스를 출력
		// lblIndex.setText(String.format("%d", idx+1));
		lblIndex.setText((idx + 1) + "");
	}

	// 생성자
	// 객체를 만들 때 초기화를 위해서 생성
	public StudentsView() {
		// 레이블을 생성
		newlb();
		// 텍스트 필드 생성
		newtf();
		// 5행 2열 배치될 수 있는 레이아웃으로 변경, 여백
		// 넣을 값이 양쪽 2개씩 5개이므로 이렇게 설정.
		// 때에 따라서 적절하게 조정할 것.
		// 중앙에 배치할 패널 생성
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(5, 2, 3, 3));
		centerPanel.add(lblName);
		centerPanel.add(tfName);

		centerPanel.add(lblPart);
		centerPanel.add(tfPart);

		centerPanel.add(lblPhone);
		centerPanel.add(tfPhone);

		centerPanel.add(lblEmergency);
		centerPanel.add(tfEmergency);

		centerPanel.add(lblBirthday);
		centerPanel.add(tfBirthday);

		add("Center", centerPanel);

		display();

		setBounds(500, 500, 500, 300);

		setTitle("학생 정보");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		setVisible(true);

		// 데이터베이스에서 데이터를 가져옵니다.
		list = dao.allreadTest();
		printData();
	}

	private void display() {
		// 버튼 생성
		btnFirst = new JButton("First");
		btnFirst.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				idx = 0;
				JOptionPane.showMessageDialog(null, "첫번째 데이터입니다.", "조회", JOptionPane.INFORMATION_MESSAGE);
				printData();
			}

		});
		btnPrev = new JButton("Previous");

		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (idx == 0) {
					JOptionPane.showMessageDialog(null, "첫번째 데이터입니다.\n확인을 누르면 마지막 데이터로 이동합니다.", "조회",
							JOptionPane.INFORMATION_MESSAGE);
					/*
					 * JOptionPane.showMessageDialog(null, "첫번째 데이터입니다.", "조회에러",
					 * JOptionPane.ERROR_MESSAGE);
					 */

					idx = list.size();
				}
				idx = idx - 1;
				printData();
			}

		});

		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				idx = idx + 1;

				if (idx == list.size()) {
					JOptionPane.showMessageDialog(null, "마지막 데이터입니다.\n확인을 누르면 첫번째 데이터로 이동합니다.", "조회",
							JOptionPane.INFORMATION_MESSAGE);
					idx = 0;
				}
				printData();
			}

		});
		btnLast = new JButton("Last");
		btnLast.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				idx = list.size() - 1;
				JOptionPane.showMessageDialog(null, "마지막 데이터입니다.", "조회", JOptionPane.INFORMATION_MESSAGE);
				printData();
			}

		});
		btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// lblIndex의 텍스트를 조사해서 삽입이 아니면 메시지 박스를 출력하고 작업중단

				// 문자열의 동일성 여부는 ==가 아니고 equals로 해야 합니다.
				if (lblIndex.getText().equals("삽입") == false) {
					// 오류창 띄우고 리턴:
					JOptionPane.showMessageDialog(null, "지우고 쓰세요", "삽입에러", JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					String name = tfName.getText();
					String part = tfPart.getText();
					String phone = tfPhone.getText();
					String emergency = tfEmergency.getText();
					String birthday = tfBirthday.getText();

					// name은 필수 입력이고 3자 이상 입력했는지 검사
					if (name.trim().length() < 3 || name.trim().length() > 5) {
						// 오류창 띄우고 리턴:
						JOptionPane.showMessageDialog(null, "이름은 3자 이상, 5자 이하입니다.", "이름 오류", JOptionPane.ERROR_MESSAGE);
						return;
					}
					String message = "";
					if (name.trim().length() < 1) {
						message = "이름필수";
					} else if (phone.trim().length() < 1) {
						message = "번호필수";
					}
					if (message.length() >= 1) {
						JOptionPane.showMessageDialog(null, message, "입력오류", JOptionPane.ERROR_MESSAGE);
						return;
					}

					// phone은 전부 숫자이고 11자리인지 검사
					if (phone.trim().length() != 11) {
						// 오류창 띄우고 리턴:
						JOptionPane.showMessageDialog(null, "핸드폰 번호는 11자리로 입력해주세요.", "핸드폰 번호 오류",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					int i = 0;
					while (i < phone.trim().length()) {
						char ch = phone.trim().charAt(i);
						if (ch < '0' || ch > '9') {
							// 오류창 띄우고 리턴:
							JOptionPane.showMessageDialog(null, "핸드폰 번호는 숫자만입력하세요", "핸드폰 번호 오류",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						i = i + 1;
					}

					// 날짜 데이터가 년도 4자리월2자리일2자리 형식인지 조사
					// yyyymmdd
					i = 0;
					if (birthday.length() != 8) {
						JOptionPane.showMessageDialog(null, "생일은 8자리로 만들어주세요.", "입력오류", JOptionPane.ERROR_MESSAGE);
						return;
					}
					while (i < birthday.length()) {
						char ch = birthday.charAt(i);
						// 첫번째부터 네번째까지 숫자가 아니면 반복문 종료
						if (i >= 0 && i <= 8) {
							if (ch < '0' || ch > '9') {
								break;
							}
						}
						
						i = i + 1;
					}
					// 유효성 검사에 실패하면 메시지 박스를 출력하고 리턴
					if (i != birthday.length()) {
						JOptionPane.showMessageDialog(null, "생일은 yyyymmdd 형식", "생일 입력 오류", JOptionPane.ERROR_MESSAGE);
						return;
					}
					// Dao의 메소드에 맞게 데이터 생성
					DTO_test dto = new DTO_test();
					dto.setName(name);
					dto.setPart(part);
					dto.setPhone(phone);
					dto.setEmergency(emergency);

					// birthday를 Date 타입으로 변경.

					int year = Integer.parseInt(birthday.substring(0, 4));
					int month = Integer.parseInt(birthday.substring(4, 6));
					int day = Integer.parseInt(birthday.substring(6));
					Calendar cal = Calendar.getInstance();
					cal.set(Calendar.YEAR, year);
					cal.set(Calendar.MONTH, month - 1);
					cal.set(Calendar.DAY_OF_MONTH, day);
					Date date = new Date(cal.getTimeInMillis());

					dto.setBirthday(date);

					// 데이터 베이스 작업 수행
					dao.insertTest(dto);
					// 작업 수행 후 재출력을 위해서 데이터를 다시 가져오고 인덱스 조정
					list = dao.allreadTest();
					idx = list.size()-1;
					printData();

					// 대화상자 출력하기
					JOptionPane.showMessageDialog(null, "삽입 성공", "데이터삽입", JOptionPane.INFORMATION_MESSAGE);

				}

			}
		});
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 입력한 텍스트 전부 가져옴
				String name = tfName.getText();
				String part = tfPart.getText();
				String phone = tfPhone.getText();
				String emergency = tfEmergency.getText();
				String birthday = tfBirthday.getText();

				// name의 데이터가 비어있으면 메시지 박스를 출력하고 리턴하기
				String message = "";
				if (name.trim().length() < 1) {
					message = "이름필수";
				} else if (phone.trim().length() < 1) {
					message = "번호필수";
				}
				if (message.length() >= 1) {
					JOptionPane.showMessageDialog(null, message, "입력오류", JOptionPane.ERROR_MESSAGE);
					return;
				}
				// 날짜 데이터가 년도 4자리-월2자리-일2자리 형식인지 조사
				// yyyy-mm-dd
				int i = 0;
				if (birthday.length() != 10) {
					JOptionPane.showMessageDialog(null, "생일은 10자리로 만들어주세요.", "입력오류", JOptionPane.ERROR_MESSAGE);
					return;
				}
				while (i < birthday.length()) {
					char ch = birthday.charAt(i);
					// 첫번째부터 네번째까지 숫자가 아니면 반복문 종료
					if (i >= 0 && i <= 3) {
						if (ch < '0' || ch > '9') {
							break;
						}
					}
					if (i == 4 || i == 7) {
						if (ch != '-') {
							break;
						}
					}
					if (i == 5) {
						if (ch != '0' && ch != '1') {
							break;
						}
					}
					if (i == 6) {
						if (ch < '0' || ch > '9') {
							break;
						}
					}
					if (i > 7) {
						if (ch < '0' || ch > '9') {
							break;
						}
					}
					i = i + 1;
				}
				// 유효성 검사에 실패하면 메시지 박스를 출력하고 리턴
				if (i != birthday.length()) {
					JOptionPane.showMessageDialog(null, "생일은 yyyy-mm-dd 형식", "입력오류", JOptionPane.ERROR_MESSAGE);
					return;
				}

				DTO_test students = new DTO_test();
				students.setNum(list.get(idx).getNum());
				students.setName(name);
				students.setPart(part);
				students.setPhone(phone);
				students.setEmergency(emergency);

				// 형식 문자열을 가지고 Date 만들기
				// 0번째에서 4번째 앞까지
				int year = Integer.parseInt(birthday.substring(0, 4));
				int month = Integer.parseInt(birthday.substring(5, 7));
				int day = Integer.parseInt(birthday.substring(8));
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.YEAR, year);
				cal.set(Calendar.MONTH, month - 1);
				cal.set(Calendar.DAY_OF_MONTH, day);
				Date date = new Date(cal.getTimeInMillis());
				students.setBirthday(date);

				dao.updateTest(students);
				JOptionPane.showMessageDialog(null, "수정 성공", "데이터수정", JOptionPane.INFORMATION_MESSAGE);
				printData();
				list = dao.allreadTest();
				printData();

			}

		});
		btnDelete = new JButton("Delete");

		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int r = JOptionPane.showConfirmDialog(null, "정말로 삭제?", "삭제", JOptionPane.YES_NO_OPTION);
				System.out.println(r);
				if (r == 0) {
					JOptionPane.showMessageDialog(null, "삭제 성공", "삭제", JOptionPane.INFORMATION_MESSAGE);
					// 번호를 이용해서 삭제
					dao.deleteTest(list.get(idx).getNum());
					list = dao.allreadTest();
					idx = 0;
					printData();
				}
			}

		});
		btnSearch = new JButton("Search");

		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog(null, "조회할 이름의 일부분을 입력하세요!", "이름으로 조회",
						JOptionPane.QUESTION_MESSAGE);
				tfName.setText("");
				tfPart.setText("");
				tfPhone.setText("");
				tfEmergency.setText("");
				tfBirthday.setText("");

				if (name != null) {
					list = dao.readTest(name.trim().toUpperCase());
					printData();
				}

			};

		});

		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 텍스트 필드들의 텍스트 전부 삭제
				tfName.setText("");
				tfPart.setText("");
				tfPhone.setText("");
				tfEmergency.setText("");
				tfBirthday.setText("");

				// lblIndex 의 타이틀을 삽입으로 변경
				lblIndex.setText("삽입");

			}

		});

		lblIndex = new JLabel("", JLabel.CENTER);

		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(1, 5, 7, 7));
		panel1.setBorder(new TitledBorder("조회"));
		panel1.add(btnFirst);
		panel1.add(btnPrev);
		panel1.add(lblIndex);
		panel1.add(btnNext);
		panel1.add(btnLast);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1, 5, 7, 7));
		panel2.setBorder(new TitledBorder("작업"));
		panel2.add(btnInsert);
		panel2.add(btnUpdate);
		panel2.add(btnDelete);
		panel2.add(btnSearch);
		panel2.add(btnClear);

		JPanel southpanel = new JPanel(new BorderLayout());
		southpanel.add("Center", panel1);
		southpanel.add("South", panel2);

		add("South", southpanel);
	}

	private void newlb() {
		lblName = new JLabel("이름", JLabel.RIGHT);
		lblPart = new JLabel("역할", JLabel.RIGHT);
		lblPhone = new JLabel("핸드폰 번호", JLabel.RIGHT);
		lblEmergency = new JLabel("비상 연락처", JLabel.RIGHT);
		lblBirthday = new JLabel("생일", JLabel.RIGHT);
	}

	private void newtf() {
		tfName = new JTextField();
		tfPart = new JTextField();
		tfPhone = new JTextField();
		tfEmergency = new JTextField();
		tfBirthday = new JTextField();
	}

}
