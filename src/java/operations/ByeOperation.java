/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marta
 */
public class ByeOperation extends Operations {

    public ByeOperation() {
    }
    
    @Override
    public void execute(HttpServletResponse response) {        
        try {
            PrintWriter out = response.getWriter();
            out.write("Soy un objeto de la clase ByeOperation");
        } catch(Exception e) {}
    }
    
}
