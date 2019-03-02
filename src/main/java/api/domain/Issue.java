package api.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Issue {

    @Id
    private int id;
    private String title;
    private double issueNumber;
    private String resourceURI;
    private String date;
    private float price;
    private String thumbnail;

    private Issue(){
        // Private for deserialization
    }
}
