package game;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyPage extends Frame {
  Load lo;
  String id;
  String pw;
  String name;
  String email;
  Font font;
  Label l_name;
  Label l_id;
  Label l_id2;
  Label l_pw;
  Label l_email;
  HintTextField tf_name;
  Label show_id;
  HintTextField tf_pw;
  HintTextField tf_email;
  Dialog di;
  Label msg;
  Button ok;
  Dialog di2;
  Label msg2;
  Button ok2;
  Button fin_btn;
  private String verifier;
  private String[] loginInfo;// 로그인성공여부 ,패스워드,이름, 아이디,이메일

  public MyPage(String verifier) {
    loginInfo = new String[5];
    this.verifier = verifier;
    System.out.println("MyPage " + verifier);
    Token t = new Token();
    loginInfo = t.pull(verifier);

    // 화면 틀
    this.setBounds(720, 300, 480, 600);
    this.setTitle("MyPage");
    this.setLayout(null);
    font = new Font("", 0, 20);

    // 텍스트 라벨
    l_name = new Label("이름 ");
    l_name.setBounds(20, 200, 180, 30);

    l_id = new Label("아이디 ");
    l_id.setBounds(20, 250, 50, 30);

    l_id2 = new Label(loginInfo[3]);
    l_id2.setBounds(200, 250, 150, 30);
    l_id2.setBackground(Color.DARK_GRAY);
    l_pw = new Label("비밀번호 ");
    l_pw.setBounds(20, 300, 180, 30);

    l_email = new Label("이메일 " + loginInfo[4]);
    l_email.setBounds(20, 350, 180, 30);

    // 이름 영역
    tf_name = new HintTextField(loginInfo[2]);
    tf_name.setBounds(200, 200, 150, 30);
    // tf_name.setFont(font);
    this.add(tf_name);
    this.add(l_name);
    // id 표출 영역
    show_id = new Label(id);
    show_id.setBounds(100, 250, 150, 30);
    // show_id.setFont(font);
    this.add(show_id);
    this.add(l_id);
    this.add(l_id2);

    // pw 수정 영역
    tf_pw = new HintTextField(loginInfo[1]);
    tf_pw.setBounds(200, 300, 150, 30);
    this.add(tf_pw);
    this.add(l_pw);

    // 이메일 수정 영역
    tf_email = new HintTextField(loginInfo[3]);
    tf_email.setBounds(200, 350, 150, 30);
    tf_email.setText(loginInfo[3]);
    this.add(tf_email);
    this.add(l_email);

    // 수정 완료 모달
    di = new Dialog(this, "Info", true);
    di.setBounds(835, 525, 250, 150);
    di.setLayout(new FlowLayout());
    msg = new Label("수정 완료", Label.CENTER);
    ok = new Button("확인");
    ok.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        di.dispose();

      }
    });
    di.add(msg);
    di.add(ok);
    // 공백 경고 모달
    di2 = new Dialog(this, "Info", true);
    di2.setBounds(835, 525, 250, 150);
    di2.setLayout(new FlowLayout());
    msg2 = new Label("모든 항목을 입력해주세요", Label.CENTER);
    ok2 = new Button("확인");

    ok2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        di2.dispose();

      }
    });
    di2.add(msg2);
    di2.add(ok2);
    // 완료 버튼
    fin_btn = new Button("완료");
    fin_btn.setBounds(100, 400, 90, 30);

    fin_btn.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        if (tf_pw.getText().trim().equals("") || tf_name.getText().trim().equals("")
            || tf_email.getText().trim().equals("")) {
          di2.setVisible(true);// 공백 경고
          return;
        }
        // 완료 버튼 클릭시 진행될 이벤트
        new Save().save(id, tf_pw.getText(), tf_name.getText(), tf_email.getText());
        di.setVisible(true);
        dispose();
      }
    });
    this.add(fin_btn);

    // 닫기버튼
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        dispose();
      }
    });

    this.setVisible(true);

  }

}