package com.example.asus.boxdrawingview;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.asus.boxdrawingview.Fragment.DragAndDrawFragment;


public class DragAndDrawActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {

        return new DragAndDrawFragment();
    }
}
