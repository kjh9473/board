package kr.or.ddit.board.model;

public class AttachedVO {
	private String att_id;
	private String att_file;
	private int att_chk;
	private String att_path;
	private String att_bul;
	
	
	public AttachedVO(String att_id, String att_file, int att_chk,
			String att_path, String att_bul) {
		super();
		this.att_id = att_id;
		this.att_file = att_file;
		this.att_chk = att_chk;
		this.att_path = att_path;
		this.att_bul = att_bul;
	}


	public AttachedVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getAtt_id() {
		return att_id;
	}


	public void setAtt_id(String att_id) {
		this.att_id = att_id;
	}


	public String getAtt_file() {
		return att_file;
	}


	public void setAtt_file(String att_file) {
		this.att_file = att_file;
	}


	public int getAtt_chk() {
		return att_chk;
	}


	public void setAtt_chk(int att_chk) {
		this.att_chk = att_chk;
	}


	public String getAtt_path() {
		return att_path;
	}


	public void setAtt_path(String att_path) {
		this.att_path = att_path;
	}


	public String getAtt_bul() {
		return att_bul;
	}


	public void setAtt_bul(String att_bul) {
		this.att_bul = att_bul;
	}


	@Override
	public String toString() {
		return "AttachedVO [att_id=" + att_id + ", att_file=" + att_file
				+ ", att_chk=" + att_chk + ", att_path=" + att_path
				+ ", att_bul=" + att_bul + "]";
	}

}
