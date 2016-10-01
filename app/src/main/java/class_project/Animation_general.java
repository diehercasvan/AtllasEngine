package class_project;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.edibca.atlasengine.*;
/**
 * Created by DIEGO H CASALLAS on 1/10/2016.
 */

public class Animation_general {

    private Animation animation;

    public  Animation selectAnimation(int iTypeAnimation){
       int iAnimation=0;
            switch (iTypeAnimation)
            {
                case 0:
                    iAnimation=R.anim.fade_in;
                    break;
                case 1:
                    iAnimation=R.anim.fade_out;
                    break;
                case 2:
                    iAnimation=R.anim.slide_down;
                    break;
                case 3:
                    iAnimation=R.anim.slide_left;
                    break;
                case 4:
                    iAnimation=R.anim.slide_right;
                    break;
                case 5:
                    iAnimation=R.anim.slide_up;
                    break;
            }
        animation= AnimationUtils.loadAnimation(General.CONTEXT,iAnimation);
        return  animation;
    }
}
