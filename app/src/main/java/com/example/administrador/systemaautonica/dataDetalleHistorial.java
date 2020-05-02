package com.example.administrador.systemaautonica;

public class dataDetalleHistorial {

    private String ITEMNMBR, ITEMDESC, UOFM, QUANTITY;

    public dataDetalleHistorial() {
    }

    public dataDetalleHistorial(String ITEMNMBR, String ITEMDESC, String UOFM, String QUANTITY) {
        this.ITEMNMBR = ITEMNMBR;
        this.ITEMDESC = ITEMDESC;
        this.UOFM = UOFM;
        this.QUANTITY = QUANTITY;
    }

    public String getITEMNMBR() {
        return ITEMNMBR;
    }

    public void setITEMNMBR(String ITEMNMBR) {
        this.ITEMNMBR = ITEMNMBR;
    }

    public String getITEMDESC() {
        return ITEMDESC;
    }

    public void setITEMDESC(String ITEMDESC) {
        this.ITEMDESC = ITEMDESC;
    }

    public String getUOFM() {
        return UOFM;
    }

    public void setUOFM(String UOFM) {
        this.UOFM = UOFM;
    }

    public String getQUANTITY() {
        return QUANTITY;
    }

    public void setQUANTITY(String QUANTITY) {
        this.QUANTITY = QUANTITY;
    }
}
