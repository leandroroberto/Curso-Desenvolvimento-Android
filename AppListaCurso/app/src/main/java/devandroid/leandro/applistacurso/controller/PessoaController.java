package devandroid.leandro.applistacurso.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.leandro.applistacurso.model.Pessoa;

public class PessoaController {

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "Controller iniciado");
        return super.toString();
    }

    public static void salvar(Pessoa pessoa) {
        Log.d("MVC_Controller", "Salvo " + pessoa.toString());
    }
}
