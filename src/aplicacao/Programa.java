package aplicacao;

import entidades.ContratoPorHora;
import entidades.Departamento;
import entidades.Trabalhador;
import entidades.enumeracao.NivelDeTrabalho;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) throws ParseException {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.print("Entre com o nome do departamento: ");
        String nomeDepartamento = sc.nextLine();
        System.out.println("Entre com os dados do trabalhador:");
        System.out.print("Nome: ");
        String nomeTrabalhador = sc.nextLine();
        System.out.print("Nivel: ");
        String nivel = sc.nextLine();
        System.out.print("Salário: ");
        double salario = sc.nextDouble();
        Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, NivelDeTrabalho.valueOf(nivel), salario, new Departamento(nomeDepartamento));
        
        System.out.print("Quantos contratos para esse trabalhador? ");
        int qtdeContrato = sc.nextInt();
        for (int cont=1; cont <= qtdeContrato; cont++) {
            System.out.println("Digite os dados do contrato nº" +cont+ ":");
            System.out.print("Data (DD/MM/AAAA): ");
            Date data = sdf.parse(sc.next());
            System.out.print("Valor por hora: ");
            double valorPorHora = sc.nextDouble();
            System.out.print("Duração (horas): ");
            int horas = sc.nextInt();
            ContratoPorHora contrato = new ContratoPorHora(data, valorPorHora, horas);
            trabalhador.addContrato(contrato);
        }
        
        System.out.println();
        System.out.print("Digite o mês e o ano para calcular a renda (MM/AAAA): ");
        String mesAno = sc.next();
        int mes = Integer.parseInt(mesAno.substring(0, 2));
        int ano = Integer.parseInt(mesAno.substring(3));
        System.out.println("Nome: " +trabalhador.getNome());
        System.out.println("Departamento: " +trabalhador.getDepartamento().getNome());
        System.out.println("Salário total na data " +mesAno+ ": " +String.format("%.2f", trabalhador.salarioTotal(mes, ano)));
        
        sc.close();
    }
    
}