package me.chromuim.cinematic_clean.domain.repository;

import io.reactivex.Observable;
import java.util.List;
import me.chromuim.cinematic_clean.domain.Movie;

public interface MovieRepository {

  Observable<List<Movie>> movies();

  Observable<Movie> movie(final int movieId);
}
