package class_project;

import android.support.v4.app.Fragment;

import fragments.FragmentList_image;
import fragments.GalleryFragment;
import fragments.ImageFragment;
import fragments.TextInfoFragment;
import fragments.VideoFragment;

/**
 * Created by DIEGO H CASALLAS on 5/10/2016.
 */

public class MenuFragment {
    private Fragment fragment;

    public MenuFragment() {
        this.fragment = null;
    }

    public Fragment selectFragmentMenu(int iSelectionPage) {

        switch (iSelectionPage) {
            case 0:
                VideoFragment videoFragment = new VideoFragment();
                fragment = videoFragment;
                break;
            case 1:
                ImageFragment imageFragment = new ImageFragment();
                fragment = imageFragment;
                break;
            case 2:
                GalleryFragment galleryFragment = new GalleryFragment();
                fragment = galleryFragment;
                break;
            case 3:
                FragmentList_image fragmentList_image = new FragmentList_image();
                fragment = fragmentList_image;
                break;
            case 4:

                TextInfoFragment textInfoFragment = new TextInfoFragment();
                fragment = textInfoFragment;

                break;
            case 5:
                ImageFragment imageInfoFragment = new ImageFragment();
                fragment = imageInfoFragment;
                break;
            case 6:
                break;
        }
        return fragment;
    }
}
