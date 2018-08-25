package me.riddhi.gada.olcademy.fragments;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

import me.riddhi.gada.olcademy.CreateCourse;
import me.riddhi.gada.olcademy.MainActivity;
import me.riddhi.gada.olcademy.R;
import me.riddhi.gada.olcademy.Settings;

public class Teacher extends Fragment {

    Dialog myDialog;
    TextView settings, signout, txtclose, createCourse,out;
    Button btnCreate;
    EditText courseName;
    static TextView Name;
    private static final int RC_SIGN_IN = 007;
    private GoogleApiClient mGoogleApiClient;
   // boolean doubleBackToExitPressedOnce = false;
 //   Uri googlepic;
    //String gname=getArguments().getString("googlename");
    //String displayname=gname.toString();


    public static Teacher newInstance() {
        Teacher fragment = new Teacher();
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.frag_teacher, container, false);


        Name=(TextView ) view.findViewById(R.id.UserName);
        out=view.findViewById(R.id.logout);
        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivity.signout();
                getActivity().finish();
            }
        });

        myDialog = new Dialog(getContext());

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
        createCourse= (TextView) view.findViewById(R.id.createCourse);
        createCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowPopup(view);
            }
        });



      /*  String gname=getArguments().getString("googlename");
        String displayname=gname.toString();

       Toast.makeText(getActivity(),gname,Toast.LENGTH_SHORT).show();

        if (displayname!=null) {
            Name.setText(gname);
        }*/
        return view;
    }

    public void ShowPopup(View v) {
        myDialog.setContentView(R.layout.createcourse_popup);
        txtclose = (TextView) myDialog.findViewById(R.id.txtclose);
        btnCreate = (Button) myDialog.findViewById(R.id.btnCreate);
        courseName = (EditText) myDialog.findViewById(R.id.createCourseName);

        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = courseName.getText().toString();
                if(!value.isEmpty()){
                    Intent i = new Intent(getContext(), CreateCourse.class);
                    i.putExtra("CourseName", value);
                    startActivity(i);
                }
            }
        });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

    public static void setDetails(String value){

        Name.setText(value);
    }

}
