package com.example.android.miwok;

public class Word {

    private String defaultTranslation;
    private String miwokTranslation;
    private int soundSrc;
    private int imageSrc = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String defaultTranslation, String miwokTranslation, int soundSrc) {
        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
        this.soundSrc = soundSrc;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageSrc, int soundSrc) {
       this.miwokTranslation = miwokTranslation;
       this.defaultTranslation = defaultTranslation;
       this.imageSrc = imageSrc;
       this.soundSrc =soundSrc;
    }

    public String getDefaultTranslation() {
        return defaultTranslation;
    }

    public String getMiwokTranslation() {
        return miwokTranslation;
    }

    public int getImageSrc() {
        return imageSrc;
    }

    public boolean hasImage() {
        return imageSrc != NO_IMAGE_PROVIDED;
    }

    public int getSoundSrc() {
        return soundSrc;
    }
}
