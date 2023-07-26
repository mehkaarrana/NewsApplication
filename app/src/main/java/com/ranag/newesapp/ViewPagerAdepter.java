package com.ranag.newesapp;

import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdepter extends FragmentPagerAdapter {

   int cont;
    public ViewPagerAdepter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        cont=behavior;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Homefrg();
            case 1:
                return new Sportsfrg();
            case 2:
                return new Sciencefrg();
            case 3:
                return new Healthfrg();
            case 4:
                return new Entertainmentfrg();
            case 5:
                return new Technologyfrg();
            default:
                return null;
        }
    }


    @Override
    public int getCount() {
        return cont;
    }
}
