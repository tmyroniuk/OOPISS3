import Parsers.XmlValidator;
import org.junit.Assert;
import org.junit.Test;

public class ValidationTest {

    private static String xsd = "src/test/resources/Bank.xsd";

    @Test
    public void testValid() {
        Assert.assertTrue(XmlValidator.validate("src/test/resources/Bank.xml", xsd));
    }

    @Test
    public void testInvalid1() {
        Assert.assertFalse(XmlValidator.validate("src/test/resources/Invalid1.xml", xsd));
    }

    @Test
    public void testInvalid2() {
        Assert.assertFalse(XmlValidator.validate("src/test/resources/Invalid2.xml", xsd));
    }

    @Test
    public void testInvalid3() {
        Assert.assertFalse(XmlValidator.validate("src/test/resources/Invalid3.xml", xsd));
    }

}
