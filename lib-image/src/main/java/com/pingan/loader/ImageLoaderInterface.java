package com.pingan.loader;

import android.content.Context;
import android.net.Uri;
import android.view.View;

import java.io.File;
import java.io.Serializable;

/**
 * @author apple
 * @Description :
 * @date 17/1/24  上午10:39
 */

public interface ImageLoaderInterface<T extends View> extends Serializable {

    void loadNormalImg(Context context, Uri path, T imageView);
    void loadNormalImg(Context context, String path, T imageView);
    void loadNormalImg(Context context, File file, T imageView);
    void loadNormalImg(Context context, int res, T imageView);


    void loadCircleImg(Context context, Uri path, T imageView);
}
