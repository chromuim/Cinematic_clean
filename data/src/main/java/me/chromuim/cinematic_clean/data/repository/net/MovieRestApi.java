package me.chromuim.cinematic_clean.data.repository.net;

import io.reactivex.Observable;
import me.chromuim.cinematic_clean.data.repository.entity.MovieEntity;
import me.chromuim.cinematic_clean.data.repository.entity.ResponseList;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieRestApi {

  @GET("discover/movie?")
  Observable<ResponseList<MovieEntity>> loadMovies(@Query("sort_by") String sort);
}
