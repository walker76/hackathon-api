package api.repository;

import api.domain.Job;
import api.domain.JobType;
import api.domain.Series;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends MongoRepository<Job, String> {

    List<Job> findAllByTypeIs(JobType type);
}
