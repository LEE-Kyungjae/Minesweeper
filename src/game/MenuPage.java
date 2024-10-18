package game;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuPage extends Frame {
  private static String verifier = "";// id 가 상시 저장될 수 있게 함

  public MenuPage() {

  }// constructor

  public MenuPage(String verifier) {
    this.verifier = verifier;
    // 화면 틀 생성
    this.setBounds(720, 300, 480, 600);
    this.setTitle("MainMenu");
    this.setLayout(null);
    Font font = new Font("", 0, 20);

    // 게임시작 버튼
    Button start_btn = new Button("게임시작");
    start_btn.setBounds(180, 260, 120, 40);
    start_btn.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        // mineSweeper새로 열기
        new GamePage(9, 9, 9);
      }
    });
    this.add(start_btn);

    // 마이페이지 버튼
    Button my_btn = new Button("마이페이지");
    my_btn.setBounds(180, 320, 120, 40);
    my_btn.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        // Mypage새로 열기
        new MyPage(verifier);
      }
    });
    this.add(my_btn);

    // 랭킹페이지 버튼
    Button rank_btn = new Button("랭킹");
    rank_btn.setBounds(180, 380, 120, 40);
    rank_btn.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        // Rank_page새로 열기
        new RankPage(verifier);
      }
    });
    this.add(rank_btn);

    // 닫기 버튼
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
