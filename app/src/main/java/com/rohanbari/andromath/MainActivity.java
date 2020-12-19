package com.rohanbari.andromath;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.rohanbari.andromath.ProblemGenerator.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generate();

        TextView textView = findViewById(R.id.probText);
        textView.setText(String.format("%d %s %d", getVar1(), getOp(), getVar2()));

        ButtonOrganizer.organize(this);
    }
}