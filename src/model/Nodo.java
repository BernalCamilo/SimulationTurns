package model;

public class Nodo {
    private int turno;
    private int vecesPasadas;
    private Nodo next;
    private Nodo last;

    public Nodo(int turno, Nodo next, Nodo last) {
        this.vecesPasadas=0;
        this.turno = turno;
        this.next = next;
        this.last = last;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getVecesPasadas() {
        return vecesPasadas;
    }

    public void setVecesPasadas(int vecesPasadas) {
        this.vecesPasadas = vecesPasadas;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public Nodo getLast() {
        return last;
    }

    public void setLast(Nodo last) {
        this.last = last;
    }
}
