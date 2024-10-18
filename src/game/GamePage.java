package game;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;

public class GamePage extends JFrame {
  private JButton[][] buttons;
  private int[][] minesweeperGrid;
  private int rows, cols, numMines;
  private boolean[][] revealed;
  private boolean[][] flagged;
  private boolean gameover;
  private JLabel statusLabel;
  private JLabel timerLabel;
  private int count = 0; // 깃발갯수(지뢰개수)
  private JButton iconbtn;
  private String pathimg;
  private String pathimg2;
  Timer1 timethread = new Timer1();
  ImageIcon happy;
  ImageIcon sad;
  ResetThread t2;
  JPanel gridPanel;
  JPanel toppanel;
  JPanel statusTpanel;
  JPanel iconTpanel;
  JPanel timerTpanel;
  JPanel bottompanel;
  // Record record;
  String verifier;
  Token t;

  public GamePage(int rows, int cols, int numMines) {
    t = new Token();
    this.timerLabel = timethread.ltime;
    this.rows = rows;
    this.cols = cols;
    this.numMines = numMines;
    t2 = new ResetThread(rows, cols, numMines, verifier);
    pathimg = (System.getProperty("user.dir") + "/img/happy.png").replace("\\", "/");
    pathimg2 = (System.getProperty("user.dir") + "/img/sad.png").replace("\\", "/");
    // 패널 사이즈
    setTitle("지뢰 찾기");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setLayout(new BorderLayout(0, 5));

    // 그리드패널 선언
    gridPanel = new JPanel(new GridLayout(rows, cols));
    // 탑패널
    toppanel = new JPanel(new BorderLayout(20, 0));
    // 바텀패널
    bottompanel = new JPanel(new BorderLayout(20, 0));// 형식상 선언, 실질적으로 변경점 없음
    // 탑->status 패널
    statusTpanel = new JPanel();
    // 탑->icon 패널
    iconTpanel = new JPanel();
    // 탑->timer 패널
    timerTpanel = new JPanel();
    // 바텀패널

    toppanel.setBorder(new LineBorder(Color.DARK_GRAY, 10));
    bottompanel.setBorder(new LineBorder(Color.DARK_GRAY, 10));

    buttons = new JButton[rows][cols];
    minesweeperGrid = new int[rows][cols];
    revealed = new boolean[rows][cols];
    flagged = new boolean[rows][cols];

    happy = new ImageIcon(pathimg);
    sad = new ImageIcon(pathimg2);

    statusLabel = new JLabel();
    statusLabel.setFont(new Font("TimesRoman", Font.BOLD, 30));
    statusLabel.setForeground(Color.RED);
    statusLabel.setHorizontalAlignment(JLabel.CENTER);
    statusLabel.setPreferredSize(new Dimension(100, 100));

    // icontop.setForeground(Color.RED);
    iconbtn = new JButton(happy);
    iconbtn.setBorderPainted(false);
    iconbtn.setContentAreaFilled(false);
    iconbtn.setFocusPainted(false);

    timerLabel.setPreferredSize(new Dimension(100, 100));

    // 초기화된 지뢰찾기 그리드 생성
    // 그리드 생성했을 때 값을
    this.count = initializeMineSweeperGrid(count);

    // 버튼 그리드 생성
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        final int row = i;
        final int col = j;
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(50, 50));

        iconbtn.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            System.out.println("reset button pressed");
            t2.start();
            setVisible(false);
            return;
          }
        });

        button.addMouseListener(new MouseAdapter() {
          @Override
          public void mousePressed(MouseEvent e) {

            if (!gameover && !revealed[row][col]) {
              if (e.getButton() == MouseEvent.BUTTON1) {
                // 좌클릭 - 지뢰 찾기 클릭 이벤트
                // 지뢰를 밟았다면 게임오버
                if (minesweeperGrid[row][col] == -1) {
                  gameOver(sad);

                  // record = new Record(timethread.getCountTime(), verifier, false);

                } else {
                  // 지뢰를 밟지 않았다면 해당위치 주변의 지뢰 개수를 파악해서 변수에 대입
                  
                  int adjacentMines = countAdjacentMines(row, col);

                  // 주변에 지뢰가 없다면 주변에 있는 같이 빈 셀들을 찾아서 드러내고 버튼 비활성화
                  // 버튼비활성화
                  if (adjacentMines == 0) {
                    revealEmptyCells(row, col);
                  } else {
                    revealed[row][col] = true;
                    buttons[row][col].setText(Integer.toString(adjacentMines));
                  }
                  // 남은 활성화된 버튼을 개수세서 남은 지뢰수랑 같다면 게임 클리어!!
                  int cnt = countRemainButton();
                  if (cnt == numMines) {
                    gameClear();
                  }
                }
              } else if (e.getButton() == MouseEvent.BUTTON3) {
                // 우클릭으로 깃발 꽂기/빼기
                flag(row, col);
              }
            }
          }

        });
        buttons[i][j] = button;
        gridPanel.add(button);
      }
    }

    // f->Tpanel,Gpanel, bottompanel
    add(toppanel, BorderLayout.NORTH);
    add(gridPanel, BorderLayout.CENTER);
    add(bottompanel, BorderLayout.SOUTH);

    // Tpanel->statusT,iconT,timerT
    toppanel.add(statusTpanel, BorderLayout.WEST);
    // toppanel.add(iconTpanel, BorderLayout.CENTER);
    toppanel.add(iconbtn, BorderLayout.CENTER);

    toppanel.add(timerTpanel, BorderLayout.EAST);

    // iconTpanel.add(icontop);
    statusTpanel.add(statusLabel);
    timerTpanel.add(timerLabel);

    // repaint();
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }

  // 지뢰배치
  private int initializeMineSweeperGrid(int count) {
    // 초기화: -1은 지뢰, 0은 지뢰가 없음을 의미
    // 여기서는 간단하게 지뢰를 랜덤 위치에 배치
    count = 0;
    while (count < numMines) {
      int randRow = (int) (Math.random() * rows);
      int randCol = (int) (Math.random() * cols);
      if (minesweeperGrid[randRow][randCol] != -1) {
        minesweeperGrid[randRow][randCol] = -1;
        count++;
        statusLabel.setText("🏁 : " + Integer.toString(count));
      }
    }
    return count;
  }

  // 지뢰 위치를 보여줌
  private void revealMines() {
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (minesweeperGrid[i][j] == -1) {
          buttons[i][j].setText("X");
        }
      }
    }
  }

  // 해당위치 기준으로 주변에 있는 지뢰 개수 반환
  private int countAdjacentMines(int row, int col) {
    int count = 0;
    for (int i = Math.max(0, row - 1); i <= Math.min(rows - 1, row + 1); i++) {
      for (int j = Math.max(0, col - 1); j <= Math.min(cols - 1, col + 1); j++) {
        if (minesweeperGrid[i][j] == -1) {
          // 주변에 있는 지뢰개수 적힌 버튼 비활성화
          buttons[row][col].setEnabled(false);
          count++;
        }
      }
    }
    return count;
  }

  // 주변에 지뢰 없는 칸 확인하고 지뢰 없는 칸 발견시 버튼 비활성화
  private void revealEmptyCells(int row, int col) {
    // 주변에 지뢰가 없는 빈 칸들을 모두 표시
    if (row < 0 || col < 0 || row >= rows || col >= cols || revealed[row][col]) {
      return;
    }
    int adjacentMines = countAdjacentMines(row, col);
    revealed[row][col] = true;
    if (adjacentMines == 0) {
      buttons[row][col].setEnabled(false);
      buttons[row][col].setText("");
      for (int i = row - 1; i <= row + 1; i++) {
        for (int j = col - 1; j <= col + 1; j++) {
          revealEmptyCells(i, j);
        }
      }
    } else {
      buttons[row][col].setText(Integer.toString(adjacentMines));
    }
  }

  // 깃발 꽂기&뺴기 메소드
  private void flag(int row, int col) {
    if (!flagged[row][col]) {
      flagged[row][col] = true;
      buttons[row][col].setText("🏁");
      count--;
      flagCount();
    } else {
      flagged[row][col] = false;
      buttons[row][col].setText("");
      count++;
      flagCount();
    }
  }

  // 남은 버튼 개수 세는 메소드
  private int countRemainButton() {
    int cnt = 0;
    for (int i = 0; i < buttons.length; i++) {
      for (int j = 0; j < buttons.length; j++) {
        if (buttons[i][j].isEnabled()) {
          cnt++;
        }
      }
    }
    return cnt;
  }

  // 게임 클리어 메소드
  private void gameClear() {
    for (int i = 0; i < buttons.length; i++) {
      for (int j = 0; j < buttons[i].length; j++) {
        buttons[i][j].setEnabled(false);
      }
    }
    // 게임클리어 다이얼로그&타이머 멈춤
    timethread.setCheck(false);
    System.out.println("clear stop");
    JOptionPane.showMessageDialog(null, "Game Clear!");

    // 게임 클리어시 기록 저장
    new Save().rank_save(t.pull(new MenuPage().getVerifier())[3], timethread.getTime());
  }

  // 게임오버 메소드
  private void gameOver(ImageIcon sad) {
    // 스레드 종료
    timethread.setCheck(false);
//    new Save().rank_save(t.pull(new MenuPage().getVerifier())[3], timethread.getTime());
    // 전체버튼 비활성화
    for (int i = 0; i < buttons.length; i++) {
      for (int j = 0; j < buttons[i].length; j++) {
        buttons[i][j].setEnabled(false);
      }
    }
    gameover = true;
    // 모든 지뢰위치 보여주기
    revealMines();
    iconbtn.setIcon(sad);
    // 게임오버 다이얼로그 & 타이머 멈춤
    JOptionPane.showMessageDialog(null, "Game Over!");
  }

  // 플래그 남은 개수 출력 메소드
  private void flagCount() {
    statusLabel.setText("🏁 : " + Integer.toString(count));
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      GamePage game = new GamePage(9, 9, 9); // 10x10 그리드에 10개의 지뢰
    });
  }// main
}