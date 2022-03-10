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
    public Feature getFeature(int id) {
        var feature = features.get(id);
        return Feature.builder()
                .id(feature.getId())
                .name(feature.getName())
                .enabled(feature.isEnabled())
                .build();
    }

    @Override
    public void update(int id, Feature feature) {
        features.set(id, feature);
    }

}
