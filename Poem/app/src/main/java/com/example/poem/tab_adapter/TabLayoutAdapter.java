package com.example.poem.tab_adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.poem.fragment.DashboardFragment;
import com.example.poem.fragment.HomeFragment;
import com.example.poem.fragment.SettingFragment;
import com.example.poem.tab_fragment.AuthorFragment;
import com.example.poem.tab_fragment.CategoryFragment;

public class TabLayoutAdapter extends FragmentStatePagerAdapter {
    public TabLayoutAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new CategoryFragment();
            case 1:
                return new AuthorFragment();

            default:
                return new CategoryFragment();
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return  "Category";
            case 1: return "Author";
            default: return  "Category";
        }

    }
}
