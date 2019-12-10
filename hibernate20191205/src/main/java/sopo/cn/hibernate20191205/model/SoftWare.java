package sopo.cn.hibernate20191205.model;

public class SoftWare {
	private String id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String os;
	private String Browser;
	private Computer computer;

	public Computer getComputer() {
		return computer;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getBrowser() {
		return Browser;
	}

	public void setBrowser(String browser) {
		Browser = browser;
	}

	@Override
	public String toString() {
		return "SoftWare [os=" + os + ", Browser=" + Browser + "]";
	}

}
