package com.example.bhasingursifath.feedbackform;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by bhasingursifath on 27-06-2017.
 */

public class ImagePagerAdapter extends PagerAdapter {
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }

/*
    private int [] imageSlideView = new int[]{

            R.drawable.bear , R.drawable.bonobo,
            R.drawable.eagle , R.drawable.horse,
            R.drawable.owl , R.drawable.wolf};


    Context mContext;

    ImagePagerAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return imageSlideView.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==((ImageView)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView mImageView=new ImageView(mContext);
        mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        mImageView.setImageResource(imageSlideView[position]);
        ((ViewPager) container).addView(mImageView, 0);
        return mImageView;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((ImageView) object);
    }

    */
}
