package com.fzt.learning_android.fzt_002_volume;

/**
 * Created by fabio on 19/05/17.
 */

public class Sphere implements Volume {

    public String volume(double radius) {
        double result_div_pi = 4. / 3. * radius * radius * radius;
        double result = Math.PI * result_div_pi;

        String result_str = String.format("The volume of the Sphere is %g\u03c0 = %g", result_div_pi, result);

        return result_str;
    }

}
