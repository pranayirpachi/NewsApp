package com.sahil.newsapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    int talcount;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);

        talcount=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new Homefragment();
            case 1:
                return new sportsfragment();
            case 2:
                return new Headlthfragment();
            case 3:
                return new Sciencefragment();
            case 6:
                return new Enterfragment();
            case 7:
                return new Techfragment();

            default:
                return null;

        }

    }

    @Override
    public int getCount() {
        return talcount;
    }
}
