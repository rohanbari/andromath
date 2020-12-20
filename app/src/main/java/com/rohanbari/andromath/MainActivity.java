package com.rohanbari.andromath;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

import static com.rohanbari.andromath.ProblemGenerator.generate;
import static com.rohanbari.andromath.ProblemGenerator.getOp;
import static com.rohanbari.andromath.ProblemGenerator.getVar1;
import static com.rohanbari.andromath.ProblemGenerator.getVar2;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generate();
        updateQuestion();
        ButtonOrganizer.organize(this);
    }

    /**
     * Validate the answer given by the user.
     *
     * @param view Button ID
     */
    public void checkAnswer(View view) {
        int result = 0;
        int validResult;

        Button[] buttons = new Button[]{
                findViewById(R.id.op1),
                findViewById(R.id.op2),
                findViewById(R.id.op3),
                findViewById(R.id.op4),
        };

        for (Button button : buttons) {
            if (button.equals(view)) {
                result = Integer.parseInt((String) button.getText());
            }
        }

        validResult = ButtonOrganizer.getCorrectAnswer();

        if (result == validResult) {
            Toast.makeText(this, "The answer is correct!", Toast.LENGTH_SHORT).show();
            generate();
            updateQuestion();
            ButtonOrganizer.organize(this);
        } else {
            Toast.makeText(this, "Incorrect, guess again!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Arranges the question.
     */
    private void updateQuestion() {
        TextView textView = findViewById(R.id.probText);
        textView.setText(String.format(Locale.ENGLISH, "%d %s %d", getVar1(), getOp(), getVar2()));
    }
}