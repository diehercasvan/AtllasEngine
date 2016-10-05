package fragments;


import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.edibca.atlasengine.R;

import DTO.DTO_Images;
import class_project.Animation_general;
import class_project.General;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCardViewDescription extends DialogFragment implements View.OnClickListener {

    private View view;
    private ImageView [] imageViews;
    private TextView[] textViews;
    private DTO_Images dto;
    private Animation_general animation_general;
    int mNum;


    public FragmentCardViewDescription() {
        // Required empty public constructor
        this.dto = General.DTO_IMAGES;
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

        view = inflater.inflate(R.layout.fragment_card_view_description, container, false);
        // Inflate the layout for this fragment
        loadView();
        return view;
    }

    private void loadView() {
        textViews = new TextView[2];
        textViews[0] = (TextView) view.findViewById(R.id.textTitleDescription);
        textViews[1] = (TextView) view.findViewById(R.id.textDescription);


        textViews[0].setText(dto.getsTitle());
        textViews[1].setText(dto.getsDescription());
        imageViews=new ImageView[3];
        imageViews[0] = (ImageView) view.findViewById(R.id.imgListDescription);
        imageViews[0].setImageResource(dto.getiURL());

        imageViews[1] = (ImageView) view.findViewById(R.id.imgListSignal);
        imageViews[1].setImageResource(dto.getiURLSignaling());
        imageViews[2] = (ImageView) view.findViewById(R.id.imgBtnSignal);

        imageViews[2].setOnClickListener(this);

        animation_general = new Animation_general();


    }

    @Override
    public void onClick(View view) {

        if (imageViews[1].getVisibility() == View.GONE) {
            imageViews[1].startAnimation(animation_general.selectAnimation(0));
            imageViews[1].setVisibility(View.VISIBLE);
            imageViews[2].setRotation(180);


        } else {

            imageViews[1].startAnimation(animation_general.selectAnimation(1));
            imageViews[1].setVisibility(View.GONE);
            imageViews[2].setRotation(0);
        }

    }
}
