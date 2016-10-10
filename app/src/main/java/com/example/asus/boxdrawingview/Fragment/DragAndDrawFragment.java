package com.example.asus.boxdrawingview.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.boxdrawingview.R;

/**
 * Created by asus on 2016/10/9.
 */
public class DragAndDrawFragment extends Fragment {
    @Override
    public  View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle s)
    {

        View v = inflater.inflate(R.layout.activity_drag_and_draw,viewGroup,false);

        Log.d("HAHAHAH","重新打开view");
        return v;
    }
//    @Override
//    public void onCreate(Bundle s)
//    {
//        setRetainInstance(true);
//
//        super.onCreate(s);
//
//    }

}
