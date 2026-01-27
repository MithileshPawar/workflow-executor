package com.publicis.workflow_executor.repository;

import com.publicis.workflow_executor.model.Workflow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.*;

import java.util.List;
import java.util.Optional;

public interface WorkflowRepository extends JpaRepository<Workflow, Long> {

    Workflow save(Workflow workflow);

    List<Workflow> findAll();

    Optional<Workflow> findById(Long id);
}
