package game;

import java.awt.Button;
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

import javax.swing.JFrame;
import javax.swing.JLabel;

public class LoginPage extends Frame {
  // UserInfo 정보 받을 참조변수
  UserInfo ui;
  Dialog loginOkD;
  Label loginOkL;
  Button loginOkbtn;
  Dialog checkIdD;
  Label checkIdL;
  Button checkIdBtn;
  Dialog checkPwD;
  Label checkPwL;
  Button checkBtn;
  Font font;
  TextField tf_id;
  JLabel idL;
  TextField tf_pw;
  JLabel pwL;
  Button loginBtn;
  Button regBtn;
  Button sampleBtn;
  String cert;

  private String verifier;

  public final void setVerifier(String verifier) {
    this.verifier = verifier;
  }

  public void open() {

    // 로그인 성공 모달
    loginOkD = new Dialog(this, "Info", true);
    loginOkD.setBounds(835, 525, 250, 150);
    loginOkD.setLayout(new FlowLayout());
    loginOkL = new Label("로그인 성공", Label.CENTER);
    loginOkbtn = new Button("확인");

    loginOkbtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        loginOkD.dispose();

      }
    });
    loginOkD.add(loginOkL);
    loginOkD.add(loginOkbtn);

    // id를 확인하세요 모달
    checkIdD = new Dialog(this, "Info", true);
    checkIdD.setBounds(835, 525, 250, 150);
    checkIdD.setLayout(new FlowLayout());
    checkIdL = new Label("아이디를 확인하세요", Label.CENTER);
    checkIdBtn = new Button("확인");

    checkIdBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        checkIdD.dispose();

      }
    });
    checkIdD.add(checkIdL);
    checkIdD.add(checkIdBtn);

    // pw를 확인하세요 모달
    checkPwD = new Dialog(this, "Info", true);
    checkPwD.setBounds(835, 525, 250, 150);
    checkPwD.setLayout(new FlowLayout());
    checkPwL = new Label("비밀번호를 확인하세요", Label.CENTER);
    checkBtn = new Button("확인");

    checkBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        checkPwD.dispose();

      }
    });
    checkPwD.add(checkPwL);
    checkPwD.add(checkBtn);

    // 화면 틀 생성
    this.setBounds(720, 300, 480, 600);
    this.setTitle("Log-in");
    this.setLayout(null);
    font = new Font("", 0, 20);

    // id영역
    tf_id = new TextField();
    tf_id.setBounds(140, 300, 150, 30);
    tf_id.setFont(font);
    this.add(tf_id);
    idL = new JLabel("아이디 :");
    idL.setBounds(90, 300, 150, 30);
    this.add(idL);

    // pw영역
    tf_pw = new TextField();
    tf_pw.setEchoChar('*');
    tf_pw.setBounds(140, 350, 150, 30);
    tf_pw.setFont(font);
    this.add(tf_pw);
    pwL = new JLabel("패스워드 :");
    pwL.setBounds(80, 350, 150, 30);
    this.add(pwL);

    // 로그인 버튼
    loginBtn = new Button("Log-in");
    loginBtn.setBounds(300, 300, 60, 80);

    loginBtn.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        // Log-in 버튼 클릭시 진행될 이벤트
        // sav파일에서 id를 비교해서 중복체크 하고 불러오는 기능
        Load load = new Load();
        cert = load.login(tf_id.getText(), tf_pw.getText());
        verifier = load.getVerifier();
        if (cert.equals("O")) {
          loginOkD.setVisible(true);// 모달창 표출
          new MenuPage(verifier);
          setVisible(false);

        } else if (cert.contentEquals("아이디를 확인해주세요.")) {
          checkIdD.setVisible(true);
          return;
        } else if (cert.equals("비밀번호를 확인해주세요.")) {
          checkPwD.setVisible(true);
          return;
        }

      }
    });
    this.add(loginBtn);

    // 회원가입 버튼
    regBtn = new Button("회원가입");
    regBtn.setBounds(140, 390, 90, 30);

    regBtn.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        // 회원가입 버튼 클릭시 진행될 이벤트
        // 회원가입 페이지로 넘어가는 기능
        new CreateAccountPage().open();
      }
    });
    this.add(regBtn);

    // 임시버튼
//    sampleBtn = new Button("임시버튼");
//    sampleBtn.setBounds(370, 300, 60, 80);
//    this.add(sampleBtn);
//    sampleBtn.addActionListener(new ActionListener() {
//
//      @Override
//      public void actionPerformed(ActionEvent e) {
//        dispose();
//        new GamePage(9, 9, 9);
//
//      }
//    });

    // CreateAccount 페이지로 넘어가기

    // 닫기버튼
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    this.setVisible(true);

  }// open

}
