
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author homer
 */
public class Main {
    public static void main(String[] args) {
        String inicio="05/";
        String anio=inicio.substring(0,inicio.indexOf('/'));
        
        Date fInicio=new Date(Integer.parseInt(anio), 0, 0);
    }
}
