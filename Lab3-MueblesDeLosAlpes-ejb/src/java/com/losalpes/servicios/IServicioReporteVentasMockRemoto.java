/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ IServicioReporteVentasMockRemoto.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.losalpes.servicios;

import com.losalpes.entities.Mueble;
import com.losalpes.entities.Pais;
import com.losalpes.entities.RegistroVenta;
import com.losalpes.entities.Usuario;
import java.util.List;
import java.util.Map;
import javax.ejb.Remote;

/**
 * Contrato funcional de los servicios de reporte de ventas
 *
 */
@Remote
public interface IServicioReporteVentasMockRemoto {

    /**
     * Retorna todas las ventas de un cliente  
     * @param cliente cliente 
     * @return ventas lista de todas las ventas
     */
    public List<RegistroVenta> getVentasPorCliente(Usuario cliente);
    
    /**
     * Retorna los tres muebles mas vendidos   
     * @return muebles lista de los tres muebles
     */
    public List<Mueble> getTresMueblesMasVendidos();
    
    /**
     * Retorna los cinco mayores compradores por país
     * @param pais Pais por el cual se va a realizar la consulta
     * @return ventas lista de los cinco compradores
     */
    public List<RegistroVenta> getMayoresCompradoresPorPais(Pais pais);

}
