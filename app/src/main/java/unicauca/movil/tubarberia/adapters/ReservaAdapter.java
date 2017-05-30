package unicauca.movil.tubarberia.adapters;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import unicauca.movil.tubarberia.R;
import unicauca.movil.tubarberia.databinding.TemplateReservaBinding;
import unicauca.movil.tubarberia.models.Barberia;
import unicauca.movil.tubarberia.models.Reserva;
import unicauca.movil.tubarberia.util.Info;


public class ReservaAdapter extends BaseAdapter {


    LayoutInflater inflater;
    List<Reserva> data;

    public ReservaAdapter(LayoutInflater inflater, List<Reserva> data) {
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
        View v = view;
        if(v==null)
            v = inflater.inflate(R.layout.template_reserva, viewGroup, false);

        TemplateReservaBinding binding = DataBindingUtil.bind(v);
        binding.setReserva(data.get(i));

        return binding.getRoot();
    }

    public void setData(List<Reserva>data){
        this.data = data;
        notifyDataSetChanged();
    }
}
