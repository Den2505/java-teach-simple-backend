package net.thumbtack.school.ttschool;

import java.util.LinkedList;
import java.util.Queue;

public class TraineeQueue {
    private Queue<Trainee> trainees = new LinkedList<>();

    public TraineeQueue() {
    }

    public void addTrainee(Trainee trainee) {
        trainees.add(trainee);
    }

    public Trainee removeTrainee() throws TrainingException {
        if (trainees.isEmpty()) {
            throw new TrainingException(TrainingErrorCode.EMPTY_TRAINEE_QUEUE);
        }
        return trainees.remove();
    }
}
