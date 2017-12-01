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
public class V_Productos {

    public ArrayList<String> cargar_combo(String tipo) {
        conectar rp = new conectar();
        ArrayList<String> lista = rp.Cargar_Combo_Ventas(tipo);
        return lista;
    }

    public boolean reg_compra(String nombre, int edad, Character sexo, int id_producto, String fecha) {
        conectar rp = new conectar();
        boolean reg = rp.Comp_Registro(nombre, edad, sexo, id_producto, fecha);

        return reg;
    }
}
