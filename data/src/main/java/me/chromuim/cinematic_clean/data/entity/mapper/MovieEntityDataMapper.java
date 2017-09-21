package me.chromuim.cinematic_clean.data.entity.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import me.chromuim.cinematic_clean.data.entity.MovieEntity;
import me.chromuim.cinematic_clean.domain.model.Movie;

@Singleton
public class MovieEntityDataMapper {

  @Inject
  MovieEntityDataMapper() {
  }


  public Movie transform(MovieEntity movieEntity) {
    Movie movie = null;
    if (movieEntity != null) {
      movie = new Movie(movieEntity.getId(),
          movieEntity.getPosterPath(), movieEntity.getBackdropPath(), movieEntity.getTitle(), movieEntity.getOverview(), movieEntity.getAverage(), movieEntity.getReleaseDate());
    }
    return movie;
  }

  public List<Movie> transform(Collection<MovieEntity> movieEntityCollection) {
    final List<Movie> movieList = new ArrayList<>();
    for (MovieEntity movieEntity : movieEntityCollection) {
      final Movie movie = transform(movieEntity);
      if (movie != null) {
        movieList.add(movie);
      }
    }
    return movieList;
  }
}
