package net.thumbtack.school.database.model;

import java.util.Objects;

public class Trainee {
    private int id;
    private String firstName;
    private String lastName;
    private int rating;

    public Trainee (){}

    public Trainee(int id, String firstName, String lastName, int rating) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.setRating(rating);
    }

    public Trainee(String firstName, String lastName, int rating) {
        this.id = 0;
        this.firstName = firstName;
        this.lastName = lastName;
        this.setRating(rating);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainee trainee = (Trainee) o;
        return id == trainee.id &&
                getRating() == trainee.getRating() &&
                Objects.equals(firstName, trainee.firstName) &&
                Objects.equals(lastName, trainee.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName, getRating());
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", rating=" + rating +
                '}';
    }
}
