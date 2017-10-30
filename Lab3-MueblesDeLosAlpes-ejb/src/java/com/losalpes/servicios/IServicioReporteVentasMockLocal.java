/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ IServicioReporteVentasMockLocal.java
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
import javax.ejb.Local;

/**
 * Contrato funcional de los servicios de reporte de ventas
 *
 */
@Local
public interface IServicioReporteVentasMockLocal {

    /**
     * Retorna todas las ventas de un cliente   
     * @param cliente cliente
     * @return ventas lista de todas las ventas
     */
    public List<RegistroVenta> getVentasPorCliente(Usuario cliente);
    
    
    /**
     * Retorna los tres muebles mas vendidos   
     * @return ventas lista de los tres muebles
     */
    public List<RegistroVenta> getTresMueblesMasVendidos();
    
    

}
