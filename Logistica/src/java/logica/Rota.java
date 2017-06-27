package logica;

import java.util.ArrayList;
import java.util.List;

public class Rota {

    private List<Cordenadas> pos;
    private double distancia;

    public Rota() {
        this.pos = new ArrayList<>();
        this.distancia = 0;
    }

    public List<Cordenadas> getPos() {
        return pos;
    }

    public void setPos(List<Cordenadas> pos) {
        this.pos = pos;
    }

    public double getDistancia() {
        calculaDistancia();

        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public void insereEntrega(Cordenadas pos) {
        this.pos.add(pos);
        calculaDistancia();
    }

    private void calculaDistancia() {
        this.distancia = 0;
        Cordenadas aux = new Cordenadas();
        aux.setX(0);
        aux.setY(0);

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
