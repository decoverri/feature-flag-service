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
    public FeatureResponse createFeature(@RequestHeader(required = false) String userType, @RequestBody FeatureRequest request){
        if(userType != null && userType.equals("admin")){
            featureService.createFeature(request.getFeatureName());
            return createSuccessResponse();
        }
        else {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "User must be admin");
        }
    }

    @PutMapping ("/feature/{featureId}/enable")
    public FeatureResponse enableFeature(@RequestHeader(required = false) String userType, @PathVariable Integer featureId){
        if(userType != null && userType.equals("admin")){
            featureService.enableFeature(featureId);
            return createSuccessResponse();
        }
        else {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "User must be admin");
        }
    }

    @PutMapping ("/feature/{featureId}/disable")
    public FeatureResponse disableFeature(@RequestHeader(required = false) String userType, @PathVariable Integer featureId){
        if(userType != null && userType.equals("admin")){
            featureService.disableFeature(featureId);
            return createSuccessResponse();
        }
        else {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "User must be admin");
        }
    }

    private FeatureResponse createSuccessResponse() {
        var response = new FeatureResponse();
        response.setFeatures(featureService.getFeatures());
        return response;
    }

}
