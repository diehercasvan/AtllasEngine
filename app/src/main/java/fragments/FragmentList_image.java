package fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.edibca.atlasengine.R;
import java.util.ArrayList;
import DTO.DTO_Images;
import adapter.List_Image_Adapter;
import class_project.General;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentList_image extends Fragment {

    private View view;
    private ListView list;
    private Activity activity = General.ACTIVITY;
    private ArrayList<DTO_Images> arrayList;
    private DTO_Images dto_images;
    private ArrayList<Integer> iImgId=General.DTO_GENERAL.getiUriImages();
    private ArrayList<Integer> iImgSignaling=General.DTO_GENERAL.getiUriImagesSignal();

    private ArrayList<String> sDescription=General.DTO_GENERAL.getsDescriptions();
    private ArrayList<String> sTitle=General.DTO_GENERAL.getsTitles();




    public FragmentList_image() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list_image, container, false);

        loadView();
        return view;
    }

    private void loadView() {
        arrayList =new ArrayList<>();
        for (int i = 0; i < iImgId.size(); i++) {
            dto_images = new DTO_Images();
            dto_images.setiURL(iImgId.get(i));
            dto_images.setsTitle(sTitle.get(i));
            dto_images.setsDescription(sDescription.get(i));
            dto_images.setiURLSignaling(iImgSignaling.get(i));
            arrayList.add(dto_images);
        }


        List_Image_Adapter adapter = new List_Image_Adapter(activity, arrayList);
        list = (ListView) view.findViewById(R.id.listImages);
        list.setAdapter(adapter);
    }

}
