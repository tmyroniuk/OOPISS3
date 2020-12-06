import Parsers.*;
import  Bank.*;

public class Main {

    public static void main(String[] args) {
        String xml = "src/main/resources/Bank.xml";
        String xsd = "src/main/resources/Bank.xsd";
        BankBuilder builder;
        Parser parser;
        if(XmlValidator.validate(xml, xsd)) {

            System.out.println("DOM parser:");
            builder = new BankBuilder();
            parser = new DomXmlParser(builder);
            parser.parseFile(xml);
            System.out.println(builder.getBank().toString());

            System.out.println("\nSAX parser:");
            builder = new BankBuilder();
            parser = new SaxXmlParser(builder);
            parser.parseFile(xml);
            System.out.println(builder.getBank().toString());

            System.out.println("\nSTAX parser:");
            builder = new BankBuilder();
            parser = new StaxXmlParser(builder);
            parser.parseFile(xml);
            System.out.println(builder.getBank().toString());
        }
    }
}
