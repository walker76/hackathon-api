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
        // Implement adding default users
    }
}
