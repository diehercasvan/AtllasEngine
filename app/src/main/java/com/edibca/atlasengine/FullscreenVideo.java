package com.edibca.atlasengine;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.MediaController;
import android.widget.VideoView;

import class_project.General;

/**
 * Created by DIEGO CASALLAS on 6/07/2016.
 */
public class FullscreenVideo extends AppCompatActivity {
    private VideoView videoFullscreen;
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fullscreen_video);

        loadView();
    }
    public void loadView()
    {

        videoFullscreen=(VideoView)findViewById(R.id.videoFullscreen);
        mediaController = new MediaController(this);
        mediaController.setAnchorView(mediaController);
        videoFullscreen.setMediaController(mediaController);
        videoFullscreen.setVideoURI(Uri.parse(General.sUrl));
        videoFullscreen.seekTo(General.iSeconds);
        General.iSeconds=0;
        videoFullscreen.start();

    }

    @Override
    public void onStart() {
        super.onStart();
        this.getWindow().setWindowAnimations(R.style.DialogAnimation);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            General.iSeconds = videoFullscreen.getCurrentPosition();

        }
        return super.onKeyDown(keyCode, event);
    }
}
