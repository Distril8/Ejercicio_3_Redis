/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3redis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import redis.clients.jedis.Jedis;

/**
 *
 * @author DAVID
 */
public class Ejercicio3Redis {

    /**
     * @param args the command line arguments
     */
    static ArrayList<Persona> personas = new ArrayList<Persona>();
    static HashMap<String, String> Personas;

    public static void main(String[] args) {
        // TODO code application logic here
        File Ffichero = new File("final.txt");
        LeerFichero(Ffichero);
    }

    public static void LeerFichero(File Ffichero) {
        long startTime = System.currentTimeMillis();
        try {
            Jedis jedis = new Jedis("localHost");
            System.out.println("Conexion exitosa");
            if (Ffichero.exists()) {

                BufferedReader Flee = new BufferedReader(new FileReader(Ffichero));
                String Slinea;
                while ((Slinea = Flee.readLine()) != null) {
                    String linea = Slinea;
                    String[] cortarString = linea.split("\\|");
                    Persona persona = new Persona();
                    persona.setCedula(cortarString[0]);
                    persona.setNombre(cortarString[1]);
                    persona.setApellido(cortarString[2]);
                    persona.setFechaNace(cortarString[3]);
                    personas.add(persona);
                    jedis.lpush(persona.getCedula(), persona.getCedula()+" "+persona.getNombre()+" "+persona.getApellido()+
                            " "+persona.getFechaNace());
                    long endTime = System.currentTimeMillis() - startTime;
                    
                }
                System.out.println("Duración: " + endTime + " ms");
                Flee.close();
            } else {
                System.out.println("Fichero No Existe");
            }

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }
    
}
