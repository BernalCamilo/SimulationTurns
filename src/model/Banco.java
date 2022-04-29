package model;

public class Banco {
    private Nodo head;
    private Nodo turnoActual;
    private int newTurno;


    public Banco() {
        this.head = null;
        newTurno = 1;
    }

    public void addNewTurno (){
        addNewTurno(new Nodo(newTurno, null, null));
    }

    private void addNewTurno(Nodo nd){
        if(head!=null){
            Nodo preLast = head.getLast();
            Nodo newLast = new Nodo(newTurno, head, preLast);
            preLast.setNext(newLast);
            head.setLast(newLast);
        }else{
            nd.setNext(nd);
            nd.setLast(nd);
            head = nd;
            turnoActual = head;
        }
        newTurno++;
    }

    public void eliminar (){
        Nodo actual = turnoActual;
        turnoActual = turnoActual.getNext();
        if (actual.getNext().equals(actual)) {
            head = null;
            turnoActual = null;
        } else{
            if (actual.equals(head)){
                head = actual.getNext();
            }
            Nodo anterior = actual.getLast();
            Nodo siguiente = actual.getNext();
            actual = null;
            anterior.setNext(siguiente);
            siguiente.setLast(anterior);
        }
    }

    public void pasarTurno(){
        turnoActual.setVecesPasadas(turnoActual.getVecesPasadas()+1);

        if (turnoActual.getVecesPasadas()==3){
            eliminar();
        } else {
            turnoActual = turnoActual.getNext();
        }
    }

    public Nodo getTurnoActual() {
        return turnoActual;
    }

    public int getNewTurno() {
        return newTurno;
    }
}
