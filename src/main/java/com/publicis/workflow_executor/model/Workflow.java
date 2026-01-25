package com.publicis.workflow_executor.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Entity
@Data
@NoArgsConstructor
public class Workflow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String status;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ElementCollection
    public List<String> steps;

    @ElementCollection
    @CollectionTable(name = "workflow_parameters",
            joinColumns = {@JoinColumn(name = "workflow_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "parameter_name")
    @Column(name = "parameter_value")
    public Map<String, String> parameters;


}
