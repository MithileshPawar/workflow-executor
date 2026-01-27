package com.publicis.workflow_executor.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class WorkflowResponseDto {

    private Long id;
    private String status;
    private LocalDateTime createdAt;
}
