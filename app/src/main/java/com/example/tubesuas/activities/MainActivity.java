package com.example.tubesuas.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.tubesuas.Models.ItemMenu;
import com.example.tubesuas.R;
import com.example.tubesuas.adapters.item_menu_adapters;
import com.example.tubesuas.fragments.HomeFragment;
import com.example.tubesuas.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    RecyclerView item_menu;
    List<ItemMenu> listItemMenu = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(new HomeFragment());
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        // beri listener pada saat item/menu bottomnavigation terpilih
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        item_menu = findViewById(R.id.item_menu);
        ItemMenu menu = new ItemMenu("Paket 1");
        //menambahkan hero ke listSuperHero
        listItemMenu.add(menu);
        //membuat object hero baru
        menu = new ItemMenu("Paket 2");
        //menambahkan hero baru ke listSuperhero
        listItemMenu.add(menu);
        item_menu_adapters itemMenuAdapters = new item_menu_adapters(listItemMenu);
        item_menu.setAdapter(itemMenuAdapters);
        item_menu.setLayoutManager(new LinearLayoutManager(this));
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.action_home:
                fragment = new HomeFragment();
                break;
            case R.id.action_profile:
                fragment = new ProfileFragment();
                break;
        }
        return loadFragment(fragment);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

