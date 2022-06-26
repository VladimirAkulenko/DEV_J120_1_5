/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dev_j120_1_5;

/**
 *
 * @author USER
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Integer[] numbers = {1,2,3,4,5};
        String [] string = {"Александр", "Борис", "Владимир", "Григорий"};

        DoublyList<String> listString = new DoublyList<>();
        listString.addArrayList(string);
        DoublyList<Integer> listInt = new DoublyList<>();
        listInt.addArrayList(numbers);

        listInt.print();
        listString.print();

        for (Integer t: listInt) {
            System.out.println(t);
        }

        for (String t : listString){
            System.out.println(t);
        }

        listString.setRout(false);
        for (String t : listString){
            System.out.println(t);
        }

        for (int i: listInt){
            System.out.println(i);
            if(i == 2)
                break;
        }
        boolean b = false;
        for(int s: listInt){
            if ((s == 2) ==b)
                continue;
            b=true;
            System.out.println(s);
        }

        listInt.setRout(true);
        for (int t : listInt){
            System.out.println(t);
            if (t ==3)
                break;
        }

        listString.setRout(true);
        b = false;
        for (String t : listString){
            if (t.equals("Александр") == b)
                continue;
            System.out.println(t);
        }
    }
    
}
