package cn.hp.entity;
/**
 * ʵ����
 * 1.�������ṩget/set����
 * 2.�ṩ�вΡ��޲ι���
 * 3.�ṩtoString����
 * */
public class Book {
	int id;//���
	String bname;//ͼ������
	String bauthor;//ͼ������
	int bprice;//ͼ��۸�
	String btype;//ͼ������
	String bmark;//��ע
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBauthor() {
		return bauthor;
	}
	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}
	public int getBprice() {
		return bprice;
	}
	public void setBprice(int bprice) {
		this.bprice = bprice;
	}
	public String getBtype() {
		return btype;
	}
	public void setBtype(String btype) {
		this.btype = btype;
	}
	public String getBmark() {
		return bmark;
	}
	public void setBmark(String bmark) {
		this.bmark = bmark;
	}
	public Book(int id, String bname, String bauthor, int bprice, String btype,
			String bmark) {
		super();
		this.id = id;
		this.bname = bname;
		this.bauthor = bauthor;
		this.bprice = bprice;
		this.btype = btype;
		this.bmark = bmark;
	}
	
	public Book(String bname, String bauthor, int bprice, String btype,
			String bmark) {
		super();
		this.bname = bname;
		this.bauthor = bauthor;
		this.bprice = bprice;
		this.btype = btype;
		this.bmark = bmark;
	}
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String bname, String bauthor) {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String bname, String bauthor, String btype, int bprice,
			String bmark) {
		super();
		this.bname = bname;
		this.bauthor = bauthor;
		this.btype = btype;
		this.bprice = bprice;
		this.bmark = bmark;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", bname=" + bname + ", bauthor=" + bauthor
				+ ", bprice=" + bprice + ", btype=" + btype + ", bmark="
				+ bmark + "]";
	}
    
	
}
