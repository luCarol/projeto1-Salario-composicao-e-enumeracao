package entidades;

import entidades.enumeracao.NivelDeTrabalho;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Trabalhador {
    
    private String nome;
    private NivelDeTrabalho nivel;
    private Double salario;
    
    private Departamento departamento;
    private List<ContratoPorHora> contratos = new ArrayList<>();

    public Trabalhador() {
    }
    
    public Trabalhador(String nome, NivelDeTrabalho nivel, Double salario, Departamento departamento) {
        this.nome = nome;
        this.nivel = nivel;
        this.salario = salario;
        this.departamento = departamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public NivelDeTrabalho getNivel() {
        return nivel;
    }

    public void setNivel(NivelDeTrabalho nivel) {
        this.nivel = nivel;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<ContratoPorHora> getContratos() {
        return contratos;
    }

    public void addContrato(ContratoPorHora contrato) {
        contratos.add(contrato);
    }
    
    public void removeContrato(ContratoPorHora contrato) {
        contratos.remove(contrato);
    }
    
    public double salarioTotal(int mes, int ano) {
        double soma = salario;
        Calendar cal = Calendar.getInstance();
        for (ContratoPorHora contrato : contratos) {
            cal.setTime(contrato.getData());
            int mesContrato = 1 + cal.get(Calendar.MONTH);
            int anoContrato = cal.get(Calendar.YEAR);
            if (mes == mesContrato && ano == anoContrato) {
                soma += contrato.valorTotal();
            }
        }
        return soma;
        /*
            ** a validação do mês através da classe Calendar começa com o
            ** o mês de Janeiro no valor zero, por isso, coloca-se o somatório 
            ** de uma unidade antes da chamada do mês.
        */
    }
    
}