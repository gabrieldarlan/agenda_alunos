package br.com.alura.agenda.model;


import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Entity
public class Aluno implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id = 0;
    private String nome;
    private String telefone;
    private String email;
    private Calendar momentoDeCadastro = Calendar.getInstance();

    public Calendar getMomentoDeCadastro() {
        return momentoDeCadastro;
    }

    public void setMomentoDeCadastro(Calendar momentoDeCadastro) {
        this.momentoDeCadastro = momentoDeCadastro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return nome + " - " + telefone;
    }

    public boolean temIdValido() {
        return id > 0;
    }

//    public String dataFormatada(){
//        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
//        String dataFormatada = formatador.format(momentoDeCadastro.getTime());
//        return dataFormatada;
//    }
}
