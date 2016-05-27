package com.icogroup.baseprojectdatabinding.util;

import android.content.res.AssetManager;
import android.databinding.BindingAdapter;
import android.graphics.Typeface;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Hashtable;

/**
 * Created by Ulises.harris on 5/27/16.
 */
public class BindingUtils {

    private static final Hashtable<String, Typeface> sCache = new Hashtable<>();

    @BindingAdapter(value = {"android:src"}, requireAll = false)
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext())
                .load(url)
                .into(view);
    }

    @BindingAdapter({"font"})
    public static void setFont(TextView textView, String fontName) {
        AssetManager assetManager = textView.getContext().getAssets();
        String path = "fonts/" + fontName;
        Typeface typeface = sCache.get(path);
        if (typeface == null) {
            typeface = Typeface.createFromAsset(assetManager, path);
            sCache.put(path, typeface);
        }
        textView.setTypeface(typeface);
    }


}
