package ProyectoTPI.dominio;

import ProyectoTPI.recursos.MensajesDominio;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Cuenta {
    private String fechaYHoraCreacion;
    private String fechaYHoraBaja;
    private EstadoCuenta estadoCuenta;
    private ArrayList<Vehiculo> vehiculos;
    private RolPersonaUTN rolPersonaUtn;

    public Cuenta(String fechaYHoraCreacion, EstadoCuenta estadoCuenta, RolPersonaUTN rolPersonaUtn) {
        this.fechaYHoraCreacion = fechaYHoraCreacion;
        this.estadoCuenta = estadoCuenta;
        this.vehiculos = new ArrayList<>();
        this.rolPersonaUtn = rolPersonaUtn;
    }

    public String getFechaYHoraCreacion() {
        return this.fechaYHoraCreacion;
    }

    public String getFechaYHoraBaja() {
        if (this.fechaYHoraBaja == null) {
            return MensajesDominio.CUENTA_NUNCA_DADA_BAJA;
        } else {
            return this.fechaYHoraBaja;
        }
    } 

    public EstadoCuenta getEstadoCuenta() {
        return this.estadoCuenta;
    }

    public List<Vehiculo> getVehiculos() {
        if (!tieneVehiculos()) {
            return null;
        }
        return this.vehiculos;
    }
    public Vehiculo getVehiculo(String patente) {
        if (!tieneVehiculos()) {
            return null;
        }
        return buscarVehiculo(patente);
    }

    public Vehiculo buscarVehiculo(String patente) {
        Predicate<Vehiculo> verificarPatente = v -> v.getPatente().equals(patente);
        Vehiculo vehiculo = vehiculos.stream()
                              .filter(verificarPatente)
                              .findFirst()
                              .orElse(null);
        return vehiculo;
    } 

    public boolean tieneVehiculos() {
        if (this.vehiculos.isEmpty()) {
            System.out.println(MensajesDominio.NO_POSEE_VEHICULOS);
            return false;
        }
        return true;
    }

    public void agregarVehiculo(Vehiculo Automotor) {
        this.vehiculos.add(Automotor);
    }

    public void eliminarVehiculo(Vehiculo Automotor) {
        this.vehiculos.remove(Automotor);
        System.out.println(MensajesDominio.VEHICULO_ELIMINADO);
    }

    public void darDeBajaCuenta() {
        if (this.estadoCuenta.getValorEstadoCuenta() == "INACTIVA") {
            System.out.println(MensajesDominio.CUENTA_YA_DADA_BAJA + " Fecha de baja: " + this.fechaYHoraBaja);
        } else {
            this.estadoCuenta.setValorEstadoCuenta("INACTIVA");
            LocalDateTime ahora = LocalDateTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            this.fechaYHoraBaja = ahora.format(formato);
        }
    }

    public void reactivarCuenta() {
        this.estadoCuenta.setValorEstadoCuenta("ACTIVA");
    }
}