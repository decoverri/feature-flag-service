package com.infinityworks.decoverri.featureflag.dao;

import com.infinityworks.decoverri.featureflag.model.Feature;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
                .enabledToAllUsers(feature.isEnabledToAllUsers())
                .build();
    }

    @Override
    public void update(int id, Feature feature) {
        features.set(id, feature);
    }

    @Override
    public List<Feature> getFeatureByIdList(List<Integer> userEnabledFeaturesIds) {
        return features.stream()
                .filter(feature -> userEnabledFeaturesIds.contains(feature.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Feature> getEnabledFeatures() {
        return features.stream().filter(feature -> feature.isEnabledToAllUsers()).collect(Collectors.toList());
    }

}
