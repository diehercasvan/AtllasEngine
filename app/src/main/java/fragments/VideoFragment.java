package fragments;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.edibca.atlasengine.FullscreenVideo;
import com.edibca.atlasengine.R;

import DTO.DTO_General;
import class_project.General;


public class VideoFragment extends Fragment  implements View.OnClickListener{

    private VideoView videoView;
    private ImageView btnFullscreen;
    private View view;
    private Activity activity= General.ACTIVITY;
    private DTO_General dto_general=General.DTO_GENERAL;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.fragment_video, container,false);

        loadVideo();
        return view;
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState==null){

            General.sUrl="android.resource://"+activity.getPackageName()+"/"+dto_general.getiUriVideo();
            General.iSeconds=0;


        }
    }


    @Override
    public void onResume() {
        super.onResume();

        loadVideo();
    }

    public void loadVideo() {


        videoView = (VideoView) view.findViewById(R.id.videoContainer);
        videoView.setMediaController(new MediaController(activity));
        videoView.setVideoURI(Uri.parse(General.sUrl));
        videoView.seekTo(General.iSeconds);
        videoView.start();

        btnFullscreen = (ImageView) view.findViewById(R.id.imgBtnFullScreenVideo);
        btnFullscreen.setOnClickListener(this);

    }

    public VideoFragment() {
        // Required empty public constructorz|
    }


    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.imgBtnFullScreenVideo:

                General.iSeconds=videoView.getCurrentPosition();
                Intent intent=new Intent(activity,FullscreenVideo.class);
                startActivity(intent);

                break;
        }
    }
}
