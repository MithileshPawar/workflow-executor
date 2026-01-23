package com.publicis.workflow_executor.controller;

import com.publicis.workflow_executor.model.Workflow;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/workflows")
public class WorkflowController {

    @PostMapping()
    public ResponseEntity<Workflow> createWorkflow(@RequestBody Workflow workflow) {
        return ResponseEntity.ok(workflow);
    }

    @GetMapping()
    public ResponseEntity<Workflow> getAllWorkflows() {
        return ResponseEntity.ok(new Workflow());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Workflow> getWorkflowById(@PathVariable Long id) {
        return ResponseEntity.ok(new Workflow());
    }
    

}
