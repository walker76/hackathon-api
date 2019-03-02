package api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@AllArgsConstructor
public class Job {

    @Id
    String id;

    String title;
    JobType type;
    String description;
    Date time;
    long lat;
    long lang;
    JobStatus status;
}