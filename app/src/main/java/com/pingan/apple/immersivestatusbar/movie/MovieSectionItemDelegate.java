package com.pingan.apple.immersivestatusbar.movie;

import com.pingan.apple.immersivestatusbar.R;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * @author apple
 * @Description :
 * @date 17/1/24  上午11:28
 */

public class MovieSectionItemDelegate implements ItemViewDelegate<DisplaybleItem> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.movie_banner;
    }

    @Override
    public boolean isForViewType(DisplaybleItem item, int position) {
//        return item instanceof ; 轮播图请求返回数据集合
        return false;
    }

    @Override
    public void convert(ViewHolder holder, DisplaybleItem item, int position) {

    }
}
