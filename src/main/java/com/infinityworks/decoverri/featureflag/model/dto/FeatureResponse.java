package com.infinityworks.decoverri.featureflag.model.dto;

import com.infinityworks.decoverri.featureflag.model.Feature;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeatureResponse {
    public List<Feature> features;
}
