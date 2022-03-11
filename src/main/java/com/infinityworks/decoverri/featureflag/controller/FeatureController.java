package com.infinityworks.decoverri.featureflag.controller;

import com.infinityworks.decoverri.featureflag.model.dto.FeatureRequest;
import com.infinityworks.decoverri.featureflag.model.dto.FeatureResponse;
import com.infinityworks.decoverri.featureflag.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
        return createSuccessResponse();
    }

    @PutMapping ("/feature/{featureId}/enable")
    public FeatureResponse enableFeature(@PathVariable Integer featureId){
        featureService.enableFeature(featureId);
        return createSuccessResponse();
    }

    @PutMapping ("/feature/{featureId}/disable")
    public FeatureResponse disableFeature(@PathVariable Integer featureId){
        featureService.disableFeature(featureId);
        return createSuccessResponse();
    }

//    @GetMapping("/feature")
//    public FeatureResponse getEnabledFeatures() {
//        featureService.enableFeature(featureId);
//        return createSuccessResponse();
//    }

    private FeatureResponse createSuccessResponse() {
        var response = new FeatureResponse();
        response.setFeatures(featureService.getFeatures());
        return response;
    }

}
