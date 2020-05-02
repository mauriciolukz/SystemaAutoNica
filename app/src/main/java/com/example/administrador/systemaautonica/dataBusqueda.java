package com.example.administrador.systemaautonica;

/**
 * Created by Administrador on 9/2/2018.
 */

public class dataBusqueda {

    private String BusqPlacaVehiculo;
    private String BusqNumVehiculo;
    private String BusqFechaRecp;
    private String BusqCliente;
    private String BusqChasis;
    private String BusqMotor;

    public dataBusqueda() {}

    public dataBusqueda(String busqPlacaVehiculo, String busqNumVehiculo, String busqFechaRecp, String busqCliente, String busqChasis, String busqMotor) {
        BusqPlacaVehiculo = busqPlacaVehiculo;
        BusqNumVehiculo = busqNumVehiculo;
        BusqFechaRecp = busqFechaRecp;
        BusqCliente = busqCliente;
        BusqChasis = busqChasis;
        BusqMotor = busqMotor;
    }

    public String getBusqPlacaVehiculo() {
        return BusqPlacaVehiculo;
    }

    public void setBusqPlacaVehiculo(String busqPlacaVehiculo) {
        BusqPlacaVehiculo = busqPlacaVehiculo;
    }

    public String getBusqNumVehiculo() {
        return BusqNumVehiculo;
    }

    public void setBusqNumVehiculo(String busqNumVehiculo) {
        BusqNumVehiculo = busqNumVehiculo;
    }

    public String getBusqFechaRecp() {
        return BusqFechaRecp;
    }

    public void setBusqFechaRecp(String busqFechaRecp) {
        BusqFechaRecp = busqFechaRecp;
    }

    public String getBusqCliente() {
        return BusqCliente;
    }

    public void setBusqCliente(String busqCliente) {
        BusqCliente = busqCliente;
    }

    public String getBusqChasis() {
        return BusqChasis;
    }

    public void setBusqChasis(String busqChasis) {
        BusqChasis = busqChasis;
    }

    public String getBusqMotor() {
        return BusqMotor;
    }

    public void setBusqMotor(String busqMotor) {
        BusqMotor = busqMotor;
    }
}
