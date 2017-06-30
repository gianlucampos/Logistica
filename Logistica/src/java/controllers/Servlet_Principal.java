package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Servlet_Principal", urlPatterns = {"/Servlet_Principal"})
public class Servlet_Principal extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        try {
            String acao = req.getParameter("acao"); //Aqui vai receber a acao enviada atraves do id do jsp
            if ("calcular".equals(acao)) {
                Processa_acao processa = new Processa_acao(req, resp);
                processa.recebe_envia();
                RequestDispatcher despacha = req.getRequestDispatcher("index.jsp");
                despacha.forward(req, resp);
            }

        } catch (Exception ex) {

            Servlet_Principal.dispatcherErro(req, resp);
            ex.printStackTrace();

        } finally {
            if (out != null) {
                out.close();
            }
        }

    }

    public static void dispatcherErro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatchererro = req.getRequestDispatcher("erro.jsp");
        dispatchererro.forward(req, resp);
    }
}
