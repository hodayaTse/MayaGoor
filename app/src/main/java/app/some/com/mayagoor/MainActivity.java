package app.some.com.mayagoor;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        TextView newApp = (TextView)findViewById(R.id.appText);

        newApp.setText(getIntent().getStringExtra("mytext"));

        //fonts!!
        //TEXTVIEW - headlins
        TextView txtMAYA, txtSTXT, btnGoToDetailsPageTxt, btnGoToAppointmentPageTxt;

        //FONTS
        Typeface assistant, trashim, assistantb;

        //get fonts
        assistant = Typeface.createFromAsset(getAssets(), "assistant.ttf");
        trashim = Typeface.createFromAsset(getAssets(), "trashim.ttf");
        assistantb = Typeface.createFromAsset(getAssets(), "assistantb.ttf");

        //get the textVeiw by ID
        txtMAYA = (TextView) findViewById(R.id.txtHead);
        txtSTXT = (TextView) findViewById(R.id.txtSomeHead);
        btnGoToAppointmentPageTxt = (TextView) findViewById(R.id.btnGoToAppointmentPage);
        btnGoToDetailsPageTxt = (TextView) findViewById(R.id.btnGoToDetailsPage);

        //set fonts to textView
        txtMAYA.setTypeface(trashim);
        txtSTXT.setTypeface(assistant);
        btnGoToAppointmentPageTxt.setTypeface(assistantb);
        btnGoToDetailsPageTxt.setTypeface(assistantb);
        newApp.setTypeface(assistant);

        //************move to deatails page
        Button btnGoToDetailsPage = (Button) findViewById(R.id.btnGoToDetailsPage);

    }

    public void goToDetailsPage(View view){
        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);
    }


    public void goToAppointmantPage(View view){
        Intent intent = new Intent(this, AppointmantActivity.class);
        startActivity(intent);
    }
}
