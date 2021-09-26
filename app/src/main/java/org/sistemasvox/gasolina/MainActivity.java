package org.sistemasvox.gasolina;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText precoAlto, precoBaixo, reais;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instanciarObjts();
    }

    private void instanciarObjts() {
        this.precoAlto = findViewById(R.id.edtPA);
        this.precoBaixo = findViewById(R.id.edtPB);
        this.reais = findViewById(R.id.edtR);
        this.result = findViewById(R.id.txtresult);
    }

    public void calcularV(View view) {
        if (precoAlto.getText().toString().isEmpty() || precoBaixo.getText().toString().isEmpty() || reais.getText().toString().isEmpty()) {
            Toast.makeText(this, "Campo vazio", Toast.LENGTH_SHORT).show();
        } else {
            calcular();
        }
    }

    private void calcular() {
        Double pa = Double.parseDouble(precoAlto.getText().toString());
        Double pb = Double.parseDouble(precoBaixo.getText().toString());
        Double real = Double.parseDouble(reais.getText().toString());
        Double porcetagem = (((pa * 100.00) / pb) - 100.00);
        Double dif = Math.abs((real * (pa - pb) / pb));
        String s = "Diferença em porcentagem: " + porcetagem + "%.\n";
        s += ("Litros ganhos a +: " + (dif + "L.\n"));
        s += ("Economia em R$: " + ((pa - pb) * real)) + ".";
        result.setText(s);
    }
}