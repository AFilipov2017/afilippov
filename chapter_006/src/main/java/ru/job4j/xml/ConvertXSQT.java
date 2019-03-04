package ru.job4j.xml;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 02.03.2019
 */
public class ConvertXSQT {

    public void convert(File source, File dest, File scheme) throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(new StreamSource(String.valueOf(scheme)));
        transformer.transform(new StreamSource(source), new StreamResult(dest));
    }
}
