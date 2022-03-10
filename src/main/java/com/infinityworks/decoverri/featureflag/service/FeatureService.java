package com.infinityworks.decoverri.featureflag.service;

import com.infinityworks.decoverri.featureflag.dao.FeatureDao;
import com.infinityworks.decoverri.featureflag.model.Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeatureService {

    private final FeatureDao featureDao;

    @Autowired
    public FeatureService(FeatureDao featureDao){
        this.featureDao = featureDao;
    }

    public void createFeature(String name) {
        Feature feature = Feature.builder()
                .name(name)
                .enabled(false)
                .build();
        featureDao.save(feature);
    }

    public List<Feature> getFeatures() {
        return featureDao.getFeatures();
    }

    public void enableFeature(int id) {
        var feature = featureDao.getFeature(id);
        feature.setEnabled(true);
        featureDao.update(id, feature);
    }

    public void disableFeature(int id) {
        var feature = featureDao.getFeature(id);
        feature.setEnabled(false);
        featureDao.update(id, feature);
    }
}
