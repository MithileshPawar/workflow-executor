package com.publicis.workflow_executor.controller;

import com.publicis.workflow_executor.dto.WorkflowRequestDto;
import com.publicis.workflow_executor.dto.WorkflowResponseDto;
import com.publicis.workflow_executor.service.WorkflowService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/workflows")
@RequiredArgsConstructor
@Slf4j
public class WorkflowController {

    private final WorkflowService workflowService;

    @PostMapping()
    public ResponseEntity<WorkflowResponseDto> createWorkflow(@Valid @RequestBody WorkflowRequestDto workflowRequestDto) {
        log.info("Creating workflow :{}", workflowRequestDto.toString());
        WorkflowResponseDto createdWorkflowResponse = workflowService.createWorkflow(workflowRequestDto);
        return ResponseEntity.created(null).body(createdWorkflowResponse);
    }

    @GetMapping()
    public ResponseEntity<List<WorkflowResponseDto>> getAllWorkflows() {
        log.info("Getting all workflows");
        List<WorkflowResponseDto> workflowDtos = workflowService.getAllWorkflows();
        return ResponseEntity.ok(workflowDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkflowResponseDto> getWorkflowById(@PathVariable Long id) {
        log.info("Getting workflow with id {}", id);
        WorkflowResponseDto workflowResponseDto = workflowService.getWorkflowById(id);
        return ResponseEntity.ok(workflowResponseDto);
    }


}
