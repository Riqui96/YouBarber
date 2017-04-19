package unicauca.movil.tubarberia;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

import unicauca.movil.tubarberia.adapters.BarberiaAdapter;
import unicauca.movil.tubarberia.databinding.ActivityMainBinding;
import unicauca.movil.tubarberia.models.Barberia;
import unicauca.movil.tubarberia.util.Info;

public class MainActivity extends AppCompatActivity implements BarberiaAdapter.OnBarberSelected {

    ActivityMainBinding binding;
    BarberiaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        Info.data = new ArrayList<>();
        adapter = new BarberiaAdapter(getLayoutInflater(), Info.data, this);

        binding.setAdapter(adapter);

        binding.list.setLayoutManager(new LinearLayoutManager(this));


        loadBarberias();

    }

    private void loadBarberias() {

        Barberia b1 = new Barberia();
        b1.setNombre("La Barberia");
        b1.setDireccion("Cra 10A #1N-17 - Cra 8 #7N-02");
        b1.setImage("https://scontent-mia1-1.xx.fbcdn.net/v/t1.0-9/11046695_1570792159868291_7689559781080265509_n.jpg?oh=f0ef3a47ef30fbcc4dd9db0018fdf28d&oe=597AB4DC");

        Barberia b2 = new Barberia();
        b2.setNombre(" Cris Barber Shop");
        b2.setDireccion("Cra 17 # 8—18");
        b2.setImage("https://scontent-mia1-1.xx.fbcdn.net/v/t1.0-9/17203160_1804197129832037_8264212291258098331_n.jpg?oh=9b912b6f7ac706955f5315c02dd6a813&oe=5985F6D7");

        Barberia b3 = new Barberia();
        b3.setNombre("Latinos");
        b3.setDireccion("calle 8B #11-15");
        b3.setImage("https://scontent-mia1-1.xx.fbcdn.net/v/t31.0-8/474686_104312336379130_964979251_o.jpg?oh=67eee36c9c50385012db32bd861869a7&oe=59504779");

        Barberia b4 = new Barberia();
        b4.setNombre("La Barberia Timbio ");
        b4.setDireccion("Timbio");
        b4.setImage("https://scontent-mia1-1.xx.fbcdn.net/v/t1.0-9/11036167_1378702989115859_3575677087472355064_n.jpg?oh=d1609eaf946575ca5902c76800fd80eb&oe=597B8A06");

        Info.data.add(b1);
        Info.data.add(b2);
        Info.data.add(b3);
        Info.data.add(b4);

        adapter.notifyDataSetChanged();

    }


    @Override
    public void onBarber(int position) {

        Intent intent = new Intent(this, DetailBarberActivity.class);
        intent.putExtra(DetailBarberActivity.EXTRA_POS, position);
        startActivity(intent);
    }
}
