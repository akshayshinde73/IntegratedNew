package me.riddhi.gada.olcademy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class CourseDesc extends AppCompatActivity {

    String value;
    TextView name;
    VideoView demoVideo;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_desc);
        Intent i = getIntent();
        value = i.getStringExtra("CourseName");
        name = (TextView) findViewById(R.id.course_name);
        name.setText(value);

        demoVideo = (VideoView) findViewById(R.id.video_view);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.demo_video ;
        Uri uri = Uri.parse(videoPath);
        demoVideo.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        demoVideo.setMediaController(mediaController);
        mediaController.setAnchorView(demoVideo);

    }


}
