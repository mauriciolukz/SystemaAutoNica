package com.example.administrador.systemaautonica;

public class dataHistorial {

    private String SOPNUMBE;// factura
    private String ORIGNUMB;// pedido
    private String DOCID;// ID factura SOP40200
    private String DOCDATE;// fecha factura
    private String PYMTRMID;// tip de pago
    private String LOCNCODE;// donde se realizo (COdigo de Bodega)
    private String MSTRNUMB;// numero de segimiento (Numero de Maestro)
    private String MRKDNAMT;// descuento
    private String ORSUBTOT;// Sub Total
    private String ORTAXAMT;// IVA
    private String ORDOCAMT;// Total
    private String CMMTTEXT;

    public dataHistorial() {
    }

    public dataHistorial(String SOPNUMBE, String ORIGNUMB, String DOCID, String DOCDATE, String PYMTRMID, String LOCNCODE, String MSTRNUMB, String MRKDNAMT, String ORSUBTOT, String ORTAXAMT, String ORDOCAMT, String CMMTTEXT) {
        this.SOPNUMBE = SOPNUMBE;
        this.ORIGNUMB = ORIGNUMB;
        this.DOCID = DOCID;
        this.DOCDATE = DOCDATE;
        this.PYMTRMID = PYMTRMID;
        this.LOCNCODE = LOCNCODE;
        this.MSTRNUMB = MSTRNUMB;
        this.MRKDNAMT = MRKDNAMT;
        this.ORSUBTOT = ORSUBTOT;
        this.ORTAXAMT = ORTAXAMT;
        this.ORDOCAMT = ORDOCAMT;
        this.CMMTTEXT = CMMTTEXT;
    }

    public String getSOPNUMBE() {
        return SOPNUMBE;
    }

    public void setSOPNUMBE(String SOPNUMBE) {
        this.SOPNUMBE = SOPNUMBE;
    }

    public String getORIGNUMB() {
        return ORIGNUMB;
    }

    public void setORIGNUMB(String ORIGNUMB) {
        this.ORIGNUMB = ORIGNUMB;
    }

    public String getDOCID() {
        return DOCID;
    }

    public void setDOCID(String DOCID) {
        this.DOCID = DOCID;
    }

    public String getDOCDATE() {
        return DOCDATE;
    }

    public void setDOCDATE(String DOCDATE) {
        this.DOCDATE = DOCDATE;
    }

    public String getPYMTRMID() {
        return PYMTRMID;
    }

    public void setPYMTRMID(String PYMTRMID) {
        this.PYMTRMID = PYMTRMID;
    }

    public String getLOCNCODE() {
        return LOCNCODE;
    }

    public void setLOCNCODE(String LOCNCODE) {
        this.LOCNCODE = LOCNCODE;
    }

    public String getMSTRNUMB() {
        return MSTRNUMB;
    }

    public void setMSTRNUMB(String MSTRNUMB) {
        this.MSTRNUMB = MSTRNUMB;
    }

    public String getMRKDNAMT() {
        return MRKDNAMT;
    }

    public void setMRKDNAMT(String MRKDNAMT) {
        this.MRKDNAMT = MRKDNAMT;
    }

    public String getORSUBTOT() {
        return ORSUBTOT;
    }

    public void setORSUBTOT(String ORSUBTOT) {
        this.ORSUBTOT = ORSUBTOT;
    }

    public String getORTAXAMT() {
        return ORTAXAMT;
    }

    public void setORTAXAMT(String ORTAXAMT) {
        this.ORTAXAMT = ORTAXAMT;
    }

    public String getORDOCAMT() {
        return ORDOCAMT;
    }

    public void setORDOCAMT(String ORDOCAMT) {
        this.ORDOCAMT = ORDOCAMT;
    }

    public String getCMMTTEXT() {
        return CMMTTEXT;
    }

    public void setCMMTTEXT(String CMMTTEXT) {
        this.CMMTTEXT = CMMTTEXT;
    }
}
