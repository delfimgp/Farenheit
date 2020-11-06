package pt.delfimpereira.farenheit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    //public static final String TEMPERATURA = "TEMPERATURA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mostraTemperatura(View view) {
        EditText editTextTemperatura = findViewById(R.id.editTextTemperatura);
        String s = editTextTemperatura.getText().toString();

        RadioButton radioButtonCelsius = findViewById(R.id.radioButtonCelsius);

        double temperatura;
        try {
            temperatura = Double.parseDouble(s);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return;
        }

        if (radioButtonCelsius.isChecked()){
            DadosApp.temperatura = new TemperaturaCelsius(temperatura);
        } else {
            DadosApp.temperatura = new TemperaturaFahrenheit(temperatura);
        }

        Intent intent = new Intent(this, ConsultarTemperaturaActivity.class);
        //intent.putExtra(TEMPERATURA, temperatura);
        startActivity(intent);
    }
}