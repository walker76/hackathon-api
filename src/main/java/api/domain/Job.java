package api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Job {
    String title;
    JobType type;
    String description;
    Date time;
    long lat;
    long lang;
}
