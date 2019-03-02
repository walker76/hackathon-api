package api.controller;

import api.domain.Series;
import api.domain.SeriesReference;
import api.repository.SeriesRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/series")
public class SeriesController {

    private SeriesRepository seriesRepository;

    public SeriesController(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    @GetMapping("/all")
    public List<Series> getAll(){
        return this.seriesRepository.findAll();
    }

    @GetMapping("/findById/{seriesId}")
    public Series getById(@PathVariable("seriesId") String seriesId){
        Optional<Series> seriesOptional = this.seriesRepository.findById(seriesId);

        return seriesOptional.isPresent() ? seriesOptional.get() : null;

    }

    @GetMapping("/findByComic/{comicId}")
    public Series findByComicId(@PathVariable("comicId") int comicId){
        return this.seriesRepository.findSeriesByComicId(comicId);
    }

    @PutMapping("/insert")
    public void insert(@RequestBody Series series){
        this.seriesRepository.insert(series);
    }

    @PostMapping("/update")
    public void update(@RequestBody Series series){
        this.seriesRepository.save(series);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String id){
        this.seriesRepository.deleteById(id);
    }

    @GetMapping("/reference")
    public List<SeriesReference> getReference(){

        ObjectMapper mapper = new ObjectMapper();
        File ref = new File("data/ref.json");
        List<SeriesReference> references = new ArrayList<>();

        try {
            references = mapper.readValue(ref, new TypeReference<ArrayList<SeriesReference>>() {});
        } catch (IOException e){
            System.err.println("Error loading JSON file");
        }

        return references;

    }

}
