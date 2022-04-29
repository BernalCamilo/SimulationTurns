package main;

import model.Banco;
import model.Nodo;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Banco banco = new Banco();
    public static void main(String[] args) {
        int x = 0;
        while ( x!=-1){
            System.out.println("-------------MENU-------------");
            System.out.println("ingrese la opcion que desea usar");
            System.out.println("1: Aniadir nuevo turno");
            System.out.println("2: Dar turno");
            System.out.println("3: Mostrar turno actual");
            System.out.println("4: Pasar turno");
            System.out.println("5: Eliminar turno actual");
            System.out.println("-1: Cerrar programa");
            x = sc.nextInt();
            Nodo actual = banco.getTurnoActual();
            switch (x){

                case 1: banco.addNewTurno();
                    System.out.println("El turno aniadido es: "+(banco.getNewTurno()-1));
                break;
                case 2:
                    if (actual!=null){
                        banco.eliminar();
                        System.out.println("Se le dio el turno a: "+actual.getTurno());
                        System.out.println("Se elimino al turno: "+actual.getTurno()+" ya que fue atendido");
                        actual = banco.getTurnoActual();
                        if (actual!=null){
                            System.out.println("El nuevo turno es: "+actual.getTurno());
                        } else {
                            System.out.println("Esta era la ultima persona en la fila, por lo que la lista quedo vacia");
                        }

                    } else {
                        System.out.println("No se puede dar paso a nadie ya que la lista esta vacia");
                    }
                break;
                case 3:
                if (actual!=null){
                    System.out.println("el turno actual es: "+actual.getTurno());
                } else {
                    System.out.println("no se puede mostrar turnos, ya que no existe nadie en la cola");
                }
                break;
                case 4:
                    if (actual!=null){
                        banco.pasarTurno();
                        System.out.println("Se paso el turno: "+actual.getTurno());
                        int pasadas = actual.getVecesPasadas();
                        System.out.println("Se ha pasado un total de "+pasadas+" veces");
                        if (pasadas==3){
                            System.out.println("Al pasar un total de 3 veces se elimino el turno");
                            if (actual.getNext().equals(actual)){
                                System.out.println("La lista quedo vacia");
                            } else {
                                System.out.println("El nuevo turno es: "+actual.getNext().getTurno());
                            }
                        } else{
                            System.out.println("El nuevo turno es: "+actual.getNext().getTurno());
                        }
                    }else {
                        System.out.println("No existe nadie en la lista");
                    }

                break;
                case 5:
                    if (actual!=null){
                        System.out.println("Se elimino el turno: "+actual.getTurno());
                        actual = banco.getTurnoActual();
                        if (actual!=null){
                            System.out.println("El nuevo turno es: "+actual.getTurno());
                        } else {
                            System.out.println("La lista quedo vacia, se elimino a la ultima persona");
                        }

                        banco.eliminar();
                    } else{
                        System.out.println("No se puede eliminar a nadie ya que la lista esta vacia");

                    }
                    break;
                case -1: //sale del programa
                    break;
                default: System.out.println("ingrese una opcion correcta");
            }
            if (x!=-1){
                System.out.println("presione enter para continuar");
                sc.nextLine();
                sc.nextLine();
            }
        }
    }
}
