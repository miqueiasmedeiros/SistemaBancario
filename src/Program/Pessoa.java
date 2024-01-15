package Program;

public class Pessoa {

    private static int counter = 1;

    private String nome;
    private String CPF;
    private String email;

    public Pessoa(String nome, String CPF, String email) {
        this.nome = nome;
        this.CPF = CPF;
        this.email = email;
        counter += 1;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Pessoa.counter = counter;
    }

    public String getEmail() {
        return email;
    }

    public String getCPF() {
        return CPF;
    }

    public String getNome() {
        return nome;
    }

    public String toString(){
        return "\nNome: " + this.getNome() +
                "\nCPF: " + this.getCPF() +
                "\nEmail: "  + this.getEmail();
    }

}
