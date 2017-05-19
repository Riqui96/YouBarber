package unicauca.movil.tubarberia;

import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;

import unicauca.movil.tubarberia.adapters.BarberiaAdapter;
import unicauca.movil.tubarberia.databinding.ActivityMainBinding;
import unicauca.movil.tubarberia.models.Barberia;
import unicauca.movil.tubarberia.util.Info;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener, AdapterView.OnItemClickListener {

    ActivityMainBinding binding;
    BarberiaAdapter adapter;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        Info.data = new ArrayList<>();

        adapter = new BarberiaAdapter(getLayoutInflater(), Info.data);
        binding.setAdapter(adapter);


        loadBarberias();

        binding.list.setOnItemClickListener(this);

        registerForContextMenu(binding.list);
    }

    //region Create and OptionsItem -> Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.list_reser:
                Intent intent = new Intent(this, ReservaHechaActivity.class);
                startActivity(intent);
                break;

            case R.id.info:
                Toast.makeText(this, "Presionaste Acerca de", Toast.LENGTH_SHORT).show();
                break;

            case R.id.close:
                Toast.makeText(this, "Presionaste Cerrar Sesion", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
    //endregion


    //region Create and ContextItem -> Menu Contextual
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.itemlist, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {


        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        pos = info.position;

        switch (item.getItemId()){
            case R.id.action_delete:
                AlertDialog alert = new AlertDialog.Builder(this)
                        .setTitle("Eliminar")
                        .setMessage("Desea eliminar la barberia")
                        .setPositiveButton("Aceptar", this)
                        .setNegativeButton("Cancelar", this)
                        .create();
                alert.show();
                break;
        }

        return super.onContextItemSelected(item);
    }
    //endregion

    private void loadBarberias() {

        String [] precios = {"Precio", "$8.000","$7.000","$6.000","$6.000"};
        Barberia b1 = new Barberia();
        b1.setNombre("Figaro Barber Shop");
        b1.setDireccion("Cra 10A #1N-17, Cra 8 #7N-02");
        b1.setImage("http://www.figarocolombia.com/wp-content/uploads/2016/05/BANNER1.jpg");
        b1.setHorary("Lunes a Sabado: 8:30AM a 8:00PM");
        b1.setServices();
        b1.setPrecios(precios);


        String [] precios1 = {"Precio", "$8.000","$8.000","$6.000","$5.000"};
        Barberia b2 = new Barberia();
        b2.setNombre("The Barber Factory");
        b2.setDireccion("Cra 17 # 8—18");
        b2.setImage("https://www.laguia.digital/wp-content/uploads/2017/02/the-barber-factory_2.jpg");
        b2.setHorary("Lunes a Sabado: 9:00AM a 8:00PM");
        b2.setServices();
        b2.setPrecios(precios1);

        String [] precios2 = {"Precio", "$7.000","$6.000","$5.000","$5.000"};
        Barberia b3 = new Barberia();
        b3.setNombre("Londres");
        b3.setDireccion("Calle 8B #11-15");
        b3.setImage("https://images01.olx-st.com/ui/50/46/44/25/o_1490021740_1ac3daf319f296dd87bae54e45755273.jpg");
        b3.setHorary("Lunes a Sabado: 9:00AM a 7:00PM");
        b3.setServices();
        b3.setPrecios(precios2);

        String [] precios3 = {"Precio", "$6.000","$5.000","$5.000","$4.000"};
        Barberia b4 = new Barberia();
        b4.setNombre("Barberia Timbio ");
        b4.setDireccion("Timbio");
        b4.setImage("https://scontent-mia1-1.xx.fbcdn.net/v/t1.0-9/11036167_1378702989115859_3575677087472355064_n.jpg?oh=d1609eaf946575ca5902c76800fd80eb&oe=597B8A06");
        b4.setHorary("Lunes a Sabado: 10:00AM a 8:00PM");
        b4.setServices();
        b4.setPrecios(precios3);

        Info.data.add(b1);
        Info.data.add(b2);
        Info.data.add(b3);
        Info.data.add(b4);

        adapter.notifyDataSetChanged();

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this, DetailBarberActivity.class);
        intent.putExtra(DetailBarberActivity.EXTRA_POS,i);
        startActivity(intent);

    }

    //region Metodo onClick Menu Contextual
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        if(i == DialogInterface.BUTTON_POSITIVE){
            Info.data.remove(pos);
            adapter.notifyDataSetChanged();
        }
    }


    //endregion

}
