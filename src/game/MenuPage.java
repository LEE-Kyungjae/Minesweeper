package game;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuPage extends Frame {
  private static String verifier = "";// id �� ��� ����� �� �ְ� ��

  public MenuPage() {

  }// constructor

  public MenuPage(String verifier) {
    this.verifier = verifier;
    // ȭ�� Ʋ ����
    this.setBounds(720, 300, 480, 600);
    this.setTitle("MainMenu");
    this.setLayout(null);
    Font font = new Font("", 0, 20);

    // ���ӽ��� ��ư
    Button start_btn = new Button("���ӽ���");
    start_btn.setBounds(180, 260, 120, 40);
    start_btn.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        // mineSweeper���� ����
        new GamePage(9, 9, 9);
      }
    });
    this.add(start_btn);

    // ���������� ��ư
    Button my_btn = new Button("����������");
    my_btn.setBounds(180, 320, 120, 40);
    my_btn.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        // Mypage���� ����
        new MyPage(verifier);
      }
    });
    this.add(my_btn);

    // ��ŷ������ ��ư
    Button rank_btn = new Button("��ŷ");
    rank_btn.setBounds(180, 380, 120, 40);
    rank_btn.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        // Rank_page���� ����
        new RankPage(verifier);
      }
    });
    this.add(rank_btn);

    // �ݱ� ��ư
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }

    });

    this.setVisible(true);

  }// constructor

  public String getVerifier() {
    return this.verifier;
  }// getter

  // public static void main(String[] args) {
  // new Menu_page().open();
  // }// main
}
