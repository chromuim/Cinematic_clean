package me.chromuim.cinematic_clean.data.entity;

import com.google.gson.annotations.SerializedName;

public class MovieEntity {

  @SerializedName("id")
  private int mId;
  @SerializedName("poster_path")
  private String mPosterPath;
  @SerializedName("backdrop_path")
  private String mBackdropPath;
  @SerializedName("title")
  private String mTitle;
  @SerializedName("overview")
  private String mOverview;
  @SerializedName("vote_average")
  private float mAverage;
  @SerializedName("release_date")
  private String mReleaseDate;

  public MovieEntity() {
  }

  // used only in Test
  public MovieEntity(int id, String posterPath) {
    this.mId = id;
    this.mPosterPath = posterPath;
  }

  public MovieEntity(int id, String posterPath, String backdropPath, String title, String overview, float average, String releaseDate) {
    mId = id;
    mPosterPath = posterPath;
    mBackdropPath = backdropPath;
    mTitle = title;
    mOverview = overview;
    mAverage = average;
    mReleaseDate = releaseDate;
  }

  public int getId() {
    return mId;
  }

  public String getPosterPath() {
    return mPosterPath;
  }

  public String getBackdropPath() {
    return mBackdropPath;
  }

  public String getTitle() {
    return mTitle;
  }

  public String getOverview() {
    return mOverview;
  }

  public float getAverage() {
    return mAverage;
  }

  public String getReleaseDate() {
    return mReleaseDate;
  }
}
