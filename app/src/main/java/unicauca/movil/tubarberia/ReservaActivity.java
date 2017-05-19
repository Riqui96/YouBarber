package unicauca.movil.tubarberia;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

import unicauca.movil.tubarberia.databinding.ActivityReservaBinding;
import unicauca.movil.tubarberia.util.Info;

public class ReservaActivity extends AppCompatActivity implements DialogInterface.OnClickListener, View.OnClickListener {

    ActivityReservaBinding binding;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    int m=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_reserva);

        Bundle bundle =  getIntent().getExtras();
        m = bundle.getInt("posit");
        binding.setReserva(Info.data.get(m));

        binding.contentReserva.dateReserv.setOnClickListener(this);
        binding.contentReserva.timeReserv.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    //region DatePicker in Date, TimePicker in Time
    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.date_reserv:

                Calendar calen = Calendar.getInstance();
                int year = calen.get(Calendar.YEAR);
                int month = calen.get(Calendar.MONTH);
                int day = calen.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        this,0,mDateSetListener,year,month,day);

                dialog.show();

                mDateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month+1;

                        String date = day + "/" + month + "/" + year;
                        binding.contentReserva.dateReserv.setText(date);
                    }
                };
                break;

            case R.id.time_reserv:
                Calendar cal = Calendar.getInstance();
                int hour = cal.get(Calendar.HOUR);
                int min = cal.get(Calendar.MINUTE);


                TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                        binding.contentReserva.timeReserv.setText(hour+":"+minute);
                    }
                },hour,min, false);
                timePickerDialog.show();
                break;
        }


    }
    //endregion

    //region Alert in Button Reservar

    public void Reservar(View view) {

        AlertDialog alert = new AlertDialog.Builder(this)
                .setTitle("Reserva")
                .setMessage("Estas seguro de reservar?")
                .setPositiveButton("Aceptar", this)
                .setNegativeButton("Cancelar", this)
                .create();
        alert.show();

    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        if(i == DialogInterface.BUTTON_POSITIVE){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    //endregion
}
