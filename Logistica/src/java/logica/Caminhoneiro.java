package logica;

import java.util.ArrayList;
import java.util.List;

public class Caminhoneiro {

    private double x[];//vai receber 5 posições X passadas como parametro para essa classe
    private double y[];//são pegadas através da página e aqui são manipuladas pelo indice do vetor
    private double[] melhorPosX = new double[5];//aqui ele vai enviar para o servlet o melhor caminho
    private double[] melhorPosY = new double[5];//o melhor caminho vai ser ordenado pelo indice, com isso é possivel saber a sequencia
    private double melhorDistancia;
//---------------------------------------------------------------------------------------------------------
// Construtor para receber os parametros da web

    public Caminhoneiro(double[] x, double[] y) {
        this.x = x;
        this.y = y;
    }
//---------------------------------------------------------------------------------------------------------
//Geters e Seters para manipular a informação das cordenadas

    public double[] getX() {
        return x;
    }

    public void setX(double[] x) {
        this.x = x;
    }

    public double[] getY() {
        return y;
    }

    public void setY(double[] y) {
        this.y = y;
    }

    public double[] getMelhorPosX() {
        return melhorPosX;
    }

    public void setMelhorPosX(double[] melhorPosX) {
        this.melhorPosX = melhorPosX;
    }

    public double[] getMelhorPosY() {
        return melhorPosY;
    }

    public void setMelhorPosY(double[] melhorPosY) {
        this.melhorPosY = melhorPosY;
    }

    public double getMelhorDistancia() {
        return melhorDistancia;
    }

    public void setMelhorDistancia(double melhorDistancia) {
        this.melhorDistancia = melhorDistancia;
    }
//---------------------------------------------------------------------------------------------------------
//Agora temos o método principla da classe, que vai ser chamada la no Processa_Acao

    public void Guia() {

        //Declaração de um objeto do tipo Posição e uma lista de Posições
        //Vamos precisar de um objeto para posição atual e outro para uma lista de posições
        List<Cordenadas> posicao = new ArrayList<>();//Criando um array do tipo Coordenada, que vai conter x e y
        Cordenadas p;//Aqui será um objeto apenas

        //Recebe as coordenadas das entregas, nesse caso vai ser 5 entregas para serem entregues
        for (int i = 0; i < 5; i++) {
            p = new Cordenadas();// para cada entrega uma respectiva cordenada
            p.setX(x[i]);//que ira ser setada atraves de parametros descritos la da pagina
            p.setY(y[i]);
            posicao.add(p);//Adiciona as coordenadas no array
        }

        //Declaramos dois objetos do tipo rota,um sera a variavel auxiliar para comparação
        Rota caminho = new Rota();
        Rota aux;
        double distancia = 100000000;

        //chama o metodo estatico da classe permuta, que retorna um conjunto de combinações conforme um conjunto de
        //coordenadas recebidas
        List<List<Cordenadas>> lista = Permutacao.listPermutations(posicao);
//---------------------------------------------------------------------------------------------------------
//Aqui ele vai calcular e analisar a melhor distancia dentre os caminhos possiveis
        for (List<Cordenadas> l : lista) {
            aux = new Rota();
            aux.setPos(l);
            if (aux.getDistancia() < distancia) {//se a distancia real for menor que a aux, será o melhor caminho
                caminho.setPos(l);
                distancia = aux.getDistancia();
            }
//---------------------------------------------------------------------------------------------------------
//A partir daqui ele mostrará o melhor caminho dentre as opções
            int iterativo = 0;
            double[] melhorPosX2 = new double[5];
            for (Cordenadas pos : caminho.getPos()) {
                melhorPosX[iterativo] = pos.getX();//armazenar em um vetor para mandar como parametro
                melhorPosY[iterativo] = pos.getY();//o melhor caminho
                iterativo++;
            }
            melhorDistancia = caminho.getDistancia();
        }
    }
}
