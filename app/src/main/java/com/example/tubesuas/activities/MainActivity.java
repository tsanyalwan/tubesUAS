package com.example.tubesuas.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.tubesuas.R;
import com.example.tubesuas.fragments.CameraFragment;
import com.example.tubesuas.fragments.GalleryFragment;
import com.example.tubesuas.fragments.ShareFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, CameraFragment.OnFragmentInteractionListener, GalleryFragment.OnFragmentInteractionListener, ShareFragment.OnFragmentInteractionListener {


    private static final int CAMERA_REQUEST = 1337;
    TextView teks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teks=(TextView)findViewById(R.id.font);
        Typeface customfont=Typeface.createFromAsset(getAssets(), "font/knightbrush.otf");
        teks.setTypeface(customfont);

        loadFragment(new CameraFragment());
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        // beri listener pada saat item/menu bottomnavigation terpilih
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
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
//        Fragment fragment = null;
//        switch (menuItem.getItemId()) {
//            case R.id.action_camera:
//                fragment = new CameraFragment();
//                break;
//            case R.id.action_gallery:
//                fragment = new GalleryFragment();
//                break;
//            case R.id.action_share:
//                fragment = new ShareFragment();
//                break;
//        }
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onButtonClicked() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new CameraFragment())
                .commit();
    }


    @Override
    public void onCameraClicked() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent,CAMERA_REQUEST);
    }

}

