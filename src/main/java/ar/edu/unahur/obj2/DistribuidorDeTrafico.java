package ar.edu.unahur.obj2;

import java.util.List;
import java.util.Random;

public class DistribuidorDeTrafico {

    private Random random = new Random();
    private List<Proveedor> proveedores; //Cambio el switch que estaba originalmente por una lista.

    public DistribuidorDeTrafico(List<Proveedor> proveedor) {
        this.proveedores = proveedor;
    }

    public void addProveedor(Proveedor proveedor) {
        proveedores.add(proveedor);
    }

    public Proveedor proveedor() {
        return proveedores.get(random.nextInt(proveedores.size()));
    }

}
