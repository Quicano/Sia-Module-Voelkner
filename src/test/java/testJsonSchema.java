import org.everit.json.schema.ValidationException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertNotNull;

public class testJsonSchema {

    JsonValidator validator;

    @Before
    public void setup(){
        validator = new JsonValidator();
    }

    @Test
    public void testValidData() throws FileNotFoundException {
        JSONObject jsonObject = validator.validateJson("Json-schema-example-data.json");
        assertNotNull(jsonObject);
    }

    @Test(expected = ValidationException.class)
    public void testNoPpn() throws FileNotFoundException {
        validator.validateJson("src/test/java/testData/Json-schema-example-testdata1(no-ppn).json");
    }

    @Test(expected = ValidationException.class)
    public void testPpnEmpty() throws FileNotFoundException {
        validator.validateJson("src/test/java/testData/Json-schema-example-testdata2(ppn-empty).json");
    }

    @Test(expected = ValidationException.class)
    public void testWrongSourceInput() throws FileNotFoundException {
        validator.validateJson("src/test/java/testData/Json-schema-example-testdata3(wrong-source-input).json");
    }

    @Test(expected = ValidationException.class)
    public void testNoCreators() throws FileNotFoundException {
        validator.validateJson("src/test/java/testData/Json-schema-example-testdata4(no-creators).json");
    }

    @Test(expected = ValidationException.class)
    public void testWrongLanguageInput() throws FileNotFoundException {
        validator.validateJson("src/test/java/testData/Json-schema-example-testdata5(wrong-language-input).json");
    }

}
