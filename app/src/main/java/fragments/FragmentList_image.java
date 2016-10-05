package fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.edibca.atlasengine.*;

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


    String[] itemname = {
            "Safari",
            "Camera",
            "Global",
            "FireFox",
            "UC Browser",
            "Android Folder"
    };

    Integer[] imgid = {
            R.drawable.img1s,
            R.drawable.img2s,
            R.drawable.img3,
            R.drawable.img4s,
            R.drawable.img5,
            R.drawable.img6s
    };

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
        for (int i = 0; i < imgid.length; i++) {
            dto_images = new DTO_Images();
            dto_images.setiURL(imgid[i]);
            dto_images.setsTitle(itemname[i]);
            dto_images.setsDescription(itemname[i]);
            arrayList.add(dto_images);
        }


        List_Image_Adapter adapter = new List_Image_Adapter(activity, arrayList);
        list = (ListView) view.findViewById(R.id.listImages);
        list.setAdapter(adapter);
    }

}
