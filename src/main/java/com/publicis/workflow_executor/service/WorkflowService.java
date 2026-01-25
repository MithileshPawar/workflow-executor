package com.publicis.workflow_executor.service;

import com.publicis.workflow_executor.dto.WorkflowRequestDto;
import com.publicis.workflow_executor.dto.WorkflowResponseDto;
import com.publicis.workflow_executor.model.Workflow;
import com.publicis.workflow_executor.repository.WorkflowRepository;
import com.publicis.workflow_executor.util.WorkflowMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class WorkflowService {


    private final WorkflowRepository workflowRepository;
    private final WorkflowMapper workflowMapper;

    public WorkflowResponseDto createWorkflow(WorkflowRequestDto workflowRequestDto) {

        Workflow workflow = workflowMapper.toWorkflow(workflowRequestDto);
        workflow.setStatus(STATUS.PENDING.toString());

        Workflow createdWorkflow = workflowRepository.save(workflow);
        return workflowMapper.toDto(createdWorkflow);
    }

    public List<WorkflowResponseDto> getAllWorkflows() {
        List<Workflow> workflows = workflowRepository.findAll();

        List<WorkflowResponseDto> workflowResponseDtos = workflows.stream().map((workflow) -> workflowMapper.toDto(workflow)).toList();
        return workflowResponseDtos;
    }

    public WorkflowResponseDto getWorkflowById(Long id) {
        Workflow workflow = workflowRepository.findById(id).orElse(new Workflow());

        WorkflowResponseDto workflowResponseDto = workflowMapper.toDto(workflow);
        return workflowResponseDto;
    }

    private enum STATUS {
        PENDING,
        CANCELLED,
        COMPLETED
    }
}
