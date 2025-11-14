package services;

import models.Livre;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class ServiceImportDonnee {

    public ArrayList<Livre> importFromXML(String filePath) {
        ArrayList<Livre> books = new ArrayList<>();

        try {
            // 1️⃣ Charger le fichier XML
            File xmlFile = new File(filePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            // 2️⃣ Parcourir les éléments "livre"
            NodeList livreNodes = document.getElementsByTagName("livre");

            for (int i = 0; i < livreNodes.getLength(); i++) {
                Node livreNode = livreNodes.item(i);

                if (livreNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element livreElem = (Element) livreNode;
                    Livre book = new Livre();

                    // Titre
                    book.setTitre(livreElem.getElementsByTagName("titre").item(0).getTextContent());

                    // Auteurs
                    ArrayList<String> auteurs = new ArrayList<>();
                    NodeList auteurNodes = livreElem.getElementsByTagName("auteur");
                    for (int j = 0; j < auteurNodes.getLength(); j++) {
                        auteurs.add(auteurNodes.item(j).getTextContent());
                    }
                    book.setAuteurs(auteurs);

                    // Langues
                    ArrayList<String> langues = new ArrayList<>();
                    NodeList langueNodes = livreElem.getElementsByTagName("langue");
                    for (int j = 0; j < langueNodes.getLength(); j++) {
                        langues.add(langueNodes.item(j).getTextContent());
                    }
                    book.setLangues(langues);

                    // Date publication
                    String dateText = livreElem.getElementsByTagName("datePublication").item(0).getTextContent();
                    book.setAnneePublication(Integer.parseInt(dateText));

                    // Edition
                    String editionCount = livreElem.getElementsByTagName("editionCount").item(0).getTextContent();
                    book.setEditionCount(Integer.parseInt(editionCount));
                    

                    books.add(book);
                }
            }

            System.out.println("✅ Import XML réussi : " + books.size() + " livres lus");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return books;
    }
}