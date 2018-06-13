package com.example.springbootwebservice.resource;

import com.example.springbootwebservice.entity.Security;
import com.example.springbootwebservice.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Rest Endpoint
 */

@RestController
@RequestMapping("/rest/security")
public class SecurityRestController {

    @Autowired
    private SecurityService securityService;

    @GetMapping
    public String hello() {
        return "Hello";
    }

    @GetMapping(value = "/status")
    public ResponseEntity status() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Security getCollateralSecurity(@PathVariable String id) {
        return securityService.getById(Integer.valueOf(id));
    }


}
