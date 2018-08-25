package me.riddhi.gada.olcademy.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;

import me.riddhi.gada.olcademy.R;
import me.riddhi.gada.olcademy.Settings;

public class Student extends Fragment {
    private float[] yData = {25.3f, 10.6f, 66.76f, 44.32f, 46.01f, 16.89f, 23.9f};
    private String[] xData = {"Python", "Data Science", "Java", "Web Dev", "Android", "CSS", "XML"};
    PieChart pieChart;
    TextView settings, signout;
    public static Student newInstance() {
        Student fragment = new Student();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         final View view = inflater.inflate(R.layout.frag_student, container, false);



         pieChart = (PieChart) view.findViewById(R.id.pieChart);
         pieChart.setHoleRadius(50f);
         pieChart.setTransparentCircleAlpha(0);
         pieChart.setDrawEntryLabels(true);
         pieChart.setRotationEnabled(true);
         addDataSet(pieChart);

         pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
             @Override
             public void onValueSelected(Entry e, Highlight h) {

                 int pos1 = e.toString().indexOf("y: ");
                 String assg = e.toString().substring(pos1 + 3);

                 for (int i=0; i<yData.length; i++){
                     if (yData[i] == Float.parseFloat(assg)){
                         pos1 = i;
                         break;
                     }
                 }

                 String course = xData[pos1];
                 Toast.makeText(getContext(), "Courses: "+ course + "\n" + "Assg: " + assg , Toast.LENGTH_SHORT).show();

             }

             @Override
             public void onNothingSelected() {

             }
         });
         settings = (TextView) view.findViewById(R.id.txtSettings);
         settings.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 startActivity(new Intent(getContext(), Settings.class));
             }
         });
         signout = (TextView) view.findViewById(R.id.txtSignout);
         signout.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 startActivity(new Intent(getContext(), Settings.class));
             }
         });

         return view;
    }

    private void addDataSet(PieChart pieChart) {

        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        ArrayList<String> xEntrys = new ArrayList<>();

        for (int i=0; i< yData.length; i++)
            yEntrys.add(new PieEntry(yData[i], i));

        for (int i=1; i<xData.length; i++)
            xEntrys.add(xData[i]);

        PieDataSet pieDataSet = new PieDataSet( yEntrys, "Courses");
        pieDataSet.setSliceSpace(5);
        pieDataSet.setValueTextSize(12);

        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.BLUE);
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        colors.add(Color.CYAN);
        colors.add(Color.YELLOW);
        colors.add(Color.MAGENTA);
        colors.add(Color.GRAY);

        pieDataSet.setColors(colors);

        Legend legend = pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);

        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();

    }



}