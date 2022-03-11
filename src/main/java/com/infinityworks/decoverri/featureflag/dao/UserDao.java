package com.infinityworks.decoverri.featureflag.dao;

import java.util.List;

public interface UserDao {
    List<Integer> getEnabledFeaturesIdsForUser(int userId);
}
