package devandroid.leandro.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.leandro.applistacurso.R;
import devandroid.leandro.applistacurso.controller.PessoaController;
import devandroid.leandro.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    public static final String NOME_PREFERENCES = "pref_listavip";
    SharedPreferences.Editor listaVip;


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

        // Instanciando a controladora
        PessoaController controller;
        controller = new PessoaController();

        //Atribuindo o valor a Preferences
        preferences = getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();

        //Criando os objetos pessoa já instanciando ao mesmo tempo
        Pessoa pessoa = new Pessoa();

        //Inserindo dados na classe Pessoa a partir dos dados salvos no arquivo do SharedPreferences
        pessoa.setPrimeiroNome(preferences.getString("Primeiro nome", ""));
        pessoa.setSobrenome(preferences.getString("Sobrenome", ""));
        pessoa.setCursoDesejado(preferences.getString("Telefone", ""));
        pessoa.setTelefoneContato(preferences.getString("Curso", ""));

        //Referenciando cada variável de EditText ao seu ID
        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editCurso = findViewById(R.id.editCurso);
        editTelefone = findViewById(R.id.editTelefone);

        //Recuperando os dados da classe Pessoa e setando os campos com eles
        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(pessoa.getSobrenome());
        editCurso.setText(pessoa.getCursoDesejado());
        editTelefone.setText(pessoa.getTelefoneContato());

        //Referenciando cada variável dos botões ao seu ID
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        //Método de click do botão Limpar
        btnLimpar.setOnClickListener(v -> {
            editPrimeiroNome.setText("");
            editSobrenome.setText("");
            editCurso.setText("");
            editTelefone.setText("");
            listaVip.clear();
            listaVip.apply();
        });

        //Método do click do botão Finalizar
        btnFinalizar.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Finalizando aplicativo", Toast.LENGTH_LONG).show();
            finish();
        });

        //Método do click do botão Finalizar
        btnSalvar.setOnClickListener(v -> {
            pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
            pessoa.setSobrenome(editSobrenome.getText().toString());
            pessoa.setCursoDesejado(editCurso.getText().toString());
            pessoa.setTelefoneContato(editTelefone.getText().toString());
            Toast.makeText(MainActivity.this, "Salvo " + pessoa.toString(), Toast.LENGTH_LONG).show();

            // Populando o objeto listavip do SharedPreferences com os dados mockados
            listaVip.putString("Primeiro nome", pessoa.getPrimeiroNome());
            listaVip.putString("Sobrenome", pessoa.getSobrenome());
            listaVip.putString("Curso", pessoa.getCursoDesejado());
            listaVip.putString("Telefone", pessoa.getTelefoneContato());
            listaVip.apply();

            controller.salvar(pessoa);

        });
    }
}