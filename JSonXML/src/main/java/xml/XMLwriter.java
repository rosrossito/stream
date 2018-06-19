package xml;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;

public class XMLwriter {

    public void writeXML(){
        try (OutputStream outputStream = new FileOutputStream(new File("doc.xml"))) {

            XMLOutputFactory xmlof = XMLOutputFactory.newInstance();
            XMLStreamWriter out = xmlof.createXMLStreamWriter(
                    new OutputStreamWriter(outputStream, "utf-8"));

            out.writeStartDocument();
            out.writeStartElement("catalog");
            out.writeCharacters("\n  ");
            out.writeStartElement("notebook");
            out.writeCharacters("\n    ");

            //First person
            out.writeStartElement("person");
            out.writeAttribute("id", "1");
            out.writeCharacters("\n      ");

            out.writeStartElement("name");
            out.writeCharacters("John");
            out.writeEndElement();
            out.writeCharacters("\n      ");

            out.writeStartElement("address");
            out.writeCharacters("sadasdas");
            out.writeEndElement();
            out.writeCharacters("\n      ");

            out.writeStartElement("cash");
            out.writeCharacters("99999");
            out.writeEndElement();
            out.writeCharacters("\n      ");

            out.writeStartElement("education");
            out.writeCharacters("sa");
            out.writeEndElement();
            out.writeCharacters("\n    ");

            out.writeEndElement();
            out.writeCharacters("\n    ");

            //Second person
            out.writeStartElement("person");
            out.writeAttribute("id", "2");
            out.writeCharacters("\n      ");

            out.writeStartElement("name");
            out.writeCharacters("AAaa");
            out.writeEndElement();
            out.writeCharacters("\n      ");

            out.writeStartElement("address");
            out.writeCharacters("sadasdas");
            out.writeEndElement();
            out.writeCharacters("\n      ");

            out.writeStartElement("cash");
            out.writeCharacters("99999");
            out.writeEndElement();
            out.writeCharacters("\n      ");

            out.writeStartElement("education");
            out.writeCharacters("sa");
            out.writeEndElement();
            out.writeCharacters("\n    ");

            out.writeEndElement();
            out.writeCharacters("\n    ");

            //Third person
            out.writeStartElement("person");
            out.writeAttribute("id", "3");
            out.writeCharacters("\n      ");

            out.writeStartElement("name");
            out.writeCharacters("Bbb");
            out.writeEndElement();
            out.writeCharacters("\n      ");

            out.writeStartElement("address");
            out.writeCharacters("sadasdas");
            out.writeEndElement();
            out.writeCharacters("\n      ");

            out.writeStartElement("cash");
            out.writeCharacters("2222");
            out.writeEndElement();
            out.writeCharacters("\n      ");

            out.writeStartElement("education");
            out.writeCharacters("sa");
            out.writeEndElement();
            out.writeCharacters("\n    ");

            out.writeEndElement();
            out.writeCharacters("\n  ");

            out.writeEndElement();
            out.writeCharacters("\n");
            out.writeEndElement();
            out.writeEndDocument();

            out.flush();
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }


}
