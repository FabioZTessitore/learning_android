package com.example.viewmodeldemo.ui.main;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private static final Double usd_to_eu_rate = .75;
    private Double dollars = .0;

    public void setAmount(String value) {
        this.dollars = Double.valueOf(value);
    }

    public Double getResult() {
        return this.dollars * this.usd_to_eu_rate;
    }
}