package class_project;



import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.edibca.atlasengine.*;


/**
 * Created by DIEGOH on 3/08/2016.
 */
public class ClickListener implements View.OnClickListener {


    @Override
    public void onClick(View view) {
        String sTag = view.getTag().toString();
        switch (sTag) {
            case "text":
                if (General.bValidateSelectionClick) {
                    General.sTag="text";
                    int iID = view.getId();
                    TextView textView = (TextView) view.findViewById(iID);
                    textView.setBackgroundColor(General.ACTIVITY.getResources().getColor(R.color.colorAccent));
                    textView.setOnTouchListener(new MyTouchListener());
                    General.TEXT_VIEW = textView;
                    General.bValidateSelectionClick=false;


                }
                break;
            case "image":
                if (General.bValidateSelectionClick) {
                    General.sTag="image";
                    int iID = view.getId();
                    ImageView imageView = (ImageView) view.findViewById(iID);
                    imageView.setBackgroundColor(General.ACTIVITY.getResources().getColor(R.color.colorAccent));
                    imageView.setOnTouchListener(new MyTouchListener());
                    General.IMAGE_VIEW = imageView;
                    General.bValidateSelectionClick=false;


                }
                break;
        }


    }
}
