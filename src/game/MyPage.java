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
  private String[] loginInfo;// �α��μ������� ,�н�����,�̸�, ���̵�,�̸���

  public MyPage(String verifier) {
    loginInfo = new String[5];
    this.verifier = verifier;
    System.out.println("MyPage " + verifier);
    Token t = new Token();
    loginInfo = t.pull(verifier);

    // ȭ�� Ʋ
    this.setBounds(720, 300, 480, 600);
    this.setTitle("MyPage");
    this.setLayout(null);
    font = new Font("", 0, 20);

    // �ؽ�Ʈ ��
    l_name = new Label("�̸� ");
    l_name.setBounds(20, 200, 180, 30);

    l_id = new Label("���̵� ");
    l_id.setBounds(20, 250, 50, 30);

    l_id2 = new Label(loginInfo[3]);
    l_id2.setBounds(200, 250, 150, 30);
    l_id2.setBackground(Color.DARK_GRAY);
    l_pw = new Label("��й�ȣ ");
    l_pw.setBounds(20, 300, 180, 30);

    l_email = new Label("�̸��� " + loginInfo[4]);
    l_email.setBounds(20, 350, 180, 30);

    // �̸� ����
    tf_name = new HintTextField(loginInfo[2]);
    tf_name.setBounds(200, 200, 150, 30);
    // tf_name.setFont(font);
    this.add(tf_name);
    this.add(l_name);
    // id ǥ�� ����
    show_id = new Label(id);
    show_id.setBounds(100, 250, 150, 30);
    // show_id.setFont(font);
    this.add(show_id);
    this.add(l_id);
    this.add(l_id2);

    // pw ���� ����
    tf_pw = new HintTextField(loginInfo[1]);
    tf_pw.setBounds(200, 300, 150, 30);
    this.add(tf_pw);
    this.add(l_pw);

    // �̸��� ���� ����
    tf_email = new HintTextField(loginInfo[3]);
    tf_email.setBounds(200, 350, 150, 30);
    tf_email.setText(loginInfo[3]);
    this.add(tf_email);
    this.add(l_email);

    // ���� �Ϸ� ���
    di = new Dialog(this, "Info", true);
    di.setBounds(835, 525, 250, 150);
    di.setLayout(new FlowLayout());
    msg = new Label("���� �Ϸ�", Label.CENTER);
    ok = new Button("Ȯ��");
    ok.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        di.dispose();

      }
    });
    di.add(msg);
    di.add(ok);
    // ���� ��� ���
    di2 = new Dialog(this, "Info", true);
    di2.setBounds(835, 525, 250, 150);
    di2.setLayout(new FlowLayout());
    msg2 = new Label("��� �׸��� �Է����ּ���", Label.CENTER);
    ok2 = new Button("Ȯ��");

    ok2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        di2.dispose();

      }
    });
    di2.add(msg2);
    di2.add(ok2);
    // �Ϸ� ��ư
    fin_btn = new Button("�Ϸ�");
    fin_btn.setBounds(100, 400, 90, 30);

    fin_btn.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        if (tf_pw.getText().trim().equals("") || tf_name.getText().trim().equals("")
            || tf_email.getText().trim().equals("")) {
          di2.setVisible(true);// ���� ���
          return;
        }
        // �Ϸ� ��ư Ŭ���� ����� �̺�Ʈ
        new Save().save(id, tf_pw.getText(), tf_name.getText(), tf_email.getText());
        di.setVisible(true);
        dispose();
      }
    });
    this.add(fin_btn);

    // �ݱ��ư
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        dispose();
      }
    });

    this.setVisible(true);

  }

}