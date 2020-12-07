package Parsers;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class BankSaxHandler extends DefaultHandler {
    private final BankBuilder bankBuilder;
    private StringBuilder data;
    private String name;
    private String country;

    public BankSaxHandler(BankBuilder bankBuilder) {
        this.bankBuilder = bankBuilder;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        data.append(new String(ch, start, length));
    }

    @Override
    public void endDocument() {
        bankBuilder.finish(name, country);
    }

    @Override
    public void startElement(String uri, String lName, String qName, Attributes attr) {
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        switch (qName) {
            case "Name" -> name = data.toString();
            case "Country" -> country = data.toString();
            case "Deposit" -> bankBuilder.finishDeposit();
            default -> bankBuilder.tag(qName, data.toString());
        }
    }
}
