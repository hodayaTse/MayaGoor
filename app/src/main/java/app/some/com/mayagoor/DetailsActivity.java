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
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;


public class DetailsActivity extends AppCompatActivity {

    private Button buttonCall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        getSupportActionBar().hide();

        //fonts!!
        //TEXTVIEW - headlins
        TextView txtAboutMe, txtMyBusiness, txtMoreDetails;
        //TEXTVIEW - info
        TextView txtMyName, txtMyPhone, txtAddress, txtHours, txtMyDetails;

        //FONTS
        Typeface assistant, trashim;

        //get fonts
        assistant = Typeface.createFromAsset(getAssets(), "assistant.ttf");
        trashim = Typeface.createFromAsset(getAssets(), "trashim.ttf");

        //get the textVeiw by ID
        txtAboutMe = (TextView) findViewById(R.id.txtAboutMe);
        txtMyBusiness = (TextView) findViewById(R.id.txtMyBusiness);
        txtMoreDetails = (TextView) findViewById(R.id.txtMoreDetails);
        txtMyName = (TextView) findViewById(R.id.txtMyName);
        txtMyPhone = (TextView) findViewById(R.id.txtMyPhone);
        txtAddress = (TextView) findViewById(R.id.txtAddress);
        txtHours = (TextView) findViewById(R.id.txtHours);
        txtMyDetails = (TextView) findViewById(R.id.txtMyDetails);

        //set fonts to textView
        //headlins
        txtAboutMe.setTypeface(trashim);
        txtMyBusiness.setTypeface(trashim);
        txtMoreDetails.setTypeface(trashim);
        //info
        txtMyName.setTypeface(assistant);
        txtMyPhone.setTypeface(assistant);
        txtAddress.setTypeface(assistant);
        txtHours.setTypeface(assistant);
        txtMyDetails.setTypeface(assistant);


        //******* add calling

        buttonCall = (Button) findViewById(R.id.txtMyPhone);

        buttonCall.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:0525307972"));

                if (ActivityCompat.checkSelfPermission(DetailsActivity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }

                startActivity(callIntent);
            }
        });


    }
}
