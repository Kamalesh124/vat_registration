package com.registration.registration.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class RegistrationResponse {
    private Long ackNumber;
    private LocalDate dateOfVisit;
    private String registrationType;
    private String applicantName;
    private String tradeName;
    private String status;
    private String inspectorReportFileUrl;
}
