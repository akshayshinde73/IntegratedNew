package me.riddhi.gada.olcademy.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;
import me.riddhi.gada.olcademy.R;
import me.riddhi.gada.olcademy.adapter.*;
import me.riddhi.gada.olcademy.model.*;

public class Homepage extends Fragment {

    ArrayList<SectionData> allSampleData;
    private static int currentPage = 0;
    private ViewPager mPager1,mPager2;
    private static final Integer[] Ads= {R.drawable.colors,R.drawable.olcademy,R.drawable.colors,R.drawable.olcademy,};
    private ArrayList<Integer> AdsArray = new ArrayList<Integer>();
    private String Courses[] = {"Python", "Django", "Web Design", "Android", "MEAN Stack"};
    int courseImages[]= {R.drawable.web_design,R.drawable.web_design_course,R.drawable.web_dev, R.drawable.web_development,R.drawable.web_design2};

    public static Homepage newInstance() {
        Homepage fragment = new Homepage();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_home, container, false);
        allSampleData = new ArrayList<SectionData>();
        createDummyData();
        RecyclerView my_recycler_view = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        my_recycler_view.setHasFixedSize(true);
        RecyclerViewData adapter = new RecyclerViewData(getContext(), allSampleData);
        my_recycler_view.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        my_recycler_view.setAdapter(adapter);

        for(int i=0;i<Ads.length;i++)
            AdsArray.add(Ads[i]);

        // AdSlider1
        mPager1 = (ViewPager) view.findViewById(R.id.pager1);
        mPager1.setAdapter(new AdSlider(getContext(),AdsArray));
        CircleIndicator indicator1 = (CircleIndicator) view.findViewById(R.id.indicator1);
        indicator1.setViewPager(mPager1);

        // AdSlider2
        mPager2 = (ViewPager) view.findViewById(R.id.pager2);
        mPager2.setAdapter(new AdSlider(getContext(),AdsArray));
        CircleIndicator indicator2 = (CircleIndicator) view.findViewById(R.id.indicator2);
        indicator2.setViewPager(mPager2);

        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == Ads.length) {
                    currentPage = 0;
                }
                mPager1.setCurrentItem(currentPage++, true);
                mPager2.setCurrentItem(currentPage, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2500, 2500);

        return view;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void createDummyData() {
        for (int i = 1; i <= 5; i++) {
            SectionData dm = new SectionData();
            dm.setHeaderTitle("Section " + i);
            ArrayList<SingleItem> singleItem = new ArrayList<SingleItem>();
            for (int j = 0; j < 5; j++)
                singleItem.add(new SingleItem(Courses[j], courseImages[j], "URL " + j));
            dm.setAllItemsInSection(singleItem);
            allSampleData.add(dm);
        }

    }

}
