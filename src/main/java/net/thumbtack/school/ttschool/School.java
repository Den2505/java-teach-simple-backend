package net.thumbtack.school.ttschool;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class School {
    private String name;
    private int year;
    private Set<Group> groups = new TreeSet<>((o1, o2) -> o1.getName().compareTo(o2.getName()));

    public School(String name, int year) throws TrainingException {
        setName(name);
        setYear(year);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws TrainingException {
        if (name == "" || name == null) {
            throw new TrainingException(TrainingErrorCode.SCHOOL_WRONG_NAME);
        }
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void addGroup(Group group) throws TrainingException {
        if (groups.contains(group)) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_GROUP_NAME);
        }
        groups.add(group);
    }

    public void removeGroup(Group group) throws TrainingException {
        removeGroup(group.getName());
    }

    public void removeGroup(String name) throws TrainingException {
        boolean exception = true;
        for (Group elem : groups) {
            if (elem.getName().equals(name)) {
                groups.remove(elem);
                exception=false;
                break;
            }
        }
        if (exception) {
            throw new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND);
        }
    }

    public boolean containsGroup(Group group) {

        return groups.contains(group);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return year == school.year &&
                Objects.equals(name, school.name) &&
                Objects.equals(groups, school.groups);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, year, groups);
    }
}
