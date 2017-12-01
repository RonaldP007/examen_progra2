/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import base_datos.conectar;
import java.util.ArrayList;

/**
 *
 * @author Ronald
 */
public class rep2 {
    public ArrayList<String> reg_compra(String tipo) {
        conectar rp = new conectar();
        ArrayList<String> reg = rp.rep2(tipo);

        return reg;
    }
    
}
