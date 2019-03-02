package api.controller;

import api.domain.job.Job;
import api.domain.job.JobStatus;
import api.domain.job.JobType;
import api.domain.job.JobUpdateRequest;
import api.repository.JobRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/job")
public class JobController {

    private JobRepository jobRepository;

    public JobController(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @GetMapping("/all")
    public List<Job> getAll(){
        return this.jobRepository.findAll();
    }

    @GetMapping("/findById/{id}")
    public Job findById(@PathVariable("id") String id){
        Optional<Job> jobOptional = this.jobRepository.findById(id);
        return jobOptional.isPresent() ? jobOptional.get() : null;
    }

    @GetMapping("/findByJobType/{jobType}")
    public List<Job> getByJobType(@PathVariable("jobType") JobType jobType){
        return this.jobRepository.findAllByTypeIs(jobType);
    }

    @GetMapping("/findByJobStatus/{jobStatus}")
    public List<Job> getByJobType(@PathVariable("jobStatus") JobStatus jobStatus){
        return this.jobRepository.findAllByStatusIs(jobStatus);
    }

    @PutMapping("/updateJobStatus/")
    public void getByJobType(@RequestBody JobUpdateRequest jobUpdateRequest){
        Optional<Job> optionalJob = this.jobRepository.findById(jobUpdateRequest.getId());
        if(optionalJob.isPresent()){
            Job job = optionalJob.get();
            job.setStatus(jobUpdateRequest.getStatus());
            this.jobRepository.save(job);
        }
    }

    @PutMapping("/insert")
    public void insert(@RequestBody Job job){
        this.jobRepository.insert(job);
    }

    @PostMapping("/update")
    public void update(@RequestBody Job job){
        this.jobRepository.save(job);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String id){
        this.jobRepository.deleteById(id);
    }

}
