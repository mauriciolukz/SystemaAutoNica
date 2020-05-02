package com.example.administrador.systemaautonica;

/**
 * Created by Administrador on 6/2/2018.
 */

public class data {

    private String UniqueID, Type, StartDate, EndDate, StartDateWorkshop, Matricula, Location, Numero_cliente, Description, LOCNCODE, CUSTNMBR;
    private String Nombre_Cliente, CNTCPRSN, CITY, EMAIL, CHASIS, MODEL, COLOR, Ano_vehiculo, SLPRSNID, EXETIVE, ULTKM, Recepcion;

    public data(){}

    public data( String UniqueID, String type, String startDate, String endDate, String startDateWorkshop, String matricula, String location, String numero_cliente, String description, String LOCNCODE, String CUSTNMBR, String nombre_Cliente, String CNTCPRSN, String CITY, String EMAIL, String CHASIS, String MODEL, String COLOR, String ano_vehiculo, String SLPRSNID, String EXETIVE, String ULTKM, String recepcion) {
        this.UniqueID = UniqueID;
        this.Type = type;
        this.StartDate = startDate;
        this.EndDate = endDate;
        this.StartDateWorkshop = startDateWorkshop;
        this.Matricula = matricula;
        this.Location = location;
        this.Numero_cliente = numero_cliente;
        this.Description = description;
        this.LOCNCODE = LOCNCODE;
        this.CUSTNMBR = CUSTNMBR;
        this.Nombre_Cliente = nombre_Cliente;
        this.CNTCPRSN = CNTCPRSN;
        this.CITY = CITY;
        this.EMAIL = EMAIL;
        this.CHASIS = CHASIS;
        this.MODEL = MODEL;
        this.COLOR = COLOR;
        this.Ano_vehiculo = ano_vehiculo;
        this.SLPRSNID = SLPRSNID;
        this.EXETIVE = EXETIVE;
        this.ULTKM = ULTKM;
        this.Recepcion = recepcion;
    }

    public String getUniqueID() {
        return UniqueID;
    }

    public void setUniqueID(String uniqueID) {
        UniqueID = uniqueID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    public String getStartDateWorkshop() {
        return StartDateWorkshop;
    }

    public void setStartDateWorkshop(String startDateWorkshop) {
        StartDateWorkshop = startDateWorkshop;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String matricula) {
        Matricula = matricula;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getNumero_cliente() {
        return Numero_cliente;
    }

    public void setNumero_cliente(String numero_cliente) {
        Numero_cliente = numero_cliente;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getLOCNCODE() {
        return LOCNCODE;
    }

    public void setLOCNCODE(String LOCNCODE) {
        this.LOCNCODE = LOCNCODE;
    }

    public String getCUSTNMBR() {
        return CUSTNMBR;
    }

    public void setCUSTNMBR(String CUSTNMBR) {
        this.CUSTNMBR = CUSTNMBR;
    }

    public String getNombre_Cliente() {
        return Nombre_Cliente;
    }

    public void setNombre_Cliente(String nombre_Cliente) {
        Nombre_Cliente = nombre_Cliente;
    }

    public String getCNTCPRSN() {
        return CNTCPRSN;
    }

    public void setCNTCPRSN(String CNTCPRSN) {
        this.CNTCPRSN = CNTCPRSN;
    }

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getCHASIS() {
        return CHASIS;
    }

    public void setCHASIS(String CHASIS) {
        this.CHASIS = CHASIS;
    }

    public String getMODEL() {
        return MODEL;
    }

    public void setMODEL(String MODEL) {
        this.MODEL = MODEL;
    }

    public String getCOLOR() {
        return COLOR;
    }

    public void setCOLOR(String COLOR) {
        this.COLOR = COLOR;
    }

    public String getAno_vehiculo() {
        return Ano_vehiculo;
    }

    public void setAno_vehiculo(String ano_vehiculo) {
        Ano_vehiculo = ano_vehiculo;
    }

    public String getSLPRSNID() {
        return SLPRSNID;
    }

    public void setSLPRSNID(String SLPRSNID) {
        this.SLPRSNID = SLPRSNID;
    }

    public String getEXETIVE() {
        return EXETIVE;
    }

    public void setEXETIVE(String EXETIVE) {
        this.EXETIVE = EXETIVE;
    }

    public String getULTKM() {
        return ULTKM;
    }

    public void setULTKM(String ULTKM) {
        this.ULTKM = ULTKM;
    }

    public String getRecepcion() {
        return Recepcion;
    }

    public void setRecepcion(String recepcion) {
        Recepcion = recepcion;
    }
}
