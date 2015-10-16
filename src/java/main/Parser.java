/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import pojo.Operation;

/**
 *
 * @author marta
 */
public class Parser {
    static final String OPERATION = "operation";
    static final String ID = "id";
    static final String NCLASS = "nclass";
  
    public List<Operation> readOperation(InputStream opFile) {
        List<Operation> opList = new ArrayList<Operation>();
        try {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            XMLEventReader eventReader = inputFactory.createXMLEventReader(opFile);
            Operation op = null;

            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    if(startElement.getName().getLocalPart().equals(OPERATION)) {
                        op = new Operation();
                        Iterator<Attribute> attributes = startElement.getAttributes();
                        while (attributes.hasNext()) {
                            Attribute attribute = attributes.next();
                            if (attribute.getName().toString().equals(ID)) {
                              op.setId(attribute.getValue());
                            }
                            else if (attribute.getName().toString().equals(NCLASS)) {
                                op.setNClass(attribute.getValue());
                            }
                        }
                    }
                    /*
                    if (event.isStartElement()) {
                        if (event.asStartElement().getName().getLocalPart().equals(NCLASS)) {
                            event = eventReader.nextEvent();
                            op.setNClass(event.asCharacters().getData());
                            continue;
                        }
                    }
                    */
                }
                
                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if(endElement.getName().getLocalPart().equals(OPERATION)) {
                        opList.add(op);
                    }
                }

            }
        } catch (XMLStreamException e) {
          e.printStackTrace();
        }
        return opList;
    }
}
