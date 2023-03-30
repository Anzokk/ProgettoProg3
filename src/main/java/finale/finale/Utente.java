package finale.finale;

public class Utente {
    private String nomeAccount;
    private String cognome;
    private String nome;
    private String email;

    public Utente(String nomeAccount, String cognome, String nome, String email) {
        this.nomeAccount = nomeAccount;
        this.cognome = cognome;
        this.nome = nome;
        this.email = email;
    }

    public String getNomeAccount() {
        return nomeAccount;
    }

    public void setNomeAccount(String nomeAccount) {
        this.nomeAccount = nomeAccount;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "nomeAccount='" + nomeAccount + '\'' + ", cognome='" + cognome + '\'' + ", nome='" + nome + '\'' + ", email='" + email + '\'' + '}';
    }
}