package controllers;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Processa_acao {

    private HttpServletRequest req;
    private HttpServletResponse resp;

    public Processa_acao(HttpServletRequest req, HttpServletResponse resp) {
        this.req = req;
        this.resp = resp;
    }

    public void pega_parametros() throws ServletException, IOException, SQLException {

        String nome = req.getParameter("txtNome");
        int cpf = Integer.parseInt(req.getParameter("txtCpf"));
        int telefone = Integer.parseInt(req.getParameter("txtTelefone"));
        String email = req.getParameter("txtEmail");
        String usuario = req.getParameter("txtUsuario");
        String senha = req.getParameter("txtSenha");

    }

    public void processo() throws ServletException, IOException, SQLException {
        
        String x_origem = req.getParameter("X_origem");
        req.setAttribute("sucesso", "true");
        req.setAttribute("xorigem", String.valueOf(x_origem));//Mostrar numero conta ao cadastrar com sucesso, para que o cliente saiba fazer o seu login

        
    }

}
