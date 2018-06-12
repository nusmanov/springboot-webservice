package com.example.springbootwebservice.resource;

import com.example.springbootwebservice.entity.CollateralSecurity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Rest Endpoint
 */

@RestController
@RequestMapping("/rest/security")
public class SecurityRestController {

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
    public CollateralSecurity getCollateralSecurity(@PathVariable String id) {
        return new CollateralSecurity(id, "Name" + id);
    }


}
