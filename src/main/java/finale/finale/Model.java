package finale.finale;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Model {



    public void sendMail(String id, String mittente, String destinatario, String oggetto, String testo){

    }

    public ArrayList<Email> outputCasella(String nomeAccount){
        ArrayList<Email> casella=new ArrayList<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try{
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("/Users/anzo/Documents/Uni/Prog 3/Codice/EserciziProg3/Finale/ProvaLettura.xml"));
            doc.getDocumentElement().normalize();

            System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
            System.out.println("------");

            NodeList list = doc.getElementsByTagName("Email");
            for (int temp=0; temp<list.getLength(); temp++) {
                Node node = list.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String ID = element.getAttribute("id");

                    if(ID.equals(nomeAccount)){
                        String mittenteTemp = element.getElementsByTagName("mittente").item(0).getTextContent();
                        String destTemp = element.getElementsByTagName("destinatario").item(0).getTextContent();
                        String oggettoTemp=element.getElementsByTagName("oggetto").item(0).getTextContent();
                        String testoTemp=element.getElementsByTagName("testo").item(0).getTextContent();
                        String timeTemp=element.getElementsByTagName("dataSpedizione").item(0).getTextContent();
                        Email emailTemp = new Email("0", mittenteTemp, destTemp, oggettoTemp, testoTemp, timeTemp);
                        casella.add(emailTemp);
                    }
                }
            }
        } catch (ParserConfigurationException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (SAXException ex) {
            throw new RuntimeException(ex);
        }
        return casella;
    }

    public void initialSetup(){
        Utente utente1 = new Utente ("Banana33", "Stinson", "Barney", "barney.stinson@email.com");
        Utente utente2 = new Utente ("Shooter", "Curry", "Stephen", "stephen.curry@email.com");
        Utente utente3 = new Utente ("DJDiesel", "O'neal", "Shaquille", "shaquille.oneal@email.com");

        Utente [] utenti = {utente1, utente2, utente3} ;

        //Qui facciamo la Scrittura nel file XML

        try{
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            Element root = document.createElement("ContactList");
            document.appendChild(root);

            for(int i=0; i<3; i++) {
                Element user = document.createElement("User");
                root.appendChild(user);

                Attr attr = document.createAttribute("nomeAccount");
                attr.setValue(utenti[i].getNomeAccount());
                user.setAttributeNode(attr);

                Element firstName = document.createElement("firstname");
                firstName.appendChild(document.createTextNode(utenti[i].getNome()));
                user.appendChild(firstName);

                Element lastName = document.createElement("lastname");
                lastName.appendChild(document.createTextNode(utenti[i].getCognome()));
                user.appendChild(lastName);

                Element email = document.createElement("email");
                email.appendChild(document.createTextNode(utenti[i].getEmail()));
                user.appendChild(email);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("home/andreapollaccia/provaScrittura.xml"));

            transformer.transform(domSource, streamResult);
            System.out.println("Hai costruito un minchia di fila, bravo picciotto");

        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Hai sbagliato coglione");
        }
    }

    public static void main(String[] args) {

        Model m = new Model();
        m.initialSetup();

        /*qua sotto facciamo la lettura del file XML
         *modificare in base a come formatteremo il file XML dello storico delle email
         *modificare anche la classe CasellaPostaElettronica e aggiungere i controlli sul metodo di lettura di XML
         *in modo tale che da aggiungere le email all'interno della lista da noi contenuta
         * vedere se dobbiamo mettere nello storico la lista delle email sia quando siamo mittenti che destinatari
         */

    }
}