package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import class_project.*;

/**
 * Created by DIEGO CASALLAS  on 7/08/2016.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private int iListItems[]= General.iImageGridView;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        return iListItems.length;
    }

    @Override
    public Object getItem(int i) {
        return iListItems[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ImageView imageView;
        if (view == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) view;
        }

        imageView.setImageResource(iListItems[position]);
        return imageView;
    }


}
