package com.canada.victor.criminalintent;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.Date;

/**
 * Created by Víctor Cañada Ojeda on 25/9/15.
 * victorcanoje@gmail.com
 */




public class CrimeDateActivity extends SingleFragmentActivity {
    private static final String ARG_DATE = "date";

    @Override
    protected Fragment createFragment() {
        Date date = (Date) getIntent().getExtras().getSerializable(ARG_DATE);

        return DatePickerFragment.newInstance(date);
    }

    public static Intent newInstance(Context context, Date date) {
        Intent intent = new Intent(context, CrimeDateActivity.class);
        intent.putExtra(ARG_DATE, date);
        return intent;
    }

}
