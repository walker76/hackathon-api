package api.controller;

import api.domain.Series;
import api.repository.SeriesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comic")
public class ComicController {

    private SeriesRepository seriesRepository;

    public ComicController(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    @GetMapping("/findById/{comicId}")
    public List<Series> getAll(@PathVariable("comicId") int comicId){
        return null;
    }


}
