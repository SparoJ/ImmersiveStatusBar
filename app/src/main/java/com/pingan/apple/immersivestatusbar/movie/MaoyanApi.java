package com.pingan.apple.immersivestatusbar.movie;


import com.pingan.apple.immersivestatusbar.movie.bean.MovieTodayEntity;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

import static android.R.attr.type;

/**
 * @author apple
 * @Description :
 * @date 17/1/23  下午3:55
 */

public interface MaoyanApi {

    @GET("list.json")
    Observable<MovieTodayEntity> getTodayHomeMovie(@Query("type") String type, @Query("offset") int offset, @Query("limit") int limit);
}
