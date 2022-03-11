package com.infinityworks.decoverri.featureflag.dao;

import com.infinityworks.decoverri.featureflag.model.User;

import java.util.List;
import java.util.Set;

public interface UserDao {
    Set<Integer> getEnabledFeaturesIdsForUser(int userId);

    void addFeatureIdForUser(Integer featureId, Integer userId);

    void removeFeatureIdForUser(Integer featureId, Integer userId);

    List<User> getUsers();
}
