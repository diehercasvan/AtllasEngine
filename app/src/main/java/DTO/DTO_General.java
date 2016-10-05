package DTO;

import java.util.ArrayList;

/**
 * Created by DIEGO H CASALLAS on 5/10/2016.
 */

public class DTO_General {
    private String sTitle;
    private String sDescription;
    private ArrayList<String>sDescriptions;
    private ArrayList<String> sTitles;
    private int iUriImage;
    private int iUriImageSignal;
    private ArrayList<Integer> iUriImages;
    private ArrayList<Integer> iUriImagesSignal;
    private String sTextInfo;
    private int iUriVideo;
    private boolean bImgIcon;
    private boolean bTextIcon;
    private String sUriWebView;

    public DTO_General(){

    }

    public String getsTitle() {
        return sTitle;
    }

    public void setsTitle(String sTitle) {
        this.sTitle = sTitle;
    }

    public String getsDescription() {
        return sDescription;
    }

    public void setsDescription(String sDescription) {
        this.sDescription = sDescription;
    }

    public ArrayList<String> getsDescriptions() {
        return sDescriptions;
    }

    public void setsDescriptions(ArrayList<String> sDescriptions) {
        this.sDescriptions = sDescriptions;
    }

    public ArrayList<String> getsTitles() {
        return sTitles;
    }

    public void setsTitles(ArrayList<String> sTitles) {
        this.sTitles = sTitles;
    }

    public int getiUriImage() {
        return iUriImage;
    }

    public void setiUriImage(int iUriImage) {
        this.iUriImage = iUriImage;
    }

    public int getiUriImageSignal() {
        return iUriImageSignal;
    }

    public void setiUriImageSignal(int iUriImageSignal) {
        this.iUriImageSignal = iUriImageSignal;
    }

    public ArrayList<Integer> getiUriImages() {
        return iUriImages;
    }

    public void setiUriImages(ArrayList<Integer> iUriImages) {
        this.iUriImages = iUriImages;
    }

    public ArrayList<Integer> getiUriImagesSignal() {
        return iUriImagesSignal;
    }

    public void setiUriImagesSignal(ArrayList<Integer> iUriImagesSignal) {
        this.iUriImagesSignal = iUriImagesSignal;
    }

    public String getsTextInfo() {
        return sTextInfo;
    }

    public void setsTextInfo(String sTextInfo) {
        this.sTextInfo = sTextInfo;
    }

    public int getiUriVideo() {
        return iUriVideo;
    }

    public void setiUriVideo(int iUriVideo) {
        this.iUriVideo = iUriVideo;
    }

    public boolean isbImgIcon() {
        return bImgIcon;
    }

    public void setbImgIcon(boolean bImgIcon) {
        this.bImgIcon = bImgIcon;
    }

    public boolean isbTextIcon() {
        return bTextIcon;
    }

    public void setbTextIcon(boolean bTextIcon) {
        this.bTextIcon = bTextIcon;
    }

    public String getsUriWebView() {
        return sUriWebView;
    }

    public void setsUriWebView(String sUriWebView) {
        this.sUriWebView = sUriWebView;
    }
}
