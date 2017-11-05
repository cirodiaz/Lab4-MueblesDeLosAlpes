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

import com.losalpes.entities.Ciudad;
import com.losalpes.entities.Mueble;
import com.losalpes.entities.Pais;
import com.losalpes.entities.RegistroVenta;
import com.losalpes.entities.Usuario;
import java.util.ArrayList;
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
    
    /**
     * Retorna todas las ventas de un cliente  
     * @param cliente cliente 
     * @return ventas lista de todas las ventas
     */
    @Override
    public List<RegistroVenta> getVentasPorCliente(Usuario cliente) {
        List<RegistroVenta> registrosVenta = entityManager.createNamedQuery("ReporteVenta.findByUsuario").setParameter("cliente", cliente)
                .getResultList();
        return registrosVenta;   
    }

    
    /**
     * Retorna los tres muebles mas vendidos   
     * @return ventas lista de los tres muebles
     */
    @Override
    public List<Mueble> getTresMueblesMasVendidos() {
        
        List<Object[]>  registroMuebles = entityManager.createNamedQuery("Mueble.findTresMueblesMasVendidos").setMaxResults(3)
                .getResultList();
        
        
        List<Mueble> muebles = new ArrayList<>();
        for (Object[] r : registroMuebles) {
            
            Mueble m = (Mueble) r[0];
            long cantidad = (long) r[1];
            m.setCantidad((int) cantidad);
            muebles.add(m);            
        }
             
        return muebles;  
    
    }
   
    /**
     * Retorna los cinco mayores compradores por país
     * @param pais Pais por el cual se va a realizar la consulta
     * @return ventas lista de los cinco compradores
     */
    @Override
    public List<RegistroVenta> getMayoresCompradoresPorPais(Pais pais) {

        List<Ciudad> ciudadesList = entityManager.createNamedQuery("Pais.findCiudadesPorPais").
                setParameter("pais", pais.getNombre()).getResultList();

        if (!ciudadesList.isEmpty()) {
            List<Object[]> registrosCompradores = entityManager.createNamedQuery("ReporteVenta.findMayoresCompradoresPorPais").
                    setParameter("ciudades", ciudadesList).setMaxResults(5).getResultList();

            List<RegistroVenta> registrosVenta = new ArrayList<>();

            for (Object[] r : registrosCompradores) {
                Usuario u = (Usuario) r[0];
                long cantidad = (long) r[1];
                Mueble m = new Mueble();
                m.setPrecio((double) r[2]);
                RegistroVenta registro = new RegistroVenta(null, m, (int) cantidad, null, u);
                registrosVenta.add(registro);
            }
            return registrosVenta;
        }

        return null;  
    }

    
}