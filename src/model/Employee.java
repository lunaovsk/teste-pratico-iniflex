package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee extends People{

    private BigDecimal salary;
    private String role;

    // Construtor da classes Funcionario que herdam Pessoa
    public Employee(String name, LocalDate birthday,  BigDecimal salary, String role) {
        super(name, birthday);
        this.salary = salary;
        this.role = role;

    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String formatterDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return formatter.format(getBirthday());
    }

    // Metodo para printar funcionarios
    @Override
    public String toString() {
        return "Nome: " + getName() +
                " | Data Nascimento: " + formatterDate() +
                " | Salário: R$ " + this.salary +
                " | Função: " + this.role;
    }
}
