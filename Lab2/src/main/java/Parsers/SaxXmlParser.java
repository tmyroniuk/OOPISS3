package Parsers;

import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;

public class SaxXmlParser implements Parser {

    private final BankBuilder bankBuilder;

    public SaxXmlParser(BankBuilder bankBuilder) {
        this.bankBuilder = bankBuilder;
    }

    public boolean parseFile(String filePath) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            BankSaxHandler handler = new BankSaxHandler(bankBuilder);
            saxParser.parse(new File(filePath), handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
