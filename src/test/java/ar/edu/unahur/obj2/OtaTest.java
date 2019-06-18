package ar.edu.unahur.obj2;

import ar.edu.unahur.obj2.proveedores.*;
import org.joda.time.DateTime;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.Assert.*;

public class OtaTest {

    Amadeus amadeus = new Amadeus();
    Sabre sabre = new Sabre();
    Worldspan worldspan = new Worldspan();

    AmadeusAdapter amadeusAdapter = new AmadeusAdapter(amadeus);
    SabreAdapter sabreAdapter = new SabreAdapter(sabre);
    WorldspanAdapter worldspanAdapter = new WorldspanAdapter(worldspan);


        List<Proveedor> listaProveedores = Stream.of(amadeusAdapter, sabreAdapter, worldspanAdapter).collect(Collectors.toList());

    @BeforeMethod
    public void setUp() {

    }

    @org.testng.annotations.Test
    public void testBuscarVuelos() {



        DistribuidorDeTrafico distribuidorDeTrafico = new DistribuidorDeTrafico(listaProveedores);
        Ota ota = new Ota(distribuidorDeTrafico);

        DateTime fecha = new DateTime("2019-12-13");


        List<Vuelo> vuelos = ota.buscarVuelos(fecha, "BUE", "MIA");


    }

    @org.testng.annotations.Test
    public void testReservar() {
        DistribuidorDeTrafico distribuidorDeTrafico = new DistribuidorDeTrafico(listaProveedores);
        Ota ota = new Ota(distribuidorDeTrafico);

        DateTime fecha = new DateTime("2019-12-13");


        List<Vuelo> vuelos = ota.buscarVuelos(fecha, "BUE", "MIA");

        Vuelo elegido =  vuelos.get(0);
        Set<Pasajero> pasajeros = Stream.of(new Pasajero("Juan", "Pérez", 40)).collect(Collectors.toSet());

        Boleto boleto = ota.reservar(elegido, pasajeros );

        assertEquals(boleto.getVuelo(), elegido);


    }
}