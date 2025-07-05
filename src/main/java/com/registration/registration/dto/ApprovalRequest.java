package com.registration.registration.dto;

import lombok.Data;

@Data
public class ApprovalRequest {
    private boolean allAppointmentsClosed;
    private boolean necessaryPaymentsReceived;
    private boolean pTaxExemption;
    private boolean allDocumentsUploaded;
    private String approverComments;
    private String approvalStatus;
}
