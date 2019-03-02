package api.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class User {
    String id;
    List<String> jobsPosted;
    List<String> jobsWorking;
}
