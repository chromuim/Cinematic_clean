package me.chromuim.cinematic_clean.domain;


import static org.assertj.core.api.Assertions.assertThat;

import me.chromuim.cinematic_clean.domain.model.Movie;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by chromuim on 12.07.17.
 */
public class MovieTest {

  private Movie mMovie;

  private static final int MOVIE_ID = 1234;

  @Before
  public void startUp() {
    mMovie = new Movie(MOVIE_ID);
  }

  @Test
  public void testMovieConstructor() {
    final int movieId = mMovie.getId();

    assertThat(movieId).isEqualTo(MOVIE_ID);
  }


}