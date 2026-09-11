package service;

import model.Employee;
import model.People;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Principal {
    List<Employee> employees;

    public Principal() {
        this.employees = new ArrayList<>();
    }

    //adiciona todos os funcionarios em uma lista
    public void addEmployee(List<Employee> newEmployees) {
        this.employees.addAll(newEmployees);
    }

    //Traz todos os funcionarios cadastrados e retorna a lista
    public void getEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }






}
