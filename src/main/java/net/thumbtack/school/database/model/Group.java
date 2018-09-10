package net.thumbtack.school.database.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Group {
    private int id;
    private String name;
    private String room;
    private List<Trainee> trainees;
    private List<Subject> subjects;
    private int schoolId;

    public Group() { }

    public Group(int id, String name, String room, List<Trainee> trainees, List<Subject> subjects) {
        this.setId(id);
        this.setName(name);
        this.setRoom(room);
        this.setTrainees(trainees);
        this.setSubjects(subjects);
    }

    public Group(int id, String name, String room) {
        this.setId(id);
        this.setName(name);
        this.setRoom(room);
        this.setTrainees(Collections.emptyList());
        this.setSubjects(Collections.emptyList());
    }

    public Group(String name, String room) {
        this.setId(0);
        this.setName(name);
        this.setRoom(room);
        this.setTrainees(Collections.emptyList());
        this.setSubjects(Collections.emptyList());
    }

    public void addTrainee(Trainee trainee){
        this.trainees.add(trainee);
    }

    public void removeTrainee(Trainee trainee){
        this.trainees.remove(trainee);
    }

    public void addSubject(Subject subject){
        this.subjects.add(subject);
    }

    public void removeSubject(Subject subject){
        this.subjects.remove(subject);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public List<Trainee> getTrainees() {
        return trainees;
    }

    public void setTrainees(List<Trainee> trainees) {
        this.trainees = trainees;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return id == group.id &&
                Objects.equals(name, group.name) &&
                Objects.equals(room, group.room) &&
                Objects.equals(trainees, group.trainees) &&
                Objects.equals(subjects, group.subjects);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, room, trainees, subjects);
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", room='" + room + '\'' +
                ", trainees=" + trainees +
                ", subjects=" + subjects +
                ", schoolId=" + schoolId +
                '}';
    }
}
