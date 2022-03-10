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
        features.add(feature);
    }

    @Override
    public List<Feature> getFeatures() {
        return List.copyOf(features);
    }
}
