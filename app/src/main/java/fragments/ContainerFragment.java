package fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


import com.edibca.atlasengine.*;


import class_project.*;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContainerFragment extends Fragment implements View.OnClickListener {

    private View view;
    private LinearLayout[] linearLayouts;
    private FloatingActionButton[] floatingActionButtons;
    private RelativeLayout containerColor;
    private String sListColor[];
    private Activity activity;

    public ContainerFragment() {
        // Required empty public constructor
        this.activity = General.ACTIVITY;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_container, container, false);
        loadView();
        return view;
    }

    private void loadView() {


        linearLayouts = new LinearLayout[2];
        linearLayouts[0] = (LinearLayout) view.findViewById(R.id.contToolBlackboard);
        linearLayouts[1] = (LinearLayout) view.findViewById(R.id.contCreateText);
        floatingActionButtons = new FloatingActionButton[3];
        floatingActionButtons[0] = (FloatingActionButton) view.findViewById(R.id.btnToolBlackboard);
        floatingActionButtons[1] = (FloatingActionButton) view.findViewById(R.id.btnToolImage);
        floatingActionButtons[2] = (FloatingActionButton) view.findViewById(R.id.btnToolText);
        for (int i = 0; i < floatingActionButtons.length; i++) {
            floatingActionButtons[i].setOnClickListener(this);
        }
        containerColor = (RelativeLayout) view.findViewById(R.id.containerColor);
        containerColor.addView(new Colors(activity).createListColor());
    }

    @Override
    public void onClick(View view) {
        int iSelect = 0;
        switch (view.getId()) {
            case R.id.btnToolBlackboard:
                iSelect = 1;

                break;
            case R.id.btnToolImage:
                iSelect = 2;
                break;
            case R.id.btnToolText:
                iSelect = 3;
                break;
        }
        selectionGroupItems(iSelect);

    }

    private void selectionGroupItems(int iSelection) {


        switch (iSelection) {
            case 1:
                if (linearLayouts[0].getVisibility() == View.GONE) {
                    linearLayouts[1].setVisibility(View.GONE);
                    linearLayouts[0].setVisibility(View.VISIBLE);
                } else {
                    linearLayouts[0].setVisibility(View.GONE);
                }
                break;
            case 2:
                loadImageGridView();
                break;
            case 3:
                if (linearLayouts[1].getVisibility() == View.GONE) {
                    linearLayouts[0].setVisibility(View.GONE);
                    linearLayouts[1].setVisibility(View.VISIBLE);
                } else {
                    linearLayouts[1].setVisibility(View.GONE);
                }
                break;

        }
    }
    private void loadImageGridView() {

        FragmentsAlert.setDialogFragment(0);
    }
}
