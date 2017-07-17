package me.chromuim.cinematic_clean.domain;

import java.util.Objects;

public class Movie {

  private int mId;

  private String mPosterPath;
  private String mBackdropPath;
  private String mTitle;
  private String mOverview;
  private float mAverage;
  private String mReleaseDate;

  public Movie(int id, String posterPath, String backdropPath, String title, String overview, float average, String releaseDate) {
    mId = id;
    mPosterPath = posterPath;
    mBackdropPath = backdropPath;
    mTitle = title;
    mOverview = overview;
    mAverage = average;
    mReleaseDate = releaseDate;
  }

  public Movie(int id) {
    this(id, "", "", "", "", 0.0f, "");
  }

  public Movie() {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Movie movie = (Movie) o;
    return Objects.equals(mId, movie.mId);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(mId);
  }

  @Override
  public String toString() {
    return String.format("Movie : [ ID :%1s ]", mId);
  }
}
