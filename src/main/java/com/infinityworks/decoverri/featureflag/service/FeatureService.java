package com.infinityworks.decoverri.featureflag.service;

import com.infinityworks.decoverri.featureflag.dao.FeatureDao;
import com.infinityworks.decoverri.featureflag.dao.UserDao;
import com.infinityworks.decoverri.featureflag.model.Feature;
import com.infinityworks.decoverri.featureflag.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeatureService {

    private final FeatureDao featureDao;
    private final UserDao userDao;

    @Autowired
    public FeatureService(FeatureDao featureDao, UserDao userDao){
        this.featureDao = featureDao;
        this.userDao = userDao;
    }

    public void createFeature(String name) {
        Feature feature = Feature.builder()
                .name(name)
                .enabledToAllUsers(false)
                .build();
        featureDao.save(feature);
    }

    public List<Feature> getFeatures() {
        return featureDao.getFeatures();
    }

    public void enableFeature(int id) {
        var feature = featureDao.getFeature(id);
        feature.setEnabledToAllUsers(true);
        featureDao.update(id, feature);
    }

    public void disableFeature(int id) {
        var feature = featureDao.getFeature(id);
        feature.setEnabledToAllUsers(false);
        featureDao.update(id, feature);
    }

    public List<Feature> getEnabledFeaturesForUser(int userId) {
        var userEnabledFeaturesIds = userDao.getEnabledFeaturesIdsForUser(userId);
        return featureDao.getFeatureByIdList(userEnabledFeaturesIds.stream().collect(Collectors.toList()));
    }

    public void enableFeatureForUser(Integer featureId, Integer userId) {
        userDao.addFeatureIdForUser(featureId, userId);
    }

    public void disableFeatureForUser(Integer featureId, Integer userId) {
        userDao.removeFeatureIdForUser(featureId, userId);
    }

    public List<User> getUsers() {
        return userDao.getUsers();
    }
}
