/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ ServicioReporteVentasMock.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.losalpes.servicios;

import com.losalpes.entities.RegistroVenta;
import com.losalpes.entities.Usuario;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 * Implementación de los servicios de reporte de ventas de los clientes del sistema
 * 
 */
@Stateless
public class ServicioReporteVentasMock implements IServicioReporteVentasMockLocal, IServicioReporteVentasMockRemoto{

    @EJB
    private IServicioPersistenciaMockLocal servicioPersistencia;

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    /**
     * La entidad encargada de persistir en la base de datos
     */
    @PersistenceContext
    private EntityManager entityManager;
    
    
    @Override
    public List<RegistroVenta> getVentasPorCliente(Usuario cliente) {
        List<RegistroVenta> registrosVenta = entityManager.createNamedQuery("ReporteVenta.findByUsuario").setParameter("cliente", cliente)
                .getResultList();
        return registrosVenta;   
    }

    @Override
    public List<RegistroVenta> getTresMueblesMasVendidos() {
        List<RegistroVenta> registrosVenta = entityManager.createNamedQuery("ReporteVenta.findMaxMueblesVendidos").getResultList();
        
        for (RegistroVenta registroVenta : registrosVenta) {
            System.out.println("cantidad: " + registroVenta.getCantidad());
        }
                
        
        return registrosVenta; 
    
    }
   
    
}
