package app.some.com.mayagoor;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.MenuPopupWindow;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.Date;

public class AppointmantActivity extends AppCompatActivity {

    static String myDate;
    static String myTime;
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    int whatTreatment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointmant);

        getSupportActionBar().hide();


        //all the buttons
        final Button button1 = findViewById(R.id.btnHour1);
        final Button button2 = findViewById(R.id.btnHour2);
        final Button button3 = findViewById(R.id.btnHour3);
        final Button button4 = findViewById(R.id.btnHour4);
        final Button button5 = findViewById(R.id.btnHour5);
        final Button button6 = findViewById(R.id.btnHour6);
        final Button button7 = findViewById(R.id.btnHour7);

        final Button newApp = findViewById(R.id.buttonOk);
        //final TextView textTitleAppointmant = findViewById(R.id.textTitleAppointmant);
        final TextView textNoAppointmant = findViewById(R.id.textNoAppointmant);
        //final TextView dropdownList = findViewById(R.id.dropdownList);
        //Spinner dropList = (Spinner)findViewById(R.id.dropdownList);


        //final Button buttonOk = findViewById(R.id.buttonOk);

        //calander
        final CalendarView calendarView = (CalendarView) findViewById(R.id.calendarMakeApp);


        //fonts!!
        //FONTS
        final Typeface assistant, trashim;

        //get fonts
        assistant = Typeface.createFromAsset(getAssets(), "assistant.ttf");
        trashim = Typeface.createFromAsset(getAssets(), "trashim.ttf");

        //set fonts to textView
        //headlins
        //newApp.setTypeface(assistant);
        //info
        newApp.setTypeface(assistant);
        button1.setTypeface(assistant);
        button2.setTypeface(assistant);
        button3.setTypeface(assistant);
        button4.setTypeface(assistant);
        textNoAppointmant.setTypeface(assistant);
        //dropdownList.setTypeface(assistant);
        //dropList.setTextAlignment(assistant);


        //+++++++++++ select date +++++++++++++++++++++++++++++++//
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String theDate = String.valueOf(dayOfMonth) + "/" + String.valueOf(month+1);
                button7.setText(theDate);


                if (whatTreatment != 0 && dayOfMonth != 29 && dayOfMonth != 15)
                {
                    //textTitleAppointmant.setVisibility(View.VISIBLE);
                    textNoAppointmant.setVisibility(View.VISIBLE);
                    textNoAppointmant.setText("אין תורים פנויים");
                    button1.setVisibility(View.INVISIBLE);
                    button2.setVisibility(View.INVISIBLE);
                    button3.setVisibility(View.INVISIBLE);
                    button4.setVisibility(View.INVISIBLE);
                    newApp.setVisibility(View.INVISIBLE);
                }
                else if (whatTreatment == 0) {

                    textNoAppointmant.setVisibility(View.VISIBLE);
                    textNoAppointmant.setText("יש לבחור את סוג הטיפול");
                    newApp.setVisibility(View.INVISIBLE);

                }
                else if (whatTreatment != 0 && dayOfMonth == 29)
                {
                    //textTitleAppointmant.setVisibility(View.VISIBLE);
                    changeTheColor(button6, button1, button2, button3, button4, button5);
                    textNoAppointmant.setVisibility(View.INVISIBLE);
                    button1.setVisibility(View.VISIBLE);
                    button2.setVisibility(View.VISIBLE);
                    button3.setVisibility(View.INVISIBLE);
                    button4.setVisibility(View.INVISIBLE);
                    newApp.setVisibility(View.INVISIBLE);
                    myDate = String.valueOf(dayOfMonth) + "." + String.valueOf(month+1);

                }
                else if (whatTreatment != 0 && dayOfMonth == 15)
                {
                    changeTheColor(button6, button1, button2, button3, button4, button5);
                    textNoAppointmant.setVisibility(View.INVISIBLE);
                    button1.setVisibility(View.VISIBLE);
                    button2.setVisibility(View.VISIBLE);
                    button3.setVisibility(View.VISIBLE);
                    button4.setVisibility(View.VISIBLE);
                    newApp.setVisibility(View.INVISIBLE);
                    myDate = String.valueOf(dayOfMonth) + "." + String.valueOf(month+1);
                }


                //display priveus dates
                // Date currentTime = Calendar.getInstance().getTime();



            }
        });




        //+++++++++++ write hours on the buttons ++++++++++++++++//
        //change button 1
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                changeTheColor(button1, button2, button3, button4, button5, button6);
                newApp.setVisibility(View.VISIBLE);
                myTime = String.valueOf(button1.getText());
            }
        });

        //change button 2
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                changeTheColor(button2, button1, button3, button4, button5, button6);
                newApp.setVisibility(View.VISIBLE);
                myTime = String.valueOf(button2.getText());

            }
        });

        //change button 3
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                changeTheColor(button3, button1, button2, button4, button5, button6);
                newApp.setVisibility(View.VISIBLE);
                myTime = String.valueOf(button3.getText());
            }
        });

        //change button 4
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                changeTheColor(button4, button1, button2, button3, button5, button6);
                newApp.setVisibility(View.VISIBLE);
                myTime = String.valueOf(button4.getText());
            }
        });

        //change button 5
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                changeTheColor(button5, button1, button2, button3, button4, button6);
            }
        });

        //change button 6
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                changeTheColor(button6, button1, button2, button3, button4, button5);
            }
        });

        //making an appointment
        newApp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                newApp.setBackgroundColor(getResources().getColor(R.color.colorButton));

                //open dialog
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(AppointmantActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_new_appointmant, null);

                //get the text and buttons
                TextView date = (TextView)mView.findViewById(R.id.dateApp);
                TextView time = (TextView)mView.findViewById(R.id.timeApp);
                Button okApp = (Button) mView.findViewById(R.id.okNewApp);
                TextView myTitle = (TextView)  mView.findViewById(R.id.titleMaya);
                Button noApp = (Button) mView.findViewById(R.id.deleteApp);
                TextView someText = (TextView)  mView.findViewById(R.id.textLak);

                //set fonts
                myTitle.setTypeface(trashim);
                date.setTypeface(assistant);
                okApp.setTypeface(assistant);
                noApp.setTypeface(assistant);
                time.setTypeface(assistant);
                someText.setTypeface(assistant);


                date.setText( "בתאריך ה " + myDate);
                time.setText("בשעה " + myTime);

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();



                okApp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        newApp.setBackgroundColor(getResources().getColor(R.color.newAppButton));
                        Toast.makeText(AppointmantActivity.this, "התור נקבע", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();

                        String text = " תור קיים - לתאריך: " + myDate + " לשעה: " + myTime;

                        Intent myIntent = new Intent(v.getContext(),MainActivity.class);
                        myIntent.putExtra("mytext",text);
                        startActivity(myIntent);

                        //Intent intent = new Intent(AppointmantActivity.this, MainActivity.class);
                        //startActivity(intent);



                    }
                });

                noApp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        newApp.setBackgroundColor(getResources().getColor(R.color.newAppButton));
                        Toast.makeText(AppointmantActivity.this, "התור לא נקבע", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();

                    }
                });


                // openDialog();
            }
        });


        // hideNvBar();




        // ++++++++++++++++++++++++++dropdown list ++++++++++++++++++++
        spinner = (Spinner) findViewById(R.id.dropdownList);
        adapter = ArrayAdapter.createFromResource(AppointmantActivity.this, R.array.myAppointmant, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(AppointmantActivity.this, parent.getItemAtPosition(position) + "", Toast.LENGTH_SHORT).show();
                TextView myText = (TextView)view;
                myText.setTypeface(assistant);
                whatTreatment = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }


   /* private void openDialog(){
        MakeAnAppointmant newApp = new MakeAnAppointmant();
        newApp.show(getSupportFragmentManager(), "pop_make_an_appointment");
    }*/


    //onclick the buttons
    private void changeTheColor(Button button1, Button button2, Button button3, Button button4, Button button5, Button button6){

        //set colors for text and background for the clicked buttons
        button1.setBackgroundResource(R.drawable.button_hour_onclick);
        button1.setTextColor(Color.WHITE);

        //set other buttons to default color
        button2.setBackgroundResource(R.drawable.button_hour_shape);
        button2.setTextColor(Color.BLACK);
        button3.setBackgroundResource(R.drawable.button_hour_shape);
        button3.setTextColor(Color.BLACK);
        button4.setBackgroundResource(R.drawable.button_hour_shape);
        button4.setTextColor(Color.BLACK);
        button5.setBackgroundResource(R.drawable.button_hour_shape);
        button5.setTextColor(Color.BLACK);
        button6.setBackgroundResource(R.drawable.button_hour_shape);
        button6.setTextColor(Color.BLACK);

       // newApp.setVisibility(View.VISIBLE);
    }


}


