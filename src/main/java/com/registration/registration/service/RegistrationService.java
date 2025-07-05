package com.registration.registration.service;

import com.registration.registration.dto.ApprovalRequest;
import com.registration.registration.dto.RegistrationResponse;
import com.registration.registration.model.Registration;
import com.registration.registration.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository repository;

    public RegistrationResponse getRegistration(Long ackNo) {
        Registration reg = repository.findById(ackNo)
                .orElseThrow(() -> new RuntimeException("Registration not found"));

        return RegistrationResponse.builder()
                .ackNumber(reg.getAckNumber())
                .dateOfVisit(reg.getDateOfVisit())
                .applicantName(reg.getApplicantName())
                .registrationType(reg.getRegistrationType())
                .tradeName(reg.getTradeName())
                .status(reg.getStatus())
                .inspectorReportFileUrl(reg.getInspectorReportFileUrl())
                .build();
    }

    public String approveRegistration(Long ackNo, ApprovalRequest request) {
        Registration reg = repository.findById(ackNo)
                .orElseThrow(() -> new RuntimeException("Registration not found"));

        reg.setStatus(request.getApprovalStatus());
        reg.setTin("TIN" + System.currentTimeMillis());

        repository.save(reg);
        return reg.getTin();
    }

    public Registration createRegistration(Registration reg) {
        return repository.save(reg);
    }
}
