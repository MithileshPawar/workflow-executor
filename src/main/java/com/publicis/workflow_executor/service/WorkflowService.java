package com.publicis.workflow_executor.service;

import com.publicis.workflow_executor.dto.WorkflowDto;
import com.publicis.workflow_executor.model.Workflow;
import com.publicis.workflow_executor.repository.WorkflowRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class WorkflowService {

    private final WorkflowRepository workflowRepository;

    public WorkflowService(WorkflowRepository workflowRepository) {
        this.workflowRepository = workflowRepository;
    }

    public WorkflowDto createWorkflow(WorkflowDto workflowDto) {
        Workflow workflow = workflowRepository.save(new Workflow());
        return new WorkflowDto();
    }

    public List<WorkflowDto> getAllWorkflows() {
        List<Workflow> workflows = workflowRepository.findAll();
        return List.of(new WorkflowDto());
    }

    public WorkflowDto getWorkflowById(Long id) {
        Workflow workflow = workflowRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return new WorkflowDto();
    }
}
