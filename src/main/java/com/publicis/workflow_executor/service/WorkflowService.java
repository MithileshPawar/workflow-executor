package com.publicis.workflow_executor.service;

import com.publicis.workflow_executor.dto.WorkflowDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkflowService {

    public WorkflowDto createWorkflow(WorkflowDto workflowDto) {
        return new WorkflowDto();
    }

    public List<WorkflowDto> getAllWorkflows() {
        return List.of(new WorkflowDto());
    }

    public WorkflowDto getWorkflowById(Long id) {
        return new WorkflowDto();
    }
}
