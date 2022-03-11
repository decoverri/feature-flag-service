package com.infinityworks.decoverri.featureflag.dao;

import com.infinityworks.decoverri.featureflag.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.ArrayList;
import java.util.List;

@Repository
@ApplicationScope
public class InMemoryUserDao implements UserDao{
    
    private final List<User> userList = List.of(
            User.builder().id(0).name("Deco").enabledFeaturesIds(new ArrayList<>()).build(),
            User.builder().id(1).name("Chris").enabledFeaturesIds(new ArrayList<>()).build()
    );

    @Override
    public List<Integer> getEnabledFeaturesIdsForUser(int userId) {
        return userList.get(userId).getEnabledFeaturesIds();
    }

    @Override
    public void addFeatureIdForUser(Integer featureId, Integer userId) {
        userList.get(userId).getEnabledFeaturesIds().add(featureId);
    }

    @Override
    public void removeFeatureIdForUser(Integer featureId, Integer userId) {
        userList.get(userId).getEnabledFeaturesIds().remove(featureId);
    }

    @Override
    public List<User> getUsers() {
        return List.copyOf(userList);
    }
}
