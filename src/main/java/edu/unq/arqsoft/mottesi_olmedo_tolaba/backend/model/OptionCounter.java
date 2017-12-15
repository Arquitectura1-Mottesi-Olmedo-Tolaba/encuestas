package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "options_counter")
public class OptionCounter extends PersistenceEntity {

	private static final long serialVersionUID = 4878450736683941552L;
	private String description;
	private Integer capacity;
	private Integer amount;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public OptionCounter() {
	}

	public OptionCounter(String description, Integer capacity, Integer amount) {
		this.description = description;
		this.setCapacity(capacity);
		this.setAmount(amount);
	}

	public OptionCounter(String description, Integer amount) {
		this.description = description;
		this.setAmount(amount);
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public void decrease() {
		this.amount -= 1;
	}

	public void increase() {
		this.amount += 1;
	}

}
