package model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

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

    // metodo auxiliar para formatar data
    public String formatterDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return formatter.format(getBirthday());
    }

    // metodo auxiliar para formatar salario com separador de milhar como ponto e decimal como virgula
    public String formatSalary(BigDecimal salary){
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
        DecimalFormat formatter = new DecimalFormat("#,##0.00", symbols);
        return formatter.format(salary);
    }

    //metodo adicional para aplicar aumento salarial
    public void raiseSalary(BigDecimal raise){
        this.salary = salary.multiply(raise);
    }

    // Metodo para printar funcionarios
    @Override
    public String toString() {
        return "Nome: " + getName() +
                " | Data Nascimento: " + formatterDate() +
                " | Salário: R$ " + formatSalary(salary) +
                " | Função: " + this.role;
    }
}
