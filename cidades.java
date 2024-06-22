package salariomedia;

import java.util.ArrayList;
import java.util.List;

class Cidade {
    String nome;
    int codigo;
    int veiculos;
    int acidentes;

    public Cidade(String nome, int codigo, int veiculos, int acidentes) {
        this.nome = nome;
        this.codigo = codigo;
        this.veiculos = veiculos;
        this.acidentes = acidentes;
    }

    public double mediaAcidentesPorVeiculo() {
        return (double) acidentes / veiculos;
    }
}

public class cidades {

    public static void main(String[] args) {
        List<Cidade> cidades = new ArrayList<>();
        cidades.add(new Cidade("Maringá", 1, 200000, 500));
        cidades.add(new Cidade("Londrina", 2, 250000, 700));
        cidades.add(new Cidade("Cascavel", 3, 150000, 300));
        cidades.add(new Cidade("Ponta Grossa", 4, 100000, 400));
        cidades.add(new Cidade("Foz do Iguaçu", 5, 120000, 350));

        Cidade cidadeMaiorAcidentes = cidadeComMaiorAcidentes(cidades);
        Cidade cidadeMenorAcidentes = cidadeComMenorAcidentes(cidades);

        System.out.println("Cidade com maior número de acidentes: " + cidadeMaiorAcidentes.nome + " com " + cidadeMaiorAcidentes.acidentes + " acidentes.");
        System.out.println("Cidade com menor número de acidentes: " + cidadeMenorAcidentes.nome + " com " + cidadeMenorAcidentes.acidentes + " acidentes.");

        for (Cidade cidade : cidades) {
            System.out.println("Média anual de acidentes por veículo em " + cidade.nome + ": " + cidade.mediaAcidentesPorVeiculo());
        }

        double mediaTotal = mediaTotalAcidentesPorVeiculo(cidades);
        System.out.println("Média total de acidentes das cidades pesquisadas por quantidade de veículos: " + mediaTotal);
    }

    public static Cidade cidadeComMaiorAcidentes(List<Cidade> cidades) {
        Cidade maior = cidades.get(0);
        for (Cidade cidade : cidades) {
            if (cidade.acidentes > maior.acidentes) {
                maior = cidade;
            }
        }
        return maior;
    }

    public static Cidade cidadeComMenorAcidentes(List<Cidade> cidades) {
        Cidade menor = cidades.get(0);
        for (Cidade cidade : cidades) {
            if (cidade.acidentes < menor.acidentes) {
                menor = cidade;
            }
        }
        return menor;
    }

    public static double mediaTotalAcidentesPorVeiculo(List<Cidade> cidades) {
        int totalVeiculos = 0;
        int totalAcidentes = 0;
        for (Cidade cidade : cidades) {
            totalVeiculos += cidade.veiculos;
            totalAcidentes += cidade.acidentes;
        }
        return (double) totalAcidentes / totalVeiculos;
    }
}

