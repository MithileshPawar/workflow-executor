package com.publicis.workflow_executor.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Data
public class WorkflowRequestDto {

    @NotBlank(message = "Name is required")
    private String name;
    private List<String> steps;
    private Map<String,String> parameters;

}
