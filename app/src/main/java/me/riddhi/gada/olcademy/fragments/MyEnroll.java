package me.riddhi.gada.olcademy.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.riddhi.gada.olcademy.R;

public class MyEnroll extends Fragment {
    public static MyEnroll newInstance() {
        MyEnroll fragment = new MyEnroll();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_my_enroll, container, false);
    }
}
