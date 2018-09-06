package projeto04.com.br.projeto04;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //declarar os atributos da Classe
    EditText edtCelsius;
    Button btnCalcular, btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Atribuir os componentes visuais da activity_main
         * nos atributos da classe
         */

        edtCelsius = (EditText) findViewById(R.id.edtCelsius);

        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnLimpar = (Button) findViewById(R.id.btnLimpar);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtCelsius.getText().length() <= 0) {
                    Toast.makeText(getBaseContext(), "Informe TODOS os campos!!!",
                            Toast.LENGTH_SHORT).show();
                    edtCelsius.requestFocus();
                } else{
                    Double celsius = Double.parseDouble(edtCelsius.getText().toString());

                    Double fahrenheit = ((9*celsius)+ 160)/5;

                    AlertDialog.Builder alerta = new
                            AlertDialog.Builder(MainActivity.this);

                    alerta.setTitle("TEMPERATURA EM FAHRENHEIT");
                    alerta.setMessage("O número : "
                            + edtCelsius.getText().toString()
                            + "\ntem o valor em Fahrenheit de : "
                            + new DecimalFormat("0.00").format(fahrenheit));
                    alerta.setNeutralButton("Fechar", null);
                    alerta.show();
                }
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtCelsius.setText("");
                edtCelsius.requestFocus();
            }
        });
    }
}
