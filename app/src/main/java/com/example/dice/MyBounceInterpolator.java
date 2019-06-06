package com.example.dice;

import android.view.animation.Interpolator;

public class MyBounceInterpolator implements Interpolator {
    double mAmplitude=1;
    double mFrequency=10;
    MyBounceInterpolator(double amplitude,double frequency)
    {
        amplitude=mAmplitude;
        frequency=mFrequency;
    }

    public float getInterpolation(float time) {
        return (float) (-1 * Math.pow(Math.E, -time/ mAmplitude) *
                Math.cos(mFrequency * time) + 1);
    }
}
