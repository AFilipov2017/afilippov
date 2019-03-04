package ru.job4j.xml;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 04.03.2019
 */
public class Parser {
    private static final Logger LOG = LogManager.getLogger(Parser.class.getName());
    private static List<Entry> list = new ArrayList<>();

    public List<Entry> pars() {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        XMLHandler handler = new XMLHandler();
        try {
            parser.parse(new File("D://output.xml"), handler);
        } catch (SAXException e) {
            LOG.error("error message {}", "error in pars method");
        } catch (IOException e) {
            LOG.error("error message {}", "error in pars method");
        }
        return list;
    }

    private static class XMLHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("entry")) {
                int field = Integer.parseInt(attributes.getValue("field"));
                list.add(new Entry(field));
            }
        }
    }
}




