package com.soulchild.work.api.retrofitService;

import com.soulchild.work.common.RetrofitURIConstants;
import com.soulchild.work.model.NaverBookMeta;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface SearchNaverRetrofitService {
    @GET(RetrofitURIConstants.URL_SEARCH_NAVER)
    Call<NaverBookMeta> getNaverSearchBook(@Header("X-Naver-Client-Id") String clientId , @Header("X-Naver-Client-Secret") String secret , @Query("query") String query, @Query("page") int page , @Query("size") int size);
}
