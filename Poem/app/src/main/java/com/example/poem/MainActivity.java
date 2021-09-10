package com.example.poem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.poem.Adapter.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private  BottomNavigationView navigationView;
    private ViewPager viewPager;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = findViewById(R.id.bottom_menu);
        viewPager = findViewById(R.id.view_pager);
        setUpViewPager();
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        getSupportActionBar().setTitle("Home");
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.action_dashboard:
                        getSupportActionBar().setTitle("Dashboard");
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.action_favourite:
                        getSupportActionBar().setTitle("Favourite");
                        viewPager.setCurrentItem(2);
                    break;
                    case R.id.action_history:
                        getSupportActionBar().setTitle("History");
                        viewPager.setCurrentItem(3);
                        break;
                    case R.id.action_setting:
                        getSupportActionBar().setTitle("Setting");
                        viewPager.setCurrentItem(4);
                        break;
                }
                return true;
            }
        });
    }
    private void setUpViewPager(){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                    switch (position){
                        case 0:
                            navigationView.getMenu().findItem(R.id.action_home).setChecked(true);
                            break;
                        case 1:
                            navigationView.getMenu().findItem(R.id.action_dashboard).setChecked(true);
                            break;
                        case 2:
                            navigationView.getMenu().findItem(R.id.action_favourite).setChecked(true);
                            break;
                        case 3:
                            navigationView.getMenu().findItem(R.id.action_history).setChecked(true);
                            break;
                        case 4:
                            navigationView.getMenu().findItem(R.id.action_setting).setChecked(true);
                            break;
                    }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}