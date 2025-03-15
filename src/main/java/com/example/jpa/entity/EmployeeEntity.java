package com.example.jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    @OneToOne(mappedBy = "manager")
    private DepartmentEntity dep_manager;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="worker_DeptID")
    private DepartmentEntity workerDeptName;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="freelance_dept")
    private Set<DepartmentEntity> freelance_dept;

}
