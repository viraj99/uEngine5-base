package org.uengine.social.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;
import org.uengine.kernel.*;
import org.uengine.modeling.resource.ResourceManager;
import org.uengine.social.entity.WorklistEntity;
import org.uengine.social.repository.WorklistRepository;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * Created by uengine on 2017. 8. 9..
 *
 * Implementation Principals:
 *  - REST Maturity Level : 2
 *  - Not using old uEngine ProcessManagerBean, this replaces the ProcessManagerBean
 *  - ResourceManager and CachedResourceManager will be used for definition caching (Not to use the old DefinitionFactory)
 *  - json must be Typed JSON to enable object polymorphism - need to change the jackson engine. TODO: accept? typed json is sometimes hard to read
 */
@RestController
public class InstanceService {

    @RequestMapping(value = "/instance/{instanceId}/variables", method = RequestMethod.GET)
    public Map getProcessVariables(@PathVariable("instanceId") String instanceId) throws Exception {

        ProcessInstance instance = applicationContext.getBean(
                ProcessInstance.class,
                new Object[]{
                        null,
                        instanceId,
                        null
                }
        );


        return ((DefaultProcessInstance)instance).getVariables();
    }

    @Autowired
    ApplicationContext applicationContext;




}