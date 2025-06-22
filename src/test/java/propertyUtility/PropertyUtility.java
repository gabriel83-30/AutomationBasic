package propertyUtility;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

// - Facem un constructor care sa incarce fisierul in functie de nume
public class PropertyUtility {
    public Properties properties;

    public PropertyUtility(String testName) {
        loadFile(testName);
    }
    // - O metoda care incarca un fisier Properties in functie de numele fisierului

    public void loadFile(String testName) {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/inputData/"
                    + testName + "Data.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // - Facem o metoda care sa scoata valoarea unei proprietati pe baza de cheie.
    public String getPropertyValue(String key) {
        return properties.getProperty(key);
    }

    // - Facem o metoda care scoate toate cheile si valorile intr-un hashmap
    public Map<String, Object> getAllProperties() {
        Map<String, Object> allProperties = new HashMap<>();
        for (String key : properties.stringPropertyNames()) {
            String value = getPropertyValue(key);
            allProperties.put(key, value);
        }
        return allProperties;
    }
    public List<String> getPropertiesAsList(String key){
        String value = getPropertyValue(key);
        if(value!= null && value.contains(",")){
            return Arrays.asList(value.split(","));
        }

        return new ArrayList<>(List.of(value));
    }
}
