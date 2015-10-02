package com.canada.victor.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by Víctor Cañada Ojeda on 21/9/15.
 * victorcanoje@gmail.com
 */


public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
