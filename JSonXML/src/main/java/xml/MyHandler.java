package xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MyHandler extends DefaultHandler {
    private List<Person> personList = null;
    private Person person = null;
    boolean bName = false;
    private boolean bAddress = false;
    boolean bCash = false;
    boolean bEducation = false;

    //getter method for employee list
    public List<Person> getEmpList() {
        return personList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("Person")){
            //create a new Employee and put it in Map
            String id = attributes.getValue("id");
            //initialize Person object and set id attribute
            person = new Person();
            person.setId(Integer.parseInt(id));

            //initialize list
            if (personList == null) {
                personList = new ArrayList<>();
            }
        } else if (qName.equalsIgnoreCase("name")) {
            //set boolean values for fields, will be used in setting Employee variables
            bName = true;
        } else if (qName.equalsIgnoreCase("address")) {
            bAddress = true;
        } else if (qName.equalsIgnoreCase("cash")) {
            bCash = true;
        } else if (qName.equalsIgnoreCase("education")) {
            bEducation = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("Person")) {
            //add Employee object to list
            personList.add(person);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bName) {
            //age element, set Employee age
            person.setName(new String(ch, start, length));
            bName = false;
        } else if (bAddress) {
            person.setAddress(new String(ch, start, length));
            bAddress = false;
        } else if (bCash) {
            person.setCash(Integer.parseInt(new String(ch, start, length)));
            bCash = false;
        } else if (bEducation) {
            person.setEducation(new String(ch, start, length));
            bEducation = false;
        }
    }
}
