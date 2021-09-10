package com.example.poem.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.poem.fragment.DashboardFragment;
import com.example.poem.fragment.FavouriteFragment;
import com.example.poem.fragment.HistoryFragment;
import com.example.poem.fragment.HomeFragment;
import com.example.poem.fragment.SettingFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new DashboardFragment();
            case 2:
                return new FavouriteFragment();
            case 3:
                return  new HistoryFragment();
            case 4:
                return  new SettingFragment();
            default:
                return new HomeFragment();
        }

    }

    @Override
    public int getCount() {
        return 5;
    }
}
