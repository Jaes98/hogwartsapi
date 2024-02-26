package kea.exercise.hogwartsapi.dtos;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import kea.exercise.hogwartsapi.models.Student;
import kea.exercise.hogwartsapi.models.Teacher;

import java.util.List;

public class CourseDTO {
    private int id;
    private String subject;
    private int schoolYear;
    private boolean current;
    private Teacher teacher;
    private List<Student> students;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(int schoolYear) {
        this.schoolYear = schoolYear;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
