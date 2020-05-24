package br.com.alura.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import br.com.alura.agenda.R;
import br.com.alura.agenda.dao.AlunoDao;
import br.com.alura.agenda.model.Aluno;

import static br.com.alura.agenda.ui.activity.ConstantesAcitivies.CHAVE_ALUNO;
import static br.com.alura.agenda.ui.activity.ConstantesAcitivies.TITULO_APPBAR_LISTA_ALUNOS;

public class ListaAlunosActivity extends AppCompatActivity {

    private final AlunoDao dao = new AlunoDao();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(TITULO_APPBAR_LISTA_ALUNOS);
        setContentView(R.layout.activity_lista_alunos);
        configuraFabNovoAluno();
        dao.salva(new Aluno("Nayara", "1111-1111", "nayara@gmail.com"));
        dao.salva(new Aluno("Nicole", "2222-2222", "nicole@gmail.com"));
    }

    private void configuraFabNovoAluno() {
        FloatingActionButton botaoSalvar =
                findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
        botaoSalvar.setOnClickListener(v -> {
            abreFormularioModoInsereAluno();
        });
    }

    private void abreFormularioModoInsereAluno() {
        startActivity(new Intent(ListaAlunosActivity.this,
                FormularioAlunoActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        configuraLista();
    }

    private void configuraLista() {
        ListView listaDeAluno = findViewById(R.id.activity_lista_alunos_listview);
        final List<Aluno> alunos = dao.todos();
        configuraAdapter(listaDeAluno, alunos);
        configuraListernerDeCliquePorItem(listaDeAluno);
    }

    private void configuraListernerDeCliquePorItem(ListView listaDeAluno) {
        listaDeAluno.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Aluno alunoEscolhido = (Aluno) adapterView.getItemAtPosition(position);
                abreFormularioModoEditaAluno(alunoEscolhido);
            }
        });
    }

    private void abreFormularioModoEditaAluno(Aluno alunoEscolhido) {
        Intent vaiParaFormularioActivity
                = new Intent(ListaAlunosActivity.this,
                FormularioAlunoActivity.class);
        vaiParaFormularioActivity.putExtra(CHAVE_ALUNO, alunoEscolhido);
        startActivity(vaiParaFormularioActivity);
    }

    private void configuraAdapter(ListView listaDeAluno, List<Aluno> alunos) {
        listaDeAluno.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                alunos));
    }
}
