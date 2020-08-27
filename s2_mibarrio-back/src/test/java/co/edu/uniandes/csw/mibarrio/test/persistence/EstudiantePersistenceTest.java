/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mibarrio.test.persistence;

import co.edu.uniandes.csw.mibarrio.entities.EstudianteEntity;
import co.edu.uniandes.csw.mibarrio.persistence.EstudiantePersistence;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author estudiante
 */
@RunWith(Arquillian.class)
public class EstudiantePersistenceTest {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(EstudianteEntity.class.getPackage())
                .addPackage(EstudiantePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    @Inject
    EstudiantePersistence ep;
    
    @PersistenceContext
    protected EntityManager em;

    @Test
    public void createTest() {

        PodamFactory factory = new PodamFactoryImpl();
        EstudianteEntity estudiante = factory.manufacturePojo(EstudianteEntity.class);
        EstudianteEntity result = ep.create(estudiante);
        assertNotNull(result);
        
        EstudianteEntity entity = em.find(EstudianteEntity.class, result.getId());
        
        assertEquals(estudiante.getName(), entity.getName());
        assertEquals(estudiante.getAddress(), entity.getAddress());
        
    }

}
