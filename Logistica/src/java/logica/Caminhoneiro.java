package logica;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Caminhoneiro {

    public Caminhoneiro() {

        //Declaração de um objeto do tipo Posição e uma lista de Posições
        List<Cordenadas> posicao = new ArrayList<>();
        Cordenadas p;

        //Pergunta ao usuario quantas entregas serão feitas
        int numEntregas = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero de entregas:"));

        //Recebe as coordenadas das entregas
        for (int i = 0; i < numEntregas; i++) {
            p = new Cordenadas();

            p.setX(Integer.parseInt(JOptionPane.showInputDialog("Digite o X da posição de entrega " + (i + 1) + ":")));
            p.setY(Integer.parseInt(JOptionPane.showInputDialog("Digite o Y da posição de entrega " + (i + 1) + ":")));

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
