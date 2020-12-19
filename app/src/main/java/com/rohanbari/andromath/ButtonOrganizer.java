package com.rohanbari.andromath;

import android.app.Activity;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ButtonOrganizer {
    /**
     * Begins the distribution of answers among four buttons through a tolerance of 10%
     * so that all the answers would look correct to make it hard.
     *
     * @param activity The Activity to be edited
     */
    public static void organize(Activity activity) {
        int result;
        int counter = 0;

        Button[] buttons = new Button[]{
                activity.findViewById(R.id.op1),
                activity.findViewById(R.id.op2),
                activity.findViewById(R.id.op3),
                activity.findViewById(R.id.op4)};

        Random random = new Random(System.nanoTime());

        int value1 = ProblemGenerator.getVar1();
        int value2 = ProblemGenerator.getVar2();
        String op = ProblemGenerator.getOp();

        if (op.equals("+")) {
            result = value1 + value2;
        } else if (op.equals("-")) {
            result = value1 - value2;
        } else {
            result = value1 * value2;
        }

        List<String> strings = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int tolerance = random.nextInt(10) + 1;
            strings.add(String.valueOf(result * tolerance / 10));
        }

        strings.add(String.valueOf(result));

        Collections.shuffle(strings);

        for (Button button : buttons) {
            button.setText(String.valueOf(strings.get(counter++)));
        }
    }
}
