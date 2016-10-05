package class_project;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.edibca.atlasengine.*;

import DTO.DTO_General;
import DTO.DTO_Images;

/**
 * Created by DIEGO CASALLAS  on 22/09/2016.
 */

public class General {
    public static TextView TEXT_VIEW = null;
    public static Drawable DRAWABLE = null;
    public static Activity ACTIVITY = null;
    public static Context CONTEXT = null;
    public static ImageView IMAGE_VIEW = null;
    public static float width = 0f;
    public static float height = 0f;
    public static float xdpi = 0f;
    public static float ydpi = 0f;
    public static float densityDpi = 0f;
    public static RelativeLayout RELATIVE_LAYOUT = null;
    public static RelativeLayout RELATIVE_LAYOUT_SCREEN = null;
    public static int iContIdImage = 0;
    public  static String sTag=null;
    public  static  String COLOR_SELECTION_STRING=null;
    public static String ROUTE;
    public static final String NAME_FOLDER_MAIL="Pictures";
    public static String[] MAIL_CONTENT= new String []{"","Atlas ",""};
    public static String NAME_FOLDER="Atlas";
    public static VideoView VIDEO_VIEW=null;
    //Variables Video
    public static String sUrl;
    public static int iSeconds;

    public static DTO_Images DTO_IMAGES;
    public static DTO_General DTO_GENERAL;


    //References images
    public static int iImageGridView[] =
            {
                    R.drawable.ic_icon,
                    R.drawable.ic_icon1,
                    R.drawable.ic_icon2,
                    R.drawable.ic_icon3,
                    R.drawable.ic_icon4,
                    R.drawable.ic_icon5,
                    R.drawable.ic_icon6,
                    R.drawable.ic_icon,
                    R.drawable.ic_info,
                    R.drawable.ic_crop,
                    R.drawable.ic_check_circle_black,
                    R.drawable.ic_draw,
                    R.drawable.ic_gesture,
                    R.drawable.ic_image,
                    R.drawable.ic_menu_camera,
                    R.drawable.ic_menu_gallery,
                    R.drawable.ic_menu_manage,
                    R.drawable.ic_menu_share,
                    R.drawable.ic_menu_send,
                    R.drawable.ic_menu_slideshow,
            };

    public static boolean bValidateSelectionClick = true;

    public static void alertToast(int iMessage, int time) {
        int iTime = 0;
        if (time == 0) {
            iTime = Toast.LENGTH_LONG;
        } else {
            iTime = Toast.LENGTH_SHORT;
        }

        Toast.makeText(CONTEXT, iMessage, iTime).show();
    }

    public static void alertToast(String sMessage, int time) {
        int iTime = 0;
        if (time == 0) {
            iTime = Toast.LENGTH_LONG;
        } else {
            iTime = Toast.LENGTH_SHORT;
        }

        Toast.makeText(CONTEXT, sMessage, iTime).show();
    }
    private int convertDpToPx(int dp) {
        return Math.round(dp * (Resources.getSystem().getDisplayMetrics().xdpi / DisplayMetrics.DENSITY_DEFAULT));

    }

    public static int convertPxToDp(int px) {
        return Math.round(px / (Resources.getSystem().getDisplayMetrics().xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    public static float convertDpToPixel(float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return Math.round(px);
    }

    public static float convertPixelsToDp(float px) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float dp = px / (metrics.densityDpi / 160f);
        return Math.round(dp);
    }
}
