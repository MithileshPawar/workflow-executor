package com.publicis.workflow_executor.controller;

import com.publicis.workflow_executor.dto.WorkflowRequestDto;
import com.publicis.workflow_executor.dto.WorkflowResponseDto;
import com.publicis.workflow_executor.service.WorkflowService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private WorkflowService workflowService;

    @Test
    void createWorkFlow_SuccessTest() throws Exception {

        when(workflowService.createWorkflow(any(WorkflowRequestDto.class))).thenReturn(any(WorkflowResponseDto.class));

        mockMvc.perform(post("/workflows")
                        .header(HttpHeaders.AUTHORIZATION, "Basic YWRtaW46cGFzcw==")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "name": "workflow2",
                                    "steps": [
                                        "s1",
                                        "s2"
                                    ],
                                    "parameters": {
                                        "param1": "p1"
                                    }
                                }
                                """)).
                andExpect(status().isCreated());

    }
}
