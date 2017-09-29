package com.example.android.miwok;

/**
 * {@link Word} reprents a vocubulary word that the user wants to learn.
 * It contains a default translation and Miwok translation for the word.
 */

public class Word {

    /**audio resource*/
    private int mAudioResource;
    /**
     * image resource id
     */
    private int mImageResourceId;
    /**
     * default transaltion of word
     */
    private String mDefaultTranslation;

    /**
     * miwok transaltion of word
     */
    private String mMiwokTranslation;
    /**checks whether image is passed or not*/
    private final boolean mIsImagePassed;

    /**
     * constructor for phrases activity
     * @param defaultTranslation
     * @param miwokTranslation
     */
    public Word(String defaultTranslation,String miwokTranslation,int audioResource)
    {
        mDefaultTranslation=defaultTranslation;
        mMiwokTranslation=miwokTranslation;
        mIsImagePassed=false;
        mAudioResource=audioResource;
    }

    /**
     * constructor for numbers,colors and family numbers activities
     * @param defaultTranslation
     * @param miwokTranslation
     * @param imageResouceId
     */
    public Word(String defaultTranslation,String miwokTranslation,int imageResouceId,int audioResource)
    {
        mDefaultTranslation=defaultTranslation;
        mMiwokTranslation=miwokTranslation;
        mImageResourceId=imageResouceId;
        mIsImagePassed=true;
        mAudioResource=audioResource;
    }

    public String getDefaultTraslation()
    {
        return mDefaultTranslation;
    }

    public String getMiwokTraslation()
    {
        return mMiwokTranslation;
    }

    public int getImageResourceId(){return mImageResourceId;}

    public boolean isImagePassed(){return mIsImagePassed;}

    public int getAudioResource() {return mAudioResource;}

    @Override
    public String toString() {
        return "Word{" +
                "mAudioResource=" + mAudioResource +
                ", mImageResourceId=" + mImageResourceId +
                ", mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mIsImagePassed=" + mIsImagePassed +
                '}';
    }
}
