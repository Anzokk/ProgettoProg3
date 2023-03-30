package finale.finale;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.ArrayList;

public class Controller implements EventHandler {
    @FXML
    private TableColumn mittente = new TableColumn();
    @FXML
    private TableColumn destinatario = new TableColumn();
    @FXML
    private TableColumn oggetto = new TableColumn();
    @FXML
    private TableColumn testo = new TableColumn();
    @FXML
    private TableColumn id = new TableColumn();
    @FXML
    private TableColumn dataSpedizione = new TableColumn();
    @FXML
    private TableView table;


    Model coso = new Model();
    ArrayList<Email> casella = new ArrayList<>();
    int cont = 0, i = 0;


    public void fillGridPanel(String nomeAccount) {
        casella = coso.outputCasella(nomeAccount);
        System.out.println(casella.size());
        ObservableList<Email> list =FXCollections.observableList(casella);
        id.setCellValueFactory(new PropertyValueFactory<Email, String>("ID"));
        mittente.setCellValueFactory(new PropertyValueFactory<Email, String>("mittente"));
        destinatario.setCellValueFactory(new PropertyValueFactory<Email, String>("destinatario"));
        oggetto.setCellValueFactory(new PropertyValueFactory<Email, String>("oggetto"));
        testo.setCellValueFactory(new PropertyValueFactory<Email, String>("testo"));
        dataSpedizione.setCellValueFactory(new PropertyValueFactory<Email, String>("dataSpedizione"));
        table.setItems(list);
    }


    @FXML
    public void sendMail() {
    }

    @FXML
    private void deleteMail() {
    }

    @FXML
    private void replyMail() {
        fillGridPanel("let0001");
    }

    @FXML
    private void forwardMail() {

    }


    @Override
    public void handle(Event event) {
        table.setOnMouseClicked(event -> {
            table.getSelectionModel().getSelectedItem();
        }
    });
    }




  /*  idTabella.setTipoEvento(event -> { idTabella.getSelectionModel().getSelectedItem() //questo serve per prendere elemento che hai cliccato sulla tabella delle email
                ..cosa deve succedere*/
