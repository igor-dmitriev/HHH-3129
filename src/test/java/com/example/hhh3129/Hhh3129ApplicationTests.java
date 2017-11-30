package com.example.hhh3129;

import com.example.hhh3129.entity.Employee;
import com.example.hhh3129.entity.Project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManagerFactory;

import static org.hibernate.testing.transaction.TransactionUtil.doInJPA;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Hhh3129ApplicationTests {

  @Autowired
  private EntityManagerFactory emf;

  @Test
  public void testInterceptorNpe() {
    Long employeeId = doInJPA(() -> emf, em -> {
      Employee employee = new Employee();
      Project project = new Project();

      employee.getProjects().add(project);
      project.getEmployees().add(employee);

      em.persist(project);
      em.persist(employee);
      return employee.getId();
    });

    doInJPA(() -> emf, em -> {
      Employee employee = em.find(Employee.class, employeeId);
      Project newProject = new Project();

      newProject.getEmployees().add(employee);
      employee.getProjects().add(newProject);

      em.persist(newProject);
    });
  }

}
