package com.soulchild.work.api.retrofitService;

import com.soulchild.work.common.RetrofitURIConstants;
import com.soulchild.work.model.BookMeta;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface SearchRetrofitService {

    @GET(RetrofitURIConstants.URL_SEARCH_KAKAO)
    Call<BookMeta> getSearchBook(@Header("Authorization") String token , @Query("query") String query, @Query("target") String type , @Query("page") int page , @Query("size") int size);
}
