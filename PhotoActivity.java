package com.example.bhasingursifath.feedbackform;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

/**
 * Created by bhasingursifath on 27-06-2017.
 */

public class PhotoActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{
/*
    static final int NUM_ITEMS = 6;
    ImagePagerAdapter imagePagerAdapter;
    ViewPager viewPager;
    ViewFlipper viewFlipper;
    private static final int FlipDuration=3000;
    public static final String[] IMAGE_NAME = {"eagle", "horse", "bonobo", "wolf", "owl", "bear",};*/

    SliderLayout sliderLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        Intent i=getIntent();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_crimson);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        sliderLayout=(SliderLayout) findViewById(R.id.slider);

        HashMap<String,Integer> collection=new HashMap<>();
        collection.put("Career Guidance",R.drawable.career_guidance);
        collection.put("English Communication Training",R.drawable.english_communication_training);
        collection.put("Financial Literacy",R.drawable.financial_literacy);
        collection.put("Focussed Training",R.drawable.focussed_training);
        collection.put("Industry Expert Session",R.drawable.industry_expert_session);
        collection.put("Joy of Learning",R.drawable.joy_of_learning);
        collection.put("Life Skills Training",R.drawable.life_skills_training);
        collection.put("Media Training",R.drawable.media_training);
        collection.put("Peer Group Activity",R.drawable.peer_group_activity);
        collection.put("Personality Development of Youth",R.drawable.personality_development_of_youth);
        collection.put("Print Rich Environment",R.drawable.print_rich_environment);
        collection.put("Soft Skills Training",R.drawable.soft_skills_training);
        collection.put("Story of Change",R.drawable.story_of_change);
        collection.put("Story of Change",R.drawable.story_of_change2);
        collection.put("Volunteers Engagement",R.drawable.volunteers_engagement);

        for(String name: collection.keySet()) {

            TextSliderView textSliderView = new TextSliderView(this);
            textSliderView
                    .description(name)
                    .image(collection.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        //sliderLayout.setCustomIndicator((PagerIndicator)findViewById(R.id.custom_indicator));
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(4000);
        sliderLayout.addOnPageChangeListener(this);

        /*
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        Intent i=getIntent();


        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null)
            actionBar.hide();

        viewFlipper=(ViewFlipper) findViewById(R.id.image_view_flipper);
        viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this,R.anim.fade_in));
        viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this,R.anim.fade_out));

        startSlideshow();
        animateSlideshow();




////        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
////        fab.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Intent i = new Intent();
////                i.setClass(PhotoActivity.this, ReviewActivity.class);
////                startActivity(i);
////            }
////        });
//
//
//        viewPager = (ViewPager) findViewById(R.id.pager);
//        imagePagerAdapter = new ImagePagerAdapter(this);
//        viewPager.setAdapter(imagePagerAdapter);
    }


    private void startSlideshow(){

        if(!viewFlipper.isFlipping()){
            viewFlipper.setAutoStart(true);
            viewFlipper.setFlipInterval(FlipDuration);
            viewFlipper.startFlipping();
        }
    }


    private void animateSlideshow() {
        viewFlipper.getInAnimation().setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        */
    }

    @Override
    protected void onStop() {
        sliderLayout.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
