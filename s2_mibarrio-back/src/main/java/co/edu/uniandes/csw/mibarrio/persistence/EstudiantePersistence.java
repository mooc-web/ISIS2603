/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mibarrio.persistence;

import co.edu.uniandes.csw.mibarrio.entities.EstudianteEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author estudiante
 */
@Stateless
public class EstudiantePersistence {
    
    @PersistenceContext(unitName = "mibarrioPU")
    protected EntityManager em;
    
    public EstudianteEntity create(EstudianteEntity estudianteEntity){
        em.persist(estudianteEntity);
        return estudianteEntity;
    }
}
