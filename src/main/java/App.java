/*
Hoja de Trabajo 4
Jorge Martinez Cambara 
Quique Bran
 


*/


package main.java;
import main.java.domain.Stack;
import main.java.structure.*;
import main.java.service.*;

import java.io.*;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("Seleccione implementación de Stack:");
        System.out.println("1. ArrayList");
        System.out.println("2. Vector");
        System.out.println("3. Lista");

        int option = sc.nextInt();

        Stack<Character> stackChar;
        Stack<Double> stackDouble;

        switch (option) {
            case 1:
                stackChar = new ArrayListStack<>();
                stackDouble = new ArrayListStack<>();
                break;
            case 2:
                stackChar = new VectorStack<>();
                stackDouble = new VectorStack<>();
                break;
            case 3:
                System.out.println("Seleccione implementación de Lista:");
                System.out.println("1. Simplemente encadenada");
                System.out.println("2. Doblemente encadenada");

                int listOption = sc.nextInt();

                if (listOption == 1) {
                    stackChar = new ListStack<>(new SinglyLinkedList<>());
                    stackDouble = new ListStack<>(new SinglyLinkedList<>());
                } else {
                    stackChar = new ListStack<>(new DoublyLinkedList<>());
                    stackDouble = new ListStack<>(new DoublyLinkedList<>());
                }
                break;
            default:
                throw new IllegalArgumentException("Opción inválida");
        }

        BufferedReader br = new BufferedReader(new FileReader("datos.txt"));
        String expression = br.readLine();
        br.close();

        String postfix = InfixToPostfixConverter.convert(expression, stackChar);
        double result = PostfixEvaluator.evaluate(postfix, stackDouble);

        System.out.println("Infix: " + expression);
        System.out.println("Postfix: " + postfix);
        System.out.println("Resultado: " + result);
    }
}