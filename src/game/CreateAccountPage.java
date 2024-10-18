package game;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class CreateAccountPage extends LoginPage{
	
	public boolean checked = false; // id중복을 확인해야 생성가능
	
	public void open() {
		
	
		
		//화면 틀
		this.setBounds(720, 300, 480, 600);
		this.setTitle("CreateAccount");
		this.setLayout(null);
		Font font = new Font("",0,20);
		
		//텍스트 라벨
		Label l_name = new Label("이름");
		l_name.setBounds(20, 200, 80, 30);
		
		Label l_id = new Label("아이디");
		l_id.setBounds(20, 250, 80, 30);
		
		Label l_pw = new Label("비밀번호");
		l_pw.setBounds(20, 300, 80, 30);
		
		Label l_email = new Label("이메일");
		l_email.setBounds(20, 350, 80, 30);
		
		//이름 영역
		TextField tf_name = new TextField();
		tf_name.setBounds(100, 200, 150, 30);
		tf_name.setFont(font);
		this.add(tf_name);
		this.add(l_name);
		
		//id 영역
		TextField tf_id = new TextField();
		tf_id.setBounds(100, 250, 150, 30);
		tf_id.setFont(font);
		this.add(tf_id);
		this.add(l_id);
		
		//pw 영역
		TextField tf_pw = new TextField();
		tf_pw.setBounds(100, 300, 150, 30);
		tf_pw.setFont(font);
		this.add(tf_pw);
		this.add(l_pw);
		
		//이메일 영역
		TextField tf_email = new TextField();
		tf_email.setBounds(100, 350, 150, 30);
		tf_email.setFont(font);
		this.add(tf_email);
		this.add(l_email);
		
		//계정 생성 완료 모달
		Dialog di = new Dialog(this,"Info", true);
		di.setBounds(835, 525, 250, 150);
		di.setLayout(new FlowLayout());
		Label msg = new Label("계정 생성 완료", Label.CENTER);
		Button ok = new Button("확인");
	
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				di.dispose();
				
			}
		});
		di.add(msg);
		di.add(ok);
		
		//아이디 중복 모달
		Dialog di2 = new Dialog(this,"Info", true);
		di2.setBounds(835, 525, 250, 150);
		di2.setLayout(new FlowLayout());
		Label msg2 = new Label("이미 존재하는 아이디 입니다.", Label.CENTER);
		Button ok2 = new Button("확인");
	
		ok2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				di2.dispose();
				tf_id.setText("");//모달창에서 확인키 누르면 id필드가 다 지워짐
				
			}
		});
		di2.add(msg2);
		di2.add(ok2);
		
		//아이디 사용 가능 모달
		Dialog di3 = new Dialog(this,"Info", true);
		di3.setBounds(835, 525, 250, 150);
		di3.setLayout(new FlowLayout());
		Label msg3 = new Label("사용 가능한 아이디 입니다.", Label.CENTER);
		Button ok3 = new Button("확인");
	
		ok3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				di3.dispose();
				tf_id.disable();
				checked = true;
				
			}
		});
		di3.add(msg3);
		di3.add(ok3);
		
		//공백 경고 모달
		Dialog di4 = new Dialog(this,"Info", true);
		di4.setBounds(835, 525, 250, 150);
		di4.setLayout(new FlowLayout());
		Label msg4 = new Label("비어있는 항목을 입력해주세요", Label.CENTER);
		Button ok4 = new Button("확인");
	
		ok4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				di4.dispose();
				
			}
		});
		di4.add(msg4);
		di4.add(ok4);
		
		//id중복체크 필요 모달
		Dialog di5 = new Dialog(this,"Info", true);
		di5.setBounds(835, 525, 250, 150);
		di5.setLayout(new FlowLayout());
		Label msg5 = new Label("아이디 중복확인을 해주세요", Label.CENTER);
		Button ok5 = new Button("확인");
	
		ok5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				di5.dispose();
				
			}
		});
		di5.add(msg5);
		di5.add(ok5);
		
		//id중복 확인 버튼
		Button check_btn = new Button("중복확인");
		check_btn.setBounds(270, 250, 60, 30);
		
		check_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//중복확인 버튼 클릭시 진행될 이벤트
				//공백체크
				if(tf_id.getText().trim().equals("")) {
					di4.setVisible(true);
					return;
				}
				//id 중복체크
				if(new File((System.getProperty("user.dir")+ "/user/" + tf_id.getText() + ".sav").replace("\\", "/")).exists()) {
					di2.setVisible(true);//이미 존재하는 아이디
				}else {
					di3.setVisible(true);
					
				}
			}
		});
		this.add(check_btn);
		
		//완료 버튼
		Button fin_btn = new Button("완료");
		fin_btn.setBounds(100, 400, 90, 30);
		
		fin_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(tf_id.getText().trim().equals("") || tf_pw.getText().trim().equals("") || tf_name.getText().trim().equals("") || tf_email.getText().trim().equals("")) {
					di4.setVisible(true);//공백 경고
					return;
				}else if(!checked) {
					di5.setVisible(true);//id중복체크 필요 모달
					return;
				}
				//완료 버튼 클릭시 진행될 이벤트
				new Save().save(tf_id.getText(), tf_pw.getText(), tf_name.getText(), tf_email.getText());
				di.setVisible(true);
				dispose();
			}
		});
		this.add(fin_btn);
		
		//닫기버튼
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		this.setVisible(true);
		
	}

}
