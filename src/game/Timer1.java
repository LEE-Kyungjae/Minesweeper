package game;

import java.awt.Font;
import javax.swing.JLabel;

public class Timer1 extends Thread implements Runnable {

  private boolean isCheck = true;
  public JLabel ltime;
  private int countTime = 0;

  public boolean isCheck() {
    return isCheck;
  }

  public void setCheck(boolean isCheck) {
    this.isCheck = isCheck;
  }

  public Timer1() {
    int time = 0;
    ltime = new JLabel(Integer.toString(time));
    ltime.setFont(new Font("TimesRoman", Font.ITALIC, 50));
    ltime.setHorizontalAlignment(JLabel.CENTER);
    Thread t1 = new Thread(this);
    t1.start();
  }

  @Override
  public void run() {
    while (isCheck) {
      try {
        Thread.sleep(1000);
        ltime.setText(Integer.toString(++countTime));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
  
  public int getTime() {
	  return countTime;
  }

}