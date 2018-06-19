package xml;


public class App1 {
    public static void main(String[] args) {
        XMLwriter xmLwriter = new XMLwriter();
        xmLwriter.writeXML();

        XMLParserSAX xmlParserSAX = new XMLParserSAX();
        xmlParserSAX.parseXML();
    }
}
