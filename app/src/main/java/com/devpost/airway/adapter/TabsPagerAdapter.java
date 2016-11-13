package com.devpost.airway.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.devpost.airway.fragments.ArrivalFragment;
import com.devpost.airway.fragments.DepartureFragment;


public class TabsPagerAdapter extends FragmentPagerAdapter
{
    int mNumOfTabs;

    public TabsPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;

    }
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                ArrivalFragment tab1 = new ArrivalFragment();
                return tab1;
            case 1:
                DepartureFragment tab2 = new DepartureFragment();
                return tab2;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }


}
