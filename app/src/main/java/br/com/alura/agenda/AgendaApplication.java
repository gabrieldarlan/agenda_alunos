package br.com.alura.agenda;

import android.app.Application;

import br.com.alura.agenda.dao.AlunoDao;
import br.com.alura.agenda.model.Aluno;

public class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunosDeExemplo();
    }

    private void criaAlunosDeExemplo() {
        AlunoDao dao = new AlunoDao();
        dao.salva(new Aluno("Aluno1", "1111-1111", "aluno1@gmail.com"));
        dao.salva(new Aluno("Aluno2", "2222-2222", "aluno2@gmail.com"));
    }
}
