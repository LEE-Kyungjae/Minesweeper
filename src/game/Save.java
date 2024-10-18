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
		
		//계정생성필드에서 받아야 할 변수
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.email = email;
		
		//직렬화할 사용자객체
		UserInfo userInfo = new UserInfo(id, name, pw, email);
		
		//외부파일경로 생성
		//String filePath = "C:/Program Files/JavaPjt/" + id + ".sav"; //파일생성용
		//String dir = "C:/Program Files/JavaPjt/";//디렉토리 생성용
		String filePath = (System.getProperty("user.dir")+ "/user/" + id + ".sav").replace("\\", "/"); //파일생성용
		String dir = (System.getProperty("user.dir") + "/user/").replace("\\", "/");
		
		f = new File(dir);
		
		if(!f.exists()) {//디렉토리 생성
			f.mkdirs();
		}
		
		//파일 스트림 객체 생성 (try with resource)
		try {
			
			fos = new FileOutputStream(filePath);
			oos = new ObjectOutputStream(fos);
			
			// 직렬화 가능 객체를 바이트 스트림으로 변환하고 파일에 저장
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
		
		//직렬화할 랭크배열 객체
		UserRank userRank = new UserRank();
		
		//파일 로드 객체
		Load load = new Load();
		
		//로드한 리스트에 내용추가하여 임시 저장할 변수
		List<Integer> temp_rec = new ArrayList<Integer>();
		List<String> temp_id = new ArrayList<String>();
		
		//기존 랭킹을 불러와 순위대로 기록 추가 저장

		String filePath = (System.getProperty("user.dir") + "/rank/rank.sav").replace("\\", "/");
		String dir = (System.getProperty("user.dir") + "/rank/").replace("\\", "/");
		
		f = new File(dir);
		
		if(!f.exists()) {//디렉토리 생성, 첫 파일 생성
			f.mkdirs();
			temp_rec.add(rec);
			temp_id.add(id);
			
		}else {//기존 파일이 있을 경우
			int rank = 0;//유저 랭크 인덱스
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
			
			//저장된 순위를 현재 아이디와 연결
			temp_id.add(rank, id);

		}
		
		userRank.setRec_list(temp_rec);
		userRank.setId_list(temp_id);
		
		//파일 스트림 객체 생성 (try with resource)
		try {
			
			fos = new FileOutputStream(filePath);
			oos = new ObjectOutputStream(fos);
			
			// 직렬화 가능 객체를 바이트 스트림으로 변환하고 파일에 저장
			oos.writeObject(userRank);
			System.out.println("불러오기/저장 성공");
			
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
