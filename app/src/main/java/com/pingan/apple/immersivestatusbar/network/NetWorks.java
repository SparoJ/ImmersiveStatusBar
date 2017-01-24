package com.pingan.apple.immersivestatusbar.network;

import com.pingan.apple.immersivestatusbar.BuildConfig;
import com.pingan.apple.immersivestatusbar.movie.MaoyanApi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author apple
 * @Description :
 * @date 17/1/23  下午3:06
 */

public class NetWorks {

    public static final String base_movie_api = "/movie/";
    private static final int DEFAULT_TIMEOUT = 5;
    private MaoyanApi mMovideApi;


    private NetWorks() {}

    public static volatile NetWorks mNetWorks;

    /**complete DCL of single instance create**/
    public static NetWorks getInstance() {

        if(mNetWorks == null) {
            synchronized (NetWorks.class) {
                if(mNetWorks == null) {
                    mNetWorks = new NetWorks();
                }
            }
        }
        return mNetWorks;
    }

//    /********inner class create single instance *******/
//    public static class InnerWorkInstance {
//        public static final NetWorks mInstance = new NetWorks();
//    }
//
//    public static NetWorks getInsntance() {
//        return InnerWorkInstance.mInstance;
//    }
//    /***************/
//



    public MaoyanApi getMovieApi() {
        return mMovideApi == null ? configMovieRetrofit(MaoyanApi.class) : mMovideApi;
    }

    private<T> T configMovieRetrofit(Class<T> clzz) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.API_MOVIE_BASE_URL)
                .client(configMovieClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build().create(clzz);

    }

    private OkHttpClient configMovieClient() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        return okHttpClient.build();
    }
}
