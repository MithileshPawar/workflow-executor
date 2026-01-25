package com.publicis.workflow_executor.controller;

import com.publicis.workflow_executor.dto.WorkflowRequestDto;
import com.publicis.workflow_executor.dto.WorkflowResponseDto;
import com.publicis.workflow_executor.service.WorkflowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workflows")
@RequiredArgsConstructor
public class WorkflowController {

    private final WorkflowService workflowService;

    @PostMapping()
    public ResponseEntity<WorkflowResponseDto> createWorkflow(@RequestBody WorkflowRequestDto workflowRequestDto) {

        WorkflowResponseDto createdWorkflowResponse = workflowService.createWorkflow(workflowRequestDto);
        return ResponseEntity.created(null).body(createdWorkflowResponse);
    }

    @GetMapping()
    public ResponseEntity<List<WorkflowResponseDto>> getAllWorkflows() {
        List<WorkflowResponseDto> workflowDtos = workflowService.getAllWorkflows();
        return ResponseEntity.ok(workflowDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkflowResponseDto> getWorkflowById(@PathVariable Long id) {
        WorkflowResponseDto workflowResponseDto = workflowService.getWorkflowById(id);
        return ResponseEntity.ok(workflowResponseDto);
    }


}
