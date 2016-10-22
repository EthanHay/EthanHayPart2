import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ethan on 15-Sep-16.
 */
public class initDeck {

    private static ArrayList<String> fileNames = new ArrayList<>();
    private static ArrayList<String> imageNames = new ArrayList<>();
    private static ArrayList<String> card_types = new ArrayList<>();
    private static ArrayList<String> titles = new ArrayList<>();
    private static ArrayList<String> subtitles = new ArrayList<>();
    private static ArrayList<String> chemistrys = new ArrayList<>();
    private static ArrayList<String> classifications = new ArrayList<>();
    private static ArrayList<String> crystal_systems = new ArrayList<>();
    private static ArrayList<String> occurrences = new ArrayList<>();
    private static ArrayList<String> hardnesss = new ArrayList<>();
    private static ArrayList<String> specific_gravitys = new ArrayList<>();
    private static ArrayList<String> cleavages = new ArrayList<>();
    private static ArrayList<String> crustal_abundances = new ArrayList<>();
    private static ArrayList<String> economic_values = new ArrayList<>();

    public ArrayList cards = new ArrayList();
    public ArrayList rulecards = new ArrayList();

    public ArrayList initDeck() {
        {
            try {

                File fXmlFile = new File("src/MstCards_151021.plist");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(fXmlFile);

                NodeList dictList = doc.getElementsByTagName("array");

                for (int i = 0; i<dictList.getLength(); i++) {

                    Node p = dictList.item(i);
                    if(p.getNodeType()==Node.ELEMENT_NODE){

                        Element key = (Element) p;
                        NodeList keyList = key.getChildNodes();

                        for(int j=0; j<keyList.getLength(); j++) {

                            Node q = keyList.item(j);

                            if (q.getNodeType()==Node.ELEMENT_NODE){

                                Element key2 = (Element) q;
                                NodeList key2List = key2.getChildNodes();

                                for (int k=0; k<key2List.getLength(); k++) {

                                    Node r = key2List.item(k);

                                    if (!(r.getNodeName().equals("#text"))) {

                                        switch(r.getTextContent()){
                                            case "fileName":
                                                r = key2List.item(k+2);
                                                fileNames.add(r.getTextContent());
                                                break;
                                            case "imageName":
                                                r = key2List.item(k+2);
                                                imageNames.add(r.getTextContent());
                                                break;
                                            case "card_type":
                                                r = key2List.item(k+2);
                                                card_types.add(r.getTextContent());
                                                break;
                                            case "title":
                                                r = key2List.item(k+2);
                                                titles.add(r.getTextContent());
                                                break;
                                            case "chemistry":
                                                r = key2List.item(k+2);
                                                chemistrys.add(r.getTextContent());
                                                break;
                                            case "classification":
                                                r = key2List.item(k+2);
                                                classifications.add(r.getTextContent());
                                                break;
                                            case "crystal_system":
                                                r = key2List.item(k+2);
                                                crystal_systems.add(r.getTextContent());
                                                break;
                                            case "occurrence":
                                                r = key2List.item(k+2);
                                                occurrences.add(r.getTextContent());
                                                //needs custom array formatting
                                                break;
                                            case "hardness":
                                                r = key2List.item(k+2);
                                                hardnesss.add(r.getTextContent());
                                                break;
                                            case "specific_gravity":
                                                r = key2List.item(k+2);
                                                specific_gravitys.add(r.getTextContent());
                                                break;
                                            case "cleavage":
                                                r = key2List.item(k+2);
                                                cleavages.add(r.getTextContent());
                                                break;
                                            case "crustal_abundance":
                                                r = key2List.item(k+2);
                                                crustal_abundances.add(r.getTextContent());
                                                break;
                                            case "economic_value":
                                                r = key2List.item(k+2);
                                                economic_values.add(r.getTextContent());
                                                break;
                                            case "subtitle":
                                                r = key2List.item(k+2);
                                                subtitles.add(r.getTextContent());
                                                break;

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                int subtitleIndex = 0;
                for (int i = 0; i<fileNames.size()-1; i++){

                    ArrayList<String> card = new ArrayList<String>();

                    card.add(fileNames.toArray()[i].toString());
                    card.add(imageNames.toArray()[i].toString());
                    card.add(card_types.toArray()[i].toString());
                    if(card_types.toArray()[i].toString().equals("play")){
                        card.add(titles.toArray()[i].toString());
                        card.add(chemistrys.toArray()[i].toString());
                        card.add(classifications.toArray()[i].toString());
                        card.add(crystal_systems.toArray()[i].toString());
                        card.add(occurrences.toArray()[i].toString());
                        card.add(hardnesss.toArray()[i].toString());
                        card.add(specific_gravitys.toArray()[i].toString());
                        card.add(cleavages.toArray()[i].toString());
                        card.add(crustal_abundances.toArray()[i].toString());
                        card.add(economic_values.toArray()[i].toString());
                    } else if ((card_types.toArray()[i].toString().equals("trump"))|(card_types.toArray()[i].toString().equals("rule"))) {
                        card.add(titles.toArray()[i].toString());
                        card.add(subtitles.toArray()[subtitleIndex].toString());
                        subtitleIndex++;
                    } else {
                        System.out.println("Card Generation Error: no card type!");
                    }

//                    System.out.println("Card: " + card);
                    cards.add(card);



                    //cards = new ArrayList(card);
                }
                //loop and remove all rule cards

                for(int j=0; j < cards.size(); j++) {
                    ArrayList temp = (ArrayList) cards.toArray()[j];
                    System.out.println(temp);
                    if(temp.toArray()[2].equals("rule")){
                        rulecards.add(cards.get(j));
                        cards.remove(j);
                        //System.out.println("removed rule Card");
                        j--;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cards;
    }
}
