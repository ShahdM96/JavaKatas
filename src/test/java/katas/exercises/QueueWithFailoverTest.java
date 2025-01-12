package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QueueWithFailoverTest {
    @Test
    public void testQueueWithFailover() {


        QueueWithFailover jobQueue = new QueueWithFailover(3);

        jobQueue.sendJob("Job 1");
        jobQueue.sendJob("Job 2");
        jobQueue.sendJob("Job 3");

        assertEquals(3, jobQueue.size());

        String currentJob = jobQueue.getJob();
        jobQueue.jobDone(currentJob);

        currentJob = jobQueue.getJob();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        jobQueue.returnExpiredJobsToQueue();
        String finalCurrentJob = currentJob;
        assertThrows(IllegalArgumentException.class, () -> jobQueue.jobDone(finalCurrentJob));

    }
}
