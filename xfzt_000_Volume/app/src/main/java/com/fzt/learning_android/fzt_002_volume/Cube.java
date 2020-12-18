package com.fzt.learning_android.fzt_002_volume;

/**
 * Created by fabio on 19/05/17.
 */

public class Cube implements Volume {

    public String volume(double side) {

        double result = side * side * side;
        String result_str = String.format("The volume of the Cube is %g", result);

        return result_str;
    }

}
