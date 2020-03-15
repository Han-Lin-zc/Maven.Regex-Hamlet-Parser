import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        Pattern pattern = Pattern.compile("Hamlet");
        Matcher matcher = pattern.matcher(hamletText);
        hamletText = matcher.replaceAll("Leon");
        hamletParser.changeHamletToLeon();
        Assert.assertEquals(hamletText, hamletParser.getHamletData());
    }

    @Test
    public void testChangeHoratioToTariq() {
        Pattern pattern = Pattern.compile("Horatio");
        Matcher matcher = pattern.matcher(hamletText);
        hamletText = matcher.replaceAll("Tariq");
        hamletParser.changeHoratioToTariq();
        Assert.assertEquals(hamletText, hamletParser.getHamletData());
    }

    @Test
    public void testFindHamletTrue() {
        Assert.assertTrue(hamletParser.findHamlet());
    }

    @Test
    public void testFindHamletFalse() {
        hamletParser.changeHamletToLeon();
        Assert.assertFalse(hamletParser.findHamlet());
    }

    @Test
    public void testFindHoratioTrue() {
        Assert.assertTrue(hamletParser.findHoratio());
    }

    @Test
    public void testFindHoratioFalse() {
        hamletParser.changeHoratioToTariq();
        Assert.assertFalse(hamletParser.findHoratio());
    }
}