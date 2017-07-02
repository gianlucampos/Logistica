package logica;

import java.util.ArrayList;
import java.util.List;

public class Rota {//Vai conter uma lista de coordenadas e uma distancia, para calcular o caminho

    private List<Cordenadas> pos;
    private double distancia;

    public Rota() {
        this.pos = new ArrayList<>();
        this.distancia = 0;
    }
//---------------------------------------------------------------------------------------------------------
//Geters e Seters para manipular a informação das cordenadas
    public List<Cordenadas> getPos() {
        return pos;
    }

    public void setPos(List<Cordenadas> pos) {
        this.pos = pos;
    }

    public double getDistancia() {
        calculaDistancia();//para eu saber a distancia eu preciso calcula-la 1º

        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public void insereEntrega(Cordenadas pos) {//nesse metodo ele colocar em ordem as coordenadas(x,y)
        this.pos.add(pos);                     //na devida ordem de entrega
        calculaDistancia();//e com essas cordenadas ele calcula distancia
    }

    private void calculaDistancia() {
        this.distancia = 0;
        Cordenadas aux = new Cordenadas();
        aux.setX(0);//as variaveis auxiliares servem como comparação
        aux.setY(0);//por isso devem comecar com a origem em 0,0

        for (Cordenadas p : pos) {
            this.distancia = this.distancia + Math.pow((Math.pow(p.getX() - aux.getX(), 2) + Math.pow(p.getY() - aux.getY(), 2)), 0.5);
            aux.setX(p.getX());
            aux.setY(p.getY());
        }

        Cordenadas p = new Cordenadas();
        p.setX(0);
        p.setY(0);
        this.distancia = this.distancia + Math.pow((Math.pow(p.getX() - aux.getX(), 2) + Math.pow(p.getY() - aux.getY(), 2)), 0.5);

    }

}
