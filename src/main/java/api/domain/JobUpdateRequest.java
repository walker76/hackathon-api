package api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JobUpdateRequest {
    String id;
    JobStatus status;
}
