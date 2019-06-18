package ar.edu.unahur.obj2;

import ar.edu.unahur.obj2.proveedores.Sabre;
import org.joda.time.DateTime;

import java.util.List;
import java.util.Set;

public class SabreAdapter implements Proveedor {

    private Sabre sabre;

    public SabreAdapter(Sabre sabre) {
        this.sabre = sabre;
    }

    @Override
    public List<Vuelo> buscarVuelos(DateTime fecha, String origen, String destino) {
        return sabre.buscar(fecha, origen, destino);
    }

    @Override
    public Boleto reservar(Vuelo vuelo, Set<Pasajero> pasajeros) {
        return sabre.comprar(vuelo, pasajeros);
    }
}
