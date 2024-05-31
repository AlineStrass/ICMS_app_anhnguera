package com.example.icms_app_anhnguera;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //instanciar - cada elemento de view vai ter um objeto jva ligado a ele. O "m" é só para representar ue é ium objeto das views.
    private EditText mEditTextEstado;
    private EditText mEditTextValor;
    private TextView mEditTextPorcentagem;
    private TextView mEditTextTotal;


    // Parte da aplicação que faz rodar/abrir o código em xml.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //fazer a associação do ID do arquivo xml com o arquivo do java
        mEditTextEstado = findViewById(R.id.editTextEstado);
        mEditTextValor = findViewById(R.id.editTextValor);
        mEditTextPorcentagem = findViewById(R.id.textViewPorcentagem);
        mEditTextTotal = findViewById(R.id.textViewTotal);


        //padrão do sistema, já veio com as configs iniciais
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
    //criar as funções
    public void calcular(View view){     //associa o botão na função
        String estado = mEditTextEstado.getText().toString(); //pega o texto e converte para string r armazena no valor string

        String valorString = mEditTextTotal.getText().toString();
        float valor = Float.parseFloat(valorString); //converte em moeda

        float porcentagem = 0;  //objeto porcentagem que vai conter o calculo da porcentagem
        switch (estado) {
            case "RO":
                porcentagem = 17.5f;
                break;
            case "SP":
                porcentagem = 18;
                break;
            case "RS":
                porcentagem = 17;
                break;
            case "SC":
                porcentagem = 17;
                break;
            case "PB":
                porcentagem = 20;
                break;

        }

        float total = valor + (valor * porcentagem/100);  //calculo do valor total

        mEditTextPorcentagem.setText(String.valueOf(porcentagem) + "%"); //converte para string e formata para mostrar na view
        mEditTextTotal.setText(String.format("R$ %.2f"));   //converte para string e formata para mostrar na view
    }

}

