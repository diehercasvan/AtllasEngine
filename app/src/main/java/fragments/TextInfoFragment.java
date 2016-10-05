package fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.edibca.atlasengine.R;

import class_project.General;


public class TextInfoFragment extends Fragment {

    private View view;

    public TextInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_text_info,container,false);
        loadView();
        return view;
    }
    private void loadView(){
        TextView textView=(TextView)view.findViewById(R.id.textInfo);
        textView.setText(General.DTO_GENERAL.getsTextInfo());

    }

}
