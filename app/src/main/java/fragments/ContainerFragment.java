package fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.edibca.atlasengine.My_Canvas;
import com.edibca.atlasengine.R;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import class_project.ClickListener;
import class_project.Colors;
import class_project.General;
import class_project.Screen_Share;


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
    private ImageButton[] buttons;
    private EditText edtNewText;
    private String sDatanewtext;
    private My_Canvas my_canvas;
    private DiscreteSeekBar sizePoint;
    //Button  blackboard
    private ImageButton[] imageButtons;

    //Class screen
    private Screen_Share screen_share;

    public ContainerFragment() {
        // Required empty public constructor
        this.activity = General.ACTIVITY;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_container, container, false);
        loadView();
        loadButton();
        return view;
    }

   private  void loadButton(){
       imageButtons = new ImageButton[3];
       imageButtons[0] = (ImageButton) view.findViewById(R.id.btnWrite);
       imageButtons[1] = (ImageButton) view.findViewById(R.id.btnCleanBlackboard);
       imageButtons[2] = (ImageButton) view.findViewById(R.id.btnDraft);
       for (int i = 0; i < imageButtons.length; i++) {

           imageButtons[i].setOnClickListener(this);
       }
       buttons = new ImageButton[1];
       edtNewText = (EditText) view.findViewById(R.id.edtNewText);
       buttons[0] = (ImageButton) view.findViewById(R.id.btnOk);
       for (int i = 0; i < buttons.length; i++) {
           buttons[i].setOnClickListener(this);
       }
       floatingActionButtons = new FloatingActionButton[4];
       floatingActionButtons[0] = (FloatingActionButton) view.findViewById(R.id.btnToolBlackboard);
       floatingActionButtons[1] = (FloatingActionButton) view.findViewById(R.id.btnToolImage);
       floatingActionButtons[2] = (FloatingActionButton) view.findViewById(R.id.btnToolText);
       floatingActionButtons[3] = (FloatingActionButton) view.findViewById(R.id.btnToolShare);
       for (int i = 0; i < floatingActionButtons.length; i++) {
           floatingActionButtons[i].setOnClickListener(this);
       }
   }
    private void loadView() {

        //Load view blackboard
        my_canvas = (My_Canvas) view.findViewById(R.id.Canvas);
        sizePoint = (DiscreteSeekBar) view.findViewById(R.id.sizePoint);
        sizePoint.setNumericTransformer(new DiscreteSeekBar.NumericTransformer() {
            @Override
            public int transform(int value) {
                //
                my_canvas.setSizePoint(value);
                return value;
            }
        });


        linearLayouts = new LinearLayout[2];
        linearLayouts[0] = (LinearLayout) view.findViewById(R.id.contToolBlackboard);
        linearLayouts[1] = (LinearLayout) view.findViewById(R.id.contCreateText);
        containerColor = (RelativeLayout) view.findViewById(R.id.containerColor);
        containerColor.addView(new Colors(activity,my_canvas).createListColor());
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
            case R.id.btnToolShare:
                iSelect = 4;
                break;

            case R.id.btnOk:
                sDatanewtext = edtNewText.getText().toString();
                Pattern pattern = Pattern.compile("^\\s");
                Matcher matcher = pattern.matcher(sDatanewtext);
                if (sDatanewtext.equals("") || sDatanewtext.length() == 0 || matcher.find()) {
                    General.alertToast(R.string.message_0, 1);
                } else {
                    createTextView();

                }

                return;
            case R.id.btnWrite:
                my_canvas.setWrite();
                return;
            case R.id.btnCleanBlackboard:
                my_canvas.setClean();
                return;
            case R.id.btnDraft:
                my_canvas.setDraft();
                return;
        }
        selectionGroupItems(iSelect);

    }

    private void createTextView() {
        TextView newTextView = new TextView(activity);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        newTextView.setId(General.iContIdImage);
        newTextView.setText(sDatanewtext);
        newTextView.setTag("text");
        newTextView.setTypeface(null);
        newTextView.setBackground(null);
        params.setMargins(3, 3, 3, 3);
        edtNewText.setText("");
        newTextView.setPadding(3, 3, 3, 3);
        newTextView.setLayoutParams(params);
        newTextView.setOnClickListener(new ClickListener());

        //Toast.makeText(activity,"font Size "+newTextView.getTextSize(),Toast.LENGTH_LONG).show();
        General.RELATIVE_LAYOUT.addView(newTextView);
        linearLayouts[1].setVisibility(View.GONE);
        hideSoftKeyboard();
        General.iContIdImage++;

    }

    public void hideSoftKeyboard() {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(General.RELATIVE_LAYOUT.getWindowToken(), 0);
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
                linearLayouts[0].setVisibility(View.GONE);
                linearLayouts[1].setVisibility(View.GONE);
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
            case 4:
                screen_share= new Screen_Share(General.RELATIVE_LAYOUT_SCREEN);
                screen_share.createScreen();
                break;

        }
    }

    private void loadImageGridView() {

        FragmentsAlert.setDialogFragment(0);
    }
}
