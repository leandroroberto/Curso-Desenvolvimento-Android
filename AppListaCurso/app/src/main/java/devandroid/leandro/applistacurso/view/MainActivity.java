package devandroid.leandro.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import devandroid.leandro.applistacurso.R;
import devandroid.leandro.applistacurso.controller.PessoaController;
import devandroid.leandro.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    //Instanciando os EditText do projeto
    EditText editPrimeiroNome;
    EditText editSobrenome;
    EditText editTelefone;
    EditText editCurso;

    //Instanciando os botões do projeto
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    // Instanciando a controladora
    PessoaController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Criando os objetos pessoa já instanciando ao mesmo tempo
        Pessoa pessoa;

        controller = new PessoaController(MainActivity.this);
        pessoa = new Pessoa();
        controller.buscar(pessoa);

        //Referenciando cada variável de EditText ao seu ID
        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editCurso = findViewById(R.id.editCurso);
        editTelefone = findViewById(R.id.editTelefone);

        //Referenciando cada variável dos botões ao seu ID
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(pessoa.getSobrenome());
        editCurso.setText(pessoa.getCursoDesejado());
        editTelefone.setText(pessoa.getTelefoneContato());

        //Método de click do botão Limpar
        btnLimpar.setOnClickListener(v -> {
            editPrimeiroNome.setText("");
            editSobrenome.setText("");
            editCurso.setText("");
            editTelefone.setText("");
            controller.limpar();
        });

        //Método do click do botão Finalizar
        btnFinalizar.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Finalizando aplicativo", Toast.LENGTH_LONG).show();
            finish();
        });

        //Método do click do botão salvar
            btnSalvar.setOnClickListener(v -> {
                Toast.makeText(MainActivity.this, "Salvo " + pessoa, Toast.LENGTH_LONG).show();
                PessoaController.salvar(pessoa);
        });
    }
}