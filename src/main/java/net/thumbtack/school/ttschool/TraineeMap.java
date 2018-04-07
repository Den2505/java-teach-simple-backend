package net.thumbtack.school.ttschool;

import java.util.*;

public class TraineeMap {
    private Map<Trainee, String> traineeInfo = new HashMap<>();

    public TraineeMap() {
    }

    public void addTraineeInfo(Trainee trainee, String institute) throws TrainingException {
        if (traineeInfo.containsKey(trainee)) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_TRAINEE);
        }
        traineeInfo.put(trainee, institute);
    }

    public void replaceTraineeInfo(Trainee trainee, String institute) throws TrainingException {
        if (!traineeInfo.containsKey(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        traineeInfo.replace(trainee, institute);
    }

    public void removeTraineeInfo(Trainee trainee) throws TrainingException {
        if (traineeInfo.remove(trainee) == null) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }

    }

    public int getTraineesCount() {
        return traineeInfo.size();
    }

    public String getInstituteByTrainee(Trainee trainee) throws TrainingException {
        String traineeInstitute = traineeInfo.get(trainee);
        if (traineeInstitute == null) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        } else
            return traineeInstitute;
    }

    public Set<Trainee> getAllTrainees() {
        return traineeInfo.keySet();
    }

    public Set<String> getAllInstitutes() {

        return new HashSet<String>(traineeInfo.values());
    }

    public boolean isAnyFromInstitute(String institute) {
        Set<String> set = getAllInstitutes();
        return set.contains(institute);
    }
}
