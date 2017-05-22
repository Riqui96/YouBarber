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

public class ReservaHechaActivity extends AppCompatActivity {

    ActivityReservaHechaBinding binding;
    ReservaAdapter adapter;
    List<Reserva> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_reserva_hecha);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        data = new ArrayList<>();
        adapter = new ReservaAdapter(getLayoutInflater(),data);
        binding.listReserva.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
