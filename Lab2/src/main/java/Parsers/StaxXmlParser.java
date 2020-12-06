package Parsers;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StaxXmlParser implements Parser {

    private final BankBuilder bankBuilder;
    private String name;
    private String country;

    public StaxXmlParser(BankBuilder bankBuilder) {
        this.bankBuilder = bankBuilder;
    }

    public boolean parseFile(String filePath) {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader reader = null;
        try {
            reader = xmlInputFactory.createXMLEventReader(new FileInputStream(filePath));
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        }

        while (reader.hasNext()) {
            XMLEvent nextEvent = null;
            XMLEvent event = null;
            try {
                event = reader.nextEvent();
                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    nextEvent = reader.nextEvent();
                    switch (startElement.getName().getLocalPart()) {
                        case "Name" -> name = nextEvent.asCharacters().getData();
                        case "Country" -> country = nextEvent.asCharacters().getData();
                        case "Type" -> bankBuilder.tagType(nextEvent.asCharacters().getData());
                        case "Depositor" -> bankBuilder.tagDepositor(nextEvent.asCharacters().getData());
                        case "AccountId" -> bankBuilder.tagAccountId(nextEvent.asCharacters().getData());
                        case "AmountOnDeposit" -> bankBuilder.tagAmountOnDeposit(nextEvent.asCharacters().getData());
                        case "Profitability" -> bankBuilder.tagProfitability(nextEvent.asCharacters().getData());
                        case "TimeConstraints" -> bankBuilder.tagTimeConstraints(nextEvent.asCharacters().getData());
                    }
                }
                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if (endElement.getName().getLocalPart().equals("Deposit")) {
                        bankBuilder.finishDeposit();
                    } else if (endElement.getName().getLocalPart().equals("Bank")) {
                        bankBuilder.finish(name, country);
                    }
                }
            } catch (XMLStreamException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
