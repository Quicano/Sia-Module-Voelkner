

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class JsonValidator {

    public static void main(String[] args) throws FileNotFoundException {
        //json schema
        File schemaFile = new File("Json-schema-example.json");

        JSONTokener schemaData = new JSONTokener(new FileInputStream(schemaFile));
        JSONObject jsonSchema = new JSONObject(schemaData);

        //json data
        File jsonData = new File("Json-schema-example-data.json");
        JSONTokener jsonDataFile = new JSONTokener(new FileInputStream(jsonData));
        JSONObject jsonObject = new JSONObject(jsonDataFile);

        //validate schema
        Schema schemaValidator = SchemaLoader.load(jsonSchema);
        schemaValidator.validate(jsonObject);
        System.out.println(jsonObject.get("title"));

    }


}
