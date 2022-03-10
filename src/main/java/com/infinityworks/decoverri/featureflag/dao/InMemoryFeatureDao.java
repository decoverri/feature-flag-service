package com.infinityworks.decoverri.featureflag.dao;

import com.infinityworks.decoverri.featureflag.model.Feature;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.ArrayList;
import java.util.List;

@Repository
@ApplicationScope
public class InMemoryFeatureDao implements FeatureDao {

    private List<Feature> features = new ArrayList<>();

    @Override
    public void save(Feature feature) {
        feature.setId(features.size());
        features.add(feature);
    }

    @Override
    public List<Feature> getFeatures() {
        return List.copyOf(features);
    }

    @Override
    public void enableFeature(int featureId) {
        features.get(featureId).setEnabled(true);
    }

    @Override
    public void disableFeature(Integer featureId) {
        features.get(featureId).setEnabled(false);
    }
}
