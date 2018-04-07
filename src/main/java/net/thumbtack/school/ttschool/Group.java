package net.thumbtack.school.ttschool;


import java.util.*;

public class Group {
    private String name;
    private String room;
    private List<Trainee> trainees = new ArrayList<>();


    public Group(String name, String room) throws TrainingException {
        setName(name);
        setRoom(room);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) throws TrainingException {
        if (name == "" || name == null) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_NAME);
        }
        this.name = name;
    }

    public String getRoom() {

        return room;
    }

    public void setRoom(String room) throws TrainingException {
        if (room == "" || room == null) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_ROOM);
        }
        this.room = room;
    }

    public List<Trainee> getTrainees() {
        return trainees;
    }

    public void addTrainee(Trainee trainee) {
        trainees.add(trainee);
    }

    public void removeTrainee(Trainee trainee) throws TrainingException {
        if (!trainees.remove(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }

    }

    public void removeTrainee(int index) throws TrainingException {
        if (trainees.size() - 1 < index) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        trainees.remove(index);
    }

    public Trainee getTraineeByFirstName(String firstName) throws TrainingException {
        ListIterator<Trainee> iterator = trainees.listIterator();
        while (iterator.hasNext()) {
            Trainee trainee = iterator.next();
            if (trainee.getFirstName().equals(firstName)) {
                return trainee;
            }
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);

    }

    public Trainee getTraineeByFullName(String fullName) throws TrainingException {
        ListIterator<Trainee> iterator = trainees.listIterator();
        while (iterator.hasNext()) {
            Trainee trainee = iterator.next();
            if (trainee.getFullName().equals(fullName)) {
                return trainee;
            }
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public void sortTraineeListByFirstNameAscendant() {
        trainees.sort((o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
    }

    public void sortTraineeListByRatingDescendant() {
        trainees.sort((o1, o2) -> Integer.compare(o1.getRating(), o2.getRating()));
        reverseTraineeList();
    }

    public void reverseTraineeList() {
        Collections.reverse(trainees);
    }

    public void rotateTraineeList(int positions) {
        Collections.rotate(trainees, positions);

    }

    public List<Trainee> getTraineesWithMaxRating() throws TrainingException {
        if (trainees.isEmpty()) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }

        List<Trainee> traineesMaxRait = new ArrayList<>();
        int tempRait = 0;
        for (Trainee trainee : trainees) {
            if (tempRait < trainee.getRating()) {
                tempRait = trainee.getRating();
                traineesMaxRait.clear();
            }
            if (tempRait == trainee.getRating()) {
                traineesMaxRait.add(trainee);
            }
        }
        return traineesMaxRait;
    }

    public boolean hasDuplicates() {
        Set<Trainee> set = new HashSet<>();
        set.addAll(trainees);
        return set.size() != trainees.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(name, group.name) &&
                Objects.equals(room, group.room) &&
                Objects.equals(trainees, group.trainees);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, room, trainees);
    }
}

