package com.example.administrador.systemaautonica.paqueteria;

/**
 * Created by Administrador on 7/3/2018.
 */

public class dataVehiculosRecepcionados {

    int IDzRecepcionVehiculo;
    boolean Circulacion, Seguro, EMC;
    boolean Panel_Instrumento, Velocimetro, Tablero, PideVia_y_Luces, SistemaAudio, ControRadio, Pito, Parabrisas, LucesInterna,
    Retrovisores, FrenoDeMano, Retroceso, EncendedorDeCigarro, Cenicero, Guantera, CinturonDeSeguridad,FuncionamientoVentana,
    PuertasySeguros, AireAcondicionado, MovilidadVolante, IndicadoresAuditivos, CamaraDeRetroceso, ControlDeAlarma,Alfombra;
    boolean TapaCombustible, SistemaDeEnllave, LlanteDeRepusto, Herramientas, Trangulo, Extintores, Remolque,CopaDeSeguridad;
    boolean PuertasDelanteraLH_RH, FalconLH_RH, BumberDelanteroTracero, GuardafangoLH_RH, PuertasTracerasLH_RH,HalogenoLH_RH,
    FocosDelanteros, TricosyTapones, NivelesLiquidos, NivelesAceites, VidrioDelantero, Emblema, RielTecho ,Pescante ,RinDeLujo,
    TechoCanastera, CopaDeLlanta, Lodera, Stop ,TapaDeAceite, AperturaDeMaletero, Calcomania, VidrioTracero, Antena, Defensa,
    Antivuelco, Forros;
    boolean Bateria, Suciedad;
    int NivelDeCombustible;
    String Recepcionista;
    String fecha, hora1, hora2, Matricula;
    int Ultimo_Kilometraje;
    boolean Llanta1;
    String Llanta_detalle1;
    boolean Llanta2;
    String Llanta_detalle2;
    boolean Llanta3;
    String Llanta_detalle3;
    boolean Llanta4;
    String Llanta_detalle4;
    boolean ingresado;
    String parqueo;
    boolean pruebas_de_manejo;
    String fecha_final;
    String Comentario;

    public dataVehiculosRecepcionados() {
    }

    public dataVehiculosRecepcionados(int IDzRecepcionVehiculo, boolean circulacion, boolean seguro, boolean EMC, boolean panel_Instrumento, boolean velocimetro, boolean tablero, boolean pideVia_y_Luces, boolean sistemaAudio, boolean controRadio, boolean pito, boolean parabrisas, boolean lucesInterna, boolean retrovisores, boolean frenoDeMano, boolean retroceso, boolean encendedorDeCigarro, boolean cenicero, boolean guantera, boolean cinturonDeSeguridad, boolean funcionamientoVentana, boolean puertasySeguros, boolean aireAcondicionado, boolean movilidadVolante, boolean indicadoresAuditivos, boolean camaraDeRetroceso, boolean controlDeAlarma, boolean alfombra, boolean tapaCombustible, boolean sistemaDeEnllave, boolean llanteDeRepusto, boolean herramientas, boolean trangulo, boolean extintores, boolean remolque, boolean copaDeSeguridad, boolean puertasDelanteraLH_RH, boolean falconLH_RH, boolean bumberDelanteroTracero, boolean guardafangoLH_RH, boolean puertasTracerasLH_RH, boolean halogenoLH_RH, boolean focosDelanteros, boolean tricosyTapones, boolean nivelesLiquidos, boolean nivelesAceites, boolean vidrioDelantero, boolean emblema, boolean rielTecho, boolean pescante, boolean rinDeLujo, boolean techoCanastera, boolean copaDeLlanta, boolean lodera, boolean stop, boolean tapaDeAceite, boolean aperturaDeMaletero, boolean calcomania, boolean vidrioTracero, boolean antena, boolean defensa, boolean antivuelco, boolean forros, boolean bateria, boolean suciedad, int nivelDeCombustible, String recepcionista, String fecha, String hora1, String hora2, String matricula, int ultimo_Kilometraje, boolean llanta1, String llanta_detalle1, boolean llanta2, String llanta_detalle2, boolean llanta3, String llanta_detalle3, boolean llanta4, String llanta_detalle4, boolean ingresado, String parqueo, boolean pruebas_de_manejo, String fecha_final, String Comentario) {
        this.IDzRecepcionVehiculo = IDzRecepcionVehiculo;
        Circulacion = circulacion;
        Seguro = seguro;
        this.EMC = EMC;
        Panel_Instrumento = panel_Instrumento;
        Velocimetro = velocimetro;
        Tablero = tablero;
        PideVia_y_Luces = pideVia_y_Luces;
        SistemaAudio = sistemaAudio;
        ControRadio = controRadio;
        Pito = pito;
        Parabrisas = parabrisas;
        LucesInterna = lucesInterna;
        Retrovisores = retrovisores;
        FrenoDeMano = frenoDeMano;
        Retroceso = retroceso;
        EncendedorDeCigarro = encendedorDeCigarro;
        Cenicero = cenicero;
        Guantera = guantera;
        CinturonDeSeguridad = cinturonDeSeguridad;
        FuncionamientoVentana = funcionamientoVentana;
        PuertasySeguros = puertasySeguros;
        AireAcondicionado = aireAcondicionado;
        MovilidadVolante = movilidadVolante;
        IndicadoresAuditivos = indicadoresAuditivos;
        CamaraDeRetroceso = camaraDeRetroceso;
        ControlDeAlarma = controlDeAlarma;
        Alfombra = alfombra;
        TapaCombustible = tapaCombustible;
        SistemaDeEnllave = sistemaDeEnllave;
        LlanteDeRepusto = llanteDeRepusto;
        Herramientas = herramientas;
        Trangulo = trangulo;
        Extintores = extintores;
        Remolque = remolque;
        CopaDeSeguridad = copaDeSeguridad;
        PuertasDelanteraLH_RH = puertasDelanteraLH_RH;
        FalconLH_RH = falconLH_RH;
        BumberDelanteroTracero = bumberDelanteroTracero;
        GuardafangoLH_RH = guardafangoLH_RH;
        PuertasTracerasLH_RH = puertasTracerasLH_RH;
        HalogenoLH_RH = halogenoLH_RH;
        FocosDelanteros = focosDelanteros;
        TricosyTapones = tricosyTapones;
        NivelesLiquidos = nivelesLiquidos;
        NivelesAceites = nivelesAceites;
        VidrioDelantero = vidrioDelantero;
        Emblema = emblema;
        RielTecho = rielTecho;
        Pescante = pescante;
        RinDeLujo = rinDeLujo;
        TechoCanastera = techoCanastera;
        CopaDeLlanta = copaDeLlanta;
        Lodera = lodera;
        Stop = stop;
        TapaDeAceite = tapaDeAceite;
        AperturaDeMaletero = aperturaDeMaletero;
        Calcomania = calcomania;
        VidrioTracero = vidrioTracero;
        Antena = antena;
        Defensa = defensa;
        Antivuelco = antivuelco;
        Forros = forros;
        Bateria = bateria;
        Suciedad = suciedad;
        NivelDeCombustible = nivelDeCombustible;
        Recepcionista = recepcionista;
        this.fecha = fecha;
        this.hora1 = hora1;
        this.hora2 = hora2;
        Matricula = matricula;
        Ultimo_Kilometraje = ultimo_Kilometraje;
        Llanta1 = llanta1;
        Llanta_detalle1 = llanta_detalle1;
        Llanta2 = llanta2;
        Llanta_detalle2 = llanta_detalle2;
        Llanta3 = llanta3;
        Llanta_detalle3 = llanta_detalle3;
        Llanta4 = llanta4;
        Llanta_detalle4 = llanta_detalle4;
        this.ingresado = ingresado;
        this.parqueo = parqueo;
        this.pruebas_de_manejo = pruebas_de_manejo;
        this.fecha_final = fecha_final;
        this.Comentario = Comentario;
    }

    public int getIDzRecepcionVehiculo() {
        return IDzRecepcionVehiculo;
    }

    public void setIDzRecepcionVehiculo(int IDzRecepcionVehiculo) {
        this.IDzRecepcionVehiculo = IDzRecepcionVehiculo;
    }

    public boolean isCirculacion() {
        return Circulacion;
    }

    public void setCirculacion(boolean circulacion) {
        Circulacion = circulacion;
    }

    public boolean isSeguro() {
        return Seguro;
    }

    public void setSeguro(boolean seguro) {
        Seguro = seguro;
    }

    public boolean isEMC() {
        return EMC;
    }

    public void setEMC(boolean EMC) {
        this.EMC = EMC;
    }

    public boolean isPanel_Instrumento() {
        return Panel_Instrumento;
    }

    public void setPanel_Instrumento(boolean panel_Instrumento) {
        Panel_Instrumento = panel_Instrumento;
    }

    public boolean isVelocimetro() {
        return Velocimetro;
    }

    public void setVelocimetro(boolean velocimetro) {
        Velocimetro = velocimetro;
    }

    public boolean isTablero() {
        return Tablero;
    }

    public void setTablero(boolean tablero) {
        Tablero = tablero;
    }

    public boolean isPideVia_y_Luces() {
        return PideVia_y_Luces;
    }

    public void setPideVia_y_Luces(boolean pideVia_y_Luces) {
        PideVia_y_Luces = pideVia_y_Luces;
    }

    public boolean isSistemaAudio() {
        return SistemaAudio;
    }

    public void setSistemaAudio(boolean sistemaAudio) {
        SistemaAudio = sistemaAudio;
    }

    public boolean isControRadio() {
        return ControRadio;
    }

    public void setControRadio(boolean controRadio) {
        ControRadio = controRadio;
    }

    public boolean isPito() {
        return Pito;
    }

    public void setPito(boolean pito) {
        Pito = pito;
    }

    public boolean isParabrisas() {
        return Parabrisas;
    }

    public void setParabrisas(boolean parabrisas) {
        Parabrisas = parabrisas;
    }

    public boolean isLucesInterna() {
        return LucesInterna;
    }

    public void setLucesInterna(boolean lucesInterna) {
        LucesInterna = lucesInterna;
    }

    public boolean isRetrovisores() {
        return Retrovisores;
    }

    public void setRetrovisores(boolean retrovisores) {
        Retrovisores = retrovisores;
    }

    public boolean isFrenoDeMano() {
        return FrenoDeMano;
    }

    public void setFrenoDeMano(boolean frenoDeMano) {
        FrenoDeMano = frenoDeMano;
    }

    public boolean isRetroceso() {
        return Retroceso;
    }

    public void setRetroceso(boolean retroceso) {
        Retroceso = retroceso;
    }

    public boolean isEncendedorDeCigarro() {
        return EncendedorDeCigarro;
    }

    public void setEncendedorDeCigarro(boolean encendedorDeCigarro) {
        EncendedorDeCigarro = encendedorDeCigarro;
    }

    public boolean isCenicero() {
        return Cenicero;
    }

    public void setCenicero(boolean cenicero) {
        Cenicero = cenicero;
    }

    public boolean isGuantera() {
        return Guantera;
    }

    public void setGuantera(boolean guantera) {
        Guantera = guantera;
    }

    public boolean isCinturonDeSeguridad() {
        return CinturonDeSeguridad;
    }

    public void setCinturonDeSeguridad(boolean cinturonDeSeguridad) {
        CinturonDeSeguridad = cinturonDeSeguridad;
    }

    public boolean isFuncionamientoVentana() {
        return FuncionamientoVentana;
    }

    public void setFuncionamientoVentana(boolean funcionamientoVentana) {
        FuncionamientoVentana = funcionamientoVentana;
    }

    public boolean isPuertasySeguros() {
        return PuertasySeguros;
    }

    public void setPuertasySeguros(boolean puertasySeguros) {
        PuertasySeguros = puertasySeguros;
    }

    public boolean isAireAcondicionado() {
        return AireAcondicionado;
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        AireAcondicionado = aireAcondicionado;
    }

    public boolean isMovilidadVolante() {
        return MovilidadVolante;
    }

    public void setMovilidadVolante(boolean movilidadVolante) {
        MovilidadVolante = movilidadVolante;
    }

    public boolean isIndicadoresAuditivos() {
        return IndicadoresAuditivos;
    }

    public void setIndicadoresAuditivos(boolean indicadoresAuditivos) {
        IndicadoresAuditivos = indicadoresAuditivos;
    }

    public boolean isCamaraDeRetroceso() {
        return CamaraDeRetroceso;
    }

    public void setCamaraDeRetroceso(boolean camaraDeRetroceso) {
        CamaraDeRetroceso = camaraDeRetroceso;
    }

    public boolean isControlDeAlarma() {
        return ControlDeAlarma;
    }

    public void setControlDeAlarma(boolean controlDeAlarma) {
        ControlDeAlarma = controlDeAlarma;
    }

    public boolean isAlfombra() {
        return Alfombra;
    }

    public void setAlfombra(boolean alfombra) {
        Alfombra = alfombra;
    }

    public boolean isTapaCombustible() {
        return TapaCombustible;
    }

    public void setTapaCombustible(boolean tapaCombustible) {
        TapaCombustible = tapaCombustible;
    }

    public boolean isSistemaDeEnllave() {
        return SistemaDeEnllave;
    }

    public void setSistemaDeEnllave(boolean sistemaDeEnllave) {
        SistemaDeEnllave = sistemaDeEnllave;
    }

    public boolean isLlanteDeRepusto() {
        return LlanteDeRepusto;
    }

    public void setLlanteDeRepusto(boolean llanteDeRepusto) {
        LlanteDeRepusto = llanteDeRepusto;
    }

    public boolean isHerramientas() {
        return Herramientas;
    }

    public void setHerramientas(boolean herramientas) {
        Herramientas = herramientas;
    }

    public boolean isTrangulo() {
        return Trangulo;
    }

    public void setTrangulo(boolean trangulo) {
        Trangulo = trangulo;
    }

    public boolean isExtintores() {
        return Extintores;
    }

    public void setExtintores(boolean extintores) {
        Extintores = extintores;
    }

    public boolean isRemolque() {
        return Remolque;
    }

    public void setRemolque(boolean remolque) {
        Remolque = remolque;
    }

    public boolean isCopaDeSeguridad() {
        return CopaDeSeguridad;
    }

    public void setCopaDeSeguridad(boolean copaDeSeguridad) {
        CopaDeSeguridad = copaDeSeguridad;
    }

    public boolean isPuertasDelanteraLH_RH() {
        return PuertasDelanteraLH_RH;
    }

    public void setPuertasDelanteraLH_RH(boolean puertasDelanteraLH_RH) {
        PuertasDelanteraLH_RH = puertasDelanteraLH_RH;
    }

    public boolean isFalconLH_RH() {
        return FalconLH_RH;
    }

    public void setFalconLH_RH(boolean falconLH_RH) {
        FalconLH_RH = falconLH_RH;
    }

    public boolean isBumberDelanteroTracero() {
        return BumberDelanteroTracero;
    }

    public void setBumberDelanteroTracero(boolean bumberDelanteroTracero) {
        BumberDelanteroTracero = bumberDelanteroTracero;
    }

    public boolean isGuardafangoLH_RH() {
        return GuardafangoLH_RH;
    }

    public void setGuardafangoLH_RH(boolean guardafangoLH_RH) {
        GuardafangoLH_RH = guardafangoLH_RH;
    }

    public boolean isPuertasTracerasLH_RH() {
        return PuertasTracerasLH_RH;
    }

    public void setPuertasTracerasLH_RH(boolean puertasTracerasLH_RH) {
        PuertasTracerasLH_RH = puertasTracerasLH_RH;
    }

    public boolean isHalogenoLH_RH() {
        return HalogenoLH_RH;
    }

    public void setHalogenoLH_RH(boolean halogenoLH_RH) {
        HalogenoLH_RH = halogenoLH_RH;
    }

    public boolean isFocosDelanteros() {
        return FocosDelanteros;
    }

    public void setFocosDelanteros(boolean focosDelanteros) {
        FocosDelanteros = focosDelanteros;
    }

    public boolean isTricosyTapones() {
        return TricosyTapones;
    }

    public void setTricosyTapones(boolean tricosyTapones) {
        TricosyTapones = tricosyTapones;
    }

    public boolean isNivelesLiquidos() {
        return NivelesLiquidos;
    }

    public void setNivelesLiquidos(boolean nivelesLiquidos) {
        NivelesLiquidos = nivelesLiquidos;
    }

    public boolean isNivelesAceites() {
        return NivelesAceites;
    }

    public void setNivelesAceites(boolean nivelesAceites) {
        NivelesAceites = nivelesAceites;
    }

    public boolean isVidrioDelantero() {
        return VidrioDelantero;
    }

    public void setVidrioDelantero(boolean vidrioDelantero) {
        VidrioDelantero = vidrioDelantero;
    }

    public boolean isEmblema() {
        return Emblema;
    }

    public void setEmblema(boolean emblema) {
        Emblema = emblema;
    }

    public boolean isRielTecho() {
        return RielTecho;
    }

    public void setRielTecho(boolean rielTecho) {
        RielTecho = rielTecho;
    }

    public boolean isPescante() {
        return Pescante;
    }

    public void setPescante(boolean pescante) {
        Pescante = pescante;
    }

    public boolean isRinDeLujo() {
        return RinDeLujo;
    }

    public void setRinDeLujo(boolean rinDeLujo) {
        RinDeLujo = rinDeLujo;
    }

    public boolean isTechoCanastera() {
        return TechoCanastera;
    }

    public void setTechoCanastera(boolean techoCanastera) {
        TechoCanastera = techoCanastera;
    }

    public boolean isCopaDeLlanta() {
        return CopaDeLlanta;
    }

    public void setCopaDeLlanta(boolean copaDeLlanta) {
        CopaDeLlanta = copaDeLlanta;
    }

    public boolean isLodera() {
        return Lodera;
    }

    public void setLodera(boolean lodera) {
        Lodera = lodera;
    }

    public boolean isStop() {
        return Stop;
    }

    public void setStop(boolean stop) {
        Stop = stop;
    }

    public boolean isTapaDeAceite() {
        return TapaDeAceite;
    }

    public void setTapaDeAceite(boolean tapaDeAceite) {
        TapaDeAceite = tapaDeAceite;
    }

    public boolean isAperturaDeMaletero() {
        return AperturaDeMaletero;
    }

    public void setAperturaDeMaletero(boolean aperturaDeMaletero) {
        AperturaDeMaletero = aperturaDeMaletero;
    }

    public boolean isCalcomania() {
        return Calcomania;
    }

    public void setCalcomania(boolean calcomania) {
        Calcomania = calcomania;
    }

    public boolean isVidrioTracero() {
        return VidrioTracero;
    }

    public void setVidrioTracero(boolean vidrioTracero) {
        VidrioTracero = vidrioTracero;
    }

    public boolean isAntena() {
        return Antena;
    }

    public void setAntena(boolean antena) {
        Antena = antena;
    }

    public boolean isDefensa() {
        return Defensa;
    }

    public void setDefensa(boolean defensa) {
        Defensa = defensa;
    }

    public boolean isAntivuelco() {
        return Antivuelco;
    }

    public void setAntivuelco(boolean antivuelco) {
        Antivuelco = antivuelco;
    }

    public boolean isForros() {
        return Forros;
    }

    public void setForros(boolean forros) {
        Forros = forros;
    }

    public boolean isBateria() {
        return Bateria;
    }

    public void setBateria(boolean bateria) {
        Bateria = bateria;
    }

    public boolean isSuciedad() {
        return Suciedad;
    }

    public void setSuciedad(boolean suciedad) {
        Suciedad = suciedad;
    }

    public int getNivelDeCombustible() {
        return NivelDeCombustible;
    }

    public void setNivelDeCombustible(int nivelDeCombustible) {
        NivelDeCombustible = nivelDeCombustible;
    }

    public String getRecepcionista() {
        return Recepcionista;
    }

    public void setRecepcionista(String recepcionista) {
        Recepcionista = recepcionista;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora1() {
        return hora1;
    }

    public void setHora1(String hora1) {
        this.hora1 = hora1;
    }

    public String getHora2() {
        return hora2;
    }

    public void setHora2(String hora2) {
        this.hora2 = hora2;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String matricula) {
        Matricula = matricula;
    }

    public int getUltimo_Kilometraje() {
        return Ultimo_Kilometraje;
    }

    public void setUltimo_Kilometraje(int ultimo_Kilometraje) {
        Ultimo_Kilometraje = ultimo_Kilometraje;
    }

    public boolean isLlanta1() {
        return Llanta1;
    }

    public void setLlanta1(boolean llanta1) {
        Llanta1 = llanta1;
    }

    public String getLlanta_detalle1() {
        return Llanta_detalle1;
    }

    public void setLlanta_detalle1(String llanta_detalle1) {
        Llanta_detalle1 = llanta_detalle1;
    }

    public boolean isLlanta2() {
        return Llanta2;
    }

    public void setLlanta2(boolean llanta2) {
        Llanta2 = llanta2;
    }

    public String getLlanta_detalle2() {
        return Llanta_detalle2;
    }

    public void setLlanta_detalle2(String llanta_detalle2) {
        Llanta_detalle2 = llanta_detalle2;
    }

    public boolean isLlanta3() {
        return Llanta3;
    }

    public void setLlanta3(boolean llanta3) {
        Llanta3 = llanta3;
    }

    public String getLlanta_detalle3() {
        return Llanta_detalle3;
    }

    public void setLlanta_detalle3(String llanta_detalle3) {
        Llanta_detalle3 = llanta_detalle3;
    }

    public boolean isLlanta4() {
        return Llanta4;
    }

    public void setLlanta4(boolean llanta4) {
        Llanta4 = llanta4;
    }

    public String getLlanta_detalle4() {
        return Llanta_detalle4;
    }

    public void setLlanta_detalle4(String llanta_detalle4) {
        Llanta_detalle4 = llanta_detalle4;
    }

    public boolean isIngresado() {
        return ingresado;
    }

    public void setIngresado(boolean ingresado) {
        this.ingresado = ingresado;
    }

    public String getParqueo() {
        return parqueo;
    }

    public void setParqueo(String parqueo) {
        this.parqueo = parqueo;
    }

    public boolean isPruebas_de_manejo() {
        return pruebas_de_manejo;
    }

    public void setPruebas_de_manejo(boolean pruebas_de_manejo) {
        this.pruebas_de_manejo = pruebas_de_manejo;
    }

    public String getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String comentario) {
        Comentario = comentario;
    }
}
