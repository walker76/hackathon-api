package api.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class User {
    @Id
    String email;
    List<String> jobsPosted;
    List<String> jobsWorking;

    User(String email){
        this.email = email;
        this.jobsPosted = new ArrayList<>();
        this.jobsWorking = new ArrayList<>();
    }
}
