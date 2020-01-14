/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import mx.com.gm.sga.domain.Persona;

/**
 *
 * @author macbook
 */
@Stateless
public class PersonaServiceImpl implements PersonaServiceRemote {

    @Override
    public List<Persona> listarPersonas() {
   
       List<Persona> personas= new ArrayList<>();
       personas.add(new Persona(1,"Juan","Perez","Suarez","jperez@gmail.com","5566789"));
       personas.add(new Persona(2,"Martha","Suarez","Jimenez","msuarez@gmail.com","656678911"));
       return personas;
    }

    @Override
    public Persona encontrarPersonaPorID(Persona persona) {
        return null;
    }

    @Override
    public Persona encontrarPersonaPorEmail(Persona persona) {
         return null;
    }

    @Override
    public void registrarPersona(Persona persona) {
      
    }

    @Override
    public void modificarPersona(Persona persona) {
      }

    @Override
    public void eliminarPersona(Persona persona) {
    }
    
    
    
    
    
    
}
