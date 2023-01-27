package softuni.exam.util;

import java.io.FileNotFoundException;

public interface XmlParser {

    <T> T fromFile(String filePath, Class<T> tClass) throws FileNotFoundException, jakarta.xml.bind.JAXBException;
}
