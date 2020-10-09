/************************************************************
 * Copyright 2000-2020 OPPO Mobile Comm Corp., Ltd.
 * All rights reserved.
 * <p>
 * FileName       : GlideLoadImage.java
 * Version Number : 1.0
 * Description    :
 * Author         : Dongsheng.Ye
 * Date           : 2020/9/28
 * History        :( ID,     Date,         Author, Description)
 * v1.0, 2020/9/28, Dongsheng.Ye, create
 ************************************************************/
package com.crystallake.wanandroid.fragment;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yds.library.IMultiImageLoader;

public class GlideLoadImage implements IMultiImageLoader {

    @Override
    public void load(Context context, Object url, ImageView imageView) {
        Glide.with(context).load(url).into(imageView);
    }
}
    