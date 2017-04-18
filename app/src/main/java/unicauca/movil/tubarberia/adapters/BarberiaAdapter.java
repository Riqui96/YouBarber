package unicauca.movil.tubarberia.adapters;


import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import unicauca.movil.tubarberia.R;
import unicauca.movil.tubarberia.databinding.TemplateBarberiaBinding;
import unicauca.movil.tubarberia.models.Barberia;

public class BarberiaAdapter extends RecyclerView.Adapter<BarberiaAdapter.BarberHolder>{

    LayoutInflater inflater;
    List<Barberia> data;

    public BarberiaAdapter(LayoutInflater inflater, List<Barberia> data) {
        this.inflater = inflater;
        this.data = data;
    }

    @Override
    public BarberHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.template_barberia,parent, false);
        return new BarberHolder(v);
    }

    @Override
    public void onBindViewHolder(BarberHolder holder, int position) {
        Barberia barberia = data.get(position);
        holder.binding.setBarber(barberia);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    //region ViewHolder
    static class BarberHolder extends RecyclerView.ViewHolder{

        TemplateBarberiaBinding binding;

        public BarberHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
    //endregion
}
