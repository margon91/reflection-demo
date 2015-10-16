/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marta
 */
public abstract class Operations {
    public abstract void execute(HttpServletResponse response);
}
