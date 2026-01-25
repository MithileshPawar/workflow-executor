package com.publicis.workflow_executor.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Data
public class WorkflowRequestDto {

    private String name;
    private List<String> steps;
    private Map<String,String> parameters;

}
