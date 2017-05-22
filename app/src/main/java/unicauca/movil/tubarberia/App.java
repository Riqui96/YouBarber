package unicauca.movil.tubarberia;

import android.app.Application;

import org.greenrobot.greendao.database.Database;

import unicauca.movil.tubarberia.models.DaoMaster;
import unicauca.movil.tubarberia.models.DaoSession;


public class App extends Application {

    DaoSession session;
    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "reservas.db");
        Database db = helper.getWritableDb();

        DaoMaster master = new DaoMaster(db);
        session = master.newSession();
    }
}
