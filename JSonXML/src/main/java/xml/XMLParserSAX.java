package xml;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class XMLParserSAX {
    private static final String fileName ="C:/Users/Ruslan_Omelchenko/IdeaProjects/JSonXML/src/main/resources/reachPeople.txt";
    private List<Person> personList;
    private List<Person> reachPersonList;

    public void parseXML() {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            MyHandler handler = new MyHandler();
            saxParser.parse(new File("doc.xml"), handler);
            //Get Employees list
            personList = handler.getEmpList();
            reachPersonList = new ArrayList<>();
            //print employee information
            for (Person person : personList) {
                if (person.getCash() > 10000) {
                    System.out.println(person);
                    reachPersonList.add(person);
                }
            }
            writePersonToFile(reachPersonList);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public void writePersonToFile(List <Person> reachPersonList){
        try (OutputStreamWriter fos = new OutputStreamWriter(new FileOutputStream(fileName), UTF_8)) {
            for (Person person : reachPersonList) {
                fos.write(person.toString());
                fos.write("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
