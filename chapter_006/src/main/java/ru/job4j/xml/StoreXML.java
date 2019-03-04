package ru.job4j.xml;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 02.03.2019
 */
public class StoreXML {
    private static final Logger LOG = LogManager.getLogger(StoreXML.class.getName());

    private File target;

    public StoreXML(File target) {
        this.target = target;
    }

    public void save(List<Entry> list) {
        Entity entity = new Entity();
        entity.setEntry(list);
        try {
            JAXBContext context = JAXBContext.newInstance(Entity.class);
            Marshaller jaxbMarshaller = context.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(entity, target);
        } catch (JAXBException e) {
            LOG.error("error message {}", "error in save method");
        }
    }
}
