package com.mobintum.crmlite.database;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;


/**
 * Created by Rick on 07/05/16.
 * email: ricardo.centeno@mobintum.com
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "crmlite.db";
    private static final Integer VER_1 = 1;
    private static final Integer DATABASE_VERSION = VER_1;

    private Context mContext;

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Address (" +
                "    addressId integer NOT NULL AUTOINCREMENT," +
                "    street varchar(250) NOT NULL," +
                "    number varchar(250) NOT NULL," +
                "    numberInterior varchar(250)," +
                "    building varchar(250)," +
                "    neightborhood varchar(250) NOT NULL," +
                "    city varchar(250) NOT NULL," +
                "    telephone varchar(250)," +
                "    mobile varchar(250)," +
                "    zipcode varchar(250) NOT NULL," +
                "    latitude double," +
                "    logitude double," +
                "    state varchar(250)," +
                "    fk_countryId integer NOT NULL," +
                "    fk_stateId integer NOT NULL," +
                "    CONSTRAINT Address_pk PRIMARY KEY (addressId)," +
                "    CONSTRAINT Address_Country FOREIGN KEY (fk_countryId)" +
                "    REFERENCES Country (countryId)," +
                "    CONSTRAINT Address_State FOREIGN KEY (fk_stateId)" +
                "    REFERENCES State (stateId)" +
                ");");

        db.execSQL("CREATE TABLE Country (" +
                "    countryId integer NOT NULL," +
                "    name varchar(250) NOT NULL," +
                "    CONSTRAINT Country_pk PRIMARY KEY (countryId)" +
                ");");

        db.execSQL("CREATE TABLE Customer (" +
                "    customerId integer NOT NULL AUTOINCREMENT," +
                "    name varchar(250) NOT NULL," +
                "    businessName varchar(250)," +
                "    rfc varchar(250)," +
                "    notes varchar(250)," +
                "    fk_addressId integer NOT NULL," +
                "    CONSTRAINT Customer_pk PRIMARY KEY (customerId)," +
                "    CONSTRAINT Customer_Address FOREIGN KEY (fk_addressId)" +
                "    REFERENCES Address (addressId)" +
                ");");

        db.execSQL("CREATE TABLE State (" +
                "    stateId integer NOT NULL AUTOINCREMENT," +
                "    name integer NOT NULL," +
                "    fk_countryId integer NOT NULL," +
                "    CONSTRAINT State_pk PRIMARY KEY (stateId)," +
                "    CONSTRAINT State_Country FOREIGN KEY (fk_countryId)" +
                "    REFERENCES Country (countryId)" +
                ");");
        
        db.execSQL("INSERT INTO Country(countryId,name) VALUES " +
                "(1,'Afganistan')," +
                "(2,'Africa del Sur')," +
                "(3,'Albania')," +
                "(4,'Alemania')," +
                "(5,'Andorra')," +
                "(6,'Angola')," +
                "(7,'Antigua y Barbuda')," +
                "(8,'Antillas Holandesas')," +
                "(9,'Arabia Saudita')," +
                "(10,'Argelia')," +
                "(11,'Argentina')," +
                "(12,'Armenia')," +
                "(13,'Aruba')," +
                "(14,'Australia')," +
                "(15,'Austria')," +
                "(16,'Azerbaijan')," +
                "(17,'Bahamas')," +
                "(18,'Bahrain')," +
                "(19,'Bangladesh')," +
                "(20,'Barbados')," +
                "(21,'Belarusia')," +
                "(22,'Belgica')," +
                "(23,'Belice')," +
                "(24,'Benin')," +
                "(25,'Bermudas')," +
                "(26,'Bolivia')," +
                "(27,'Bosnia')," +
                "(28,'Botswana')," +
                "(29,'Brasil')," +
                "(30,'Brunei Darussulam')," +
                "(31,'Bulgaria')," +
                "(32,'Burkina Faso')," +
                "(33,'Burundi')," +
                "(34,'Butan')," +
                "(35,'Camboya')," +
                "(36,'Camerun')," +
                "(37,'Canada')," +
                "(38,'Cape Verde')," +
                "(39,'Chad')," +
                "(40,'Chile')," +
                "(41,'China')," +
                "(42,'Chipre')," +
                "(43,'Colombia')," +
                "(44,'Comoros')," +
                "(45,'Congo')," +
                "(46,'Corea del Norte')," +
                "(47,'Corea del Sur')," +
                "(48,'Costa de Marfíl')," +
                "(49,'Costa Rica')," +
                "(50,'Croasia')," +
                "(51,'Cuba')," +
                "(52,'Dinamarca')," +
                "(53,'Djibouti')," +
                "(54,'Dominica')," +
                "(55,'Ecuador')," +
                "(56,'Egipto')," +
                "(57,'El Salvador')," +
                "(58,'Emiratos Arabes Unidos')," +
                "(59,'Eritrea')," +
                "(60,'Eslovenia')," +
                "(61,'España')," +
                "(62,'Estados Unidos')," +
                "(63,'Estonia')," +
                "(64,'Etiopia')," +
                "(65,'Fiji')," +
                "(66,'Filipinas')," +
                "(67,'Finlandia')," +
                "(68,'Francia')," +
                "(69,'Gabon')," +
                "(70,'Gambia')," +
                "(71,'Georgia')," +
                "(72,'Ghana')," +
                "(73,'Granada')," +
                "(74,'Grecia')," +
                "(75,'Groenlandia')," +
                "(76,'Guadalupe')," +
                "(77,'Guam')," +
                "(78,'Guatemala')," +
                "(79,'Guayana Francesa')," +
                "(80,'Guerney')," +
                "(81,'Guinea')," +
                "(82,'Guinea-Bissau')," +
                "(83,'Guinea Equatorial')," +
                "(84,'Guyana')," +
                "(85,'Haiti')," +
                "(86,'Holanda')," +
                "(87,'Honduras')," +
                "(88,'Hong Kong')," +
                "(89,'Hungria')," +
                "(90,'India')," +
                "(91,'Indonesia')," +
                "(92,'Irak')," +
                "(93,'Iran')," +
                "(94,'Irlanda')," +
                "(95,'Islandia')," +
                "(96,'Islas Caiman')," +
                "(97,'Islas Faroe')," +
                "(98,'Islas Malvinas')," +
                "(99,'Islas Marshall')," +
                "(100,'Islas Solomon')," +
                "(101,'Islas Virgenes Britanicas')," +
                "(102,'Islas Virgenes (U.S.)')," +
                "(103,'Israel')," +
                "(104,'Italia')," +
                "(105,'Jamaica')," +
                "(106,'Japon')," +
                "(107,'Jersey')," +
                "(108,'Jordania')," +
                "(109,'Kazakhstan')," +
                "(110,'Kenia')," +
                "(111,'Kiribati')," +
                "(112,'Kuwait')," +
                "(113,'Kyrgyzstan')," +
                "(114,'Laos')," +
                "(115,'Latvia')," +
                "(116,'Lesotho')," +
                "(117,'Libano')," +
                "(118,'Liberia')," +
                "(119,'Libia')," +
                "(120,'Liechtenstein')," +
                "(121,'Lituania')," +
                "(122,'Luxemburgo')," +
                "(123,'Macao')," +
                "(124,'Macedonia')," +
                "(125,'Madagascar')," +
                "(126,'Malasia')," +
                "(127,'Malawi')," +
                "(128,'Maldivas')," +
                "(129,'Mali')," +
                "(130,'Malta')," +
                "(131,'Marruecos')," +
                "(132,'Martinica')," +
                "(133,'Mauricio')," +
                "(134,'Mauritania')," +
                "(135,'Mexico')," +
                "(136,'Micronesia')," +
                "(137,'Moldova')," +
                "(138,'Monaco')," +
                "(139,'Mongolia')," +
                "(140,'Mozambique')," +
                "(141,'Myanmar (Burma)')," +
                "(142,'Namibia')," +
                "(143,'Nepal')," +
                "(144,'Nicaragua')," +
                "(145,'Niger')," +
                "(146,'Nigeria')," +
                "(147,'Noruega')," +
                "(148,'Nueva Caledonia')," +
                "(149,'Nueva Zealandia')," +
                "(150,'Oman')," +
                "(151,'Pakistan')," +
                "(152,'Palestina')," +
                "(153,'Panama')," +
                "(154,'Papua Nueva Guinea')," +
                "(155,'Paraguay')," +
                "(156,'Peru')," +
                "(157,'Polinesia Francesa')," +
                "(158,'Polonia')," +
                "(159,'Portugal')," +
                "(160,'Puerto Rico')," +
                "(161,'Qatar')," +
                "(162,'Reino Unido')," +
                "(163,'Republica Centroafricana')," +
                "(164,'Republica Checa')," +
                "(165,'Republica Democratica del Congo')," +
                "(166,'Republica Dominicana')," +
                "(167,'Republica Eslovaca')," +
                "(168,'Reunion')," +
                "(169,'Ruanda')," +
                "(170,'Rumania')," +
                "(171,'Rusia')," +
                "(172,'Sahara')," +
                "(173,'Samoa')," +
                "(174,'San Cristobal-Nevis (St. Kitts)')," +
                "(175,'San Marino')," +
                "(176,'San Vincente y las Granadinas')," +
                "(177,'Santa Helena')," +
                "(178,'Santa Lucia')," +
                "(179,'Santa Sede (Vaticano)')," +
                "(180,'Sao Tome & Principe')," +
                "(181,'Senegal')," +
                "(182,'Seychelles')," +
                "(183,'Sierra Leona')," +
                "(184,'Singapur')," +
                "(185,'Siria')," +
                "(186,'Somalia')," +
                "(187,'Sri Lanka (Ceilan)')," +
                "(188,'Sudan')," +
                "(189,'Sudan del Sur')," +
                "(190,'Suecia')," +
                "(191,'Suiza')," +
                "(192,'Sur Africa')," +
                "(193,'Surinam')," +
                "(194,'Swaziland')," +
                "(195,'Tailandia')," +
                "(196,'Taiwan')," +
                "(197,'Tajikistan')," +
                "(198,'Tanzania')," +
                "(199,'Timor Oriental')," +
                "(200,'Togo')," +
                "(201,'Tokelau')," +
                "(202,'Tonga')," +
                "(203,'Trinidad & Tobago')," +
                "(204,'Tunisia')," +
                "(205,'Turkmenistan')," +
                "(206,'Turquia')," +
                "(207,'Ucrania')," +
                "(208,'Uganda')," +
                "(209,'Union Europea')," +
                "(210,'Uruguay')," +
                "(211,'Uzbekistan')," +
                "(212,'Vanuatu')," +
                "(213,'Venezuela')," +
                "(214,'Vietnam')," +
                "(215,'Yemen')," +
                "(216,'Zambia')," +
                "(217,'Zimbabwe ');");
        
        db.execSQL("INSERT INTO State(fk_countryId,name) VALUES" +
                "(135,'Aguascalientes')," +
                "(135,'Baja California')," +
                "(135,'Baja California Sur')," +
                "(135,'Campeche')," +
                "(135,'Chiapas')," +
                "(135,'Chihuahua')," +
                "(135,'Coahuila')," +
                "(135,'Colima')," +
                "(135,'Ciudad de México')," +
                "(135,'Durango')," +
                "(135,'Estado de México')," +
                "(135,'Guanajuato')," +
                "(135,'Guerrero')," +
                "(135,'Hidalgo')," +
                "(135,'Jalisco')," +
                "(135,'Michoacán')," +
                "(135,'Morelos')," +
                "(135,'Nayarit')," +
                "(135,'Nuevo León')," +
                "(135,'Oaxaca')," +
                "(135,'Puebla')," +
                "(135,'Querétaro')," +
                "(135,'Quintana Roo')," +
                "(135,'San Luis Potosí')," +
                "(135,'Sinaloa')," +
                "(135,'Sonora')," +
                "(135,'Tabasco')," +
                "(135,'Tamaulipas')," +
                "(135,'Tlaxcala')," +
                "(135,'Veracruz')," +
                "(135,'Yucatán')," +
                "(135,'Zacatecas');");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public ArrayList<Cursor> getData(String Query){
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[] { "mesage" };
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2= new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);

        try{
            String maxQuery = Query ;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);
            //add value to cursor2
            Cursor2.addRow(new Object[] { "Success" });

            alc.set(1,Cursor2);
            if (null != c && c.getCount() > 0) {


                alc.set(0,c);
                c.moveToFirst();

                return alc ;
            }
            return alc;
        } catch(SQLException sqlEx){
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[] { ""+sqlEx.getMessage() });
            alc.set(1,Cursor2);
            return alc;
        } catch(Exception ex){

            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[] { ""+ex.getMessage() });
            alc.set(1,Cursor2);
            return alc;
        }
    }
}
