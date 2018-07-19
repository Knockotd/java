package awt_eventHandling;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.Frame;

public class Aclass extends Frame {
	//생성자
    public Aclass() {
         //위치&크기
         setBounds(200,200,320,600);
         //타이틀
         setTitle("Aclass_텍스트 이벤트");
         //여러 개를 배치하기 위해서 패널을 설치
         Panel p = new Panel();
         
         //5칸 텍스트 필드 생성 - 패널에 설치
         TextField tf1 = new TextField(5);
         p.add(tf1);
         //+ 라벨 생성 - 패널에 설치
         Label plus = new Label("+");
         p.add(plus);
         
         //5칸 텍스트 필드 생성 - 패널에 설치
         TextField tf2 = new TextField(5);
         p.add(tf2);
         //= 라벨 생성 - 패널에 설치
         Label assign = new Label("=");
         p.add(assign);
         
         //결과가 나올 6칸 텍스트 필드 생성 - 패널에 설치
         TextField result = new TextField(6);
         p.add(result);
         
         //결과 출력 이벤트가 들어갈 버튼 생성 - 패널에 설치
         //버튼 글자가 깨지면 - ms949로 바꾸기 - 윈도우 프로그램이라서 그런 것임.
         Button btn = new Button("계산");
         p.add(btn);
         
         //**--Event-Start--**//
         //ActionListener 인터페이스의 anonymous class생성
         ActionListener listener = new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                  //첫번째 와 두번째 텍스트 필드의 내용 가져오기
                  String n1 = tf1.getText();
                  String n2 = tf2.getText();
                  
                  //정수로 바꾸어서 결과를 만들기
                  int r = Integer.parseInt(n1) + Integer.parseInt(n2);
                  
                  //결과를 result 텍스트 필드에 넣기
                  String rr = String.format("%d",r); //result.setText(r+""); -이런 방법도 있다.
                  result.setText(rr);
             }
             
         };
         btn.addActionListener(listener); //- 버튼을 클릭하면 이벤트를 실행하겠다는 것.
         
         //**--Event-End--**//
         
         //글자 출력 - 부착
         Label lblPw = new Label("비밀번호");
         p.add(lblPw);
         //텍스트 필드 생성 - 부착
         TextField pw = new TextField(15);
         p.add(pw);
         //텍스트 입력에 따라 결과를 출력하기 위함 - 부착
         Label pwResult = new Label();
         p.add(pwResult);
         
         //**--Event-Start--**//
         
         //텍스트 피드의 내용이 변경 될 때를 처리할 수 있는 인터페이스의 인스턴스 생성
         TextListener t1 = new TextListener() {
             @Override
             public void textValueChanged(TextEvent arg0) {
                  //텍스트 필드의 내용 받아오기
                  String password = pw.getText();
                  //각 문자 종류별로 개수 세기
                  //개수를 저장할 변수 만들기
                  int dae = 0; //대문자
                  int so = 0; //소문자
                  int num = 0; //숫자
                  int tc = 0; //특수문자
                  //password의 모든 글자를 순회(조사)
                  for(int i=0; i<password.length(); i++) {
                       //모든 문자 수집
                       char ch = password.charAt(i);
                       //대문자 인지 확인: A-Z
                       if(ch>='A' && ch<= 'Z') {
                            dae = dae + 1;
                       }
                       //소문자 인지 확인: a-z
                       else if(ch>='a' && ch<='z') {
                            so = so + 1;
                       }
                       //숫자 인지 확인: 0-9 - 입력한 숫자가 문자이기 때문에 문자로 인지를 해야합니다.
                       else if(ch>='0' && ch<='9') {
                            num = num + 1;
                       }
                       //특수문자 인지 확인: 영어대소문자, 숫자가 아닌 것.
                       else {
                            tc = tc + 1;
                       }
                  }
                  //각 문자가 1개 이상이어야 함
                  //4개 중에 한개도 0이 없으면
                  if(dae*so*num*tc>0) {
                       pwResult.setForeground(Color.GREEN);
                       pwResult.setText("사용 가능한 비밀번호");
                  }else {
                       pwResult.setForeground(Color.RED);
                       pwResult.setText("너무 약한 비밀번호 입니다.");
                  }
             }
             
         };
         pw.addTextListener(t1); //이 이벤트를 어느곳에 적용시킬것인지.이벤트처리기(이벤트처리기 이름); - 이벤트를 필요한 곳에 부착
         //**--Event-End--**//
         
         //프레임에 패널을 설치
         add(p);
         //화면 출력
         setVisible(true);
    }
}

