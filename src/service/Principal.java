package service;

import model.Employee;
import java.math.BigDecimal;
import java.math.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Principal {
    List<Employee> employees;

    public Principal() {
        this.employees = new ArrayList<>();
    }

    //adiciona todos os funcionarios em uma lista
    public void addEmployee(List<Employee> newEmployees) {
        employees.addAll(newEmployees);
    }

    //Traz todos os funcionarios cadastrados e retorna a lista
    public void getEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    //remover funcionario por nome
    public void removeEmployeeByName(String name) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getName().equals(name)) {
                employees.remove(i);
            }
        }
        getEmployees();

    }

    //orquestracao do metodo de aumento salarial
    public void raise(BigDecimal raise) {
        for (Employee employee : employees) {
            employee.raiseSalary(raise);
        }
        getEmployees();
    }

    //criacao do map para agrupar funcionarios por funcao
    public void groupEmployees() {
        Map<String, List<Employee>> groupEmployees = new HashMap<>();

        for (Employee employee : employees) {
            String r = employee.getRole();
            if (!groupEmployees.containsKey(r)) {
                groupEmployees.put(r, new ArrayList<>());
            }
            groupEmployees.get(r).add(employee);
        }
        for (String r : groupEmployees.keySet()) {
            System.out.println(r + ":\t" + groupEmployees.get(r));
        }


    }

    //imprime funcionarios que fazem apenas aniversario no mes 10 e 12
    public void getEmployeesByMonth() {
        for (Employee employee : employees) {
            int month = employee.getBirthday().getMonthValue();
            if (month == 10 || month == 12) {
                System.out.println(employee);
            }
        }
    }

    //imprimir unico funcionario com a maior idade
    public void getEmployeesByYear() {
        String peopleOld = "";
        LocalDate year = LocalDate.MAX;
        
        for (Employee emp : employees) {
            if (emp.getBirthday().isBefore(year)) {
                year = emp.getBirthday();
                peopleOld = emp.getName();
            }
        }
        int oldYears = Period.between(year, LocalDate.now()).getYears();
        System.out.println(peopleOld + " " + oldYears);
    }

    //buscar funcionarios por ordem alfabetica
    public void orderEmployees() {
        employees.sort(Comparator.comparing(Employee::getName));
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    //somar o salário de todos os funcionarios
    public void sumSalary() {
        BigDecimal total = BigDecimal.ZERO;
        for (Employee employee : employees) {
            total = total.add(employee.getSalary());

        }
        System.out.println(employees.getFirst().formatSalary(total));
    }

    //metodo para verificar quantos salarios minimos ganha cada funcionario com base em 1212.00
    /*
    Valores necessários para o BigDecimal .divide de acordo com a documentação;
    * Params:
        divisor – value by which this BigDecimal is to be divided.
        scale – scale of the BigDecimal quotient to be returned.
        roundingMode – rounding mode to apply.
    * */
    public void minSalary() {
        final BigDecimal  min = new BigDecimal("1212.00");
        for (Employee employee : employees) {
            BigDecimal qtdSalary = employee.getSalary().divide(min, 2, RoundingMode.HALF_UP);
            System.out.println(employee.getName() + "\t" + employee.formatSalary(qtdSalary));
        }

    }







}
