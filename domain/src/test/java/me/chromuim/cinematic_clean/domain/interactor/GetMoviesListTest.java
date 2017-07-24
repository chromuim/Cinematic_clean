package me.chromuim.cinematic_clean.domain.interactor;

import me.chromuim.cinematic_clean.domain.executor.OnBackgroundExecutor;
import me.chromuim.cinematic_clean.domain.executor.OnMainThreadExecutor;
import me.chromuim.cinematic_clean.domain.repository.MovieRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class GetMoviesListTest {

  @Mock
  MovieRepository mRepository;

  @Mock
  OnMainThreadExecutor mOnMainThreadExecutor;

  @Mock
  OnBackgroundExecutor mOnBackgroundExecutor;


  private GetMoviesList mGetMoviesList;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    mGetMoviesList = new GetMoviesList(mOnBackgroundExecutor, mOnMainThreadExecutor, mRepository);
  }

  @Test
  public void testRepositoriesCallGetMovies() {
    mGetMoviesList.buildUseCase(null);
    Mockito.verify(mRepository).movies();
    Mockito.verifyNoMoreInteractions(mRepository);
  }

}