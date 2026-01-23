package com.publicis.workflow_executor.controller;

import com.publicis.workflow_executor.dto.WorkflowDto;
import com.publicis.workflow_executor.model.Workflow;
import com.publicis.workflow_executor.service.WorkflowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workflows")
public class WorkflowController {

    private final WorkflowService workflowService;

    public WorkflowController(WorkflowService workflowService) {
        this.workflowService = workflowService;
    }

    @PostMapping()
    public ResponseEntity<WorkflowDto> createWorkflow(@RequestBody WorkflowDto workflowDto) {
        WorkflowDto createdWorkflow = workflowService.createWorkflow(workflowDto);
        return ResponseEntity.created(null).body(createdWorkflow);
    }

    @GetMapping()
    public ResponseEntity<List<WorkflowDto>> getAllWorkflows() {
        List<WorkflowDto> workflowDtos = workflowService.getAllWorkflows();
        return ResponseEntity.ok(workflowDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkflowDto> getWorkflowById(@PathVariable Long id) {
        WorkflowDto workflowDto = workflowService.getWorkflowById(id);
        return ResponseEntity.ok(workflowDto);
    }


}
