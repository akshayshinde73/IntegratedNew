package me.riddhi.gada.olcademy;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class CreateCourse extends AppCompatActivity {

    String value;
    Button next;
    EditText tools_reqd, target_audience, course_ach;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_course);
        Intent i = getIntent();
        value = i.getStringExtra("CourseName");
        getSupportActionBar().setTitle(value);

        tools_reqd = (EditText) findViewById(R.id.tools_reqd);
        target_audience = (EditText) findViewById(R.id.target_audience);
        course_ach = (EditText) findViewById(R.id.course_ach);
        next = (Button) findViewById(R.id.btnTargetStudent);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hasText(tools_reqd) && hasText(target_audience) && hasText(course_ach))
                    getFragmentManager().beginTransaction().replace(android.R.id.content, new CourseStructureFragment()).commit();
            }
        });
    }

    public static class CourseStructureFragment extends Fragment {

        Button btnCourseStructure;

        @Override
        public void onCreate(final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.course_structure, container, false);
            btnCourseStructure = (Button) view.findViewById(R.id.btnCourseStructure);
            btnCourseStructure.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getFragmentManager().beginTransaction().replace(android.R.id.content, new LandingPageFragment()).commit();
                }
            });
            return view;
        }
    }

    public static class LandingPageFragment extends Fragment {

        Button btnLandingPage;
        EditText course_title, course_subtitle, course_description, inst_desc, prim_taught;
        Spinner spinner_lang, spinner_level;

        @Override
        public void onCreate(final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.landing_page, container, false);
            btnLandingPage = (Button) view.findViewById(R.id.btnLandingPage);
            course_title = (EditText) view.findViewById(R.id.course_title);
            course_subtitle = (EditText) view.findViewById(R.id.course_subtitle);
            course_description = (EditText) view.findViewById(R.id.course_description);
            inst_desc = (EditText) view.findViewById(R.id.inst_desc);
            prim_taught = (EditText) view.findViewById(R.id.prim_taught);
            btnLandingPage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (hasText(course_title) && hasText(course_subtitle) && hasText(course_description) && hasText(inst_desc) && hasText(prim_taught))
                        getFragmentManager().beginTransaction().replace(android.R.id.content, new PricesCouponsFragment()).commit();
                }
            });

            Spinner spinner_lang = (Spinner) view.findViewById(R.id.spinner_lang);
            Spinner spinner_level = (Spinner) view.findViewById(R.id.spinner_level);
            Spinner spinner_cat = (Spinner) view.findViewById(R.id.spinner_cat);

            ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.spinner_lang));
            myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_lang.setAdapter(myAdapter1);

            ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.spinner_level));
            myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_level.setAdapter(myAdapter2);

            ArrayAdapter<String> myAdapter3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.spinner_cat));
            myAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_cat.setAdapter(myAdapter3);

            return view;
        }
    }

    public static class PricesCouponsFragment extends Fragment {

        Button btnPricesCoupons;
        EditText course_price;

        @Override
        public void onCreate(final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.prices_coupons, container, false);
            btnPricesCoupons = (Button) view.findViewById(R.id.btnPricesCoupons);
            course_price = (EditText) view.findViewById(R.id.course_price);

            btnPricesCoupons.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (hasText(course_price))
                        getFragmentManager().beginTransaction().replace(android.R.id.content, new CurriculumFragment()).commit();
                }
            });

            Spinner spinner_currency = (Spinner) view.findViewById(R.id.spinner_currency);
            ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.spinner_currency));
            myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_currency.setAdapter(myAdapter);

            return view;
        }
    }

    public static class CurriculumFragment extends Fragment {

        Button btnCurriculum, course_platform;
        RadioButton radioButton;
        RadioGroup radioGroup;
        TextView txtSelectedPlatform, txtID;
        String platform;
        int radioId;

        @Override
        public void onCreate(final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.curriculum, container, false);
            btnCurriculum = (Button) view.findViewById(R.id.btnCurriculum);
            course_platform = (Button) view.findViewById(R.id.course_platform);
            radioGroup = (RadioGroup) view.findViewById(R.id.radioGroup);
            txtID = (TextView) view.findViewById(R.id.txtcourse_platformID);
            txtSelectedPlatform = (TextView) view.findViewById(R.id.txtSelectedPlatform);

            btnCurriculum.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getFragmentManager().beginTransaction().replace(android.R.id.content, new CourseSectionFragment()).commit();
                }
            });

            course_platform.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    radioId = radioGroup.getCheckedRadioButtonId();
                    radioButton = (RadioButton) view.findViewById(radioId);
                    switch (radioId) {
                        case R.id.radio_zoom:
                            platform =  "Zoom";
                            txtSelectedPlatform.setText("For the " + platform + "the session should be strictly of 40 mins. So Please make each lecture as per the session");
                            break;
                        case R.id.radio_zoompre:
                            platform = "Zoom Premium";
                            txtSelectedPlatform.setText("Selected Software is " + platform);
                            break;
                        case R.id.radio_ezTalks:
                            platform = "ezTalks";
                            txtSelectedPlatform.setText("For the " + platform + "the session should be strictly of 40 mins. So Please make each lecture as per the session");
                            break;
                        case R.id.radio_ezTalkspre:
                            platform = "ezTalks Premium";
                            txtSelectedPlatform.setText("Selected Software is " + platform);
                            break;
                        case R.id.radio_skype:
                            platform = "Skype";
                            txtSelectedPlatform.setText("For the " + platform + "the session should be strictly of 240 mins. So Please make each lecture as per the session");
                            break;
                    }
                    txtID.setText("Add " + platform + "Id: ");
                }
            });

            return view;
        }

    }

    public static class CourseSectionFragment extends Fragment {

        Button btnCourseSection, addNewSection;
        TextView txtclose;
        CardView sectionCard;
        LinearLayout newSection;
        View newCourseSection;

        @Override
        public void onCreate(final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.course_section, container, false);
            btnCourseSection = (Button) view.findViewById(R.id.btnCourseSection);
            addNewSection = (Button) view.findViewById(R.id.addNewSection);
            txtclose = (TextView) view.findViewById(R.id.txtclose);
            sectionCard = (CardView) view.findViewById(R.id.sectionCard);
            newSection = (LinearLayout) view.findViewById(R.id.newSection);

            txtclose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sectionCard.setVisibility(View.GONE);
                }
            });

            addNewSection.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    newCourseSection = getLayoutInflater().inflate(R.layout.course_section_card, newSection, true);
                }
            });

            btnCourseSection.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getFragmentManager().beginTransaction().replace(android.R.id.content, new CourseMessageFragment()).commit();
                }
            });

            return view;
        }
    }

    public static class CourseMessageFragment extends Fragment {

        Button btnPublishCourse;

        @Override
        public void onCreate(final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.course_comm, container, false);
            btnPublishCourse = (Button) view.findViewById(R.id.btnPublishCourse);

            btnPublishCourse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getFragmentManager().beginTransaction().replace(android.R.id.content, new CurriculumFragment()).commit();
                }
            });

            return view;
        }
    }

    public static boolean hasText(EditText editText) {
        String text = editText.getText().toString().trim();
        editText.setError(null);
        if (text.length() == 0) {
            editText.setError("This field is required.");
            return false;
        }
        return true;
    }

}
