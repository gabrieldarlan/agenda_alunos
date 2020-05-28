package br.com.alura.agenda;

import android.app.Application;

import androidx.room.Room;

import br.com.alura.agenda.database.AgendaDatabase;
import br.com.alura.agenda.database.dao.RoomAlunoDAO;
import br.com.alura.agenda.model.Aluno;

@SuppressWarnings("WeakerAccess")
public class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunosDeExemplo();
    }

    private void criaAlunosDeExemplo() {
        AgendaDatabase database = Room
                .databaseBuilder(this, AgendaDatabase.class, "agenda.db")
                .allowMainThreadQueries()
                .build();

        RoomAlunoDAO dao = database.getRoomAlunoDAO();

        dao.salva(new Aluno("Aluno1", "1111-1111", "aluno1@gmail.com"));
        dao.salva(new Aluno("Aluno2", "2222-2222", "aluno2@gmail.com"));
    }


}
