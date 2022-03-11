package com.infinityworks.decoverri.featureflag.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Feature {
    int id;
    String name;
    boolean enabledToAllUsers;
}
