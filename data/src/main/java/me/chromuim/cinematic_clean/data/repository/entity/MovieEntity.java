package me.chromuim.cinematic_clean.data.repository.entity;

import com.google.gson.annotations.SerializedName;

public class MovieEntity {

  @SerializedName("id")
  private final int mId;

  @SerializedName("poster_path")
  private final String mPosterPath;

  @SerializedName("backdrop_path")
  private final String mBackdropPath;

  @SerializedName("title")
  private final String mTitle;

  @SerializedName("overview")
  private final String mOverview;

  @SerializedName("vote_average")
  private final float mAverage;

  @SerializedName("release_date")
  private final String mReleaseDate;

  public MovieEntity(int id, String posterPath, String backdropPath, String title, String overview, float average, String releaseDate) {
    mId = id;
    mPosterPath = posterPath;
    mBackdropPath = backdropPath;
    mTitle = title;
    mOverview = overview;
    mAverage = average;
    mReleaseDate = releaseDate;
  }
}
