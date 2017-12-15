package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto;

public class StudentInformation {

	private Integer total;
	private Integer completed;

	public StudentInformation(Integer total, Integer completed) {
		super();
		this.total = total;
		this.completed = completed;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getCompleted() {
		return completed;
	}

	public void setCompleted(Integer completed) {
		this.completed = completed;
	}

}
