package sopo.cn.hibernate20191205.model;

public class Myemployees_copy {
	private Integer id;
	private String name;
	private String occupation;
	private Mydepartments mydepartments;

	public Myemployees_copy(Integer id, String name, String occupation, Mydepartments mydepartments) {
		super();
		this.id = id;
		this.name = name;
		this.occupation = occupation;
		this.mydepartments = mydepartments;
	}

	public Mydepartments getMydepartments() {
		return mydepartments;
	}

	public void setMydepartments(Mydepartments mydepartments) {
		this.mydepartments = mydepartments;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public Myemployees_copy() {
		super();
	}
}
