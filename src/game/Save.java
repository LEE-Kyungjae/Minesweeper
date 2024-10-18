package game;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Save {
	
	private String id;
	private String name;
	private String pw;
	private String email;
	
	public void save(String id, String pw, String name, String email) {
		
		File f;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		//���������ʵ忡�� �޾ƾ� �� ����
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.email = email;
		
		//����ȭ�� ����ڰ�ü
		UserInfo userInfo = new UserInfo(id, name, pw, email);
		
		//�ܺ����ϰ�� ����
		//String filePath = "C:/Program Files/JavaPjt/" + id + ".sav"; //���ϻ�����
		//String dir = "C:/Program Files/JavaPjt/";//���丮 ������
		String filePath = (System.getProperty("user.dir")+ "/user/" + id + ".sav").replace("\\", "/"); //���ϻ�����
		String dir = (System.getProperty("user.dir") + "/user/").replace("\\", "/");
		
		f = new File(dir);
		
		if(!f.exists()) {//���丮 ����
			f.mkdirs();
		}
		
		//���� ��Ʈ�� ��ü ���� (try with resource)
		try {
			
			fos = new FileOutputStream(filePath);
			oos = new ObjectOutputStream(fos);
			
			// ����ȭ ���� ��ü�� ����Ʈ ��Ʈ������ ��ȯ�ϰ� ���Ͽ� ����
			oos.writeObject(userInfo);
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				oos.close();
				fos.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}//save
	
	public void rank_save(String id, int rec) {
		File f;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		//����ȭ�� ��ũ�迭 ��ü
		UserRank userRank = new UserRank();
		
		//���� �ε� ��ü
		Load load = new Load();
		
		//�ε��� ����Ʈ�� �����߰��Ͽ� �ӽ� ������ ����
		List<Integer> temp_rec = new ArrayList<Integer>();
		List<String> temp_id = new ArrayList<String>();
		
		//���� ��ŷ�� �ҷ��� ������� ��� �߰� ����

		String filePath = (System.getProperty("user.dir") + "/rank/rank.sav").replace("\\", "/");
		String dir = (System.getProperty("user.dir") + "/rank/").replace("\\", "/");
		
		f = new File(dir);
		
		if(!f.exists()) {//���丮 ����, ù ���� ����
			f.mkdirs();
			temp_rec.add(rec);
			temp_id.add(id);
			
		}else {//���� ������ ���� ���
			int rank = 0;//���� ��ũ �ε���
			temp_rec = load.rank_load().getRec_list();
			temp_id = load.rank_load().getId_list();
			
			for(int i = 0; i < temp_rec.size(); i++) {

				if(rec < temp_rec.get(i)) {
					temp_rec.add(i, rec);
					rank = i;
					break;
				}else if(rec == temp_rec.get(i)) {
					temp_rec.add(i+1, rec);
					rank = i+1;
					break;
				}else if(i == temp_rec.size() - 1){
					temp_rec.add(rec);
					rank = temp_rec.size() - 1;
					break;
				}
					
			}//for
			
			//����� ������ ���� ���̵�� ����
			temp_id.add(rank, id);

		}
		
		userRank.setRec_list(temp_rec);
		userRank.setId_list(temp_id);
		
		//���� ��Ʈ�� ��ü ���� (try with resource)
		try {
			
			fos = new FileOutputStream(filePath);
			oos = new ObjectOutputStream(fos);
			
			// ����ȭ ���� ��ü�� ����Ʈ ��Ʈ������ ��ȯ�ϰ� ���Ͽ� ����
			oos.writeObject(userRank);
			System.out.println("�ҷ�����/���� ����");
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				oos.close();
				fos.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}//rank_save

}
