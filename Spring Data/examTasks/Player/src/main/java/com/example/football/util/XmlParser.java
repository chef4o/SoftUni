package com.example.football.util;


import java.io.FileNotFoundException;

public interface XmlParser {

    <T> T fromFile(String filePath, Class<T> tClass) throws jakarta.xml.bind.JAXBException, FileNotFoundException;
}
