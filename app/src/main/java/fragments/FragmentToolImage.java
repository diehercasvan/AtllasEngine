package fragments;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.edibca.atlasengine.R;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import class_project.General;


public class FragmentToolImage extends DialogFragment implements View.OnClickListener {
    private View view;
    private ImageView imageView = General.IMAGE_VIEW;
    private ImageView imageViewUpdate;
    private Activity activity;
    private DiscreteSeekBar sizeImage, rotateImage;
    private float fSizeImage = 0F;
    private LinearLayout.LayoutParams layoutParams;
    private ImageButton[] imageButtons;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tool_image, container, false);
        loadView();
        getDialog().setTitle(activity.getResources().getString(R.string.message_dialog_image));

        return view;
    }

    private void loadView() {
        activity = General.ACTIVITY;
        imageViewUpdate = (ImageView) view.findViewById(R.id.imgUpdate);

        fSizeImage = imageViewUpdate.getWidth();
        sizeImage = (DiscreteSeekBar) view.findViewById(R.id.sizeUpdateSize);
        rotateImage = (DiscreteSeekBar) view.findViewById(R.id.sizeUpdateRotate);
        imageButtons = new ImageButton[3];
        imageButtons[0] = (ImageButton) view.findViewById(R.id.btnUpdateImage);
        imageButtons[1] = (ImageButton) view.findViewById(R.id.btnDestroyImage);
        imageButtons[2] = (ImageButton) view.findViewById(R.id.btnPreviousToolImage);

        for (int i = 0; i < imageButtons.length; i++) {
            imageButtons[i].setOnClickListener(this);
        }


        loadImageUpdate();
        sizeImage.setNumericTransformer(new DiscreteSeekBar.NumericTransformer() {
            @Override
            public int transform(int value) {

                Log.i("Dato", "" + value);
                //imageViewUpdate
                imageViewUpdate.getLayoutParams().width = value * 10;
                imageViewUpdate.getLayoutParams().height = value * 10;
                imageViewUpdate.requestLayout();
                return value;
            }
        });
        rotateImage.setNumericTransformer(new DiscreteSeekBar.NumericTransformer() {

            @Override
            public int transform(int value) {
                imageViewUpdate.setRotation(value);
                return value;
            }
        });
    }

    private void loadImageUpdate() {

        imageViewUpdate.setImageDrawable(imageView.getDrawable());
        sizeImage.setProgress(imageView.getLayoutParams().width / 10);
        imageViewUpdate.setRotation(imageView.getRotation());
        rotateImage.setProgress((int) imageView.getRotation());


    }

    private void updateImage() {
        imageView.setRotation(imageViewUpdate.getRotation());
        imageView.getLayoutParams().width = imageViewUpdate.getLayoutParams().width;
        imageView.getLayoutParams().height = imageViewUpdate.getLayoutParams().height;
        imageView.requestLayout();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnUpdateImage:
                updateImage();
                dismiss();
                break;
            case R.id.btnDestroyImage:
                General.RELATIVE_LAYOUT.removeView(imageView);
                General.bValidateSelectionClick = true;
                dismiss();
                break;
            case R.id.btnPreviousToolImage:
                dismiss();
                break;
        }
    }
}
