package ru.job4j.xml;

import javax.xml.transform.TransformerException;
import java.io.File;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 02.03.2019
 */
public class Go {
    public static void main(String[] args) throws SQLException, TransformerException {
        Config config = new Config();
        StoreSQL storeSQL = new StoreSQL(config);
        storeSQL.generate(10);
        File file = new File("D://file.xml");
        File dest = new File("D://output.xml");
        File schema = new File("D://schema.xsl");
        StoreXML storeXML = new StoreXML(file);
        List<Entry> values = storeSQL.load();
        storeXML.save(values);
        ConvertXSQT conv = new ConvertXSQT();
        conv.convert(file, dest, schema);
        Parser parser = new Parser();
        List<Entry> list = parser.pars();
        int b = 0;
        for (Entry e : list
                ) {
          b = b + e.getField();
        }
        System.out.println(b);
    }
}
