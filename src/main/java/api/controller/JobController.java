package api.controller;

import api.domain.Job;
import api.domain.JobType;
import api.repository.JobRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/findByJobType/{jobType}")
    public List<Job> getByJobType(@PathVariable("jobType") JobType jobType){
        return this.jobRepository.findAllByTypeIs(jobType);
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
