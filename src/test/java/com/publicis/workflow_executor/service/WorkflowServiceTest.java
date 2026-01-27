package com.publicis.workflow_executor.service;

import com.publicis.workflow_executor.dto.WorkflowRequestDto;
import com.publicis.workflow_executor.dto.WorkflowResponseDto;
import com.publicis.workflow_executor.model.Workflow;
import com.publicis.workflow_executor.repository.WorkflowRepository;
import com.publicis.workflow_executor.util.WorkflowMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WorkflowServiceTest {

    @Mock
    private WorkflowRepository workflowRepository;

    @Mock
    private WorkflowMapper workflowMapper;

    @InjectMocks
    private WorkflowService workflowService;

    @Test
    public void testCreateWorkflow() {
        WorkflowRequestDto requestDto = new WorkflowRequestDto();
        requestDto.setName("Test Workflow");

        Workflow workflow = new Workflow();
        workflow.setName("Test Workflow");
        workflow.setStatus("PENDING");

        Workflow savedWorkflow = new Workflow();
        savedWorkflow.setId(1L);
        savedWorkflow.setName("Test Workflow");
        savedWorkflow.setStatus("PENDING");

        WorkflowResponseDto responseDto = new WorkflowResponseDto();
        responseDto.setId(1L);
        responseDto.setStatus("PENDING");

        when(workflowMapper.toWorkflow(any(WorkflowRequestDto.class))).thenReturn(workflow);
        when(workflowRepository.save(any(Workflow.class))).thenReturn(savedWorkflow);
        when(workflowMapper.toDto(any(Workflow.class))).thenReturn(responseDto);

        WorkflowResponseDto result = workflowService.createWorkflow(requestDto);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("PENDING", result.getStatus());
    }
}
