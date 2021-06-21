import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JsonWriter {

    public JSONObject writeJSONFromMetadata(Metadata metadata) throws IOException {
        JSONObject jsonOutput = new JSONObject();

        jsonOutput.put("ppn", metadata.ppn);

        JSONArray titelList = new JSONArray();
        JSONObject titleObjects = new JSONObject();
        titleObjects.put("source", metadata.metadataSource);
        titleObjects.put("title", metadata.title);
        titelList.add(titleObjects);
        jsonOutput.put("title", titelList);

        JSONArray volumeList = new JSONArray();
        JSONObject volumeObjects = new JSONObject();
        volumeObjects.put("source", metadata.metadataSource);
        volumeObjects.put("volume", metadata.volume);
        volumeList.add(volumeObjects);
        jsonOutput.put("volume", volumeList);

        JSONArray pagesList = new JSONArray();
        JSONObject pagesObjects = new JSONObject();
        pagesObjects.put("source", metadata.metadataSource);
        pagesObjects.put("pages", metadata.getPages());
        pagesList.add(pagesObjects);
        jsonOutput.put("pages", pagesList);

        JSONArray yearList = new JSONArray();
        JSONObject yearObjects = new JSONObject();
        yearObjects.put("source", metadata.metadataSource);
        yearObjects.put("year", metadata.year);
        yearList.add(yearObjects);
        jsonOutput.put("year", yearList);

        JSONArray creatorsList = new JSONArray();
        JSONObject creatorsObjects = new JSONObject();
        creatorsObjects.put("source", metadata.metadataSource);
        creatorsObjects.put("creators", metadata.creators);
        creatorsList.add(creatorsObjects);
        jsonOutput.put("creators", creatorsList);

        JSONArray languagesList = new JSONArray();
        JSONObject languagesObjects = new JSONObject();
        languagesObjects.put("source", metadata.metadataSource);
        languagesObjects.put("languages", metadata.languages);
        languagesList.add(languagesObjects);
        jsonOutput.put("languages", languagesList);


        JSONObject keywordsObject = new JSONObject();
        keywordsObject.put("ppn", metadata.keywords);
        jsonOutput.put("keywords", keywordsObject);




        try(FileWriter file = new FileWriter("myJson.json")){
            file.write(jsonOutput.toString());
            file.flush();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return jsonOutput;
    }


    public static void main(String[] args) throws IOException {
        Metadata metada = new Metadata();
        JsonWriter jsonWriter = new JsonWriter();
        JSONObject object = jsonWriter.writeJSONFromMetadata(metada);
        System.out.println(object);
    }
}