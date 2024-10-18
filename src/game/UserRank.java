package game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserRank implements Serializable{

	private String id;
	private int rec;
	private List<Integer> rec_list = new ArrayList<Integer>();
	private List<String> id_list = new ArrayList<String>();
	
	public UserRank() {//데이터 로드시 가져올 생성자
		
	}
	
	public void setRec_list(List<Integer> rec_list) {
		this.rec_list = rec_list;
	}
	
	public void setId_list(List<String> id_list) {
		this.id_list = id_list;
	}
	
	public List<Integer> getRec_list() {
		
		return rec_list;
	}
	
	public List<String> getId_list(){
		
		return id_list;
	}
	
}
