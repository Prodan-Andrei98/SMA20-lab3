package com.example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {

    String[] colors = { "Red", "Green", "Blue"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);


        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,colors);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin.setAdapter(aa);

        final EditText eName = (EditText) findViewById(R.id.eName);
        Button bClick = (Button) findViewById(R.id.bClick);
        final TextView tName = (TextView) findViewById(R.id.tName);
        final String[] name = new String[1];


        bClick.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                if (tName.getText().toString().equals("")) {
                    name[0] =  eName.getText().toString();
                    tName.setText(eName.getText().toString());
                    tName.setText("Hello, " + name[0]);
                } else {
                    tName.setText("");
                }
            }
        });

        final Button butPop = (Button) findViewById(R.id.butPop);

        butPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonShowPopupWindowClick(v, "Hello, " + name[0] );
            }
        });

        Button butonp = (Button) findViewById(R.id.butonp);
        Button butonn = (Button) findViewById(R.id.butonn);
        butonp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Positive Toast",Toast.LENGTH_SHORT).show();
            }
        });
        butonn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Negative Toast",Toast.LENGTH_SHORT).show();
            }
        });

        final Button butonsh = (Button) findViewById(R.id.butonsh);
        butonsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailSelectorIntent = new Intent(Intent.ACTION_SENDTO);
                emailSelectorIntent.setData(Uri.parse("mailto:"));

                final Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"address@mail.com"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                emailIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                emailIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                emailIntent.setSelector( emailSelectorIntent );

                if( emailIntent.resolveActivity(getPackageManager()) != null )
                    startActivity(emailIntent);
            }
        });


        final Button butonsrc = (Button) findViewById(R.id.butonsrc);
        butonsrc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String googleUrl = "https://www.google.com/search?q=" + name[0];
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(googleUrl));
                startActivity(i);
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(), colors[position] + position, Toast.LENGTH_LONG).show();
        Button bClick = (Button) findViewById(R.id.bClick);
        switch(position) {
            case 0:
                bClick.setBackgroundColor(Color.RED);
                break;
            case 1:
                bClick.setBackgroundColor(Color.GREEN);
                break;
            case 2:
                bClick.setBackgroundColor(Color.BLUE);
                break;
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
        Toast.makeText(getApplicationContext(), "Select a color", Toast.LENGTH_LONG).show();
    }

    public void onButtonShowPopupWindowClick(View view, final String name) {

        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup, null);

        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);


        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);


        ((TextView)popupWindow.getContentView().findViewById(R.id.eName2)).setText(name);


        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }

}