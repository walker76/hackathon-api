package api.domain.job;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.Random;

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

    String posterId;
    String workerId;

    public Job(String id, String title, JobType type, String description, Date time, long lat, long lang, JobStatus status, String posterId) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.description = description;
        this.time = time;
        this.lat = lat;
        this.lang = lang;
        this.status = status;
        this.posterId = posterId;
    }

    public Job(String title, JobType type, String description, Date time, long lat, long lang, JobStatus status, String posterId) {
        this.id = generateUniqueId();
        this.title = title;
        this.type = type;
        this.description = description;
        this.time = time;
        this.lat = lat;
        this.lang = lang;
        this.status = status;
        this.posterId = posterId;
    }

    private String generateUniqueId() {
        int val = -1;

        do {
            val = new Random().nextInt(200000);
        } while (val < 0);

        return new Integer(val).toString();
    }
}