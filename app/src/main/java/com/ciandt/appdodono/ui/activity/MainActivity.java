package com.ciandt.appdodono.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ciandt.appdodono.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = (EditText) findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.button_gino_go);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strGino = editText.getText().toString();
                Intent intent = new Intent(MainActivity.this, GinoGOActivity.class);
                intent.putExtra("sHomenagem", strGino);
                startActivity(intent);
            }
        });


    }
}
