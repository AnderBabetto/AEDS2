 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

// ============================================================================
// CLASSE DATA
// ============================================================================
class Data {
    private int ano;
    private int mes;
    private int dia;

    public Data() {}

    public Data(int ano, int mes, int dia) {
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
    }

    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }

    public int getMes() { return mes; }
    public void setMes(int mes) { this.mes = mes; }

    public int getDia() { return dia; }
    public void setDia(int dia) { this.dia = dia; }

    public static Data parseData(String s) {
        String[] partes = s.split("-");
        int ano = Integer.parseInt(partes[0].trim());
        int mes = Integer.parseInt(partes[1].trim());
        int dia = Integer.parseInt(partes[2].trim());
        return new Data(ano, mes, dia);
    }

    public String format() {
        return String.format("%02d/%02d/%04d", dia, mes, ano);
    }
}

// ============================================================================
// CLASSE VEICULO
// ============================================================================
class Veiculo {
    private int id;
    private String marca;
    private String modelo;
    private int ano;
    private String categoria;
    private String[] combustivel;
    private int cilindros;
    private double cilindrada;
    private String transmissao;
    private String tracao;
    private double consumoCidade;
    private double consumoEstrada;
    private double co2;
    private boolean turbo;
    private Data dataRegistro;

    public Veiculo() {}

    public Veiculo(int id, String marca, String modelo, int ano, String categoria,
                   String[] combustivel, int cilindros, double cilindrada,
                   String transmissao, String tracao, double consumoCidade,
                   double consumoEstrada, double co2, boolean turbo, Data dataRegistro) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.categoria = categoria;
        this.combustivel = combustivel;
        this.cilindros = cilindros;
        this.cilindrada = cilindrada;
        this.transmissao = transmissao;
        this.tracao = tracao;
        this.consumoCidade = consumoCidade;
        this.consumoEstrada = consumoEstrada;
        this.co2 = co2;
        this.turbo = turbo;
        this.dataRegistro = dataRegistro;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String[] getCombustivel() { return combustivel; }
    public void setCombustivel(String[] combustivel) { this.combustivel = combustivel; }

    public int getCilindros() { return cilindros; }
    public void setCilindros(int cilindros) { this.cilindros = cilindros; }

    public double getCilindrada() { return cilindrada; }
    public void setCilindrada(double cilindrada) { this.cilindrada = cilindrada; }

    public String getTransmissao() { return transmissao; }
    public void setTransmissao(String transmissao) { this.transmissao = transmissao; }

    public String getTracao() { return tracao; }
    public void setTracao(String tracao) { this.tracao = tracao; }

    public double getConsumoCidade() { return consumoCidade; }
    public void setConsumoCidade(double consumoCidade) { this.consumoCidade = consumoCidade; }

    public double getConsumoEstrada() { return consumoEstrada; }
    public void setConsumoEstrada(double consumoEstrada) { this.consumoEstrada = consumoEstrada; }

    public double getCo2() { return co2; }
    public void setCo2(double co2) { this.co2 = co2; }

    public boolean isTurbo() { return turbo; }
    public void setTurbo(boolean turbo) { this.turbo = turbo; }

    public Data getDataRegistro() { return dataRegistro; }
    public void setDataRegistro(Data dataRegistro) { this.dataRegistro = dataRegistro; }

    public static Veiculo parseVeiculo(String s) {
        String[] p = s.split(",");
        
        int id = Integer.parseInt(p[0].trim());
        String marca = p[1].trim();
        String modelo = p[2].trim();
        int ano = Integer.parseInt(p[3].trim());
        String categoria = p[4].trim();
        String[] combustivel = p[5].trim().split(";");
        int cilindros = Integer.parseInt(p[6].trim());
        double cilindrada = Double.parseDouble(p[7].trim());
        String transmissao = p[8].trim();
        String tracao = p[9].trim();
        double consumoCidade = Double.parseDouble(p[10].trim());
        double consumoEstrada = Double.parseDouble(p[11].trim());
        double co2 = Double.parseDouble(p[12].trim());
        boolean turbo = Boolean.parseBoolean(p[13].trim());
        Data dataRegistro = Data.parseData(p[14].trim());

        return new Veiculo(id, marca, modelo, ano, categoria, combustivel,
                           cilindros, cilindrada, transmissao, tracao,
                           consumoCidade, consumoEstrada, co2, turbo, dataRegistro);
    }

    public String format() {
        StringBuilder combBuilder = new StringBuilder("[");
        for (int i = 0; i < combustivel.length; i++) {
            combBuilder.append(combustivel[i]);
            if (i < combustivel.length - 1) {
                combBuilder.append(", ");
            }
        }
        combBuilder.append("]");

        return String.format("[%d ## %s ## %s ## %d ## %s ## %s ## %d ## %s ## %s ## %s ## %s ## %s ## %s ## %b ## %s]",
            id, marca, modelo, ano, categoria, combBuilder.toString(),
            cilindros,
            (cilindrada == (long) cilindrada ? String.format("%d", (long) cilindrada) : String.valueOf(cilindrada)),
            transmissao, tracao,
            (consumoCidade == (long) consumoCidade ? String.format("%d", (long) consumoCidade) : String.valueOf(consumoCidade)),
            (consumoEstrada == (long) consumoEstrada ? String.format("%d", (long) consumoEstrada) : String.valueOf(consumoEstrada)),
            (co2 == (long) co2 ? String.format("%d", (long) co2) : String.valueOf(co2)),
            turbo, dataRegistro.format());
    }
}

// ============================================================================
// CLASSE LEITOR CSV
// ============================================================================
class LeitorCsv {
    static Veiculo[] ler(String caminhoArquivo) {
        Veiculo[] veiculos = new Veiculo[1000];
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            br.readLine(); // Ignora o cabeçalho
            String linha;
            while ((linha = br.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    veiculos[count++] = Veiculo.parseVeiculo(linha);
                }
            }
        } catch (IOException e) {
            // Silencia ou trata sem e.printStackTrace()
        }

        Veiculo[] resultado = new Veiculo[count];
        System.arraycopy(veiculos, 0, resultado, 0, count);
        return resultado;
    }
}

// ============================================================================
// CLASSE PRINCIPAL
// ============================================================================
public class Q1_TP2 {
    private static Veiculo pesquisaSequencial(Veiculo[] veiculos, int idProcurado) {
        for (Veiculo v : veiculos) {
            if (v != null && v.getId() == idProcurado) {
                return v;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String caminho = "veiculos.csv";
        Veiculo[] veiculos = LeitorCsv.ler(caminho);

        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextInt()) {
                int id = scanner.nextInt();
                if (id == -1) break;

                Veiculo encontrado = pesquisaSequencial(veiculos, id);
                if (encontrado != null) {
                    System.out.println(encontrado.format());
                }
            }
        }
    }
}