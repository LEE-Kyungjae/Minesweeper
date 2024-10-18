package game;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class RankPage extends Frame {

  public RankPage(String verifier) {

    Load lo = new Load();// �̸�, ���� ���� �о�����
    // Save, Load�� ��ŷ�� sav���� �����ϰ� �ҷ����� ��� �߰�
    // �ش� ������ ���� ������ ��ȣ�ۿ�, �̸�/���� ��ġ�Ͽ� ����
    
    String[] arr = new String[5];
    
    File f = new File((System.getProperty("user.dir") + "/rank/rank.sav").replace("\\", "/"));
    
    Token t = new Token();
    
    arr=t.pull(verifier);
    
    if(!f.exists()) {
    	
        Dialog emptyFileD = new Dialog(this, "Info", true);
        Button emptyFileBtn = new Button("Ȯ��");
        emptyFileD.setBounds(835, 525, 250, 150);
        emptyFileD.setLayout(new FlowLayout());
        Label emptyFileL = new Label("����� ����� �����ϴ�!", Label.CENTER);

        emptyFileBtn.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
        	  emptyFileD.dispose();

          }
        });
        emptyFileD.add(emptyFileL);
        emptyFileD.add(emptyFileBtn);
        
        emptyFileD.setVisible(true);
    	
    }else {
    	
        for (int i = 0; i < lo.rank_load().getRec_list().size(); i++) {
            System.out.println(lo.rank_load().getRec_list().get(i).toString());
            System.out.println(lo.rank_load().getId_list().get(i));

          } // for

          // ������ Ʋ
          this.setBounds(720, 300, 480, 600);
          this.setTitle("Rank");
          this.setLayout(null);
          Font font = new Font("", 0, 25);

          // ������ ǥ�õ� ����
          Label l_1th = new Label("1��");
          l_1th.setBounds(30, 120, 60, 30);
          l_1th.setFont(font);
          l_1th.setVisible(true);
          this.add(l_1th);

          Label l_2th = new Label("2��");
          l_2th.setBounds(30, 190, 60, 30);
          l_2th.setFont(font);
          l_2th.setVisible(true);
          this.add(l_2th);

          Label l_3th = new Label("3��");
          l_3th.setBounds(30, 260, 60, 30);
          l_3th.setFont(font);
          l_3th.setVisible(true);
          this.add(l_3th);

          Label l_4th = new Label("4��");
          l_4th.setBounds(30, 330, 60, 30);
          l_4th.setFont(font);
          l_4th.setVisible(true);
          this.add(l_4th);

          Label l_5th = new Label("5��");
          l_5th.setBounds(30, 400, 60, 30);
          l_5th.setFont(font);
          l_5th.setVisible(true);
          this.add(l_5th);

          // id/����� ǥ�õ� ����
          Label top_rank = new Label("����");// id ��������
          top_rank.setBounds(30, 70, 60, 30);
          top_rank.setFont(font);
          top_rank.setVisible(true);
          this.add(top_rank);

          Label top_id = new Label("id");// id ��������
          top_id.setBounds(110, 70, 100, 30);
          top_id.setFont(font);
          top_id.setVisible(true);
          this.add(top_id);

          Label top_rec = new Label("Ŭ����Ÿ��");// rec ��������
          top_rec.setBounds(230, 70, 140, 30);
          top_rec.setFont(font);
          top_rec.setVisible(true);
          this.add(top_rec);

          try {

            Label l_id1 = new Label(lo.rank_load().getId_list().get(0));// id ��������
            l_id1.setBounds(110, 120, 100, 30);
            l_id1.setFont(font);
            l_id1.setVisible(true);
            this.add(l_id1);

            Label l_rec1 = new Label(lo.rank_load().getRec_list().get(0).toString() + "��");// rec ��������
            l_rec1.setBounds(230, 120, 100, 30);
            l_rec1.setFont(font);
            l_rec1.setVisible(true);
            this.add(l_rec1);

            Label l_id2 = new Label(lo.rank_load().getId_list().get(1));// id ��������
            l_id2.setBounds(110, 190, 100, 30);
            l_id2.setFont(font);
            l_id2.setVisible(true);
            this.add(l_id2);

            Label l_rec2 = new Label(lo.rank_load().getRec_list().get(1).toString() + "��");// rec ��������
            l_rec2.setBounds(230, 190, 100, 30);
            l_rec2.setFont(font);
            l_rec2.setVisible(true);
            this.add(l_rec2);

            Label l_id3 = new Label(lo.rank_load().getId_list().get(2));// id ��������
            l_id3.setBounds(110, 260, 100, 30);
            l_id3.setFont(font);
            l_id3.setVisible(true);
            this.add(l_id3);

            Label l_rec3 = new Label(lo.rank_load().getRec_list().get(2).toString() + "��");// rec ��������
            l_rec3.setBounds(230, 260, 100, 30);
            l_rec3.setFont(font);
            l_rec3.setVisible(true);
            this.add(l_rec3);

            Label l_id4 = new Label(lo.rank_load().getId_list().get(3));// id ��������
            l_id4.setBounds(110, 330, 100, 30);
            l_id4.setFont(font);
            l_id4.setVisible(true);
            this.add(l_id4);

            Label l_rec4 = new Label(lo.rank_load().getRec_list().get(3).toString() + "��");// rec ��������
            l_rec4.setBounds(230, 330, 100, 30);
            l_rec4.setFont(font);
            l_rec4.setVisible(true);
            this.add(l_rec4);

            Label l_id5 = new Label(lo.rank_load().getId_list().get(4));// id ��������
            l_id5.setBounds(110, 400, 100, 30);
            l_id5.setFont(font);
            l_id5.setVisible(true);
            this.add(l_id5);

            Label l_rec5 = new Label(lo.rank_load().getRec_list().get(4).toString() + "��");// rec ��������
            l_rec5.setBounds(230, 400, 100, 30);
            l_rec5.setFont(font);
            l_rec5.setVisible(true);
            this.add(l_rec5);

          } catch (Exception e) {
            // TODO: handle exception
          }

          // �ݱ� ��ư
          this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
              dispose();
            }
          });

          this.setVisible(true);
    	
    }


  }// open

}
