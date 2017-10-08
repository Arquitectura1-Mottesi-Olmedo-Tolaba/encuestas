package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course extends PersistenceEntity {

	@OneToOne(cascade = CascadeType.ALL)
    private Professor professor;
    
	@OneToOne(cascade = CascadeType.ALL)
    private Subject subject;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Timeline> timelines;

    public Course() {
    }

    public Course(Professor professor, Subject subject, List<Timeline> timelines) {
        this.professor = professor;
        this.subject = subject;
        this.timelines = timelines;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<Timeline> getTimelines() {
        return timelines;
    }

    public void setTimelines(List<Timeline> timelines) {
        this.timelines = timelines;
    }

}
