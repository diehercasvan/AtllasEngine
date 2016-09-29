package class_project;


import android.annotation.TargetApi;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;

import fragments.FragmentsAlert;

/**
 * Created by DIEGO  CASALLAS on 25/07/2016.
 */
public class MyDragListener implements View.OnDragListener {
    public float fX = 0f;
    public float fY = 0f;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public boolean onDrag(View view, DragEvent dragEvent) {
        if (General.sTag.equals("text")) {
            switch (dragEvent.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    Log.i("info", "ACTION_DRAG_STARTED");
                    General.TEXT_VIEW.setOnClickListener(null);
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:

                    Log.i("info", "ACTION_DRAG_ENTERED");
                    break;
                case DragEvent.ACTION_DRAG_EXITED:


                    Log.i("info", "ACTION_DRAG_EXITED");

                    break;
                case DragEvent.ACTION_DROP:
                    Log.i("info", "ACTION_DROP");

                    break;
                case DragEvent.ACTION_DRAG_ENDED:

                    Log.i("info", "ACTION_DRAG_ENDED");
                    General.TEXT_VIEW.setVisibility(View.VISIBLE);
                    General.TEXT_VIEW.setX(fX);
                    General.TEXT_VIEW.setY(fY);
                    General.TEXT_VIEW.setBackground(null);
                    General.TEXT_VIEW.setOnTouchListener(null);
                    General.TEXT_VIEW.setOnClickListener(new ClickListener());
                    General.bValidateSelectionClick = true;
                    FragmentsAlert.setDialogFragment(1);
                    General.RELATIVE_LAYOUT.setBackground(null);
                    break;
                case DragEvent.ACTION_DRAG_LOCATION:
                    Point touchPosition = getTouchPositionFromDragEvent(view, dragEvent);
                    fX = touchPosition.x - (General.TEXT_VIEW.getWidth() / 2);
                    fY = touchPosition.y - 120;
                    Log.i("info", "ACTION_DRAG_LOCATION" + fX);

                    General.TEXT_VIEW.setVisibility(View.INVISIBLE);

                    break;
            }
        } else {

            switch (dragEvent.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    Log.i("info", "ACTION_DRAG_STARTED");
                    General.IMAGE_VIEW.setOnClickListener(null);
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:

                    Log.i("info", "ACTION_DRAG_ENTERED");
                    break;
                case DragEvent.ACTION_DRAG_EXITED:


                    Log.i("info", "ACTION_DRAG_EXITED");

                    break;
                case DragEvent.ACTION_DROP:
                    Log.i("info", "ACTION_DROP");

                    break;
                case DragEvent.ACTION_DRAG_ENDED:

                    Log.i("info", "ACTION_DRAG_ENDED");
                    General.IMAGE_VIEW.setVisibility(View.VISIBLE);
                    General.IMAGE_VIEW.setX(fX);
                    General.IMAGE_VIEW.setY(fY);
                    General.IMAGE_VIEW.setBackground(null);
                    General.IMAGE_VIEW.setOnTouchListener(null);
                    General.IMAGE_VIEW.setOnClickListener(new ClickListener());
                    General.bValidateSelectionClick = true;
                    FragmentsAlert.setDialogFragment(3);
                    General.RELATIVE_LAYOUT.setBackground(null);

                    break;
                case DragEvent.ACTION_DRAG_LOCATION:
                    Point touchPosition = getTouchPositionFromDragEvent(view, dragEvent);
                    fX = touchPosition.x - (General.IMAGE_VIEW.getWidth() / 2);
                    fY = touchPosition.y - (General.IMAGE_VIEW.getHeight());
                    Log.i("info", "ACTION_DRAG_LOCATION" + fX);

                    General.IMAGE_VIEW.setVisibility(View.INVISIBLE);

                    break;
            }
        }
        return true;
    }

    public Point getTouchPositionFromDragEvent(View item, DragEvent event) {
        Rect rItem = new Rect();
        item.getGlobalVisibleRect(rItem);
        return new Point(rItem.left + Math.round(event.getX()), rItem.top + Math.round(event.getY()));
    }
}
