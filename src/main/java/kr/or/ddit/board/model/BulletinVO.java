package kr.or.ddit.board.model;

import java.util.Date;

public class BulletinVO {
	private String bul_id;
	private String bul_title;
	private String bul_text;
	private Date bul_date;
	private int bul_chk;
	private String bul_mem;
	private String bul_brd;
	private int groub_num;
	private String bul_pid;
	private int rnum;
	
	public BulletinVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	




	

	public BulletinVO(String bul_id, String bul_title, String bul_text,
			Date bul_date, int bul_chk, String bul_mem, String bul_brd,
			int groub_num, String bul_pid, int rnum) {
		super();
		this.bul_id = bul_id;
		this.bul_title = bul_title;
		this.bul_text = bul_text;
		this.bul_date = bul_date;
		this.bul_chk = bul_chk;
		this.bul_mem = bul_mem;
		this.bul_brd = bul_brd;
		this.groub_num = groub_num;
		this.bul_pid = bul_pid;
		this.rnum = rnum;
	}










	public String getBul_pid() {
		return bul_pid;
	}



	public void setBul_pid(String bul_pid) {
		this.bul_pid = bul_pid;
	}



	public int getGroub_num() {
		return groub_num;
	}

	public void setGroub_num(int groub_num) {
		this.groub_num = groub_num;
	}

	public String getBul_id() {
		return bul_id;
	}

	public void setBul_id(String bul_id) {
		this.bul_id = bul_id;
	}

	public String getBul_title() {
		return bul_title;
	}

	public void setBul_title(String bul_title) {
		this.bul_title = bul_title;
	}

	public String getBul_text() {
		return bul_text;
	}

	public void setBul_text(String bul_text) {
		this.bul_text = bul_text;
	}

	public Date getBul_date() {
		return bul_date;
	}

	public void setBul_date(Date bul_date) {
		this.bul_date = bul_date;
	}

	public int getBul_chk() {
		return bul_chk;
	}

	public void setBul_chk(int bul_chk) {
		this.bul_chk = bul_chk;
	}

	public String getBul_mem() {
		return bul_mem;
	}

	public void setBul_mem(String bul_mem) {
		this.bul_mem = bul_mem;
	}

	public String getBul_brd() {
		return bul_brd;
	}

	public void setBul_brd(String bul_brd) {
		this.bul_brd = bul_brd;
	}
	
	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	@Override
	public String toString() {
		return "BulletinVO [bul_id=" + bul_id + ", bul_title=" + bul_title
				+ ", bul_text=" + bul_text + ", bul_date=" + bul_date
				+ ", bul_chk=" + bul_chk + ", bul_mem=" + bul_mem
				+ ", bul_brd=" + bul_brd + ", groub_num=" + groub_num
				+ ", bul_pid=" + bul_pid + ", rnum=" + rnum + "]";
	}

	
}
