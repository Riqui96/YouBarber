package unicauca.movil.tubarberia;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import java.util.ArrayList;

import unicauca.movil.tubarberia.adapters.BarberiaAdapter;
import unicauca.movil.tubarberia.databinding.ActivityMainBinding;
import unicauca.movil.tubarberia.util.Info;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding;
    BarberiaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        Info.data = new ArrayList<>();
        adapter = new BarberiaAdapter(getLayoutInflater(), Info.data);

        binding.setAdapter(adapter);

        binding.list.setLayoutManager(new LinearLayoutManager(this));
        binding.list.setOnClickListener(this);

        loadBarberias();

    }

    private void loadBarberias() {

    }

    @Override
    public void onClick(View view) {

    }
}
