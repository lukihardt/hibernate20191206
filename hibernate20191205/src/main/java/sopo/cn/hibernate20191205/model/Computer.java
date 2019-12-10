package sopo.cn.hibernate20191205.model;

import java.util.Set;

public class Computer {
	private String id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String cpu;
	private String gpu;
	private Set<SoftWare> set;

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getGpu() {
		return gpu;
	}

	public void setGpu(String gpu) {
		this.gpu = gpu;
	}

	public Set<SoftWare> getSet() {
		return set;
	}

	public void setSet(Set<SoftWare> set) {
		this.set = set;
	}

	@Override
	public String toString() {
		return "Computer [cpu=" + cpu + ", gpu=" + gpu + ", set=" + set + "]";
	}

}
