package api.component;

import api.domain.Issue;
import api.domain.Series;
import api.repository.SeriesRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DBSeeder implements CommandLineRunner {

    private SeriesRepository seriesRepository;

    public DBSeeder(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        this.seriesRepository.deleteAll();

        int count = 0;
        File dir = new File("data");

        File[] files = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String filename)
            { return filename.endsWith(".json"); }
        } );

        ObjectMapper mapper = new ObjectMapper();

        for(File f : files){
            System.out.println(f.toString());
            Series series = null;
            try {
                series = mapper.readValue(f, Series.class);
            } catch (IOException e){
                System.err.println("Error loading JSON file");
            }

            if(series != null){
                System.out.println("Successfully loaded " + series.getTitle());
                this.seriesRepository.save(series);
                System.out.println("Successfully saved " + series.getTitle());
                count++;

            }
        }

        System.out.println("Processed " + count + " JSON files");

    }
}
