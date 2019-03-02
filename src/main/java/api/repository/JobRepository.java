package api.repository;

import api.domain.Job;
import api.domain.JobStatus;
import api.domain.JobType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends MongoRepository<Job, String> {

    List<Job> findAllByTypeIs(JobType type);
    List<Job> findAllByStatusIs(JobStatus status);
}
