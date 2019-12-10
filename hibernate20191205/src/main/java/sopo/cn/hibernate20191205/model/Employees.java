package sopo.cn.hibernate20191205.model;

public class Employees {
	private int id;
	private String name;
	private String pwd;

	public Employees() {
		super();
	}

	public Employees(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employees [id=" + id + ", name=" + name + ", pwd=" + pwd + "]";
	}
}
