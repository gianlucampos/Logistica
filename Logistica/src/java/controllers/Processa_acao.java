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

    public void recebe_envia() throws ServletException, IOException, SQLException {
    //---------------------------------------------------------------------------------------------
    //Recebe as cordenadas passadas pela pagina
        double x[] = new double[5];//como são 5 rotas pra calcular, crio um vetor de indice 5 para passar
        x[0] = Double.parseDouble(req.getParameter("X_origem"));// para o método guia no pacote logica
        x[1] = Double.parseDouble(req.getParameter("X1"));
        x[2] = Double.parseDouble(req.getParameter("X2"));
        x[3] = Double.parseDouble(req.getParameter("X3"));
        x[4] = Double.parseDouble(req.getParameter("X4"));

        double y[] = new double[5];
        y[0] = Double.parseDouble(req.getParameter("Y_origem"));
        y[1] = Double.parseDouble(req.getParameter("Y1"));
        y[2] = Double.parseDouble(req.getParameter("Y2"));
        y[3] = Double.parseDouble(req.getParameter("Y3"));
        y[4] = Double.parseDouble(req.getParameter("Y4"));

    //-----------------------------------------------------------------------------------------------------
    //Envia as cordenadas para calcular menor distancia e melhor ordem de cordenadas para deslocamento
        Caminhoneiro cam = new Caminhoneiro(x, y);//passo para o construtor os vetores que contem os parametros
        cam.Guia();//e chamo o metodo,todo o processo sera feito lá na classe Caminhoneiro   
        
    //------------------------------------------------------------------------------------------------------
    //Recebe um vetor ordenado por indice com o melhor caminho |X[0] = melhor x inicial cordenada... etc |
        double melhorX[] = cam.getMelhorPosX();// recebe em um vetor, em ordem as melhores coordenadas
        double melhorY[] = cam.getMelhorPosY();
    //-------------------------------------------------------------------------------------------------------
    //Envia pra página exibir as cordenadas em ordem com o melhor caminho
        req.setAttribute("sucesso", "true");//pra cair no if do js
        req.setAttribute("melhorX0", String.valueOf(melhorX[0]));//Envia o melhor x inicial
        req.setAttribute("melhorX1", String.valueOf(melhorX[1]));//e assim por diante
        req.setAttribute("melhorX2", String.valueOf(melhorX[2]));
        req.setAttribute("melhorX3", String.valueOf(melhorX[3]));
        req.setAttribute("melhorX4", String.valueOf(melhorX[4]));
        
        req.setAttribute("melhorY0", String.valueOf(melhorY[0]));
        req.setAttribute("melhorY1", String.valueOf(melhorY[1]));
        req.setAttribute("melhorY2", String.valueOf(melhorY[2]));
        req.setAttribute("melhorY3", String.valueOf(melhorY[3]));
        req.setAttribute("melhorY4", String.valueOf(melhorY[4]));
        

    }

}
