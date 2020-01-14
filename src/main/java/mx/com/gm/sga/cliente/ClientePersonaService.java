/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.cliente;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaServiceRemote;

/**
 *
 * @author macbook
 */
public class ClientePersonaService {
    
    
    public static void main(String[] args){
        
         System.out.println("Iniciando llamada al EJB desde el cliente\n");
         
         Context jndi;
        try {
            jndi = new InitialContext();
             PersonaServiceRemote personaService = 
               (PersonaServiceRemote) jndi.lookup("java:global/sga-jee/PersonaServiceImpl!mx.com.gm.sga.servicio.PersonaServiceRemote");
         
         List<Persona> personas = personaService.listarPersonas();
         
         for(Persona persona: personas){
         System.out.println(persona);
         }
            
             System.out.println("\nFin llamada al EJB desde el cliente");
            
            
        } catch (NamingException ex) {
          //  Logger.getLogger(ClientePersonaService.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        
         
         
         
        
        
    }
    
    
}
