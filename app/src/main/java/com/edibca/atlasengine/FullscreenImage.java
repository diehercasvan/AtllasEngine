package com.edibca.atlasengine;

import android.app.Activity;
import android.os.Bundle;

import class_project.General;
import class_project.ZoomImage;

/**
 * Created by DIEGO CASALLAS on 6/07/2016.
 */
public class FullscreenImage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.fullscreen_video);
        ZoomImage img = new ZoomImage(this);
        img.setImageDrawable(General.DRAWABLE);
        img.setMaxZoom(4f);
        setContentView(img);
    }


    @Override
    public void onStart() {
        super.onStart();
        this.getWindow().setWindowAnimations(R.style.DialogAnimation);
    }

}
