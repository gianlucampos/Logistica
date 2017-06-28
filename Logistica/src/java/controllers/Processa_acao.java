package controllers;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Caminhoneiro;

public class Processa_acao {

    private HttpServletRequest req;
    private HttpServletResponse resp;

    public Processa_acao(HttpServletRequest req, HttpServletResponse resp) {
        this.req = req;
        this.resp = resp;
    }

    public void processo() throws ServletException, IOException, SQLException {

        seta_parametros();//vai executar as funcoes 

    }

    public void seta_parametros() throws ServletException, IOException, SQLException {

        double x[] = new double[5];
        x[0] = Double.parseDouble(req.getParameter("X_origem"));
        x[1] = Double.parseDouble(req.getParameter("X1"));
        x[2] = Double.parseDouble(req.getParameter("X2"));
        x[3] = Double.parseDouble(req.getParameter("X3"));
        x[4] = Double.parseDouble(req.getParameter("X4"));
        
        double y[] = new double[5];
        y[0]= Double.parseDouble(req.getParameter("Y_origem"));
        y[1] = Double.parseDouble(req.getParameter("Y1"));
        y[2] = Double.parseDouble(req.getParameter("Y2"));
        y[3] = Double.parseDouble(req.getParameter("Y3"));
        y[4] = Double.parseDouble(req.getParameter("Y4"));
        
       Caminhoneiro cam = new Caminhoneiro(x,y);
       cam.Guia();


       // req.setAttribute("sucesso", "true");
       // req.setAttribute("melhor_rota", String.valueOf(y4));
       

    }

}
