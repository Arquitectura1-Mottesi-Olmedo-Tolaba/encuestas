package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course extends PersistenceEntity {

	@OneToOne(cascade = CascadeType.ALL)
    private Professor professor;
        
    @ManyToMany() //cascade = CascadeType.MERGE, orphanRemoval = true
    private List<Timeline> timelines;

    public Course() {
    }

    public Course(Professor professor, List<Timeline> timelines) {
        this.professor = professor;
        this.timelines = timelines;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Timeline> getTimelines() {
        return timelines;
    }

    public void setTimelines(List<Timeline> timelines) {
        this.timelines = timelines;
    }

}
