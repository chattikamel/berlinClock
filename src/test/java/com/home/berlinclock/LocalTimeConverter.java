package com.home.berlinclock;


import cucumber.api.Transformer;

import java.time.LocalTime;

public class LocalTimeConverter extends Transformer<LocalTime> {
    public LocalTime transform(String s) {
        return LocalTime.parse(s);
    }
}
