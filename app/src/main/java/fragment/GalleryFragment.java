package fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.edibca.atlasengine.R;

import java.util.ArrayList;

import DTO.DTO_Images;
import General.General;
import adapter.ListAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment {
    private ImageView imageView;
    private final int images_id[] = {
            R.drawable.logo,
            R.drawable.logo2,
            R.drawable.logo,
            R.drawable.logo2,
            R.drawable.logo,
            R.drawable.logo,
            R.drawable.logo2

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
    private void loadView(){
        imageView=(ImageView)view.findViewById(R.id.imgContainerList);
        imageView.setImageResource(images_id[0]);
    }

    private void initViews() {

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerImage);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList listImage = loadData();
        ListAdapter adapter = new ListAdapter(context, listImage,imageView);
        recyclerView.setAdapter(adapter);

    }

    private ArrayList loadData() {

        ArrayList list_images = new ArrayList<>();
        for (int i = 0; i < images_id.length; i++) {
            DTO_Images dto_images = new DTO_Images();
            dto_images.setiURL(images_id[i]);

            list_images.add(dto_images);
        }

        return  list_images;
    }
}
