package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Prophandle {
	Properties prop = new Properties();

    public Prophandle() {
        try (FileInputStream file = new FileInputStream("config.properties")) {
            prop.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {
        return prop.getProperty("baseUrl");
    }
    public String getCourseName() {
        return prop.getProperty("Course_Name");
    }
    public int getNoOfCourse() {
        return Integer.parseInt(prop.getProperty("Number_Of_Course_Displayed"));
    }   

}

