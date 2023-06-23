package com.example.ejercicio2_modul5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ejercicio2_modul5.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    private Button button;
    private boolean isFragmentShown;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());


        mainBinding.buttonOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFragmentShown) {
                    closeFragment();
                } else {
                    openFragment();
                }
            }
        });
    }

    private void openFragment() {

        BlankFragment blankFragment = new BlankFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction =
                fragmentManager.beginTransaction().replace(mainBinding.container.getId(),
                        blankFragment, BlankFragment.class.getSimpleName());
        transaction.commit();
        mainBinding.buttonOpen.setText("Close");
        isFragmentShown = true;


    }

    private void closeFragment() {
        FragmentManager manager = getSupportFragmentManager();
        BlankFragment blankFragment = (BlankFragment) manager.findFragmentById(mainBinding.container.getId());

        if (blankFragment != null) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(blankFragment);
            transaction.commit();
            mainBinding.buttonOpen.setText("Open");
            isFragmentShown = false;
        }

    }
}