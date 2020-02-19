package com.soulchild.work.common;

import com.soulchild.work.api.retrofitService.SearchNaverRetrofitService;
import com.soulchild.work.api.retrofitService.SearchRetrofitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {

    @Autowired
    private Environment env;

    @Bean("searchRetrofit")
    public SearchRetrofitService kakaoRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(env.getProperty("book.search.kakao.url"))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(SearchRetrofitService.class);
    }

    @Bean("searchNaverRetrofit")
    public SearchNaverRetrofitService naverRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(env.getProperty("book.search.naver.url"))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(SearchNaverRetrofitService.class);
    }
}
