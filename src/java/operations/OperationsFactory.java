/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import main.Parser;
import pojo.Operation;

/**
 *
 * @author marta
 */
public class OperationsFactory {
    
    private static OperationsFactory factory = null;
    private HashMap<String, String> map = null;

    private OperationsFactory() {
        map = new HashMap<String, String>();
    }
    
    public static OperationsFactory getFactory() {
        if(factory == null) {
            synchronized (OperationsFactory.class) {
                if(factory == null)
                    factory = new OperationsFactory();
            }
        }
        return factory;
    }
    
    public void populate(InputStream file) {
        Parser read = new Parser();
        List<Operation> readOperation = read.readOperation(file);
        for(Operation op : readOperation) {
            map.put(op.getId(), op.getNClass());
        }
    }
    
    public Operations getOperation(String key) {
        String value = map.get(key);
        if(map.containsValue(value)) {
            try {
                Class classOperation = Class.forName("operations." + value);
                //Constructor constructor = classOperation.getConstructor(new Class[] {});
                //Operations operation = (Operations) constructor.newInstance();
                Operations operation = (Operations) classOperation.newInstance();
                return operation;
            } catch (Exception e) {
                return null;
            }
        }
        else {
            return null;
        }
    }
    
}
