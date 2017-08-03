package me.chromuim.cinematic_clean.data.repository.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ResponseList<T> {

  @SerializedName("page")
  private int mPage;

  @SerializedName("results")
  private List<T> mResults;

  @SerializedName("total_pages")
  private int mTotalPages;

  @SerializedName("total_results")
  private int mTotalResults;


  public ResponseList(int page, List<T> results, int totalPages, int totalResults) {
    mPage = page;
    mResults = results;
    mTotalPages = totalPages;
    mTotalResults = totalResults;
  }

  public List<T> getResults() {
    return mResults;
  }
}
