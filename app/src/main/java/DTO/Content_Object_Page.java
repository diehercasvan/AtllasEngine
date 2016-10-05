package DTO;

import android.app.Activity;

import com.edibca.atlasengine.R;

import java.util.ArrayList;

import class_project.General;

/**
 * Created by DIEGO H CASALLAS on 5/10/2016.
 */

public class Content_Object_Page {

    private DTO_General dto_general = new DTO_General();
    private Activity activity = General.ACTIVITY;
    private ArrayList<Integer> images_id = new ArrayList<>();
    private ArrayList<Integer> images_signaling_id =new ArrayList<>();
    private ArrayList<String> textDescription =new ArrayList<>();
    private ArrayList<String> textTitle =new ArrayList<>();


    public void loadObjectPage(int iSelectionPage) {
        images_signaling_id.clear();
        images_id.clear();
        switch (iSelectionPage) {
            case 0:
                dto_general.setbImgIcon(true);
                dto_general.setbTextIcon(true);
                dto_general.setiUriVideo(R.raw.ateroesclerosis);
                dto_general.setsTextInfo(activity.getResources().getString(R.string.lorem_ipsum));
                dto_general.setiUriImage(R.drawable.img1);
                dto_general.setiUriImageSignal(R.drawable.img1s);

                break;
            case 1:
                dto_general.setbImgIcon(false);
                dto_general.setbTextIcon(true);
                dto_general.setsTextInfo(activity.getResources().getString(R.string.lorem_ipsum));
                dto_general.setiUriImage(R.drawable.img1);
                dto_general.setiUriImageSignal(R.drawable.img1s);
                break;
            case 2:
                images_id.add(R.drawable.img1);
                images_id.add(R.drawable.img2);
                images_id.add(R.drawable.img3);
                images_id.add(R.drawable.img4);
                images_id.add(R.drawable.img5);
                images_id.add(R.drawable.img6);

                images_signaling_id.add(R.drawable.img1s);
                images_signaling_id.add(R.drawable.img2s);
                images_signaling_id.add(R.drawable.img3s);
                images_signaling_id.add(R.drawable.img4s);
                images_signaling_id.add(R.drawable.img5s);
                images_signaling_id.add(R.drawable.img5s);


                dto_general.setbImgIcon(false);
                dto_general.setbTextIcon(true);
                dto_general.setsTextInfo(activity.getResources().getString(R.string.lorem_ipsum));
                dto_general.setiUriImages(images_id);
                dto_general.setiUriImagesSignal(images_signaling_id);
                break;
            case 3:
                images_id.add(R.drawable.img1);
                images_id.add(R.drawable.img2);
                images_id.add(R.drawable.img3);
                images_id.add(R.drawable.img4);
                images_id.add(R.drawable.img5);
                images_id.add(R.drawable.img6);

                images_signaling_id.add(R.drawable.img1s);
                images_signaling_id.add(R.drawable.img2s);
                images_signaling_id.add(R.drawable.img3s);
                images_signaling_id.add(R.drawable.img4s);
                images_signaling_id.add(R.drawable.img5s);
                images_signaling_id.add(R.drawable.img5s);

                textDescription.add(activity.getResources().getString(R.string.lorem_ipsum));
                textDescription.add(activity.getResources().getString(R.string.lorem_ipsum));
                textDescription.add(activity.getResources().getString(R.string.lorem_ipsum));
                textDescription.add(activity.getResources().getString(R.string.lorem_ipsum));
                textDescription.add(activity.getResources().getString(R.string.lorem_ipsum));
                textDescription.add(activity.getResources().getString(R.string.lorem_ipsum));

                String sTitles[] =activity.getResources().getStringArray(R.array.title);

                for(int i=0;i<sTitles.length;i++){
                    textTitle.add(sTitles[i]);
                }

                dto_general.setbImgIcon(false);
                dto_general.setbTextIcon(false);
                dto_general.setsTextInfo(activity.getResources().getString(R.string.lorem_ipsum));
                dto_general.setiUriImages(images_id);
                dto_general.setiUriImagesSignal(images_signaling_id);
                dto_general.setsDescriptions(textDescription);
                dto_general.setsTitles(textTitle);


                break;
        }

        General.DTO_GENERAL = dto_general;
    }
}
