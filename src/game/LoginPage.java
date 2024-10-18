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
  // UserInfo ���� ���� ��������
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

    // �α��� ���� ���
    loginOkD = new Dialog(this, "Info", true);
    loginOkD.setBounds(835, 525, 250, 150);
    loginOkD.setLayout(new FlowLayout());
    loginOkL = new Label("�α��� ����", Label.CENTER);
    loginOkbtn = new Button("Ȯ��");

    loginOkbtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        loginOkD.dispose();

      }
    });
    loginOkD.add(loginOkL);
    loginOkD.add(loginOkbtn);

    // id�� Ȯ���ϼ��� ���
    checkIdD = new Dialog(this, "Info", true);
    checkIdD.setBounds(835, 525, 250, 150);
    checkIdD.setLayout(new FlowLayout());
    checkIdL = new Label("���̵� Ȯ���ϼ���", Label.CENTER);
    checkIdBtn = new Button("Ȯ��");

    checkIdBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        checkIdD.dispose();

      }
    });
    checkIdD.add(checkIdL);
    checkIdD.add(checkIdBtn);

    // pw�� Ȯ���ϼ��� ���
    checkPwD = new Dialog(this, "Info", true);
    checkPwD.setBounds(835, 525, 250, 150);
    checkPwD.setLayout(new FlowLayout());
    checkPwL = new Label("��й�ȣ�� Ȯ���ϼ���", Label.CENTER);
    checkBtn = new Button("Ȯ��");

    checkBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        checkPwD.dispose();

      }
    });
    checkPwD.add(checkPwL);
    checkPwD.add(checkBtn);

    // ȭ�� Ʋ ����
    this.setBounds(720, 300, 480, 600);
    this.setTitle("Log-in");
    this.setLayout(null);
    font = new Font("", 0, 20);

    // id����
    tf_id = new TextField();
    tf_id.setBounds(140, 300, 150, 30);
    tf_id.setFont(font);
    this.add(tf_id);
    idL = new JLabel("���̵� :");
    idL.setBounds(90, 300, 150, 30);
    this.add(idL);

    // pw����
    tf_pw = new TextField();
    tf_pw.setEchoChar('*');
    tf_pw.setBounds(140, 350, 150, 30);
    tf_pw.setFont(font);
    this.add(tf_pw);
    pwL = new JLabel("�н����� :");
    pwL.setBounds(80, 350, 150, 30);
    this.add(pwL);

    // �α��� ��ư
    loginBtn = new Button("Log-in");
    loginBtn.setBounds(300, 300, 60, 80);

    loginBtn.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        // Log-in ��ư Ŭ���� ����� �̺�Ʈ
        // sav���Ͽ��� id�� ���ؼ� �ߺ�üũ �ϰ� �ҷ����� ���
        Load load = new Load();
        cert = load.login(tf_id.getText(), tf_pw.getText());
        verifier = load.getVerifier();
        if (cert.equals("O")) {
          loginOkD.setVisible(true);// ���â ǥ��
          new MenuPage(verifier);
          setVisible(false);

        } else if (cert.contentEquals("���̵� Ȯ�����ּ���.")) {
          checkIdD.setVisible(true);
          return;
        } else if (cert.equals("��й�ȣ�� Ȯ�����ּ���.")) {
          checkPwD.setVisible(true);
          return;
        }

      }
    });
    this.add(loginBtn);

    // ȸ������ ��ư
    regBtn = new Button("ȸ������");
    regBtn.setBounds(140, 390, 90, 30);

    regBtn.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        // ȸ������ ��ư Ŭ���� ����� �̺�Ʈ
        // ȸ������ �������� �Ѿ�� ���
        new CreateAccountPage().open();
      }
    });
    this.add(regBtn);

    // �ӽù�ư
//    sampleBtn = new Button("�ӽù�ư");
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

    // CreateAccount �������� �Ѿ��

    // �ݱ��ư
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    this.setVisible(true);

  }// open

}
