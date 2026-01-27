package com.publicis.workflow_executor.util;

import com.publicis.workflow_executor.dto.WorkflowRequestDto;
import com.publicis.workflow_executor.dto.WorkflowResponseDto;
import com.publicis.workflow_executor.model.Workflow;
import org.springframework.stereotype.Component;

@Component
public class WorkflowMapper {

    public Workflow toWorkflow(WorkflowRequestDto workflowRequestDto) {
        Workflow workflow = new Workflow();
        workflow.setName(workflowRequestDto.getName());
        workflow.setSteps(workflowRequestDto.getSteps());
        workflow.setParameters(workflowRequestDto.getParameters());
        return workflow;

    }

    public WorkflowResponseDto toDto(Workflow workflow) {

        WorkflowResponseDto workflowResponseDto = new WorkflowResponseDto();
        workflowResponseDto.setId(workflow.getId());
        workflowResponseDto.setStatus(workflow.getStatus());
        workflowResponseDto.setCreatedAt(workflow.getCreatedAt());
        return workflowResponseDto;
    }


}
