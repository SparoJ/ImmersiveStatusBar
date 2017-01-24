package com.pingan.apple.immersivestatusbar.movie;

import android.content.Context;

import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.util.List;

/**
 * @author apple
 * @Description :
 * @date 17/1/24  上午11:25
 */

public class RefactorMovieAdapter extends MultiItemTypeAdapter<DisplaybleItem> {

    public RefactorMovieAdapter(Context context, List<DisplaybleItem> datas) {
        super(context, datas);


    }
}
