package com.example.cultiva;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerCultivos;
    private Calendar selectedDate;
    private final ArrayList<Cultivo> cultivos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerCultivos = findViewById(R.id.spinner_cultivos);
        Button btnSelectDate = findViewById(R.id.btn_select_date);
        Button btnSave = findViewById(R.id.btn_save);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btnViewCultivos = findViewById(R.id.btn_view_cultivos);

        btnSelectDate.setOnClickListener(v -> showDatePicker());

        btnSave.setOnClickListener(v -> saveCultivo());

        btnViewCultivos.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ListCultivosActivity.class);
            intent.putExtra("cultivos", cultivos);
            startActivity(intent);
        });
    }

    private void showDatePicker() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (view, year, month, dayOfMonth) -> {
                    selectedDate = Calendar.getInstance();
                    selectedDate.set(year, month, dayOfMonth);
                },
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    private void saveCultivo() {
        if (selectedDate == null) {
            Toast.makeText(this, R.string.seleccione_una_fecha, Toast.LENGTH_SHORT).show();
            return;
        }

        String cultivoSeleccionado = spinnerCultivos.getSelectedItem().toString();
        int diasCosecha = getDiasCosecha(cultivoSeleccionado);

        Calendar fechaCosecha = (Calendar) selectedDate.clone();
        fechaCosecha.add(Calendar.DAY_OF_YEAR, diasCosecha);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String fechaCosechaFormatted = dateFormat.format(fechaCosecha.getTime());

        cultivos.add(new Cultivo(cultivoSeleccionado, selectedDate, fechaCosecha));

        String mensaje = getString(R.string.cultivo_guardado_exitosamente) + ": " + fechaCosechaFormatted;
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
    }

    private int getDiasCosecha(String cultivo) {
        switch (cultivo) {
            case "Tomates":
                return 80;
            case "Cebollas":
                return 120;
            case "Lechugas":
                return 60;
            case "Apio":
                return 85;
            case "Choclo":
                return 90;
            default:
                return 0;
        }
    }
}
