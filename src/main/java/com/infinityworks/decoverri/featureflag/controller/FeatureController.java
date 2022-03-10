package com.infinityworks.decoverri.featureflag.controller;

import com.infinityworks.decoverri.featureflag.model.dto.FeatureResponse;
import com.infinityworks.decoverri.featureflag.model.dto.FeatureRequest;
import com.infinityworks.decoverri.featureflag.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class FeatureController {

    private FeatureService featureService;

    @Autowired
    public FeatureController(FeatureService featureService){
        this.featureService = featureService;
    }

    @PostMapping("/feature")
    public FeatureResponse createFeature(@RequestBody FeatureRequest request){
        featureService.createFeature(request.getFeatureName());
        var response = new FeatureResponse();
        response.setFeatures(featureService.getFeatures());
        return response;
    }

    //TODO: add those functionalities
//    @PutMapping ("/feature/{featureId}/enable")
//    public void enableFeature(int featureId){
//        featureService.enableFeature(featureId);
//    }
//
//    @PutMapping ("/feature/{featureId}/disable")
//    public void disableFeature(int featureId){
//        featureService.disableFeature(featureId);
//    }

}
