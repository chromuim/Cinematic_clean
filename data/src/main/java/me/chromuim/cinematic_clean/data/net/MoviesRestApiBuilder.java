package me.chromuim.cinematic_clean.data.net;

import me.chromuim.cinematic_clean.data.BuildConfig;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesRestApiBuilder {

  // TODO: 03.08.17 move the hard coded strings to util/constant class
  private static Retrofit.Builder sBuilder = new Builder()
      .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
      .addConverterFactory(GsonConverterFactory.create())
      .baseUrl("http://api.themoviedb.org/3/");

  private static OkHttpClient.Builder sHttpBuilder = new OkHttpClient.Builder();

  public static <T> T createService(Class<T> restApiServiceClass) {
    sHttpBuilder.addInterceptor(chain -> {
      Request request = chain.request();
      HttpUrl url = request.url().newBuilder().addQueryParameter("api_key", BuildConfig.API_KEY).build();

      Request newRequest = request.newBuilder().url(url).build();
      return chain.proceed(newRequest);
    });

    Retrofit retrofit = sBuilder.client(sHttpBuilder.build()).build();
    return retrofit.create(restApiServiceClass);
  }

}
