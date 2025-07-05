package com.registration.registration.controller;



import com.registration.registration.dto.ApprovalRequest;
import com.registration.registration.dto.RegistrationResponse;
import com.registration.registration.model.Registration;
import com.registration.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService service;

    @GetMapping("/{ackNo}")
    public RegistrationResponse getRegistration(@PathVariable Long ackNo) {
        return service.getRegistration(ackNo);
    }

    @PutMapping("/{ackNo}/approval")
    public Map<String, Object> approveRegistration(@PathVariable Long ackNo,
                                                   @RequestBody ApprovalRequest request) {
        String tin = service.approveRegistration(ackNo, request);
        return Map.of("success", true, "newTin", tin);
    }

    @PostMapping
    public ResponseEntity<Registration> createRegistration(@RequestBody Registration reg) {
        Registration saved = service.createRegistration(reg);
        return ResponseEntity.ok(saved);
    }
}

