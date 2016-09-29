package fragments;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.edibca.atlasengine.R;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import class_project.General;


public class FragmentToolImage extends DialogFragment {
    private View view;
    private ImageView imageView= General.IMAGE_VIEW;
    private ImageView imageViewUpdate;
    private Activity activity;
    private DiscreteSeekBar sizeImage;
    private float fSizeImage=0F;
    private LinearLayout.LayoutParams  layoutParams;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_tool_image,container,false);
        loadView();
        getDialog().setTitle(activity.getResources().getString(R.string.message_dialog_image));

        return view;
    }
    private void loadView(){
        activity=General.ACTIVITY;
        imageViewUpdate=(ImageView)view.findViewById(R.id.imgUpdate);

        fSizeImage=imageViewUpdate.getWidth();
        sizeImage = (DiscreteSeekBar) view.findViewById(R.id.sizeUpdateImage);
        loadImageUpdate();
        sizeImage.setNumericTransformer(new DiscreteSeekBar.NumericTransformer() {
            @Override
            public int transform(int value) {




                return value;
            }
        });
    }
    private void loadImageUpdate(){

        imageViewUpdate.setImageDrawable(imageView.getDrawable());
        sizeImage.setProgress(imageView.getLayoutParams().width);



    }
}
