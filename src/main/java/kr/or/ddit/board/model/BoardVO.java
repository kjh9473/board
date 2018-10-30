package kr.or.ddit.board.model;

import java.util.Date;

public class BoardVO {
	private String brd_id;
	private String brd_name;
	private int brd_chk;
	private String brd_mem;
	private Date brd_date;
	
	
	public BoardVO() {
		super();
	}


	public BoardVO(String brd_id, String brd_name, int brd_chk, String brd_mem,
			Date brd_date) {
		super();
		this.brd_id = brd_id;
		this.brd_name = brd_name;
		this.brd_chk = brd_chk;
		this.brd_mem = brd_mem;
		this.brd_date = brd_date;
	}


	public String getBrd_id() {
		return brd_id;
	}


	public void setBrd_id(String brd_id) {
		this.brd_id = brd_id;
	}


	public String getBrd_name() {
		return brd_name;
	}


	public void setBrd_name(String brd_name) {
		this.brd_name = brd_name;
	}


	public int getBrd_chk() {
		return brd_chk;
	}


	public void setBrd_chk(int brd_chk) {
		this.brd_chk = brd_chk;
	}


	public String getBrd_mem() {
		return brd_mem;
	}


	public void setBrd_mem(String brd_mem) {
		this.brd_mem = brd_mem;
	}


	public Date getBrd_date() {
		return brd_date;
	}


	public void setBrd_date(Date brd_date) {
		this.brd_date = brd_date;
	}


	@Override
	public String toString() {
		return "BoardVO [brd_id=" + brd_id + ", brd_name=" + brd_name
				+ ", brd_chk=" + brd_chk + ", brd_mem=" + brd_mem
				+ ", brd_date=" + brd_date + "]";
	}
	
	
	
	
}
