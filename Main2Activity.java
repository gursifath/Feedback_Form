package com.example.bhasingursifath.feedbackform;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.github.amlcurran.showcaseview.ShowcaseView;

import java.util.ArrayList;
import java.util.jar.Attributes;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button b;
    RatingBar ratingBar1, ratingBar2, ratingBar3;
    String NameInput, GenderInput, AgeInput, NameOfWorkshopInput, AreaOFWorkshopInput, DateInput, DurationInput, FeedbackInput, Rating1, Rating2, Rating3;
    ProgressDialog progressBar;
    int progressBarStatus=0;
    Handler progressBarbHandler = new Handler();
    String [] feedback={"Average", "Good", "Very Good", "Needs Improvement"};
    String FeedbackSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        boolean x=isNetworkAvailable();
        if(!x)
            Toast.makeText(Main2Activity.this,"No active Intenet Connection Found. Fix connection and try again",Toast.LENGTH_SHORT).show();

        this.setTitle("Feedback Form-Part 2");

        Intent i = getIntent();
        NameInput = i.getStringExtra("Name");
        GenderInput = i.getStringExtra("Gender");
        AgeInput = i.getStringExtra("Age");
        NameOfWorkshopInput = i.getStringExtra("NameOfWorkshop");
        AreaOFWorkshopInput = i.getStringExtra("AreaOfWorkshop");
        DateInput = i.getStringExtra("Date");
        DurationInput = i.getStringExtra("Time");


        b = (Button) findViewById(R.id.button);
        ratingBar1 = (RatingBar) findViewById(R.id.ratingBar1);
        ratingBar2 = (RatingBar) findViewById(R.id.ratingBar2);
        ratingBar3 = (RatingBar) findViewById(R.id.ratingBar3);

        Spinner spinner= (Spinner) findViewById(R.id.SP_Feedback);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,feedback);
        spinner.setOnItemSelectedListener(this);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        retrofit_call();
    }

    private void retrofit_call() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://docs.google.com/forms/d/")
                .build();

        final PostRequestInterface postRequestInterface = retrofit.create(PostRequestInterface.class);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (isNetworkAvailable()) {

                    progressBar = new ProgressDialog(v.getContext());
                    progressBar.setCancelable(true);
                    progressBar.setMessage("Storing your information. Please Wait..");
                    progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    progressBar.setProgress(0);
                    progressBar.setMax(100);
                    progressBar.show();
                    progressBarStatus = 0;


                    new Thread(new Runnable() {
                        public void run() {
                            while (progressBarStatus < 100) {
                                progressBarStatus = 80;

                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                                progressBarbHandler.post(new Runnable() {
                                    public void run() {
                                        progressBar.setProgress(progressBarStatus);
                                    }
                                });
                            }

                            if (progressBarStatus >= 100) {
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                progressBar.dismiss();
                            }
                        }
                    }).start();

                Rating1 = String.valueOf(ratingBar1.getRating());
                Rating2 = String.valueOf(ratingBar2.getRating());
                Rating3 = String.valueOf(ratingBar3.getRating());
                FeedbackInput = FeedbackSelected;

                Log.d("final", NameInput+" "+GenderInput+" "+AgeInput+" "+NameOfWorkshopInput+" "+AreaOFWorkshopInput+" "+DateInput+" "+DurationInput+" "+FeedbackSelected);

                Call<Void> CompleteFormCall = postRequestInterface.CompleteForm(NameInput, GenderInput, AgeInput, NameOfWorkshopInput, AreaOFWorkshopInput, DateInput, DurationInput, FeedbackInput, Rating1, Rating2, Rating3);
                CompleteFormCall.enqueue(callCallback);
                }
                else
                    Toast.makeText(Main2Activity.this,"No active Intenet Connection Found. Fix connection and try again",Toast.LENGTH_SHORT).show();

            }
    });
    }


    private final Callback<Void> callCallback = new Callback<Void>() {
        @Override
        public void onResponse(Call<Void> call, Response<Void> response) {

                    Log.d("YYY", "Submitted. code" + String.valueOf(response.code()));
                    Log.d("XXX", "Submitted. message " + String.valueOf(response.message()));
                    Toast.makeText(Main2Activity.this,"Thank you for your feedback",Toast.LENGTH_SHORT).show();

            Intent i=new Intent();
            i.setClass(Main2Activity.this,FrontPage.class);
            startActivity(i);
        }

        @Override
        public void onFailure(Call<Void> call, Throwable t) {

            Toast.makeText(Main2Activity.this,"Form could not be submitted. Check Internet Connection and try again.",Toast.LENGTH_SHORT).show();
            Log.e("XXX", "Failed " +t);
        }
    };

//                CompleteFormCall.enqueue(new Callback<Void>() {
//                @Override
//                public void onResponse(Call<Void> call, Response<Void> response) {
//                    Log.d("YYY", "Submitted. code" + String.valueOf(response.code()));
//                    Log.d("XXX", "Submitted. message " + String.valueOf(response.message()));
//                    Toast.makeText(Main2Activity.this,"Thank you for your feedback",Toast.LENGTH_SHORT).show();
////                        Intent i=new Intent();
////                        i.setClass(ReviewActivity.this,MainActivity.class);
////                        startActivity(i);
//                }
//
//                @Override
//                public void onFailure(Call<Void> call, Throwable t) {
//                    Log.e("XXX", "Failed " +t);
//                }
//            });
//
//    }
//

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        FeedbackSelected=feedback[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
