package DTO;

/**
 * Created by DIEGO CASALLAS  on 22/09/2016.
 */

public class DTO_Images {
    private int iURL;
    private int iURLSignaling;
    private String sDescription;
    private String sTitle;
    private String sSignpost;

    public int getiURLSignaling() {
        return iURLSignaling;
    }

    public String getsDescription() {
        return sDescription;
    }

    public void setsDescription(String sDescription) {
        this.sDescription = sDescription;
    }

    public String getsTitle() {
        return sTitle;
    }

    public void setsTitle(String sTitle) {
        this.sTitle = sTitle;
    }

    public void setiURLSignaling(int iURLSignaling) {
        this.iURLSignaling = iURLSignaling;
    }

    public int getiURL() {
        return iURL;
    }

    public void setiURL(int iURL) {
        this.iURL = iURL;
    }

    public String getsSignpost() {
        return sSignpost;
    }

    public void setsSignpost(String sSignpost) {
        this.sSignpost = sSignpost;
    }
}
