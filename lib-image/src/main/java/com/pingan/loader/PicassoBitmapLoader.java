package com.pingan.loader;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;


/**
 * @author apple   同样的方式 参考 glide的写法 glide 的load（params） 中的params可为object 不用重载重复代码
 * @Description :
 * @date 17/1/24  上午11:05
 */

public class PicassoBitmapLoader implements ImageLoaderInterface<ImageView> {

    public static class LoaderInstance {
        public static final PicassoBitmapLoader mInstance = new PicassoBitmapLoader();
    }

    private PicassoBitmapLoader(){}
    public PicassoBitmapLoader getInstance() {
        return LoaderInstance.mInstance;
    }

    @Override
    public void loadNormalImg(Context context, Uri path, ImageView imageView) {
        Picasso.with(context).load(path).centerCrop()
                .transform(new RectBitmapTransformer())
                .fit()
                .into(imageView);
    }

    @Override
    public void loadNormalImg(Context context, String path, ImageView imageView) {

    }

    @Override
    public void loadNormalImg(Context context, File file, ImageView imageView) {

    }

    @Override
    public void loadNormalImg(Context context, int res, ImageView imageView) {

    }

    @Override
    public void loadCircleImg(Context context, Uri path, ImageView imageView) {
        Picasso.with(context).load(path).centerCrop()
                .transform(new RoundBitmapTransformer())
                .fit()
                .into(imageView);
    }

}
