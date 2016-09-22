package adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.edibca.atlasengine.R;

import java.util.ArrayList;

import DTO.DTO_Images;

/**
 * Created by DIEGO CASALLAS  on 22/09/2016.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private ArrayList<DTO_Images> listImage;
    private Context context;
    private ImageView imageViewSelection;

    public ListAdapter(Context context, ArrayList<DTO_Images> images, ImageView imageView) {
        this.context = context;
        this.listImage = images;
        this.imageViewSelection = imageView;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_gallery_layout, parent, false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imageView.setImageResource(listImage.get(position).getiURL());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView img=null;
                img=(ImageView)view.findViewById(view.getId());
                Drawable drawable=img.getDrawable();
                imageViewSelection.setImageDrawable(drawable);
            }
        });
    }


    @Override
    public int getItemCount() {
        return listImage.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.img_content_list);
        }
    }
}
