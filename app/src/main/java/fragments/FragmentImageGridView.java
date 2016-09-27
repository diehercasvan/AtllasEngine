package fragments;


import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.edibca.atlasengine.*;

import adapter.ImageAdapter;
import class_project.*;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentImageGridView extends DialogFragment {
    private View view;
    private Activity activity;
    int mNum;
    private int iListImagens[] = null;

    public FragmentImageGridView() {
        // Required empty public constructor
        this.activity = General.ACTIVITY;
        this.iListImagens = General.iImageGridView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNum = 1;

        // Pick a style based on the num.
        int style = DialogFragment.STYLE_NORMAL, theme = 0;
        switch ((mNum - 1) % 6) {
            case 1:
                style = DialogFragment.STYLE_NO_TITLE;
                break;
            case 2:
                style = DialogFragment.STYLE_NO_FRAME;
                break;
            case 3:
                style = DialogFragment.STYLE_NO_INPUT;
                break;
            case 4:
                style = DialogFragment.STYLE_NORMAL;
                break;
            case 5:
                style = DialogFragment.STYLE_NORMAL;
                break;
            case 6:
                style = DialogFragment.STYLE_NO_TITLE;
                break;
            case 7:
                style = DialogFragment.STYLE_NO_FRAME;
                break;
            case 8:
                style = DialogFragment.STYLE_NORMAL;
                break;
        }

        switch ((mNum - 1) % 6) {
            case 4:
                theme = android.R.style.Theme_Holo;
                break;
            case 5:
                theme = android.R.style.Theme_Holo_Light_Dialog;
                break;
            case 6:
                theme = android.R.style.Theme_Holo_Light;
                break;
            case 7:
                theme = android.R.style.Theme_Holo_Light_Panel;
                break;
            case 8:
                theme = android.R.style.Theme_Holo_Light;
                break;
        }
        theme = android.R.style.Theme_DeviceDefault_Light_NoActionBar;
        setStyle(style, theme);

    }

    @Override
    public void onStart() {
        super.onStart();
        getDialog().getWindow().setWindowAnimations(R.style.DialogAnimation);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_image_grid_view, container, false);
        loadView();
        return view;
    }

    private void loadView() {
        GridView gridview = (GridView) view.findViewById(R.id.gridviewImage);
        gridview.setAdapter(new ImageAdapter(General.ACTIVITY));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                int idImage = v.getId();

                General.alertToast("position" + idImage, 0);
                createImage(position);
            }
        });
    }

    private void createImage(int position) {
        float fSize = activity.getResources().getDimension(R.dimen.sizeImage);

        ImageView imageView = new ImageView(activity);
        imageView.setId(iListImagens[position]);
        imageView.setImageResource(iListImagens[position]);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams((int)fSize, (int)fSize);
        params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        imageView.setTag("image");
        //imageView.setOnClickListener(new ClickListener());
        imageView.setLayoutParams(params);

        General.RELATIVE_LAYOUT.addView(imageView);

    }


}
