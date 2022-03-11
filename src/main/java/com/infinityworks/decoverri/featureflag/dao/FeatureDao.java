package com.infinityworks.decoverri.featureflag.dao;

import com.infinityworks.decoverri.featureflag.model.Feature;

import java.util.List;

public interface FeatureDao {
    void save(Feature feature);

    List<Feature> getFeatures();

    Feature getFeature(int id);

    void update(int id, Feature feature);

    List<Feature> getFeatureByIdList(List<Integer> userEnabledFeaturesIds);
}
