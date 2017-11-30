package com.example.hhh3129.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Project {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_seq")
  @SequenceGenerator(name = "project_seq", sequenceName = "project_seq")
  private Long id;

  private String name;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "employees_to_projects"
      , joinColumns = {
      @JoinColumn(name = "project_id", referencedColumnName = "id")
  }
      , inverseJoinColumns = {
      @JoinColumn(name = "employee_id")
  }
  )
  private List<Employee> employees = new ArrayList<>();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(List<Employee> employees) {
    this.employees = employees;
  }

}
