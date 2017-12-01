package Task7___24_11_2017.urlValidating;

import org.junit.Test;

import static org.junit.Assert.*;

public class UrlValidatorTest {
    @Test
    public void validate() throws Exception {
        assertTrue(UrlValidator.validate("https://stackoverflow.com/questions/5713558/detect-and-extract-url-from-a-string"));
        assertFalse(UrlValidator.validate("fd://fdffd"));
    }

}