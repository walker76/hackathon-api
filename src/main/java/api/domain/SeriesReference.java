package api.domain;

import lombok.Data;

@Data
public class SeriesReference {
    private String title;
    private int id;

    private SeriesReference(){
        // Private for deserialization
    }
}