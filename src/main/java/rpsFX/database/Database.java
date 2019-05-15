package rpsFX.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import rpsFX.state.Leaderboard;
import rpsFX.state.Player;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

/**
 * Class representing the Database.
 */
///CLOVER:OFF
public class Database {

    Logger logger = LoggerFactory.getLogger(Database.class);

    File jarFile = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath());
    String jarFilePath = jarFile.getAbsolutePath();
    String rootPath = jarFilePath.replace(jarFile.getName(), "");

    /**
     * Data list to push to the TableView.
     */
    public static ObservableList<Leaderboard> data = FXCollections.observableArrayList();

    /**
     * Method to create the leaderboard xml file.
     * @param player specified player object.
     */
    public void createXML(Player player) {

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            Element rootElement = document.createElement("players");
            document.appendChild(rootElement);

            Element playerElement = document.createElement("player");
            rootElement.appendChild(playerElement);

            Element nickname = document.createElement("nickname");
            nickname.appendChild(document.createTextNode(player.getName()));
            playerElement.appendChild(nickname);

            Element score = document.createElement("score");
            score.appendChild(document.createTextNode(Integer.toString(player.getScore())));
            playerElement.appendChild(score);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);

            StreamResult streamResult = new StreamResult(new File(rootPath + "leaderboard.xml"));
            transformer.transform(domSource, streamResult);

            logger.info("leaderboard.xml created successfully.");

        } catch (TransformerException | ParserConfigurationException ex) {
            logger.error("Exception: " + ex);
        }
    }

    /**
     * Method to parse the leaderboard xml file.
     */
    public void parseXML() {
        File xmlFile = new File(rootPath + "leaderboard.xml");

        try {
            if (xmlFile.exists()) {
                DocumentBuilderFactory db = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = db.newDocumentBuilder();
                Document doc = dBuilder.parse(xmlFile);
                doc.getDocumentElement().normalize();


                NodeList nList = doc.getElementsByTagName("player");

                for(int i = 0; i < nList.getLength(); i++){
                    Leaderboard leaderboard = new Leaderboard();
                    Node nNode = nList.item(i);

                    if (nNode.getNodeType() == Node.ELEMENT_NODE){
                        Element element = (Element) nNode;
                        leaderboard.setNickname(element.getElementsByTagName("nickname").item(0).getTextContent());
                        System.out.println(element.getElementsByTagName("nickname").item(0).getTextContent());
                        leaderboard.setScore(Integer.parseInt(element.getElementsByTagName("score").item(0).getTextContent()));
                        System.out.println(element.getElementsByTagName("score").item(0).getTextContent());
                    }
                    data.add(leaderboard);
                }
            }

            logger.info("leaderboard.xml parsed successfully.");

        } catch (IOException | SAXException | ParserConfigurationException ex) {
            logger.error("Exception: " + ex);
        }
    }

    /**
     * Method to write the leaderboard xml file.
     * @param player specified player object.
     */
    public void writeXML(Player player) {
        File xmlFile = new File(rootPath + "leaderboard.xml");

        try {
            if (xmlFile.exists()) {
                System.out.println("file exists");
                DocumentBuilderFactory db = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = db.newDocumentBuilder();
                Document doc = dBuilder.parse(xmlFile);

                Element rootElement = doc.getDocumentElement();

                Element playerElement = doc.createElement("player");

                Element nameElement = doc.createElement("nickname");
                nameElement.appendChild(doc.createTextNode(player.getName()));
                playerElement.appendChild(nameElement);

                Element scoreElement = doc.createElement("score");
                scoreElement.appendChild(doc.createTextNode(Integer.toString(player.getScore())));
                playerElement.appendChild(scoreElement);

                rootElement.appendChild(playerElement);

                DOMSource domSource = new DOMSource(doc);

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();

                StreamResult streamResult = new StreamResult(xmlFile);
                transformer.transform(domSource, streamResult);
            }

            logger.info("leaderboard.xml edited successfully.");

        } catch (IOException | SAXException | TransformerException | ParserConfigurationException ex) {
            logger.error("Exception: " + ex);
        }
    }
}
///CLOVER:ON
