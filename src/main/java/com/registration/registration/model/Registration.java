package com.registration.registration.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.ZonedDateTime;

@Entity
@Table(name = "registrations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Registration {

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ack_no_seq")
   @SequenceGenerator(name = "ack_no_seq", sequenceName = "ack_no_seq", allocationSize = 1)
   @Column(name = "ack_no")
    private Long ackNumber;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "ack_date", nullable = false)
    private LocalDate dateOfVisit;

    @Column(name = "registration_type", nullable = false)
    private String registrationType;

    @Column(name = "applicant_name", nullable = false)
    private String applicantName;

    @Column(name = "trade_name")
    private String tradeName;

    private String status;

    @Column(name = "inspector_report_file_url")
    private String inspectorReportFileUrl;

    @Column(name = "created_at")
    private ZonedDateTime createdAt ;

    @Column(name = "tin")
    private String tin;

    
    @PrePersist
    public void prePersistDefaults() {
        if (status == null) {
            status = "Pending";
        }
        if (createdAt == null) {
            createdAt = ZonedDateTime.now();
        }
    }
}
