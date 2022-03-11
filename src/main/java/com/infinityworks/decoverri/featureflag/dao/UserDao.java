package com.infinityworks.decoverri.featureflag.dao;

import com.infinityworks.decoverri.featureflag.model.User;

import java.util.List;

public interface UserDao {
    List<Integer> getEnabledFeaturesIdsForUser(int userId);

    void addFeatureIdForUser(Integer featureId, Integer userId);

    void removeFeatureIdForUser(Integer featureId, Integer userId);

    List<User> getUsers();
}
