package me.chromuim.cinematic_clean.data.entity.mapper;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import me.chromuim.cinematic_clean.data.entity.MovieEntity;
import me.chromuim.cinematic_clean.domain.model.Movie;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

public class MovieEntityDataMapperTest {

  private static final int DUMMY_MOVIE_ID = 123;
  private static final String DUMMY_MOVIE_POSTER_PATH = "/hohoh";

  //  @Mock
  MovieEntityDataMapper mMovieEntityDataMapper;

  MovieEntity mMovieEntity;

  @Before
  public void startUp() {
    MockitoAnnotations.initMocks(this);
    mMovieEntity = createDummyMovie();
    mMovieEntityDataMapper = new MovieEntityDataMapper();
  }


  @Test
  public void testTransformSimpleEntity() {
    Movie movie = mMovieEntityDataMapper.transform(mMovieEntity);
    assertThat(movie, is(instanceOf(Movie.class)));
    assertThat(movie.getId(), equalTo(DUMMY_MOVIE_ID));
    assertThat(movie.getPosterPath(), equalTo(DUMMY_MOVIE_POSTER_PATH));
  }

  @Test
  public void testTransformCollectionEntity() {
    MovieEntity movieEntityOne = mock(MovieEntity.class);
    MovieEntity movieEntityTwo = mock(MovieEntity.class);

    List<MovieEntity> movieEntityList = new ArrayList<>();
    movieEntityList.add(movieEntityOne);
    movieEntityList.add(movieEntityTwo);

    Collection<Movie> movieCollection = mMovieEntityDataMapper.transform(movieEntityList);
    assertThat(movieCollection.size(), is(2));
    assertThat(movieCollection.toArray()[0], is(instanceOf(Movie.class)));
  }


  private MovieEntity createDummyMovie() {
    return new MovieEntity(DUMMY_MOVIE_ID, DUMMY_MOVIE_POSTER_PATH);
  }


}