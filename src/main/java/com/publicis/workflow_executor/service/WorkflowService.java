package com.publicis.workflow_executor.service;

import com.publicis.workflow_executor.dto.WorkflowRequestDto;
import com.publicis.workflow_executor.dto.WorkflowResponseDto;
import com.publicis.workflow_executor.exception.NotFoundException;
import com.publicis.workflow_executor.model.Workflow;
import com.publicis.workflow_executor.repository.WorkflowRepository;
import com.publicis.workflow_executor.util.WorkflowMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
@Slf4j
public class WorkflowService {


    private final WorkflowRepository workflowRepository;
    private final WorkflowMapper workflowMapper;

    public WorkflowResponseDto createWorkflow(WorkflowRequestDto workflowRequestDto) {

        log.info("Creating workflow : Started");
        Workflow workflow = workflowMapper.toWorkflow(workflowRequestDto);
        workflow.setStatus(STATUS.PENDING.toString());

        Workflow createdWorkflow = workflowRepository.save(workflow);

        WorkflowResponseDto responseDto = workflowMapper.toDto(createdWorkflow);
        return responseDto;

    }

    public List<WorkflowResponseDto> getAllWorkflows() {
        log.info("Getting workflows : Started");

        List<Workflow> workflows = workflowRepository.findAll();

        List<WorkflowResponseDto> workflowResponseDtos = workflows.stream().map((workflow) -> workflowMapper.toDto(workflow)).toList();
        return workflowResponseDtos;
    }

    public WorkflowResponseDto getWorkflowById(Long id) {
        log.info("Getting workflowById : Started");

        Workflow workflow = workflowRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Workflow with id %d not found", id)));

        WorkflowResponseDto workflowResponseDto = workflowMapper.toDto(workflow);
        return workflowResponseDto;
    }

    private enum STATUS {
        PENDING,
        CANCELLED,
        COMPLETED
    }
}
