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
import class_project.General;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCardViewDescription extends DialogFragment implements View.OnClickListener {

    private View view;
    private ImageView imageView;
    private TextView[] textViews;
    private DTO_Images dto;
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
        imageView = (ImageView) view.findViewById(R.id.imgListDescription);
        textViews[0].setText(dto.getsTitle());
        textViews[1].setText(dto.getsDescription());
        imageView.setImageResource(dto.getiURL());
    }

    @Override
    public void onClick(View view) {


    }
}
