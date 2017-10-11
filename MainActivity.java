package com.example.bhasingursifath.feedbackform;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends FragmentActivity {

//    static final int NUM_ITEMS = 6;
//    ImagePagerAdapter imageFragmentPagerAdapter;
//    ViewPager viewPager;
//    public static final String[] IMAGE_NAME = {"eagle", "horse", "bonobo", "wolf", "owl", "bear"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        imageFragmentPagerAdapter = new ImagePagerAdapter(getSupportFragmentManager());
//        viewPager = (ViewPager) findViewById(R.id.pager);
//        viewPager.setAdapter(imageFragmentPagerAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.FAB);
        fab.setImageResource(R.drawable.pencil);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar snackbar=Snackbar.make(view, "Do you wish to fill the Feedback Form? ",Snackbar.LENGTH_LONG)
                        .setAction("YES",new yesClickListener()).setActionTextColor(Color.BLACK);
                View sb=snackbar.getView();
                sb.setBackgroundColor(Color.CYAN);
                //sb.setForegroundTintMode(Color.BLACK);
                snackbar.show();

            }
        });
    }

    public class yesClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            Intent i = new Intent();
            i.setClass(MainActivity.this, ReviewActivity.class);
            startActivity(i);
        }
    }

//    public class ImagePagerAdapter extends FragmentPagerAdapter {
//        public ImagePagerAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            SwipeFragment fragment = new SwipeFragment();
//            return fragment.newInstance(position);
//        }
//
//        @Override
//        public int getCount() {
//            return NUM_ITEMS;
//        }
//    }
//        public static class SwipeFragment extends Fragment {
//
//            @Override
//            public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                     Bundle savedInstanceState) {
//                View swipeView = inflater.inflate(R.layout.swipe_fragment, container, false);
//                ImageView imageView = (ImageView) swipeView.findViewById(R.id.imageView);
//                Bundle bundle = getArguments();
//                int position = bundle.getInt("position");
//                String imageFileName = IMAGE_NAME[position];
//                int imgResId = getResources().getIdentifier(imageFileName,"drawable","com.example.bhasingursifath.feedbackform");
//                imageView.setImageResource(imgResId);
//                return swipeView;
//            }
//
//            SwipeFragment newInstance(int position) {
//                SwipeFragment swipeFragment = new SwipeFragment();
//                Bundle bundle = new Bundle();
//                bundle.putInt("position", position);
//                swipeFragment.setArguments(bundle);
//                return swipeFragment;
//            }
//        }
    }

