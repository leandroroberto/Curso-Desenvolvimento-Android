package devandroid.leandro.applistacurso.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.leandro.applistacurso.model.Pessoa;
import devandroid.leandro.applistacurso.view.MainActivity;

public class PessoaController {

    //Instanciando o shared Preferences e criando a string para usar nele
    SharedPreferences preferences;
    public static final String NOME_PREFERENCES = "pref_listavip";
    static SharedPreferences.Editor listaVip;

    //Construtor da classe PessoaController
    public PessoaController(MainActivity mainActivity){
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "Controller iniciado");
        return super.toString();
    }

    public static void salvar(Pessoa pessoa) {

        Log.d("MVC_Controller", "Salvo " + pessoa.toString());

        // Populando o objeto listavip do SharedPreferences com os dados mockados
        listaVip.putString("Primeiro nome", pessoa.getPrimeiroNome());
        listaVip.putString("Sobrenome", pessoa.getSobrenome());
        listaVip.putString("Curso", pessoa.getCursoDesejado());
        listaVip.putString("Telefone", pessoa.getTelefoneContato());
        listaVip.apply();
    }

    public Pessoa buscar(Pessoa pessoa) {
        //Inserindo dados na classe Pessoa a partir dos dados salvos no arquivo do SharedPreferences
        pessoa.setPrimeiroNome(preferences.getString("Primeiro nome", ""));
        pessoa.setSobrenome(preferences.getString("Sobrenome", ""));
        pessoa.setCursoDesejado(preferences.getString("Telefone", ""));
        pessoa.setTelefoneContato(preferences.getString("Curso", ""));
        return pessoa;
    }

    public void limpar(){
        listaVip.clear();
        listaVip.apply();
    }
}
