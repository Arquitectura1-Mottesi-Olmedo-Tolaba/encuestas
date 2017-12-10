package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.dto;

import java.io.Serializable;
import java.util.List;

public class OfferDTO implements Serializable{

	private static final long serialVersionUID = 6477268411333321005L;
	private Long id;
    private List<CourseDTO> courses;
    private OptionDTO selectedOption;
    private List<OptionDTO> options;

    public OfferDTO(){}
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<CourseDTO> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseDTO> courses) {
		this.courses = courses;
	}

	public OptionDTO getSelectedOption() {
		return selectedOption;
	}

	public void setSelectedOption(OptionDTO selectedOption) {
		this.selectedOption = selectedOption;
	}

	public List<OptionDTO> getOptions() {
		return options;
	}

	public void setOptions(List<OptionDTO> options) {
		this.options = options;
	}

}
