package logica;

import java.util.ArrayList;
import java.util.List;

public class Caminhoneiro {

    private double x[];
    private double y[];

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

    public void Guia() {

        //Declaração de um objeto do tipo Posição e uma lista de Posições
        List<Cordenadas> posicao = new ArrayList<>();
        Cordenadas p;

        //Recebe as coordenadas das entregas
        for (int i = 0; i < 5; i++) {
            p = new Cordenadas();
            p.setX(x[i]);//setar a cordenada x passada la na pagina
            p.setY(y[i]);//
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
            if (aux.getDistancia() < distancia) {
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
        for (Cordenadas pos : caminho.getPos()) {
            System.out.print("(" + pos.getX() + "," + pos.getY() + ") ");
        }
        System.out.print("(0,0)\n");
        System.out.println("Distancia Percorrida: " + caminho.getDistancia());

    }
}
