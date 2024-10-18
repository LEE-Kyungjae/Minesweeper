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
	
	public boolean checked = false; // id�ߺ��� Ȯ���ؾ� ��������
	
	public void open() {
		
	
		
		//ȭ�� Ʋ
		this.setBounds(720, 300, 480, 600);
		this.setTitle("CreateAccount");
		this.setLayout(null);
		Font font = new Font("",0,20);
		
		//�ؽ�Ʈ ��
		Label l_name = new Label("�̸�");
		l_name.setBounds(20, 200, 80, 30);
		
		Label l_id = new Label("���̵�");
		l_id.setBounds(20, 250, 80, 30);
		
		Label l_pw = new Label("��й�ȣ");
		l_pw.setBounds(20, 300, 80, 30);
		
		Label l_email = new Label("�̸���");
		l_email.setBounds(20, 350, 80, 30);
		
		//�̸� ����
		TextField tf_name = new TextField();
		tf_name.setBounds(100, 200, 150, 30);
		tf_name.setFont(font);
		this.add(tf_name);
		this.add(l_name);
		
		//id ����
		TextField tf_id = new TextField();
		tf_id.setBounds(100, 250, 150, 30);
		tf_id.setFont(font);
		this.add(tf_id);
		this.add(l_id);
		
		//pw ����
		TextField tf_pw = new TextField();
		tf_pw.setBounds(100, 300, 150, 30);
		tf_pw.setFont(font);
		this.add(tf_pw);
		this.add(l_pw);
		
		//�̸��� ����
		TextField tf_email = new TextField();
		tf_email.setBounds(100, 350, 150, 30);
		tf_email.setFont(font);
		this.add(tf_email);
		this.add(l_email);
		
		//���� ���� �Ϸ� ���
		Dialog di = new Dialog(this,"Info", true);
		di.setBounds(835, 525, 250, 150);
		di.setLayout(new FlowLayout());
		Label msg = new Label("���� ���� �Ϸ�", Label.CENTER);
		Button ok = new Button("Ȯ��");
	
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				di.dispose();
				
			}
		});
		di.add(msg);
		di.add(ok);
		
		//���̵� �ߺ� ���
		Dialog di2 = new Dialog(this,"Info", true);
		di2.setBounds(835, 525, 250, 150);
		di2.setLayout(new FlowLayout());
		Label msg2 = new Label("�̹� �����ϴ� ���̵� �Դϴ�.", Label.CENTER);
		Button ok2 = new Button("Ȯ��");
	
		ok2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				di2.dispose();
				tf_id.setText("");//���â���� Ȯ��Ű ������ id�ʵ尡 �� ������
				
			}
		});
		di2.add(msg2);
		di2.add(ok2);
		
		//���̵� ��� ���� ���
		Dialog di3 = new Dialog(this,"Info", true);
		di3.setBounds(835, 525, 250, 150);
		di3.setLayout(new FlowLayout());
		Label msg3 = new Label("��� ������ ���̵� �Դϴ�.", Label.CENTER);
		Button ok3 = new Button("Ȯ��");
	
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
		
		//���� ��� ���
		Dialog di4 = new Dialog(this,"Info", true);
		di4.setBounds(835, 525, 250, 150);
		di4.setLayout(new FlowLayout());
		Label msg4 = new Label("����ִ� �׸��� �Է����ּ���", Label.CENTER);
		Button ok4 = new Button("Ȯ��");
	
		ok4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				di4.dispose();
				
			}
		});
		di4.add(msg4);
		di4.add(ok4);
		
		//id�ߺ�üũ �ʿ� ���
		Dialog di5 = new Dialog(this,"Info", true);
		di5.setBounds(835, 525, 250, 150);
		di5.setLayout(new FlowLayout());
		Label msg5 = new Label("���̵� �ߺ�Ȯ���� ���ּ���", Label.CENTER);
		Button ok5 = new Button("Ȯ��");
	
		ok5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				di5.dispose();
				
			}
		});
		di5.add(msg5);
		di5.add(ok5);
		
		//id�ߺ� Ȯ�� ��ư
		Button check_btn = new Button("�ߺ�Ȯ��");
		check_btn.setBounds(270, 250, 60, 30);
		
		check_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//�ߺ�Ȯ�� ��ư Ŭ���� ����� �̺�Ʈ
				//����üũ
				if(tf_id.getText().trim().equals("")) {
					di4.setVisible(true);
					return;
				}
				//id �ߺ�üũ
				if(new File((System.getProperty("user.dir")+ "/user/" + tf_id.getText() + ".sav").replace("\\", "/")).exists()) {
					di2.setVisible(true);//�̹� �����ϴ� ���̵�
				}else {
					di3.setVisible(true);
					
				}
			}
		});
		this.add(check_btn);
		
		//�Ϸ� ��ư
		Button fin_btn = new Button("�Ϸ�");
		fin_btn.setBounds(100, 400, 90, 30);
		
		fin_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(tf_id.getText().trim().equals("") || tf_pw.getText().trim().equals("") || tf_name.getText().trim().equals("") || tf_email.getText().trim().equals("")) {
					di4.setVisible(true);//���� ���
					return;
				}else if(!checked) {
					di5.setVisible(true);//id�ߺ�üũ �ʿ� ���
					return;
				}
				//�Ϸ� ��ư Ŭ���� ����� �̺�Ʈ
				new Save().save(tf_id.getText(), tf_pw.getText(), tf_name.getText(), tf_email.getText());
				di.setVisible(true);
				dispose();
			}
		});
		this.add(fin_btn);
		
		//�ݱ��ư
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		this.setVisible(true);
		
	}

}
