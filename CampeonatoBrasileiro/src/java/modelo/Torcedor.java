package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Torcedor extends Conexao {

    //VARIÁVEIS
    private String email;
    private String sexo;
    private String nome;
    private String anoNasc;
    private String time;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Connection cx;

    // GETS E SETS
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAnoNasc() {
        return anoNasc;
    }

    public void setAnoNasc(String anoNasc) {
        this.anoNasc = anoNasc;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    //CONSTRUTORES
    public Torcedor() throws ClassNotFoundException, SQLException {
        this.cx = getConexao();
    }

    public Torcedor(Connection cx) {
        this.cx = cx;
    }

    //MÉTODOS
    public boolean obterTorcedorPorEmail() throws SQLException {
        try {
            pst = cx.prepareStatement("select * from torcedor where email = ?");
            pst.setString(1, this.email);
            rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } finally {
            pst.close();
            rs.close();
        }
        return false;
    }

    public void obterTimePorEmail() throws SQLException {
        try {
            pst = cx.prepareStatement("select time from torcedor where email = ?");
            pst.setString(1, this.email);
            rs = pst.executeQuery();
            if (rs.next()) {
                this.time = rs.getString("time");
            }

        } finally {
            pst.close();
            rs.close();
        }

        try {
            pst = cx.prepareStatement("select nome from torcedor where email = ?");
            pst.setString(1, this.email);
            rs = pst.executeQuery();
            if (rs.next()) {
                this.nome = rs.getString("nome");
            }

        } finally {
            pst.close();
            rs.close();
        }

    }

    public boolean gravarTorcedor() throws SQLException {
        try {
            pst = cx.prepareStatement("INSERT INTO torcedor (nome, email, sexo, nascimento, time) VALUES (?,?,?,?,?);");
            pst.setString(1, getNome());
            pst.setString(2, getEmail());
            pst.setString(3, getSexo());
            pst.setString(4, getAnoNasc());
            pst.setString(5, getTime());
            if (pst.execute()) {
                return false;
            }
        } finally {
            pst.close();
            //           rs.close();
        }
        return true;

    }

    public List listaTimesPorTorcedor() throws SQLException {
        try {
            List lista = new ArrayList();

            pst = cx.prepareStatement("select count(nome)as conta, time from torcedor group by time;");
            rs = pst.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString("time"));
                lista.add(rs.getString("conta"));

            }
            return lista;
        
        } finally {
            pst.close();
            
        }

    }
}