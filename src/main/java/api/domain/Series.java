package api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@Document(collection = "Series")
public class Series {

    @Id
    private String id;
    @Indexed(direction = IndexDirection.ASCENDING)
    private String title;
    private String description;
    private String resourceURI;
    private int startYear;
    private int endYear;
    private String thumbnail;
    private int issueCount;
    private ArrayList<Issue> issues;

    private Series(){
        // Private for deserialization
    }
}
