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

    Load lo = new Load();// 이름, 점수 정보 읽어오기용
    // Save, Load에 랭킹용 sav파일 저장하고 불러오는 기능 추가
    // 해당 파일은 게임 끝나고 상호작용, 이름/점수 매치하여 저장
    
    String[] arr = new String[5];
    
    File f = new File((System.getProperty("user.dir") + "/rank/rank.sav").replace("\\", "/"));
    
    Token t = new Token();
    
    arr=t.pull(verifier);
    
    if(!f.exists()) {
    	
        Dialog emptyFileD = new Dialog(this, "Info", true);
        Button emptyFileBtn = new Button("확인");
        emptyFileD.setBounds(835, 525, 250, 150);
        emptyFileD.setLayout(new FlowLayout());
        Label emptyFileL = new Label("저장된 기록이 없습니다!", Label.CENTER);

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

          // 페이지 틀
          this.setBounds(720, 300, 480, 600);
          this.setTitle("Rank");
          this.setLayout(null);
          Font font = new Font("", 0, 25);

          // 순위가 표시될 구역
          Label l_1th = new Label("1위");
          l_1th.setBounds(30, 120, 60, 30);
          l_1th.setFont(font);
          l_1th.setVisible(true);
          this.add(l_1th);

          Label l_2th = new Label("2위");
          l_2th.setBounds(30, 190, 60, 30);
          l_2th.setFont(font);
          l_2th.setVisible(true);
          this.add(l_2th);

          Label l_3th = new Label("3위");
          l_3th.setBounds(30, 260, 60, 30);
          l_3th.setFont(font);
          l_3th.setVisible(true);
          this.add(l_3th);

          Label l_4th = new Label("4위");
          l_4th.setBounds(30, 330, 60, 30);
          l_4th.setFont(font);
          l_4th.setVisible(true);
          this.add(l_4th);

          Label l_5th = new Label("5위");
          l_5th.setBounds(30, 400, 60, 30);
          l_5th.setFont(font);
          l_5th.setVisible(true);
          this.add(l_5th);

          // id/기록이 표시될 구역
          Label top_rank = new Label("순위");// id 가져오기
          top_rank.setBounds(30, 70, 60, 30);
          top_rank.setFont(font);
          top_rank.setVisible(true);
          this.add(top_rank);

          Label top_id = new Label("id");// id 가져오기
          top_id.setBounds(110, 70, 100, 30);
          top_id.setFont(font);
          top_id.setVisible(true);
          this.add(top_id);

          Label top_rec = new Label("클리어타임");// rec 가져오기
          top_rec.setBounds(230, 70, 140, 30);
          top_rec.setFont(font);
          top_rec.setVisible(true);
          this.add(top_rec);

          try {

            Label l_id1 = new Label(lo.rank_load().getId_list().get(0));// id 가져오기
            l_id1.setBounds(110, 120, 100, 30);
            l_id1.setFont(font);
            l_id1.setVisible(true);
            this.add(l_id1);

            Label l_rec1 = new Label(lo.rank_load().getRec_list().get(0).toString() + "초");// rec 가져오기
            l_rec1.setBounds(230, 120, 100, 30);
            l_rec1.setFont(font);
            l_rec1.setVisible(true);
            this.add(l_rec1);

            Label l_id2 = new Label(lo.rank_load().getId_list().get(1));// id 가져오기
            l_id2.setBounds(110, 190, 100, 30);
            l_id2.setFont(font);
            l_id2.setVisible(true);
            this.add(l_id2);

            Label l_rec2 = new Label(lo.rank_load().getRec_list().get(1).toString() + "초");// rec 가져오기
            l_rec2.setBounds(230, 190, 100, 30);
            l_rec2.setFont(font);
            l_rec2.setVisible(true);
            this.add(l_rec2);

            Label l_id3 = new Label(lo.rank_load().getId_list().get(2));// id 가져오기
            l_id3.setBounds(110, 260, 100, 30);
            l_id3.setFont(font);
            l_id3.setVisible(true);
            this.add(l_id3);

            Label l_rec3 = new Label(lo.rank_load().getRec_list().get(2).toString() + "초");// rec 가져오기
            l_rec3.setBounds(230, 260, 100, 30);
            l_rec3.setFont(font);
            l_rec3.setVisible(true);
            this.add(l_rec3);

            Label l_id4 = new Label(lo.rank_load().getId_list().get(3));// id 가져오기
            l_id4.setBounds(110, 330, 100, 30);
            l_id4.setFont(font);
            l_id4.setVisible(true);
            this.add(l_id4);

            Label l_rec4 = new Label(lo.rank_load().getRec_list().get(3).toString() + "초");// rec 가져오기
            l_rec4.setBounds(230, 330, 100, 30);
            l_rec4.setFont(font);
            l_rec4.setVisible(true);
            this.add(l_rec4);

            Label l_id5 = new Label(lo.rank_load().getId_list().get(4));// id 가져오기
            l_id5.setBounds(110, 400, 100, 30);
            l_id5.setFont(font);
            l_id5.setVisible(true);
            this.add(l_id5);

            Label l_rec5 = new Label(lo.rank_load().getRec_list().get(4).toString() + "초");// rec 가져오기
            l_rec5.setBounds(230, 400, 100, 30);
            l_rec5.setFont(font);
            l_rec5.setVisible(true);
            this.add(l_rec5);

          } catch (Exception e) {
            // TODO: handle exception
          }

          // 닫기 버튼
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
