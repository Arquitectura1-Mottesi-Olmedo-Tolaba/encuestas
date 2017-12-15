package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto;

public class OptionCounterDTO {

    private String name;
    private Integer capacity;
    private Integer amount;

    public OptionCounterDTO(String name, Integer capacity, Integer amount) {
        this.name = name;
        this.capacity = capacity;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
