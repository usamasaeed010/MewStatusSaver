package com.astzz.statussaver.model;

public class ImageFragmentModel  {

    private String FeatureName;
    private String FeatureValue;

    public ImageFragmentModel(String featureName, String featureValue) {
        FeatureName = featureName;
        FeatureValue = featureValue;
    }

    public String getFeatureName() {
        return FeatureName;
    }

    public void setFeatureName(String featureName) {
        FeatureName = featureName;
    }

    public String getFeatureValue() {
        return FeatureValue;
    }

    public void setFeatureValue(String featureValue) {
        FeatureValue = featureValue;
    }
}
