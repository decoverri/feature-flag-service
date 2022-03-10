package com.infinityworks.decoverri.featureflag.dao;

import com.infinityworks.decoverri.featureflag.model.Feature;

import java.util.List;

public interface FeatureDao {
    void save(Feature feature);

    List<Feature> getFeatures();

    void enableFeature(int featureId);

    void disableFeature(Integer featureId);
}
