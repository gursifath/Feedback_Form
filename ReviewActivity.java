package com.example.bhasingursifath.feedbackform;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.icu.util.Calendar;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ReviewActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static final String Name = "entry.1256178576";
    public static final String Gender = "entry.426491975";
    public static final String Age = "entry.2000641666";
    public static final String NameOfWorkshopAttended = "entry.1350691592";
    public static final String AreaOfWorkshop = "entry.1015570159";
    public static final String DateOfWorkshop = "entry.1458731727";
    public static final String TimeOfWorkshop = "entry.173119943";
    public static final String Feedback = "entry.721038449";
    public static final String Rating1 = "entry.1511956055";
    public static final String Rating2 = "entry.639437097";
    public static final String Rating3 = "entry.1512736639";


    String[] Workshops = {"Career Guidance", "Practical Practices-Field", "Co-Curricular Activities", "Social Work", "Industry Expert Session", "Life Skills", "Use of Technology", "Competitions & Programs"};
    String[] Areas = {"Badarpur", "Budh Vihar", "Uttam Nagar", "East Vinod Nagar", "YLP-EVN", "Sahibabad", "Bhangel", "Greater Noida", "Narsinghpur", "Sidhrawali"};
    String[] Duration= {"2 Hours", "3 Hours", "4 Hours", "Full Day"};
    String WorkshopSelected, AreaSelected, DurationSelected, gender, Date, Time;
    Button submit_button;
    EditText _Name, _Age;
    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView datePicker, timePicker;
    boolean a = true;
    Snackbar snackbar;
    CoordinatorLayout coordinatorLayout;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        Intent i = getIntent();

        coordinatorLayout=(CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        message="No active Intenet Connection Found. Fix connection and try again";
        boolean x=isNetworkAvailable();
        if(!x)
        {
            snackbar = Snackbar
                    .make(coordinatorLayout,message,Snackbar.LENGTH_LONG)
                    .setAction("X", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            snackbar.dismiss();
                        }
                    })
            .setActionTextColor(Color.RED);

            snackbar.show();
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        this.setTitle("Feedback Form-Part 1");


        /// Internet connection failed/not working.
        ///Please try again.


        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        submit_button = (Button) findViewById(R.id.angry_btn);
        _Name = (EditText) findViewById(R.id.ET_Name);
        _Age = (EditText) findViewById(R.id.ET_Age);
        datePicker = (TextView) findViewById(R.id.DatePicker);
        timePicker = (TextView) findViewById(R.id.TimePicker);

        Spinner spinner = (Spinner) findViewById(R.id.SP_NameOfWorkshop);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Workshops);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setPrompt("Choose Name");
        spinner.setAdapter(adapter);


        Spinner spinner1 = (Spinner) findViewById(R.id.SP_AreaOFWorkshop);
        spinner1.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Areas);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setPrompt("Choose Area");
        spinner1.setAdapter(adapter1);

        Spinner spinner2= (Spinner) findViewById(R.id.SP_Duration);
        spinner2.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter2=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,Duration);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setPrompt("Choose Duration");
        spinner2.setAdapter(adapter2);


        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(ReviewActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {
                        Date = "" + dayOfMonth + "/" + (month + 1) + "/" + year;
                        String writeDate = "Date : " + dayOfMonth + "/" + (month + 1) + "/" + year;
                        datePicker.setText(writeDate);
                    }
                }, 2017, 06, 11);

                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

                datePickerDialog.show();
            }
        });

        /*
        timePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(ReviewActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {

                        int n1 = hourOfDay / 10;
                        int n2 = minute / 10;

                        if (hourOfDay <= 11) {
                            if (n1 == 0 && n2 == 0)
                                Time = "0" + hourOfDay + ":0" + minute + "AM";
                            else if (hourOfDay <= 11 && n1 == 0)
                                Time = "0" + hourOfDay + ":" + minute + "AM";
                            else if (hourOfDay <= 11 && n2 == 0)
                                Time = "" + hourOfDay + ":0" + minute + "AM";
                            else if (hourOfDay <= 11)
                                Time = "" + hourOfDay + ":" + minute + "AM";
                        } else {
                            if (n1 == 0 && n2 == 0)
                                Time = "0" + hourOfDay + ":0" + minute + "PM";
                            else if (n1 == 0)
                                Time = "0" + hourOfDay + ":" + minute + "PM";
                            else if (n2 == 0)
                                Time = "" + hourOfDay + ":0" + minute + "PM";
                            else
                                Time = "" + hourOfDay + ":" + minute + "PM";
                        }


                        String writeTime = "Time : " + Time;
                        timePicker.setText(writeTime);
                    }
                }, 0, 0, true);

                timePickerDialog.show();
            }
        });  */


        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int radioID = radioGroup.getCheckedRadioButtonId();
                if (TextUtils.isEmpty(_Name.getText().toString())) {
                    Toast.makeText(ReviewActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                    a = false;
                } else if (radioID == -1) {
                    Toast.makeText(ReviewActivity.this, "Please select your Gender", Toast.LENGTH_SHORT).show();
                    a = false;
                } else if (TextUtils.isEmpty(_Age.getText().toString())) {
                    Toast.makeText(ReviewActivity.this, "Please enter your age", Toast.LENGTH_SHORT).show();
                    a = false;
                } else if (datePicker.getText().toString().equals("  Select Date")) {
                    Toast.makeText(ReviewActivity.this, "Please enter the date of workshop", Toast.LENGTH_SHORT).show();
                    a = false;
                } else
                    a = true;


                if (a) {

                    radioButton = (RadioButton) findViewById(radioID);
                    gender = radioButton.getText().toString();
                    String NameInput = _Name.getText().toString();
                    String GenderInput = gender;
                    String AgeInput = _Age.getText().toString();
                    String NameofWorkshopInput = WorkshopSelected;
                    String AreaOFWorkshopInput = AreaSelected;
                    String DateInput = Date;
                    String DurationInput = DurationSelected;


                    Log.d("Output", NameInput + " " + GenderInput + " " + AgeInput + " " + NameofWorkshopInput + " " + AreaOFWorkshopInput + " " + DateInput + " " + DurationInput);

                    Intent i = new Intent();
                    i.setClass(ReviewActivity.this, Main2Activity.class);
                    i.putExtra("Name", NameInput);
                    i.putExtra("Gender", GenderInput);
                    i.putExtra("Age", AgeInput);
                    i.putExtra("NameOfWorkshop", NameofWorkshopInput);
                    i.putExtra("AreaOfWorkshop", AreaOFWorkshopInput);
                    i.putExtra("Date", DateInput);
                    i.putExtra("Time", DurationInput);

                    if(isNetworkAvailable())
                        startActivity(i);
                    else{
                        snackbar = Snackbar
                                .make(coordinatorLayout,message,Snackbar.LENGTH_LONG)
                                .setAction("X", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        snackbar.dismiss();
                                    }
                                })
                        .setActionTextColor(Color.RED);

                        snackbar.show();
                    }


                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Spinner spin = (Spinner) parent;
        Spinner spin1 = (Spinner) parent;
        Spinner spin2 = (Spinner) parent;
        if (spin.getId() == R.id.SP_NameOfWorkshop) {
            WorkshopSelected = Workshops[position];
        }
        if (spin1.getId() == R.id.SP_AreaOFWorkshop) {
            AreaSelected = Areas[position];
        }
        if(spin2.getId() == R.id.SP_Duration) {
            DurationSelected=Duration[position];
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

        Toast.makeText(this, "All fields are mandatory!", Toast.LENGTH_SHORT).show();
    }


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();

    }
}
