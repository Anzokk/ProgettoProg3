package finale.finale;

public class Email {
    private String ID;
    private String mittente;
    private String destinatario;
    private String oggetto;
    private String testo;
    private String dataSpedizione;

    public Email(String ID, String mittente, String destinatario, String oggetto, String testo, String dataSpedizione){
        this.ID = ID;
        this.mittente = mittente;
        this.destinatario = destinatario;
        this.oggetto=oggetto;
        this.testo = testo;
        this.dataSpedizione = dataSpedizione;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMittente() {
        return mittente;
    }

    public void setMittente(String mittente) {
        this.mittente = mittente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getOggetto() {return oggetto;}

    public void setOggetto(String oggetto) {this.oggetto = oggetto;}

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public String getDataSpedizione() {
        return dataSpedizione;
    }

    public void setDataSpedizione(String dataSpedizione) {
        this.dataSpedizione = dataSpedizione;
    }

    @Override
    public String toString() {
        return "Email{" + "ID='" + ID + '\'' + ", mittente='" + mittente + '\'' + ", destinatario='" + destinatario + '\'' +
                ", testo='" + testo + '\'' + ", dataSpedizione='" + dataSpedizione + '\'' + '}';
    }
}
