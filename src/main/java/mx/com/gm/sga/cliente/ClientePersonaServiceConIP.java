/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.cliente;

import java.util.List;
import java.util.Properties;
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
public class ClientePersonaServiceConIP {
    
    public static void main(String[] args){
        
         System.out.println("Iniciando llamada al EJB desde el cliente\n");
         
         try {
         Properties props = new Properties();
         props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
         props.setProperty("java.naming.factory.factory.url.pkgs", "com.sun.enterprise.naming");
         props.setProperty("java.naming.factory.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
//Optional . Aqui se cambia la IP del servidor donde est glassfish
         props.setProperty("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
         
        
            Context jndi = new InitialContext(props);
            
              PersonaServiceRemote personaService = 
               (PersonaServiceRemote) jndi.lookup("java:global/sga-jee/PersonaServiceImpl!mx.com.gm.sga.servicio.PersonaServiceRemote");
         
             List<Persona> personas = personaService.listarPersonas();
         
         for(Persona persona: personas){
         System.out.println(persona);
         }
            
             System.out.println("\nFin llamada al EJB desde el cliente");
            
            
            
        } catch (NamingException ex) {
            Logger.getLogger(ClientePersonaServiceConIP.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
        
        
        
    }
    
    
    
    
}
