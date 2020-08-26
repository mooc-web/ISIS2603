/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mibarrio.test.persistence;

import co.edu.uniandes.csw.mibarrio.entities.EstudianteEntity;
import co.edu.uniandes.csw.mibarrio.persistence.EstudiantePersistence;
import java.util.ArrayList;
import javax.inject.Inject;
import junit.framework.Assert;
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
    public static JavaArchive createDeplyment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(EstudianteEntity.class.getPackage())
                .addPackage(EstudiantePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    @Inject
    EstudiantePersistence ep;

    @Test
    public void createTest() {

        /*PodamFactory factory = new PodamFactoryImpl();
        
        ArrayList<EstudianteEntity> estudiantes = new ArrayList<EstudianteEntity>();
        
        for (int i = 0; i < 10; i++) {
            EstudianteEntity estudiante = factory.manufacturePojo(EstudianteEntity.class);
            estudiantes.add(estudiante);
            EstudianteEntity result = ep.create(estudiante);
        }

        Assert.assertNotNull(result);
        */
    }

}
