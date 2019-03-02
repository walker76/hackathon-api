package api.component;

import api.domain.Job;
import api.domain.JobType;
import api.repository.JobRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class DBSeeder implements CommandLineRunner {

    private JobRepository jobRepository;

    public DBSeeder(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Implement adding default users

        jobRepository.insert(new Job(
                "Job 1",
                JobType.FOOD,
                "Test Food Job",
                new Date(),
                0,
                0
        ));

        jobRepository.insert(new Job(
                "Job 2",
                JobType.FOOD,
                "Test Food Job",
                new Date(),
                0,
                0
        ));

        jobRepository.insert(new Job(
                "Job 3",
                JobType.RECREATION,
                "Test Recreation Job",
                new Date(),
                0,
                0
        ));
    }
}
