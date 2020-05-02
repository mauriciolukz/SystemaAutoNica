package com.example.administrador.systemaautonica;


import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.StrictMode;
import android.util.Base64;
import android.widget.Toast;

import com.example.administrador.systemaautonica.paqueteria.OtrasClases;
import com.example.administrador.systemaautonica.paqueteria.Rfc2898DeriveBytes;
import com.example.administrador.systemaautonica.paqueteria.dataVehiculosRecepcionados;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


/**
 * Created by Administrador on 6/2/2018.
 */

public class conexion_base_de_datos {

    static public String usuario;
    
    public static class ConexionSQL {

        public static Connection ConnectionHelper(Context df) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Connection connection = null;
            String ConnectionURL = null;

            if(compruebaConexion(df)){
                try {
                    Class.forName("net.sourceforge.jtds.jdbc.Driver");
                    //ConnectionURL = "jdbc:jtds:sqlserver://192.168.1.45;databaseName=ANSA;user=sa;password=D1t2020;";
                    ConnectionURL = "jdbc:jtds:sqlserver://192.168.0.97;databaseName=ANSA;user=Lrodriguez;password=Jack2016;";
                    connection = DriverManager.getConnection(ConnectionURL);
                } catch (SQLException | ClassNotFoundException se ) {
                    Toast.makeText(df.getApplicationContext(),se.getMessage().toString(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(df.getApplicationContext(),e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(df.getApplicationContext(),"No hay conexion a internet, revice su conecion antes de realizar otra accion", Toast.LENGTH_SHORT).show();
            }
            return connection;
        }
    }

    public static class ConexionSQL2 {

        public static Connection ConnectionHelper(Context df) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Connection connection = null;
            String ConnectionURL = null;

            try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver");
                //ConnectionURL = "jdbc:jtds:sqlserver://192.168.1.45;databaseName=CC;user=sa;password=D1t2020;";
                ConnectionURL = "jdbc:jtds:sqlserver://192.168.0.97;databaseName=CC;user=Lrodriguez;password=Jack2016;";

                connection = DriverManager.getConnection(ConnectionURL);

            } catch (SQLException | ClassNotFoundException se ) {
                Toast.makeText(df.getApplicationContext(),se.getMessage().toString(), Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(df.getApplicationContext(),e.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
            return connection;
        }
    }

    public static class ConexionSQL3 {

        public static Connection ConnectionHelper(Context df) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Connection connection = null;
            String ConnectionURL = null;

            try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver");
                //ConnectionURL = "jdbc:jtds:sqlserver://192.168.1.45;databaseName=TRASLADOS;user=sa;password=D1t2020;";
                ConnectionURL = "jdbc:jtds:sqlserver://192.168.0.97;databaseName=TRASLADOS;user=Lrodriguez;password=Jack2016;";

                connection = DriverManager.getConnection(ConnectionURL);

            } catch (SQLException | ClassNotFoundException se ) {
                Toast.makeText(df.getApplicationContext(),se.getMessage().toString(), Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(df.getApplicationContext(),e.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
            return connection;
        }
    }

    public List<String> parqueo( Context df ){

        List<String> lista = new ArrayList<>();

        try {
            Connection connect = ConexionSQL2.ConnectionHelper(df);
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM [dbo].[zParqueo]");
            while (rs.next()) {

                lista.add(rs.getString("derivacion"));
            }
            connect.close();

        } catch (SQLException e) {
            Toast.makeText(df.getApplicationContext(),e.getMessage().toString(), Toast.LENGTH_SHORT).show();

        }

        return lista;
    }

    public List<data> contenercitas( Context df , dataBusqueda db){
        List<data> DataListaCitas = new ArrayList<>();

        String da1 = "", da12 = "", da13 = "", da14 = "";

        if (db.getBusqMotor() != ""){
            da1 = " and CUSTNMBR = '"+db.getBusqMotor()+"'";
        }
        if (db.getBusqPlacaVehiculo() != ""){
            da12 = " and Subject = '"+db.getBusqPlacaVehiculo()+"'";
        }
        if (db.getBusqChasis() != ""){
            da13 = " and CHASIS = '"+db.getBusqChasis()+"'";
        }
        if (db.getBusqNumVehiculo() != ""){
            da14 = " and PERIOD = '"+db.getBusqNumVehiculo()+"'";
        }

        SharedPreferences sharedPref = df.getSharedPreferences("Systema_data_archivo_complejo", Context.MODE_PRIVATE);
        String defaultValue1 = sharedPref.getString("Nombre","");
        String defaultValue2 = sharedPref.getString("permiso","Usuario");
        String defaultValue3 = sharedPref.getString("lugar","");

        String datos_ingresa_cita = "";

        if(defaultValue2.equals("Usuario")){
            datos_ingresa_cita = "and SLPRSNID = '"+defaultValue1+"' ";
        }

        try {

            Connection connect = ConexionSQL2.ConnectionHelper(null);

            if(connect != null){
                Statement st = connect.createStatement();

                ResultSet rs = st.executeQuery("SELECT Appointments.UniqueID, Type, StartDate, EndDate, StartDateWorkshop, Subject as Matricula, Location, \n" +
                        "Description, LOCNCODE, CUSTNMBR, CUSTNAME as Nombre_Cliente, CNTCPRSN, \n" +
                        "CITY, EMAIL, CHASIS, MODEL, COLOR, PERIOD as Ano_vehiculo, SLPRSNID, EXETIVE, ULTKM, DEXROW AS Recepcion\n" +
                        "FROM Appointments  INNER JOIN AppointmentsDetail ON Appointments.UniqueID  = AppointmentsDetail.UniqueID \n" +
                        "where convert(date ,StartDateWorkshop) = '"+db.getBusqFechaRecp()+"' \n" +
                        "and CUSTNAME like ('%"+db.getBusqCliente()+"%') and CUSTNAME <> '' "+da1+da12+da13+da14+" and ActionRe = 0 and LOCNCODE='"+defaultValue3+"' "+datos_ingresa_cita+" order by CUSTNAME");

                while (rs.next()) {

                    data d = new data();

                    d.setUniqueID(rs.getString("UniqueID"));
                    d.setType(rs.getString("Type"));
                    d.setStartDate(rs.getString("StartDate"));
                    d.setEndDate(rs.getString("EndDate"));
                    d.setStartDateWorkshop(rs.getString("StartDateWorkshop"));
                    d.setMatricula(rs.getString("Matricula"));
                    d.setCITY(rs.getString("CITY"));
                    d.setEMAIL(rs.getString("EMAIL"));
                    d.setCHASIS(rs.getString("CHASIS"));
                    d.setMODEL(rs.getString("MODEL"));
                    d.setCOLOR(rs.getString("COLOR"));
                    d.setAno_vehiculo(rs.getString("Ano_vehiculo"));
                    d.setSLPRSNID(rs.getString("SLPRSNID"));
                    d.setEXETIVE(rs.getString("EXETIVE"));
                    d.setULTKM(rs.getString("ULTKM"));
                    d.setRecepcion(rs.getString("Recepcion"));
                    d.setNombre_Cliente(rs.getString("Nombre_Cliente"));
                    d.setNumero_cliente(rs.getString("Location"));
                    d.setDescription(rs.getString("Description"));
                    d.setCUSTNMBR(rs.getString("CUSTNMBR"));

                    DataListaCitas.add(d);
                }
                connect.close();
            }else{
                //Toast.makeText(df.getApplicationContext(),"Registro de conexion invalido, verifique su conexion de datos, hable con su proveedor de servicios", Toast.LENGTH_SHORT).show();
            }

        } catch (SQLException e) {
            //Toast.makeText(df.getApplicationContext(),e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }

        return DataListaCitas;
    }

    public List<dataDetalleHistorial> ListaDetalleHistorial( Context df , String datos){
        List<dataDetalleHistorial> DataListaCitas = new ArrayList<>();

        try {

            Connection connect = ConexionSQL.ConnectionHelper(df);

            if(connect != null){
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery("select ITEMNMBR, ITEMDESC, UOFM, QUANTITY from SOP30300 where SOPNUMBE = '"+datos+"'");
                while (rs.next()) {

                    dataDetalleHistorial d = new dataDetalleHistorial();

                    d.setITEMNMBR(rs.getString("ITEMNMBR"));
                    d.setITEMDESC(rs.getString("ITEMDESC"));
                    d.setUOFM(rs.getString("UOFM"));
                    d.setQUANTITY(rs.getString("QUANTITY").replace(".00000",""));

                    DataListaCitas.add(d);
                }
                connect.close();
            }else{
                Toast.makeText(df.getApplicationContext(),"Registro de conexion invalido, verifique su conexion de datos, hable con su proveedor de servicios", Toast.LENGTH_SHORT).show();
            }

        } catch (SQLException e) {
            Toast.makeText(df.getApplicationContext(),e.getMessage().toString(), Toast.LENGTH_SHORT).show();

        }

        return DataListaCitas;
    }

    public String correo(Context df , String motor){

        String respuesta = "";

        try {
            Connection connect = ConexionSQL.ConnectionHelper(df);

            if(connect != null){
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery("select * from SY01200 where [Master_Type]='CUS' and INET1 like('%@%') and Master_ID = '"+motor.trim()+"'");
                while (rs.next()) {
                    respuesta = "" + rs.getString("INET1");
                }
                connect.close();
            }else{
                Toast.makeText(df.getApplicationContext(),"Registro de conexion invalido, verifique su conexion de datos, hable con su proveedor de servicios", Toast.LENGTH_SHORT).show();
            }

        } catch (SQLException e) {
            Toast.makeText(df.getApplicationContext(),e.getMessage().toString(), Toast.LENGTH_SHORT).show();

        }

        return respuesta;
    }

    public String correo_user(Context df , String usuario){

        String respuesta = "";

        try {
            Connection connect = ConexionSQL3.ConnectionHelper(df);

            if(connect != null){
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery("select * from HD_USUARIOS where NOMBRE = '"+usuario.trim()+"'");
                while (rs.next()) {
                    respuesta = "" + rs.getString("CORREO");
                }
                connect.close();
            }else{
                Toast.makeText(df.getApplicationContext(),"Registro de conexion invalido, verifique su conexion de datos, hable con su proveedor de servicios", Toast.LENGTH_SHORT).show();
            }

        } catch (SQLException e) {
            Toast.makeText(df.getApplicationContext(),e.getMessage().toString(), Toast.LENGTH_SHORT).show();

        }

        return respuesta;
    }

    public List<dataImagenes> ListaImagenes(Context df , String id){
        List<dataImagenes> DataListaImage = new ArrayList<>();

        try {
            Connection connect = ConexionSQL2.ConnectionHelper(df);
            if(connect != null){
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery("select * from [dbo].[zAppointmentsImagen] where IDzAppointmentsRecepcionVehiculo = "+id+" and nombre not in ('firmaEmpleado', 'firmaCliente')");
                while (rs.next()) {

                    byte[] decodedString = rs.getBytes("imagen2");
                    Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

                    dataImagenes d = new dataImagenes();
                    d.setDatos(rs.getString("nombre"));
                    d.setImage(decodedByte);
                    d.setId(rs.getString("IDzAppointmentsImagen"));
                    DataListaImage.add(d);
                }
                connect.close();
            }else{
                Toast.makeText(df.getApplicationContext(),"Registro de conexion invalido, verifique su conexion de datos, hable con su proveedor de servicios", Toast.LENGTH_SHORT).show();
            }
        } catch (SQLException e) {
            Toast.makeText(df.getApplicationContext(),e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
        return DataListaImage;
    }

    public Bitmap FotoImagenes(Context df , String id){
        Bitmap DataListaImage = null;
        try {
            Connection connect = ConexionSQL2.ConnectionHelper(df);
            if(connect != null){
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery("select * from [dbo].[zAppointmentsImagen] where IDzAppointmentsImagen = "+id);
                while (rs.next()) {
                    byte[] decodedString = rs.getBytes("imagen2");
                    Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                    DataListaImage = decodedByte;
                }
                connect.close();
            }else{
                Toast.makeText(df.getApplicationContext(),"Registro de conexion invalido, verifique su conexion de datos, hable con su proveedor de servicios", Toast.LENGTH_SHORT).show();
            }
        } catch (SQLException e) {
            Toast.makeText(df.getApplicationContext(),e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
        return DataListaImage;
    }

    public List<data> ListaAutosIngresados( Context df , dataBusqueda db){
        List<data> DataListaCitas = new ArrayList<>();

        String da1 = "", da12 = "", da13 = "", da14 = "", da15 = "";

        if (db.getBusqMotor() != ""){
            da1 = " and CUSTNMBR = '"+db.getBusqMotor()+"'";
        }
        if (db.getBusqPlacaVehiculo() != ""){
            da12 = " and Subject = '"+db.getBusqPlacaVehiculo()+"'";
        }
        if (db.getBusqFechaRecp() != ""){
            da13 = " and DDFECH = '"+db.getBusqFechaRecp()+"'";
        }
        if (db.getBusqChasis() != ""){
            da14 = " and CHASIS = '"+db.getBusqChasis()+"'";
        }
        if (db.getBusqNumVehiculo() != ""){
            da15 = " and PERIOD = '"+db.getBusqNumVehiculo()+"'";
        }

        SharedPreferences sharedPref = df.getSharedPreferences("Systema_data_archivo_complejo", Context.MODE_PRIVATE);
        String nombre = sharedPref.getString("Nombre","");

        try {

            Connection connect = ConexionSQL2.ConnectionHelper(df);

            if(connect != null){
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery("SELECT Appointments.UniqueID, Type, StartDate, EndDate, StartDateWorkshop, Subject as Matricula, Location, Description, LOCNCODE, CUSTNMBR, \n" +
                        "CUSTNAME as Nombre_Cliente, CNTCPRSN, CITY, EMAIL, CHASIS, MODEL, COLOR, PERIOD as Ano_vehiculo, SLPRSNID, EXETIVE, ULTKM, DEXROW AS Recepcion \n" +
                        "FROM Appointments  INNER JOIN AppointmentsDetail ON Appointments.UniqueID  = AppointmentsDetail.UniqueID\n" +
                        "where Appointments.UniqueID in (select IDAppointments from [dbo].[zAppointmentsRecepcionVehiculo] WHERE FFFECH is NULL and REPCEP='"+nombre+"' "+da13+") " +
                        "and CUSTNAME like ('%"+db.getBusqCliente()+"%')"+da1 + da12 + da14 + da15);
                while (rs.next()) {

                    data d = new data();
                    d.setUniqueID(rs.getString("UniqueID"));
                    d.setType(rs.getString("Type"));
                    d.setStartDate(rs.getString("StartDate"));
                    d.setEndDate(rs.getString("EndDate"));
                    d.setStartDateWorkshop(rs.getString("StartDateWorkshop"));
                    d.setMatricula(rs.getString("Matricula"));
                    d.setCITY(rs.getString("CITY"));
                    d.setEMAIL(rs.getString("EMAIL"));
                    d.setCHASIS(rs.getString("CHASIS"));
                    d.setMODEL(rs.getString("MODEL"));
                    d.setCOLOR(rs.getString("COLOR"));
                    d.setAno_vehiculo(rs.getString("Ano_vehiculo"));
                    d.setSLPRSNID(rs.getString("SLPRSNID"));
                    d.setEXETIVE(rs.getString("EXETIVE"));
                    d.setULTKM(rs.getString("ULTKM"));
                    d.setRecepcion(rs.getString("Recepcion"));
                    d.setNombre_Cliente(rs.getString("Nombre_Cliente"));
                    d.setNumero_cliente(rs.getString("Location"));
                    d.setDescription(rs.getString("Description"));
                    d.setCUSTNMBR(rs.getString("CUSTNMBR"));

                    DataListaCitas.add(d);
                }
                connect.close();
            }else{
                Toast.makeText(df.getApplicationContext(),"Registro de conexion invalido, verifique su conexion de datos, hable con su proveedor de servicios", Toast.LENGTH_SHORT).show();
            }

        } catch (SQLException e) {
            Toast.makeText(df.getApplicationContext(),e.getMessage().toString(), Toast.LENGTH_SHORT).show();

        }

        return DataListaCitas;
    }

    public dataVehiculosRecepcionados ListaAutosBuscarDataAcion(Context df , String id){
        dataVehiculosRecepcionados f = new dataVehiculosRecepcionados();

        SharedPreferences sharedPref = df.getSharedPreferences("Systema_data_archivo_complejo", Context.MODE_PRIVATE);
        String defaultValue1 = sharedPref.getString("Nombre","");

        try {

            Connection connect = ConexionSQL2.ConnectionHelper(df);

            if(connect != null){
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery("select * from [dbo].[zAppointmentsRecepcionVehiculo] WHERE FFFECH is NULL and REPCEP='"+defaultValue1+"' and IDAppointments='"+id+"';");
                if (rs.next()) {

                    Toast.makeText(df.getApplicationContext(),"Entro", Toast.LENGTH_SHORT).show();

                    f.setIDzRecepcionVehiculo(rs.getInt("IDzAppointmentsRecepcionVehiculo"));
                    f.setCirculacion(valor(rs.getInt("DOCCIR")));
                    f.setSeguro(valor(rs.getInt("DOCSEG")));
                    f.setEMC(valor(rs.getInt("DOCEMC")));
                    f.setPanel_Instrumento(valor(rs.getInt("INTPIS")));
                    f.setVelocimetro(valor(rs.getInt("INTVEL")));
                    f.setTablero(valor(rs.getInt("INTTAB")));
                    f.setPideVia_y_Luces(valor(rs.getInt("INTPVL")));
                    f.setSistemaAudio(valor(rs.getInt("INTAUD")));
                    f.setControRadio(valor(rs.getInt("INTCRA")));
                    f.setPito(valor(rs.getInt("INTPIT")));
                    f.setParabrisas(valor(rs.getInt("INTPAR")));
                    f.setLucesInterna(valor(rs.getInt("INTLUC")));
                    f.setRetrovisores(valor(rs.getInt("INTRTV")));
                    f.setFrenoDeMano(valor(rs.getInt("INTFRE")));
                    f.setRetroceso(valor(rs.getInt("INTRTC")));
                    f.setEncendedorDeCigarro(valor(rs.getInt("INTENC")));
                    f.setCenicero(valor(rs.getInt("INTCEN")));
                    f.setGuantera(valor(rs.getInt("INTGUA")));
                    f.setCinturonDeSeguridad(valor(rs.getInt("INTCIN")));
                    f.setFuncionamientoVentana(valor(rs.getInt("INTFVE")));
                    f.setPuertasySeguros(valor(rs.getInt("INTPYS")));
                    f.setAireAcondicionado(valor(rs.getInt("INTAAC")));
                    f.setMovilidadVolante(valor(rs.getInt("INTMOV")));
                    f.setIndicadoresAuditivos(valor(rs.getInt("INTIAD")));
                    f.setCamaraDeRetroceso(valor(rs.getInt("INTCRE")));
                    f.setControlDeAlarma(valor(rs.getInt("INTCAL")));
                    f.setAlfombra(valor(rs.getInt("INTALF")));
                    f.setTapaCombustible(valor(rs.getInt("POSTCO")));
                    f.setSistemaDeEnllave(valor(rs.getInt("POSSLL")));
                    f.setLlanteDeRepusto(valor(rs.getInt("POSLDR")));
                    f.setHerramientas(valor(rs.getInt("POSHER")));
                    f.setTrangulo(valor(rs.getInt("POSTRA")));
                    f.setExtintores(valor(rs.getInt("POSEXT")));
                    f.setRemolque(valor(rs.getInt("POSREM")));
                    f.setCopaDeSeguridad(valor(rs.getInt("POSCDS")));
                    f.setPuertasDelanteraLH_RH(valor(rs.getInt("EXTPDA")));
                    f.setFalconLH_RH(valor(rs.getInt("EXTFAL")));
                    f.setBumberDelanteroTracero(valor(rs.getInt("EXTBDT")));
                    f.setGuardafangoLH_RH(valor(rs.getInt("EXTGFG")));
                    f.setPuertasTracerasLH_RH(valor(rs.getInt("EXTPTA")));
                    f.setHalogenoLH_RH(valor(rs.getInt("EXTHAL")));
                    f.setFocosDelanteros(valor(rs.getInt("EXTFOC")));
                    f.setTricosyTapones(valor(rs.getInt("EXTTYT")));
                    f.setNivelesLiquidos(valor(rs.getInt("EXTNLI")));
                    f.setNivelesAceites(valor(rs.getInt("EXTNAC")));
                    f.setVidrioDelantero(valor(rs.getInt("EXTVDL")));
                    f.setEmblema(valor(rs.getInt("EXTEMB")));
                    f.setRielTecho(valor(rs.getInt("EXTRIE")));
                    f.setPescante(valor(rs.getInt("EXTPES")));
                    f.setRinDeLujo(valor(rs.getInt("EXTRDL")));
                    f.setTechoCanastera(valor(rs.getInt("EXTTCN")));
                    f.setCopaDeLlanta(valor(rs.getInt("EXTCDL")));
                    f.setLodera(valor(rs.getInt("EXTLOD")));
                    f.setStop(valor(rs.getInt("EXTSTP")));
                    f.setTapaDeAceite(valor(rs.getInt("EXTTAP")));
                    f.setAperturaDeMaletero(valor(rs.getInt("EXTAPR")));
                    f.setCalcomania(valor(rs.getInt("EXTCAL")));
                    f.setVidrioTracero(valor(rs.getInt("EXTVID")));
                    f.setAntena(valor(rs.getInt("EXTATN")));
                    f.setDefensa(valor(rs.getInt("EXTDEF")));
                    f.setAntivuelco(valor(rs.getInt("EXTATV")));
                    f.setForros(valor(rs.getInt("EXTFRR")));
                    f.setBateria(valor(rs.getInt("OTRBAT")));
                    f.setSuciedad(valor(rs.getInt("OTRSUC")));
                    f.setNivelDeCombustible(rs.getInt("OTRNCB"));
                    f.setRecepcionista(rs.getString("REPCEP"));
                    f.setFecha(rs.getString("DDFECH"));
                    f.setHora1(rs.getString("DDHOR1"));
                    f.setHora2(rs.getString("DDHOR2"));
                    f.setMatricula(rs.getString("IDDMAT"));
                    f.setUltimo_Kilometraje(rs.getInt("CADKMT"));
                    f.setLlanta1(valor(rs.getInt("AUTLL1")));
                    f.setLlanta_detalle1(rs.getString("DETLL1"));
                    f.setLlanta2(valor(rs.getInt("AUTLL2")));
                    f.setLlanta_detalle2(rs.getString("DETLL2"));
                    f.setLlanta3(valor(rs.getInt("AUTLL3")));
                    f.setLlanta_detalle3(rs.getString("DETLL3"));
                    f.setLlanta4(valor(rs.getInt("AUTLL4")));
                    f.setLlanta_detalle4(rs.getString("DETLL4"));
                    f.setIngresado(valor(rs.getInt("INGSYS")));
                    f.setParqueo(rs.getString("DDPARQ"));
                    f.setPruebas_de_manejo(valor(rs.getInt("AFMPMJ")));
                    f.setFecha_final(rs.getString("FFFECH"));
                    f.setComentario(rs.getString("COMENT"));

                }
                connect.close();
            }else{
                Toast.makeText(df.getApplicationContext(),"Registro de conexion invalido, verifique su conexion de datos, hable con su proveedor de servicios", Toast.LENGTH_SHORT).show();
            }

        } catch (SQLException e) {
            Toast.makeText(df.getApplicationContext(),e.getMessage().toString(), Toast.LENGTH_SHORT).show();

        }

        return f;
    }

    private boolean valor(int df){
        if(df==1){
            return true;
        }else{
            return false;
        }
    }

    public static boolean compruebaConexion(Context context) {

        boolean connected = false;

        ConnectivityManager connec = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo[] redes = connec.getAllNetworkInfo();

        for (int i = 0; i < redes.length; i++) {
            if (redes[i].getState() == NetworkInfo.State.CONNECTED) {
                connected = true;
            }
        }
        return connected;
    }

    public String ObtenerVerificacion( MainActivity df , dataUsuario info, String lugar){
        String datosConsultado = "";

        try {
            Connection connect = ConexionSQL.ConnectionHelper(df);

            if(connect != null){
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM zUsers WHERE Description = '" + info.getUsuario() + "'");

                if (rs.next()) {

                    String str=rs.getString("SALT");

                    byte[] encryptedVal = str.getBytes("UTF-8");
                    Rfc2898DeriveBytes c = new Rfc2898DeriveBytes(info.getPassw(), encryptedVal, 1333);

                    String base64 = Base64.encodeToString(c.getBytes(32), Base64.DEFAULT);
                    String base64_2 = base64.trim();

                    if(base64_2.equals(rs.getString("HASH"))){
                        datosConsultado = rs.getString("IDUser");
                        usuario = rs.getString("IDUser");

                        String nombre = rs.getString("Description");
                        String nombreCompleto = rs.getString("Nombres") + " " + rs.getString("Apellidos");
                        String permiso = rs.getString("Area");

                        SharedPreferences sharedPref = df.getSharedPreferences("Systema_data_archivo_complejo",Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString("Nombre",nombre);
                        editor.putString("NombreCompleto",nombreCompleto);
                        editor.putString("ID",usuario);
                        editor.putString("area",permiso);
                        editor.putString("lugar",lugar);

                        String fgh = verificacion_de_permiso_gobal(df,nombre);
                        editor.putString("permiso",fgh);

                        String correo = ""+correo_user(df,info.getUsuario());
                        editor.putString("correo",correo);

                        editor.commit();
                    }else{
                        Toast.makeText(df.getApplicationContext(),"Error en la contraseña, revise", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(df.getApplicationContext(),"Usuario no encontrado, verificar", Toast.LENGTH_SHORT).show();
                }
                connect.close();
            }else{
                Toast.makeText(df.getApplicationContext(),"Registro de conexion invalido, verifique su conexion de datos, hable con su proveedor de servicios", Toast.LENGTH_SHORT).show();
            }
            return  datosConsultado;
        } catch (SQLException e) {
            Toast.makeText(df.getApplicationContext(),e.getMessage().toString(), Toast.LENGTH_SHORT).show();
            return datosConsultado;
        } catch (NoSuchAlgorithmException e) {
            Toast.makeText(df.getApplicationContext(),e.getMessage().toString(), Toast.LENGTH_SHORT).show();
            return datosConsultado;
        } catch (UnsupportedEncodingException e) {
            Toast.makeText(df.getApplicationContext(),e.getMessage().toString(), Toast.LENGTH_SHORT).show();
            return datosConsultado;
        } catch (InvalidKeyException e) {
            Toast.makeText(df.getApplicationContext(),e.getMessage().toString(), Toast.LENGTH_SHORT).show();
            return datosConsultado;
        }
    }

    public String verificacion_de_permiso_gobal(MainActivity df, String usuario){

        try {
            Connection connect = ConexionSQL2.ConnectionHelper(df);

            if(connect != null) {
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery("select count(*) as a from zUsuariosP where nombre = '" + usuario + "'");
                if (rs.next()) {
                    if(rs.getString("a").equals("1")){
                        return "Administrador";
                    }
                }
                return "Usuario";
            }else{
                return "Usuario";
            }
        }catch (SQLException e) {
            Toast.makeText(df.getApplicationContext(),e.getMessage().toString(), Toast.LENGTH_SHORT).show();
            return "Usuario";
        }
    }

    public List<CharSequence> ObtenerBusquedaListaMatricula( MainActivity df , String info){

        List<CharSequence> datosConsultado = new ArrayList<>();

        try {
            Connection connect = ConexionSQL.ConnectionHelper(df);

            if(connect != null){
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM [dbo].[RM00101] WHERE CUSTCLAS = 'TAL-CHS' and SHRTNAME like ('"+info+"%') ");
                while (rs.next()) {
                    String str=rs.getString("Salt");
                    datosConsultado.add(new String("a"));
                }
                connect.close();
            }else{
                Toast.makeText(df.getApplicationContext(),"Registro de conexion invalido, verifique su conexion de datos, hable con su proveedor de servicios", Toast.LENGTH_SHORT).show();
            }
            return  datosConsultado;
        } catch (SQLException e) {
            Toast.makeText(df.getApplicationContext(),e.getMessage().toString(), Toast.LENGTH_SHORT).show();
            return datosConsultado;
        }
    }

    public List<CharSequence> ObtenerBusquedaListaModelosTaller( Context df ){

        List<CharSequence> datosConsultado = new ArrayList<>();
        List<CharSequence> datosRetorno = new ArrayList<>();

        try {
            Connection connect = ConexionSQL.ConnectionHelper(df);

            if(connect != null){
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery("select codMaestro as nombre from zArticuloDetalle where codMaestro like ('CH%K') group by codMaestro");
                while (rs.next()) {
                    String str=rs.getString("nombre");

                    String[] ary = str.split("_");

                    datosConsultado.add(ary[1]);

                }
                connect.close();
            }else{
                Toast.makeText(df.getApplicationContext(),"Registro de conexion invalido, verifique su conexion de datos, hable con su proveedor de servicios", Toast.LENGTH_SHORT).show();
            }

        } catch (SQLException e) {
            Toast.makeText(df.getApplicationContext(),e.getMessage().toString(), Toast.LENGTH_SHORT).show();

        }

        datosRetorno = new ArrayList<CharSequence>(new HashSet<CharSequence>(datosConsultado));

        return  datosRetorno;
    }

    public List<Integer> ObtenerBusquedaListaModelosTaller2(Context df , String nombre){

        List<Integer> datosConsultado = new ArrayList<>();

        try {
            Connection connect = ConexionSQL.ConnectionHelper(df);

            if(connect != null){
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery("select cast( REPLACE(REPLACE(REPLACE(codMaestro,'CH'+SUBSTRING(codMaestro, 3, 1)+'_"+nombre+"_',''),' ',''),'K','') as int) as kilometraje " +
                        "from [dbo].[zArticuloDetalle] where codMaestro like ('CH%_"+nombre+"%K') group by cast( REPLACE(REPLACE(REPLACE(codMaestro,'CH'+SUBSTRING(codMaestro, 3, 1)+'_"+nombre+"_',''),' ',''),'K','') as int)");
                while (rs.next()) {
                    String str=rs.getString("kilometraje");
                    datosConsultado.add( Integer.parseInt(str) );
                }
                connect.close();
            }else{
                Toast.makeText(df.getApplicationContext(),"Registro de conexion invalido, verifique su conexion de datos, hable con su proveedor de servicios", Toast.LENGTH_SHORT).show();
            }
            return  datosConsultado;
        } catch (SQLException e) {
            Toast.makeText(df.getApplicationContext(),e.getMessage().toString(), Toast.LENGTH_SHORT).show();
            return datosConsultado;
        }
    }

    public List<CharSequence> ObtenerBusquedaListaModelosTaller3( Context df , String nombre, String tipo){

        List<CharSequence> datosConsultado = new ArrayList<>();

        try {
            Connection connect = ConexionSQL.ConnectionHelper(df);

            if(connect != null){
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery("select * from [dbo].[zArticuloDetalle] where codMaestro like ('CH%_"+nombre+"_"+tipo.replace(",000 Kilometro","")+"K')");
                while (rs.next()) {
                    String str=rs.getString("Nombre");
                    datosConsultado.add(str);
                }
                connect.close();
            }else{
                Toast.makeText(df.getApplicationContext(),"Registro de conexion invalido, verifique su conexion de datos, hable con su proveedor de servicios", Toast.LENGTH_SHORT).show();
            }
            return  datosConsultado;
        } catch (SQLException e) {
            Toast.makeText(df.getApplicationContext(),e.getMessage().toString(), Toast.LENGTH_SHORT).show();
            return datosConsultado;
        }
    }

    public List<dataHistorial> ObtenerDatosHistorial( Context df , String motor){

        List<dataHistorial> datosConsultado = new ArrayList<>();

        try {
            Connection connect = ConexionSQL.ConnectionHelper(df);

            if(connect != null){
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery("SELECT *, CUSTNMBR FROM SOP30200 AS SOP30200_1 \n" +
                        "INNER JOIN SOP10106 AS SOP10106_1 ON SOP30200_1.SOPTYPE = SOP10106_1.SOPTYPE AND SOP30200_1.SOPNUMBE = SOP10106_1.SOPNUMBE\n" +
                        "WHERE (SOP30200_1.DOCID IN ('FAC-SER', 'CIN-SAL', 'FAC-MEC-SUB', 'FAC-CIN-SUB','FAC-TN1')) \n" +
                        "AND (SOP30200_1.DOCDATE > GETDATE() - 360)  AND (SOP10106_1.USRDEF04 <> '')  \n" +
                        "AND ISNUMERIC(REPLACE(SOP10106_1.USRDEF04,SUBSTRING(SOP10106_1.USRDEF04, PATINDEX('%[^0-9]%', SOP10106_1.USRDEF04), 1), '')) = 1\n" +
                        "AND CUSTNMBR = '"+motor+"'");
                while (rs.next()) {
                    dataHistorial asdf = new dataHistorial();
                    asdf.setSOPNUMBE(rs.getString("SOPNUMBE"));
                    asdf.setORIGNUMB(rs.getString("ORIGNUMB"));
                    asdf.setDOCID(rs.getString("DOCID"));
                    asdf.setDOCDATE(rs.getString("DOCDATE"));
                    asdf.setPYMTRMID(rs.getString("PYMTRMID"));
                    asdf.setLOCNCODE(rs.getString("LOCNCODE"));
                    asdf.setMSTRNUMB(rs.getString("MSTRNUMB"));
                    asdf.setMRKDNAMT(rs.getString("MRKDNAMT"));
                    asdf.setORSUBTOT(rs.getString("ORSUBTOT"));
                    asdf.setORTAXAMT(rs.getString("ORTAXAMT"));
                    asdf.setORDOCAMT(rs.getString("ORDOCAMT"));
                    asdf.setCMMTTEXT(rs.getString("CMMTTEXT"));
                    datosConsultado.add(asdf);
                }
                connect.close();
            }else{
                Toast.makeText(df.getApplicationContext(),"Registro de conexion invalido, verifique su conexion de datos, hable con su proveedor de servicios", Toast.LENGTH_SHORT).show();
            }
            return  datosConsultado;
        } catch (SQLException e) {
            Toast.makeText(df.getApplicationContext(),e.getMessage().toString(), Toast.LENGTH_SHORT).show();
            return datosConsultado;
        }
    }

    public List<dataCliente> ObtenerDatosCliente( Context df ){

        List<dataCliente> datosConsultado = new ArrayList<>();

        try {
            Connection connect = ConexionSQL.ConnectionHelper(df);

            if(connect != null){
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery("select Description, GRUPO, Area, CEDULA, Rol, (Nombres+' '+Apellidos) as Nombre_Completo from zLista_aplicacionAPP");
                while (rs.next()) {
                    String desrcipcion = rs.getString("Description");
                    String grupo = rs.getString("GRUPO");
                    String area =rs.getString("Area");
                    String cedula = rs.getString("CEDULA");
                    String rol = rs.getString("Rol");
                    String nombre = rs.getString("Nombre_Completo");

                    dataCliente asdf = new dataCliente();
                    asdf.setDescripcion(desrcipcion);
                    asdf.setGrupo(grupo);
                    asdf.setArea(area);
                    asdf.setCedula(cedula);
                    asdf.setRol(rol);
                    asdf.setNombre(nombre);

                    datosConsultado.add(asdf);
                }
                connect.close();
            }else{
                Toast.makeText(df.getApplicationContext(),"Registro de conexion invalido, verifique su conexion de datos, hable con su proveedor de servicios", Toast.LENGTH_SHORT).show();
            }
            return  datosConsultado;
        } catch (SQLException e) {
            Toast.makeText(df.getApplicationContext(),e.getMessage().toString(), Toast.LENGTH_SHORT).show();
            return datosConsultado;
        }
    }

    public boolean Guardar2( int ID, String COMENTAR, boolean AGRADO){
        boolean estado = false;
        try {
            Connection connect = ConexionSQL2.ConnectionHelper(null);
            if(connect != null){
                Connection cstar=connect;
                PreparedStatement pst2=cstar.prepareStatement("UPDATE [dbo].[zAppointmentsRecepcionVehiculo] set FFFECH = GETDATE(), COMENTAR='"+COMENTAR+"', AGRADO="+valores(AGRADO)+" where IDzAppointmentsRecepcionVehiculo = "+ID+";");

                int n2=pst2.executeUpdate();
                if (n2>0){
                    System.out.println("Se a guardado el registro de datos");
                    estado = true;
                }else{
                    System.out.println("No se a guardado el registro de datos");
                }
                connect.close();
            }else{
                System.out.println("Registro de conexion invalido, verifique su conexion de datos, hable con su proveedor de servicios");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage().toString());
        }
        return estado;
    }

    public boolean Guardar( String dato , String IDAppointments){

        boolean estado = false;

        try {
            Connection connect = ConexionSQL2.ConnectionHelper(null);
            if(connect != null){
                Connection cstar=connect;
                PreparedStatement pst=cstar.prepareStatement(dato);
                PreparedStatement pst2=cstar.prepareStatement("UPDATE Appointments SET ActionRe = 1 WHERE UniqueID = "+IDAppointments+";");
                int n=pst.executeUpdate();
                if (n>0){
                    int n2=pst2.executeUpdate();
                    if (n2>0){
                        System.out.println("Se a guardado el registro de datos");
                        estado = true;
                    }else{
                        System.out.println("No se a guardado el registro de datos");
                    }
                }
                connect.close();
            }else{
                System.out.println("Registro de conexion invalido, verifique su conexion de datos, hable con su proveedor de servicios");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage().toString());
        }

        return estado;
    }

    public void guardarfotos(){

        OtrasClases o = new OtrasClases();

        File dir = new File(o.ruta_fotos);

        if (dir.exists()){
            File[] ficheros = dir.listFiles();
            for (int x=0;x<ficheros.length;x++){

                if(ficheros[x].length()>0){
                    String fg = o.base64(ficheros[x].getName());
                    byte [] df = o.Bytes_archivo(ficheros[x].getName());
                    guardar_imagen(fg, ficheros[x].getName(),df);
                }
            }
        }
        else {
            System.out.println("Direccion no Encontrada");
        }
    }

    public void guardar_imagen_firma_entrega(String archivo, int ID){

        OtrasClases o = new OtrasClases();

        try {

            String base64 = o.base64(archivo+".jpg");
            byte[] image = o.Bytes_archivo(archivo+".jpg");

            Connection connect = ConexionSQL2.ConnectionHelper(null);
            if(connect != null){
                Connection cstar=connect;
                PreparedStatement pst=cstar.prepareStatement("insert into zAppointmentsImagen values("+ID+", GETDATE(),'"+base64+"',?,?)");
                pst.setString(1,archivo);
                pst.setBytes(2,image);
                int n=pst.executeUpdate();
                if (n>0){
                    System.out.println("Se a guardado el registro de datos");
                }
                connect.close();
            }else{
                System.out.println("Registro de conexion invalido, verifique su conexion de datos, hable con su proveedor de servicios");
            }
        } catch (SQLException e ) {

            System.out.println(e.getMessage().toString());
        }
    }

    private void guardar_imagen(String datos, String nombre_archivo, byte[] image){
        try {
            Connection connect = ConexionSQL2.ConnectionHelper(null);
            if(connect != null){
                Connection cstar=connect;
                PreparedStatement pst=cstar.prepareStatement("insert into zAppointmentsImagen values((select max(IDzAppointmentsRecepcionVehiculo) from zAppointmentsRecepcionVehiculo), GETDATE(),'"+datos+"',?,?)");

                pst.setString(1,nombre_archivo.replace(".jpg",""));
                pst.setBytes(2,image);
                int n=pst.executeUpdate();
                if (n>0){
                    System.out.println("Se a guardado el registro de datos");
                }
                connect.close();
            }else{
                System.out.println("Registro de conexion invalido, verifique su conexion de datos, hable con su proveedor de servicios");
            }
        } catch (SQLException e) {

            System.out.println(e.getMessage().toString());
        }
    }

    public String valores (Boolean df){
        if(df){
            return "1";
        }else{
            return "0";
        }
    }


}
