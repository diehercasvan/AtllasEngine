package class_project;


import android.content.ClipData;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.edibca.atlasengine.*;


/**
 * Created by DIEGO CASALLAS on 25/07/2016.
 */
public final class MyTouchListener implements View.OnTouchListener {


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        switch (motionEvent.getAction()) {

            case MotionEvent.ACTION_DOWN:
                if (view != null) {

                    //No  pasamos informacion en  el  portapapeles
                    ClipData data = ClipData.newPlainText("", "");
                    //Contruimos  la  sombra de  arrastre de la vista
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);

                    //Iniciamos el arrastre de  la vista
                    view.startDrag(data, shadowBuilder, view, 0);
                    //indicamos que hemos gestionado  el  evento

                    General.RELATIVE_LAYOUT.setBackgroundColor(General.ACTIVITY.getResources().getColor(R.color.background_trans));
                }
                return true;
            case MotionEvent.ACTION_UP:


                return true;
            case MotionEvent.ACTION_MOVE:

                Log.i("info", "ACTION_MOVE");
                return true;

        }
        return false;

    }
}
