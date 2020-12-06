package Parsers;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;

public class DomXmlParser implements Parser {

    private final BankBuilder bankBuilder;

    public DomXmlParser(BankBuilder builder) {
        this.bankBuilder = builder;
    }

    public boolean parseFile(String filePath) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        Document document = null;

        try {
            builder = factory.newDocumentBuilder();
            document = builder.parse(new File(filePath));
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
            return false;
        }
        document.getDocumentElement().normalize();

        Element root = document.getDocumentElement();

        NodeList nList = root.getElementsByTagName("Deposit");

        for (int temp = 0; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element deposit = (Element) node;
                bankBuilder.tagType(deposit.getElementsByTagName("Type").item(0).getTextContent());
                bankBuilder.tagDepositor(deposit.getElementsByTagName("Depositor").item(0).getTextContent());
                bankBuilder.tagAccountId(deposit.getElementsByTagName("AccountId").item(0).getTextContent());
                bankBuilder.tagAmountOnDeposit(deposit.getElementsByTagName("AmountOnDeposit").item(0).getTextContent());
                bankBuilder.tagProfitability(deposit.getElementsByTagName("Profitability").item(0).getTextContent());
                bankBuilder.tagTimeConstraints(deposit.getElementsByTagName("TimeConstraints").item(0).getTextContent());
                bankBuilder.finishDeposit();
            }
        }
        String name = root.getElementsByTagName("Name").item(0).getTextContent();
        String country = root.getElementsByTagName("Country").item(0).getTextContent();
        bankBuilder.finish(name, country);
        return true;
    }
}
