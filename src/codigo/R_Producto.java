/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import base_datos.conectar;

/**
 *
 * @author Ronald
 */
public class R_Producto {
    
    public boolean R_Producto(int id, String nombre, int precio, String tipo){  
        conectar rp = new conectar();
        boolean se_registro = rp.Prod_Registro(id,nombre,precio,tipo);

        return false;
    }
    
}
