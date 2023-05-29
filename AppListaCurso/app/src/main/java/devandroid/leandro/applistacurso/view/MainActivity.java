package devandroid.leandro.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import devandroid.leandro.applistacurso.R;
import devandroid.leandro.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa = new Pessoa();
    Pessoa outraPessoa = new Pessoa();

    String dadosPessoa;
    String dadosOutraPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Atribuições a pessoa,
        pessoa.setPrimeiroNome("Leandro");
        pessoa.setSobrenome("Roberto");
        pessoa.setCursoDesejado("Android");
        pessoa.setTelefoneContato("11-952299631");

        //Atribuição a outraPessoa através do SETTER
        outraPessoa.setPrimeiroNome("Noah");
        outraPessoa.setSobrenome("Gabriel");
        outraPessoa.setCursoDesejado("Java");
        outraPessoa.setTelefoneContato("11-965829383");


        //Resgatando valores a partir do GETTER de 'pessoa'
        dadosPessoa = "Nome: ";
        dadosPessoa += pessoa.getPrimeiroNome();
        dadosPessoa += " Sobrenome: ";
        dadosPessoa += pessoa.getSobrenome();
        dadosPessoa += " Curso desejado: ";
        dadosPessoa += pessoa.getCursoDesejado();
        dadosPessoa += " Telefone de contato: ";
        dadosPessoa += pessoa.getTelefoneContato();

        //Resgatando valores a partir do GETTER de 'outraPessoa'
        dadosOutraPessoa = "Nome: ";
        dadosOutraPessoa += outraPessoa.getPrimeiroNome();
        dadosOutraPessoa += " Sobrenome: ";
        dadosOutraPessoa += outraPessoa.getSobrenome();
        dadosOutraPessoa += " Curso desejado: ";
        dadosOutraPessoa += outraPessoa.getCursoDesejado();
        dadosOutraPessoa += " Telefone de contato: ";
        dadosOutraPessoa += outraPessoa.getTelefoneContato();

    }

    @Override
    public String toString() {
        return "MainActivity{" +
                "pessoa=" + pessoa +
                ", outraPessoa=" + outraPessoa +
                ", dadosPessoa='" + dadosPessoa + '\'' +
                ", dadosOutraPessoa='" + dadosOutraPessoa + '\'' +
                '}';
    }
}