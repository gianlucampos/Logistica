package logica;

import java.util.ArrayList;
import java.util.List;

public class Caminhoneiro {

    private double x[];
    private double y[];
    private double[] melhorPosX = new double[5];
    private double[] melhorPosY = new double[5];

    public Caminhoneiro(double[] x, double[] y) {
        this.x = x;
        this.y = y;
    }

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

    public void Guia() {

        //Declaração de um objeto do tipo Posição e uma lista de Posições
        List<Cordenadas> posicao = new ArrayList<>();
        Cordenadas p;

        //Recebe as coordenadas das entregas, nesse caso vai ser 5 entregas para serem entregues
        for (int i = 0; i < 5; i++) {
            p = new Cordenadas();// para cada entrega um respectiva cordenada
            p.setX(x[i]);//que ira ser setada atraves de parametros descritos la da pagina
            p.setY(y[i]);
            posicao.add(p);
        }

        //Declara dois objetos do tipo caminho e uma variavel double com um valor alto
        Rota caminho = new Rota();
        Rota aux;
        double distancia = 100000000;

        //chama o metodo estatico da classe permuta, que retorna um conjunto de combinações conforme um conjunto de
        //coordenadas recebidas
        List<List<Cordenadas>> lista = Permutacao.listPermutations(posicao);

        System.out.println("Conjunto de caminhos possives:");

        //para cada conjunto de posicões dentro da lista de permutação, calcula a distancia necessaria, selecionando a menor delas
        for (List<Cordenadas> l : lista) {
            aux = new Rota();
            aux.setPos(l);
            if (aux.getDistancia() < distancia) {//se a distancia real for menor que a aux, será o melhor caminho
                caminho.setPos(l);
                distancia = aux.getDistancia();
            }
            System.out.print("(0,0) ");
            for (Cordenadas pos : l) {
                System.out.print("(" + pos.getX() + "," + pos.getY() + ") ");
            }
            System.out.print("(0,0) ");
            System.out.println("Distancia: " + aux.getDistancia());
        }

        System.out.println("\nMelhor caminho:");
        //Exibe o melhor caminho dentre as opções
        System.out.print("(0,0) ");
        int iterativo = 0;
        double[] melhorPosX2 = new double[5];
        for (Cordenadas pos : caminho.getPos()) {
            System.out.print("(" + pos.getX() + "," + pos.getY() + ") ");
            melhorPosX[iterativo] = pos.getX();//armazenar em um vetor para mandar como parametro
            melhorPosY[iterativo] = pos.getY();//o melhor caminho
            iterativo++;
        }
        System.out.print("(0,0)\n");
        System.out.println("Distancia Percorrida: " + caminho.getDistancia());

    }
}
