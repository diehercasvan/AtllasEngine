package fragments;


import android.app.Activity;
import android.app.DialogFragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.edibca.atlasengine.*;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import class_project.Colors;
import class_project.General;

public class FragmentToolText extends DialogFragment implements View.OnClickListener {
    private View view;
    private TextView textView = General.TEXT_VIEW;
    private ImageButton[] imageButtons;
    private EditText edtUpdateText;
    private DiscreteSeekBar sizeFont;
    private RelativeLayout containerColor;
    private boolean bvalidateBold = true, bValidateItalic = true;
    private int iListTypeFace[] = {Typeface.BOLD, Typeface.ITALIC, Typeface.BOLD_ITALIC};
    private float fSizeFont=0F;
    private Activity activity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragmen_tool_text, container, false);

        loadView();
        getDialog().setTitle(activity.getResources().getString(R.string.message_dialog_text));
        return view;
    }

    private void loadView() {

        containerColor = (RelativeLayout) view.findViewById(R.id.containerColor);
        activity=General.ACTIVITY;

        imageButtons = new ImageButton[5];
        imageButtons[0] = (ImageButton) view.findViewById(R.id.btnBoldFont);
        imageButtons[1] = (ImageButton) view.findViewById(R.id.btnItalicsFont);
        imageButtons[2] = (ImageButton) view.findViewById(R.id.btnPrevious);
        imageButtons[3] = (ImageButton) view.findViewById(R.id.btnUpdateText);
        imageButtons[4] = (ImageButton) view.findViewById(R.id.btnDestroyText);

        for (int i = 0; i < imageButtons.length; i++) {
            imageButtons[i].setOnClickListener(this);
        }

        edtUpdateText = (EditText) view.findViewById(R.id.edtUpdateText);
        sizeFont = (DiscreteSeekBar) view.findViewById(R.id.sizeUpdateFont);

        containerColor.addView(new Colors(edtUpdateText,activity).createListColor());
        loadDataObjectText();
        sizeFont.setNumericTransformer(new DiscreteSeekBar.NumericTransformer() {
            @Override
            public int transform(int value) {
                edtUpdateText.setTextSize(TypedValue.COMPLEX_UNIT_SP,value);


                return value;
            }
        });
    }

    private void loadDataObjectText() {
        fSizeFont=textView.getTextSize();
        edtUpdateText.setText(textView.getText());
        sizeFont.setProgress((int)textView.getTextSize()-10);
        edtUpdateText.setTextSize(fSizeFont);
        General.alertToast("text "+textView.getTextSize(),0);
        if (textView.getTypeface() != null) {
            if (textView.getTypeface().isBold() && textView.getTypeface().isItalic()) {
                bvalidateBold = false;
                bValidateItalic = false;
            } else if (textView.getTypeface().isBold()) {
                bvalidateBold = false;
            } else if (textView.getTypeface().isItalic()) {
                bValidateItalic = false;
            }

        } else {

            bvalidateBold = true;
            bValidateItalic = true;

        }
        edtUpdateText.setTypeface(textView.getTypeface());
        edtUpdateText.setTextColor(textView.getTextColors());

        fSizeFont=0F;


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnBoldFont:

                if (bvalidateBold) {

                    setStyleBold();
                    bvalidateBold = false;

                } else {
                    setStyleBold();
                    bvalidateBold = true;
                }


                break;
            case R.id.btnItalicsFont:
                if (bValidateItalic) {

                    setStyleItalic();
                    bValidateItalic = false;

                } else {
                    setStyleItalic();
                    bValidateItalic = true;
                }


                break;
            case R.id.btnPrevious:
                dismiss();
                break;
            case R.id.btnUpdateText:
                loadViewText();
                dismiss();
                break;
            case R.id.btnDestroyText:
                General.RELATIVE_LAYOUT.removeView(textView);
                General.bValidateSelectionClick = true;
                dismiss();
                break;
        }

    }

    private void setStyleBold() {


        if (bvalidateBold) {
            if (edtUpdateText.getTypeface() == null) {
                edtUpdateText.setTypeface(null, Typeface.BOLD);
            } else {
                if (!edtUpdateText.getTypeface().isItalic()) {
                    edtUpdateText.setTypeface(null, Typeface.BOLD);
                } else {
                    edtUpdateText.setTypeface(null, Typeface.BOLD_ITALIC);
                }
            }
        } else {
            if (edtUpdateText.getTypeface().isItalic()) {
                edtUpdateText.setTypeface(null, Typeface.ITALIC);
            } else {
                edtUpdateText.setTypeface(null);
            }
        }

    }

    @Override
    public void onStart() {
        super.onStart();
        getDialog().getWindow().setWindowAnimations(R.style.DialogAnimation);
    }

    private void setStyleItalic() {


        if (bValidateItalic) {
            if (edtUpdateText.getTypeface() == null) {
                edtUpdateText.setTypeface(null, Typeface.ITALIC);
            } else {
                if (!edtUpdateText.getTypeface().isBold()) {
                    edtUpdateText.setTypeface(null, Typeface.ITALIC);
                } else {
                    edtUpdateText.setTypeface(null, Typeface.BOLD_ITALIC);
                }
            }
        } else {
            if (edtUpdateText.getTypeface().isBold()) {
                edtUpdateText.setTypeface(null, Typeface.BOLD);
            } else {
                edtUpdateText.setTypeface(null);
            }
        }

    }

    private void loadViewText() {
        fSizeFont=edtUpdateText.getTextSize()-5;
        textView.setTypeface(edtUpdateText.getTypeface());
        textView.setTextSize(fSizeFont);
        textView.setText(edtUpdateText.getText());
        textView.setTextColor(edtUpdateText.getTextColors());
        General.TEXT_VIEW=null;

    }
}
