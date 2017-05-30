package unicauca.movil.tubarberia;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import unicauca.movil.tubarberia.adapters.ReservaAdapter;
import unicauca.movil.tubarberia.databinding.ActivityReservaHechaBinding;
import unicauca.movil.tubarberia.models.Reserva;
import unicauca.movil.tubarberia.models.ReservaDao;
import unicauca.movil.tubarberia.util.Info;

public class ReservaHechaActivity extends AppCompatActivity {

    ActivityReservaHechaBinding binding;
    ReservaAdapter adapter;
    List<Reserva> data;
    ReservaDao dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_reserva_hecha);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        data = new ArrayList<>();
        adapter = new ReservaAdapter(getLayoutInflater(),data);
        binding.listReserva.setAdapter(adapter);

        dao = ((App)getApplication()).session.getReservaDao();
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Reserva>data = dao.loadAll();
        adapter.setData(data);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
