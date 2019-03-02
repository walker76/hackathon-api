package api.repository;

import api.domain.Series;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesRepository extends MongoRepository<Series, String> {

    @Query("{ \"issues\": { \"$elemMatch\": { \"_id\": ?0} } }")
    Series findSeriesByComicId(int comicId);
}
