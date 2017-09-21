package me.chromuim.cinematic_clean.data.repository;

import io.reactivex.Observable;
import java.util.List;
import me.chromuim.cinematic_clean.domain.model.Movie;
import me.chromuim.cinematic_clean.domain.repository.MovieRepository;

public class MovieDataRepo implements MovieRepository {

  @Override
  public Observable<List<Movie>> movies() {
    return null;
  }

  @Override
  public Observable<Movie> movie(int movieId) {
    return null;
  }
}
