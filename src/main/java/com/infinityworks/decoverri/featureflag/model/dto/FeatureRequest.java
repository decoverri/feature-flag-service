package com.infinityworks.decoverri.featureflag.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeatureRequest {

    @JsonProperty("feature-name")
    private String featureName;
}
