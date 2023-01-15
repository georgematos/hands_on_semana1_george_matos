package com.eldorado.handson.utils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class StringConverter {
    public double convertToDouble(String value) throws ParseException {
        Locale locale = new Locale.Builder().setLanguage("pt").setRegion("BR").build();
        NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
        var newValue = numberFormat.parse(value).doubleValue();
        return newValue;
    }
}
