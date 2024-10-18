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

    // �α��� �ʵ忡�� �޾ƾ��� ����
    this.id = id;
    this.pw = pw;

    // �ܺ����ϰ��
    String filePath = (System.getProperty("user.dir") + "/user/" + id + ".sav").replace("\\", "/");
    File f = new File(filePath);

    if (!f.exists()) {// ���̵� ���� ���� Ȯ��
      System.out.println("���̵� Ȯ�����ּ���.");
      return "���̵� Ȯ�����ּ���.";
    }

    // ���� ��Ʈ�� ��ü ����
    try {

      fis = new FileInputStream(filePath);
      ois = new ObjectInputStream(fis);

      // ����Ʈ ��Ʈ���� �ٽ� �ڹ� ��ü�� ��ȯ
      userInfo = (UserInfo) ois.readObject();

      System.out.println(userInfo);

    } catch (Exception e) {
      // TODO: handle exception
      System.out.println("�����߻�");
    } finally {
      try {
        ois.close();
        fis.close();
      } catch (Exception e2) {
        // TODO: handle exception
      }
    }

    if (!pw.equals(userInfo.getPw())) {// �ҷ��� ������������ ��й�ȣ ��ġ���� Ȯ��
      System.out.println("��й�ȣ�� Ȯ�����ּ���.");
      return "��й�ȣ�� Ȯ�����ּ���.";
    }
    // ��ũ������
    Token t = new Token();
    // �α��μ�������, �н�����,�̸�, ���̵�,�̸���
    verifier = t.push("O", userInfo.getPw().length(), userInfo.getName(), userInfo.getId(), userInfo.getEmail());
    LoginPage lP = new LoginPage();
    lP.setVerifier(verifier);
    System.out.println("�α��� ����");

    return t.pull(verifier)[0];

  }// login

  public UserInfo load(String id) {// UserInfo�� �����͸� ����
    UserInfo userInfo = null;
    FileInputStream fis = null;
    ObjectInputStream ois = null;

    // �α��� �ʵ忡�� �޾ƾ��� ����
    this.id = id;

    // �ܺ����ϰ��
    String filePath = (System.getProperty("user.dir") + "/user/" + id + ".sav").replace("\\", "/");
    File f = new File(filePath);

    // ���� ��Ʈ�� ��ü ����
    try {

      fis = new FileInputStream(filePath);
      ois = new ObjectInputStream(fis);

      // ����Ʈ ��Ʈ���� �ٽ� �ڹ� ��ü�� ��ȯ
      userInfo = (UserInfo) ois.readObject();

    } catch (Exception e) {
      // TODO: handle exception
      System.out.println("�����߻�");
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

    // ���Ͻ�Ʈ�� ��ü ����
    try {

      fis = new FileInputStream(filePath);
      ois = new ObjectInputStream(fis);

      // ����Ʈ ��Ʈ���� �ٽ� �ڹ� ��ü�� ��ȯ
      userRank = (UserRank) ois.readObject();

    } catch (Exception e) {
      // TODO: handle exception
      System.out.println("�����߻�");
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
