package devandroid.leandro.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.leandro.applistacurso.R;
import devandroid.leandro.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    //Criando os objetos pessoa e outra pessoa e já instanciando ao mesmo tempo
    Pessoa pessoa = new Pessoa();
    Pessoa outraPessoa = new Pessoa();

    //Instanciando os EditText do projeto
    EditText editPrimeiroNome;
    EditText editSobrenome;
    EditText editTelefone;
    EditText editCurso;

    //Instanciando os botões do projeto
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Atribuições a pessoa através do Setter
//        pessoa.setPrimeiroNome("Leandro");
//        pessoa.setSobrenome("Roberto");
//        pessoa.setCursoDesejado("Android");
//        pessoa.setTelefoneContato("11-952299631");

        //Atribuição a outraPessoa através do SETTER
        outraPessoa.setPrimeiroNome("Noah");
        outraPessoa.setSobrenome("Gabriel");
        outraPessoa.setCursoDesejado("Java");
        outraPessoa.setTelefoneContato("11-965829383");

        //Referenciando cada variável de EditText ao seu ID
        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editCurso = findViewById(R.id.editCurso);
        editTelefone = findViewById(R.id.editTelefone);

        //Referenciando cada variável dos botões ao seu ID
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        //Pegando os dados da classe e atribuindo ao texto dos editText
        //Através dos Getters.
        editPrimeiroNome.setText(outraPessoa.getPrimeiroNome());
        editSobrenome.setText(outraPessoa.getSobrenome());
        editCurso.setText(outraPessoa.getCursoDesejado());
        editTelefone.setText(outraPessoa.getTelefoneContato());

        //Método de click do botão Limpar
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editPrimeiroNome.setText("");
                editSobrenome.setText("");
                editCurso.setText("");
                editTelefone.setText("");
            }
        });

        //Método do click do botão Finalizar
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Finalizando aplicativo", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        //Método do click do botão Finalizar
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
                pessoa.setSobrenome(editSobrenome.getText().toString());
                pessoa.setCursoDesejado(editCurso.getText().toString());
                pessoa.setTelefoneContato(editTelefone.getText().toString());
                Toast.makeText(MainActivity.this, "Salvo " + pessoa.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}