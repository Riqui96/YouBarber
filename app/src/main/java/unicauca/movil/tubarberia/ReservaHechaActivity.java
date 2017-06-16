package unicauca.movil.tubarberia;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import unicauca.movil.tubarberia.adapters.ReservaAdapter;
import unicauca.movil.tubarberia.databinding.ActivityReservaHechaBinding;
import unicauca.movil.tubarberia.models.Reserva;
import unicauca.movil.tubarberia.models.ReservaDao;
import unicauca.movil.tubarberia.net.BarberService;
import unicauca.movil.tubarberia.util.Data;
import unicauca.movil.tubarberia.util.Info;

public class ReservaHechaActivity extends AppCompatActivity implements Callback<List<Reserva>> {

    ActivityReservaHechaBinding binding;
    ReservaAdapter adapter;
    BarberService service;
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

        service = Data.retrofit.create(BarberService.class);

        dao = ((App)getApplication()).session.getReservaDao();

    }

    @Override
    protected void onResume() {
        super.onResume();
        loadBarbers();
        List<Reserva>data = dao.loadAll();

    }

    private void loadBarbers() {
        Call<List<Reserva>> req = service.all();
        req.enqueue(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResponse(Call<List<Reserva>> call, Response<List<Reserva>> response) {
        if(response.isSuccessful()){
            adapter.setData(response.body());
        }
    }

    @Override
    public void onFailure(Call<List<Reserva>> call, Throwable t) {

    }
}
