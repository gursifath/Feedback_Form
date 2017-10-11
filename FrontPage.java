package com.example.bhasingursifath.feedbackform;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
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
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ViewTarget;

public class FrontPage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(Color.WHITE);

        this.setTitle(" ");

        FloatingActionButton FAB = (FloatingActionButton) findViewById(R.id.FAB);
        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar=Snackbar.make(view, "Do you wish to fill the Feedback Form? ",Snackbar.LENGTH_LONG)
                        .setAction("YES",new yesClickListener()).setActionTextColor(Color.BLACK);
                View sb=snackbar.getView();
                sb.setBackgroundColor(Color.RED);
                snackbar.show();
            }
        });

        ViewTarget target=new ViewTarget(R.id.FAB,this);

        //ViewTarget target = new ViewTarget(toolbar.findViewById(R.id.nav_view)).getPoint();
        /*ViewTargets targets = new ViewTargets();
        try {
            targets.navigationButtonViewTarget(toolbar);
        } catch (ViewTargets.MissingViewException e) {
            e.printStackTrace();
        }*/
//        Button closeButton = new Button(this);
//        closeButton.setBackgroundColor(200);
//        closeButton.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
//        closeButton.setText("OKAY");
//        closeButton.setGravity(Gravity.BOTTOM | Gravity.LEFT);

        Button closeButton= new Button(this);
        closeButton.setBackgroundColor(200);



        new ShowcaseView.Builder(this)
                .setTarget(target)
                .setContentTitle("Wondering what to do?!")
                .setContentText("If you wish to fill the Feedback Form, simply click on the Pink Button below!")
                .hideOnTouchOutside()
                .setStyle(R.style.CustomShowcaseTheme)
                .singleShot(70)
                .replaceEndButton(closeButton)
                .build();

/*
        new ShowcaseView.Builder(this)
                .setTarget(target)
                .setContentTitle("To know more about Udayan Care")
                .setContentText("Click here!")
                .hideOnTouchOutside()
                //.withMaterialShowcase()
                .setStyle(R.style.CustomShowcaseTheme)
                .singleShot(10)
                .replaceEndButton(closeButton)
                .build();*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    public class yesClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            Intent i = new Intent();
            i.setClass(FrontPage.this, ReviewActivity.class);
            startActivity(i);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.front_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle("      Developer's Motivation");
            View v = View.inflate(FrontPage.this, R.layout.developer, null);
            dialog.setView(v);
            dialog.show();
        }
//        else if(id == R.id.developer){
//
//            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
//            dialog.setTitle("      About the Developer");
//            View v=View.inflate(FrontPage.this, R.layout.testimonial,null);
//            dialog.setView(v);
//            dialog.show();
//        }

        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.about_us) {

            Intent i=new Intent();
            i.setClass(FrontPage.this,AboutUs.class);
            startActivity(i);
        } else if (id == R.id.nav_gallery) {

            Intent i=new Intent();
            i.setClass(FrontPage.this,PhotoActivity.class);
            startActivity(i);

        } else if (id == R.id.it_programme) {

            Intent i=new Intent();
            i.setClass(FrontPage.this,IT_Programme.class);
            startActivity(i);

        } else if (id == R.id.nav_call) {

            Intent intent=new Intent();
            intent.setAction(Intent.ACTION_DIAL);
            Uri data=Uri.parse("tel:011-46548105");
            intent.setData(data);
            startActivity(intent);

        } else if (id == R.id.nav_email) {

            Intent intent=new Intent();
            intent.setAction(Intent.ACTION_SENDTO);
            Uri data= Uri.parse("mailto: ucitvt@udayancare.org");
            intent.setData(data);
            startActivity(intent);

        } else if(id == R.id.visitus){

            AlertDialog.Builder d = new AlertDialog.Builder(FrontPage.this);
            View v= View.inflate(FrontPage.this,R.layout.visit_us_address,null);
            d.setView(v);
            d.setIcon(R.drawable.ic_visit_us);
            d.setTitle("Visit Us");
            d.show();

        }  else if (id == R.id.nav_website) {

            Intent intent=new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            Uri data= Uri.parse("https://www.udayancare.org");
            intent.setData(data);
            startActivity(intent);

        } else if (id == R.id.nav_twitter) {

            Intent intent=new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            Uri data=Uri.parse("https://twitter.com/UdayanCare");
            intent.setData(data);
            startActivity(intent);

        } else if (id == R.id.nav_facebook) {

            Intent intent=new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            Uri data=Uri.parse("https://www.facebook.com/UdayanCare");
            intent.setData(data);
            startActivity(intent);


        } else if (id == R.id.nav_blogger) {

            Intent intent=new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            Uri data= Uri.parse("http://udayancareblog.blogspot.in/");
            intent.setData(data);
            startActivity(intent);

        } else if (id == R.id.nav_youtube) {

            Intent intent=new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            Uri data= Uri.parse("https://www.youtube.com/channel/UC509HMTU0uz0JUSinlClNhA");
            intent.setData(data);
            startActivity(intent);

        } else if (id == R.id.nav_insta) {

//            Intent intent=new Intent();
//            intent.setAction(Intent.ACTION_VIEW);
//            Uri data= Uri.parse("https://www.instagram.com/udayancare/");
//            intent.setData(data);
//            startActivity(intent);

            Uri uri = Uri.parse("http://instagram.com/_u/udayancare");
            Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

            likeIng.setPackage("com.instagram.android");

            try {
                startActivity(likeIng);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://instagram.com/udayancare")));
            }

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
