package kr.or.ddit.board.model;

import java.util.Date;

public class CommentsVO {
	private String com_id;
	private String com_bul;
	private String com_mem;
	private String com_text;
	private int com_chk;
	private Date com_date;
	
	public CommentsVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommentsVO(String com_id, String com_bul, String com_mem,
			String com_text, int com_chk, Date com_date) {
		super();
		this.com_id = com_id;
		this.com_bul = com_bul;
		this.com_mem = com_mem;
		this.com_text = com_text;
		this.com_chk = com_chk;
		this.com_date = com_date;
	}

	public String getCom_id() {
		return com_id;
	}

	public void setCom_id(String com_id) {
		this.com_id = com_id;
	}

	public String getCom_bul() {
		return com_bul;
	}

	public void setCom_bul(String com_bul) {
		this.com_bul = com_bul;
	}

	public String getCom_mem() {
		return com_mem;
	}

	public void setCom_mem(String com_mem) {
		this.com_mem = com_mem;
	}

	public String getCom_text() {
		return com_text;
	}

	public void setCom_text(String com_text) {
		this.com_text = com_text;
	}

	public int getCom_chk() {
		return com_chk;
	}

	public void setCom_chk(int com_chk) {
		this.com_chk = com_chk;
	}

	public Date getCom_date() {
		return com_date;
	}

	public void setCom_date(Date com_date) {
		this.com_date = com_date;
	}

	@Override
	public String toString() {
		return "CommentsVO [com_id=" + com_id + ", com_brd=" + com_bul
				+ ", com_mem=" + com_mem + ", com_text=" + com_text
				+ ", com_chk=" + com_chk + ", com_date=" + com_date + "]";
	}
}
