package unicauca.movil.tubarberia;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import unicauca.movil.tubarberia.databinding.ActivityDetailBarberiaBinding;
import unicauca.movil.tubarberia.databinding.ActivityReservaBinding;
import unicauca.movil.tubarberia.util.Info;

public class DetailBarberActivity extends AppCompatActivity {

    ActivityDetailBarberiaBinding binding;
    public static final String EXTRA_POS ="pos";
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_barberia);
        binding.setDetail(this);

        pos = getIntent().getIntExtra(EXTRA_POS,0); //asumo que llega posicion bajo esa etiqueta

        binding.setBarber(Info.data.get(pos));

    }

    public void goToReserva(){
        Intent intent = new Intent(this, ReservaActivity.class);
        Bundle b1 = new Bundle();
        b1.putInt("posit", pos);
        intent.putExtras(b1);
        startActivity(intent);

    }
}
