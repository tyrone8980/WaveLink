package com.example.harmo.wavelink;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class nethiesinfo extends AppCompatActivity implements View.OnClickListener {

    EditText textbox;
    TextView textdisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_nethiesinfo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button one = (Button) findViewById(R.id.button2);
        one.setOnClickListener(this); // calling onClick() method
        Button two = (Button) findViewById(R.id.button3);
        two.setOnClickListener(this);
        Button three = (Button) findViewById(R.id.button4);
        three.setOnClickListener(this);
        textbox = (EditText) findViewById(R.id.editText);
        textdisplay = (TextView) findViewById(R.id.textView5);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button2:
                //startActivity(new Intent(nethiesinfo.this,creditcardinfoActivity.class));
                break;
            case R.id.button3:
                startActivity(new Intent(nethiesinfo.this,MapsActivity.class));
                break;
            case R.id.button4:
                String inputbyuser =" " + textbox.getText().toString();
                textdisplay.append(inputbyuser);
            default:
                break;
        }

    }
}
