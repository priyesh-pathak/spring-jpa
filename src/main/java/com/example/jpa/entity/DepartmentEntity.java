package com.example.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter

@NoArgsConstructor
@Builder
@ToString(callSuper = true)
@AllArgsConstructor
@Table(name="departments")
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentEntity that = (DepartmentEntity) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    @OneToOne
    @JsonIgnore
    @JoinColumn(name="dep_manager")
    private EmployeeEntity manager;


    @OneToMany(mappedBy="workerDepartment")
    @JsonIgnore
    private Set<EmployeeEntity> workers;
}
