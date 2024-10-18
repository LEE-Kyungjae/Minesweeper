package game;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Load {

  private String id;
  private String pw;
  private String verifier = "";

  public final String getVerifier() {
    return verifier;
  }

  public String login(String id, String pw) {

    UserInfo userInfo = null;
    FileInputStream fis = null;
    ObjectInputStream ois = null;

    // 로그인 필드에서 받아야할 변수
    this.id = id;
    this.pw = pw;

    // 외부파일경로
    String filePath = (System.getProperty("user.dir") + "/user/" + id + ".sav").replace("\\", "/");
    File f = new File(filePath);

    if (!f.exists()) {// 아이디 존재 여부 확인
      System.out.println("아이디를 확인해주세요.");
      return "아이디를 확인해주세요.";
    }

    // 파일 스트림 객체 생성
    try {

      fis = new FileInputStream(filePath);
      ois = new ObjectInputStream(fis);

      // 바이트 스트림을 다시 자바 객체로 변환
      userInfo = (UserInfo) ois.readObject();

      System.out.println(userInfo);

    } catch (Exception e) {
      // TODO: handle exception
      System.out.println("오류발생");
    } finally {
      try {
        ois.close();
        fis.close();
      } catch (Exception e2) {
        // TODO: handle exception
      }
    }

    if (!pw.equals(userInfo.getPw())) {// 불러온 계정정보에서 비밀번호 일치여부 확인
      System.out.println("비밀번호를 확인해주세요.");
      return "비밀번호를 확인해주세요.";
    }
    // 토크나이즈
    Token t = new Token();
    // 로그인성공여부, 패스워드,이름, 아이디,이메일
    verifier = t.push("O", userInfo.getPw().length(), userInfo.getName(), userInfo.getId(), userInfo.getEmail());
    LoginPage lP = new LoginPage();
    lP.setVerifier(verifier);
    System.out.println("로그인 성공");

    return t.pull(verifier)[0];

  }// login

  public UserInfo load(String id) {// UserInfo에 데이터를 저장
    UserInfo userInfo = null;
    FileInputStream fis = null;
    ObjectInputStream ois = null;

    // 로그인 필드에서 받아야할 변수
    this.id = id;

    // 외부파일경로
    String filePath = (System.getProperty("user.dir") + "/user/" + id + ".sav").replace("\\", "/");
    File f = new File(filePath);

    // 파일 스트림 객체 생성
    try {

      fis = new FileInputStream(filePath);
      ois = new ObjectInputStream(fis);

      // 바이트 스트림을 다시 자바 객체로 변환
      userInfo = (UserInfo) ois.readObject();

    } catch (Exception e) {
      // TODO: handle exception
      System.out.println("오류발생");
    } finally {
      try {
        ois.close();
        fis.close();
      } catch (Exception e2) {
        // TODO: handle exception
      }
    }

    return userInfo;
  }// load

  public UserRank rank_load() {
      
	UserRank userRank = null;
    FileInputStream fis = null;
    ObjectInputStream ois = null;

    String filePath = (System.getProperty("user.dir") + "/rank/rank.sav").replace("\\", "/");
    File f = new File(filePath);

    // 파일스트림 객체 생성
    try {

      fis = new FileInputStream(filePath);
      ois = new ObjectInputStream(fis);

      // 바이트 스트림을 다시 자바 객체로 변환
      userRank = (UserRank) ois.readObject();

    } catch (Exception e) {
      // TODO: handle exception
      System.out.println("오류발생");
    } finally {
      try {
        ois.close();
        fis.close();
      } catch (Exception e2) {
        // TODO: handle exception
      }
    }

    return userRank;
  }// rank_load

}
