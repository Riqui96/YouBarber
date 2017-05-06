package unicauca.movil.tubarberia.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;


import unicauca.movil.tubarberia.databinding.TemplateBarberiaBinding;
import unicauca.movil.tubarberia.models.Barberia;

public class BarberiaAdapter extends BaseAdapter{

    private LayoutInflater inflater;
    private List<Barberia>data;

    public BarberiaAdapter(LayoutInflater inflater, List<Barberia> data) {
        this.inflater = inflater;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Barberia barberia = data.get(i);
        TemplateBarberiaBinding binding = TemplateBarberiaBinding.inflate(inflater);
        binding.setBarber(barberia);

        return binding.getRoot();
    }
}
