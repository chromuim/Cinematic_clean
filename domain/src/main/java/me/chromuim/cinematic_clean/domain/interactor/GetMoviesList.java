package me.chromuim.cinematic_clean.domain.interactor;

import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import me.chromuim.cinematic_clean.domain.Movie;
import me.chromuim.cinematic_clean.domain.executor.OnBackgroundExecutor;
import me.chromuim.cinematic_clean.domain.executor.OnMainThreadExecutor;
import me.chromuim.cinematic_clean.domain.repository.MovieRepository;

public class GetMoviesList extends UseCase<List<Movie>, Void> {

  private final MovieRepository mRepository;

  @Inject
  GetMoviesList(OnBackgroundExecutor onBackgroundExecutor, OnMainThreadExecutor onMainThreadExecutor, MovieRepository repository) {
    super(onBackgroundExecutor, onMainThreadExecutor);
    mRepository = repository;
  }

  @Override
  Observable<List<Movie>> buildUseCase(Void aVoid) {
    return mRepository.movies();
  }
}
