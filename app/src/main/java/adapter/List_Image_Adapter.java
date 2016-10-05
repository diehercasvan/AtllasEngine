package adapter;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.edibca.atlasengine.FullscreenImage;
import com.edibca.atlasengine.R;

import java.util.ArrayList;

import DTO.DTO_Images;
import class_project.General;
import fragments.FragmentsAlert;

/**
 * Created by DIEGO H CASALLAS on 4/10/2016.
 */

public class List_Image_Adapter extends ArrayAdapter<DTO_Images> {
    private final Activity context;
    private ArrayList<DTO_Images> arrayListImage;
    private View row;
    public DTO_Images dto_images,dtoImages;


    public List_Image_Adapter(Activity context, ArrayList<DTO_Images> arrayList) {
        super(context, R.layout.row_image_layout, arrayList);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.arrayListImage = arrayList;

    }

    public View getView(final int position, View view, ViewGroup parent) {

        dto_images = getItem(position);
        row = view;
        ViewHolder mainviewHolder = null;

        if (row == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            row = inflater.inflate(R.layout.row_image_layout, parent, false);
            mainviewHolder = new ViewHolder(row);
            row.setTag(mainviewHolder);
        } else {
            mainviewHolder = (ViewHolder) row.getTag();
        }


        mainviewHolder.txtDescription.setText(dto_images.getsDescription());
        mainviewHolder.scrollView.setTag("" + position);
        mainviewHolder.txtTitle.setText(dto_images.getsTitle());
        mainviewHolder.imageView.setImageResource(dto_images.getiURL());
        final ViewHolder finalMainviewHolder = mainviewHolder;
        mainviewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                General.DRAWABLE = null;
                General.DRAWABLE = finalMainviewHolder.imageView.getDrawable();
                Intent intent = new Intent(context, FullscreenImage.class);
                context.startActivity(intent);

                String sDrawable = General.DRAWABLE.toString();
                Log.i("drawable", sDrawable);
            }
        });

        mainviewHolder.imgBntInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                dtoImages =new DTO_Images();
                dtoImages.setiURL(getItem(position).getiURL());
                dtoImages.setsDescription(getItem(position).getsDescription());
                dtoImages.setsTitle(getItem(position).getsTitle());
                dtoImages.setiURLSignaling(getItem(position).getiURLSignaling());
                General.DTO_IMAGES=dtoImages;
                FragmentsAlert fragmentsAlert=new FragmentsAlert();
                fragmentsAlert.setDialogFragment(4);
            }
        });


        return row;

    }

    class ViewHolder {
        ScrollView scrollView;
        ImageView imageView;
        TextView txtTitle;
        TextView txtDescription;
        ImageView imgBntInfo;

        public ViewHolder(View v) {
            this.scrollView = (ScrollView) row.findViewById(R.id.scrollView);
            this.txtTitle = (TextView) row.findViewById(R.id.textTitle);
            this.imageView = (ImageView) row.findViewById(R.id.imgList);
            this.txtDescription = (TextView) row.findViewById(R.id.textDescription);
            this.imgBntInfo = (ImageView) row.findViewById(R.id.imgBtnInfoText);
        }


    }

}
