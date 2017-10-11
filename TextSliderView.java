package com.example.bhasingursifath.feedbackform;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;

/**
 * Created by bhasingursifath on 16-07-2017.
 */

public class TextSliderView extends BaseSliderView {
    protected TextSliderView(Context context) {
        super(context);
    }

    @Override
    public View getView() {

        View v= LayoutInflater.from(getContext()).inflate(R.layout.render_type_text,null);
        ImageView target=(ImageView) v.findViewById(R.id.daimajia_slider_image);
        TextView description=(TextView) v.findViewById(R.id.description);
        description.setText(getDescription());
        bindEventAndShow(v,target);
        return v;
    }
}
