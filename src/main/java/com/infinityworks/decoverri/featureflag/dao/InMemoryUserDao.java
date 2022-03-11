package com.infinityworks.decoverri.featureflag.dao;

import com.infinityworks.decoverri.featureflag.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Repository
@ApplicationScope
public class InMemoryUserDao implements UserDao{
    
    private final List<User> userList = List.of(
            User.builder().id(0).name("Deco").build(),
            User.builder().id(1).name("Chris").build()
    );

    @Override
    public List<Integer> getEnabledFeaturesIdsForUser(int userId) {
        return userList.get(userId).getEnabledFeaturesIds();
    }
}
