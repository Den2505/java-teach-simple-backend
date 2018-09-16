package net.thumbtack.school.database.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class School {
    private int id;
    private String name;
    private int year;
    private List<Group> groups = new ArrayList<>();

    public School() {

    }

    public School(int ig, String name, int year, List<Group> groups) {
        this.setId(ig);
        this.setName(name);
        this.setYear(year);
        this.setGroups(groups);
    }

    public School(int ig, String name, int year) {
        this.setId(ig);
        this.setName(name);
        this.setYear(year);
        this.setGroups(new ArrayList<>());
    }

    public School(String name, int year) {
        this.setId(0);
        this.setName(name);
        this.setYear(year);
        this.setGroups(new ArrayList<>());
    }

    public int getId() {
        return id;
    }

    public void setId(int ig) {
        this.id = ig;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public void addGroup(Group group){
        this.groups.add(group);
    }

    public void removeGroup(Group group){
        this.groups.remove(group);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        Collections.sort(groups);
        Collections.sort(school.groups);
        return id == school.id &&
                year == school.year &&
                Objects.equals(name, school.name) &&
                Objects.equals(groups, school.groups);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, year, groups);
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", groups=" + groups +
                '}';
    }
}


