package sopo.cn.hibernate20191205.model;

public class Mydepartments {
	@Override
	public String toString() {
		return "Mydepartments [id=" + id + ", dpName=" + dpName + "]";
	}

	public Mydepartments() {
		super();
	}

	public Mydepartments(Integer id, String dpName) {
		super();
		this.id = id;
		this.dpName = dpName;
	}

	private Integer id;
	private String dpName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDpName() {
		return dpName;
	}

	public void setDpName(String dpName) {
		this.dpName = dpName;
	}

}
