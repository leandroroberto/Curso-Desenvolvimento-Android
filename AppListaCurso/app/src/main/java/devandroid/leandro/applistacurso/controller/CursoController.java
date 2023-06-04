package devandroid.leandro.applistacurso.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import devandroid.leandro.applistacurso.model.Curso;

public class CursoController {

    private List listCursos;

    public List getListaDeCursos(){
        listCursos = new ArrayList<Curso>();
        listCursos.add(new Curso("Java")); // Java
        listCursos.add(new Curso("HTML")); // HTML
        listCursos.add(new Curso("Python")); // Python
        listCursos.add(new Curso("C#")); // C#

        return listCursos;
    };

    public ArrayList<List> listaParaSpinner(){
        ArrayList<List> dados = new ArrayList<>();
        for (int i = 0; i < getListaDeCursos().size(); i++) {
            Curso objeto = (Curso) getListaDeCursos().get(i);
            dados.add(Collections.singletonList(objeto.getNomeDoCursoDesejado()));
        }

        return dados;
    }
}
