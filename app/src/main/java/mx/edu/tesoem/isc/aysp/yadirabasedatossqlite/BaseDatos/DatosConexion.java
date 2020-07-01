package mx.edu.tesoem.isc.aysp.yadirabasedatossqlite.BaseDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DatosConexion {
    private SQLiteDatabase basedatos;
    private DatosHelper datosHelper;
    private Context context;

    public DatosConexion(Context context) {
        this.context = context;
    }

    public DatosConexion open() {

        datosHelper = new DatosHelper(context);
        basedatos = datosHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        datosHelper.close();
    }

    public boolean insertar(ContentValues contentValues) {
        boolean estado = true;
        int restadoconsulta = (int) basedatos.insert(DatosHelper.tabladatos.TABLA, null, contentValues);
        if (restadoconsulta < 0) estado=false;
        return estado;
    }
}



