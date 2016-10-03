package fragments;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.edibca.atlasengine.FullscreenImage;
import com.edibca.atlasengine.R;

import java.util.ArrayList;

import DTO.DTO_Images;
import class_project.*;
import adapter.ListAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment implements View.OnClickListener {
    private ImageView[] imageViews;
    private Animation_general animation_general;
    private Activity activity = General.ACTIVITY;
    private RecyclerView recyclerView;
    private final int images_id[] = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6
    };
    private final int images_signaling_id[] = {
            R.drawable.img1s,
            R.drawable.img2s,
            R.drawable.img3s,
            R.drawable.img4s,
            R.drawable.img5s,
            R.drawable.img6s

    };
    private View view;
    private Context context = General.CONTEXT;

    public GalleryFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_gallery, container, false);
        loadView();
        initViews();

        return view;
    }

    private void loadView() {

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerImage);

        imageViews = new ImageView[4];
        imageViews[0] = (ImageView) view.findViewById(R.id.BtnMultiImgText);
        imageViews[1] = (ImageView) view.findViewById(R.id.BtnMultiImg);

        imageViews[2] = (ImageView) view.findViewById(R.id.multiImgContainer);
        imageViews[3] = (ImageView) view.findViewById(R.id.multiImgTexts);


        imageViews[2].setImageResource(images_id[0]);
        imageViews[3].setImageResource(images_signaling_id[0]);
        imageViews[0].setOnClickListener(this);
        imageViews[1].setOnClickListener(this);
        imageViews[2].setOnClickListener(this);

        animation_general = new Animation_general();
    }

    private void initViews() {

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerImage);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList listImage = loadData();
        ListAdapter adapter = new ListAdapter(context, listImage, imageViews);
        recyclerView.setAdapter(adapter);

    }

    private ArrayList loadData() {

        ArrayList list_images = new ArrayList<>();

        for (int i = 0; i < images_id.length; i++) {
            DTO_Images dto_images = new DTO_Images();
            dto_images.setiURL(images_id[i]);
            dto_images.setiURLSignaling(images_signaling_id[i]);
            list_images.add(dto_images);
        }

        return list_images;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.BtnMultiImgText:

                if (imageViews[3].getVisibility() == View.GONE) {

                    imageViews[3].startAnimation(animation_general.selectAnimation(0));
                    imageViews[3].setVisibility(View.VISIBLE);
                    imageViews[0].setRotation(180);
                    imageViews[0].setBackgroundColor(activity.getResources().getColor(R.color.colorAccent));


                } else  if (imageViews[3].getVisibility() == View.VISIBLE) {

                    imageViews[3].startAnimation(animation_general.selectAnimation(1));
                    imageViews[3].setVisibility(View.GONE);
                    imageViews[0].setRotation(0);
                    imageViews[0].setBackgroundColor(Color.TRANSPARENT);
                }
                break;
            case R.id.BtnMultiImg:

                if (recyclerView.getVisibility() == View.GONE) {
                    recyclerView.startAnimation(animation_general.selectAnimation(4));
                    recyclerView.setVisibility(View.VISIBLE);
                    imageViews[1].setRotation(180);
                    imageViews[1].setBackgroundColor(activity.getResources().getColor(R.color.colorAccent));


                } else  if (recyclerView.getVisibility() == View.VISIBLE) {

                    recyclerView.startAnimation(animation_general.selectAnimation(5));
                    recyclerView.setVisibility(View.GONE);
                    imageViews[1].setRotation(0);
                    imageViews[1].setBackgroundColor(Color.TRANSPARENT);
                }
                break;
            case R.id.multiImgContainer:
                General.DRAWABLE = null;
                General.DRAWABLE = imageViews[2].getDrawable();
                Intent intent = new Intent(activity, FullscreenImage.class);
                activity.startActivity(intent);

                String sDrawable = General.DRAWABLE.toString();
                Log.i("drawable", sDrawable);

                break;


        }
    }
}
