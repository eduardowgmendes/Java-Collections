package set;

import java.util.ArrayList;
import java.util.HashSet;

public class HashSetDemo {

    public static void main(String[] args) {

        HashSet<Character> hashSet = new HashSet<>();

        //Adiciona elementos ao conjunto hash
        hashSet.add('A');
        hashSet.add('B');
        hashSet.add('C');
        hashSet.add('D');
        System.out.println("Original contents: " + hashSet);

        //Adiciona mais elementos
        hashSet.add('E');
        hashSet.add('F');
        hashSet.add('G');
        hashSet.add('H');
        System.out.println("Contents after additions: " + hashSet);

        //Deleta E e H da coleção hash
        hashSet.remove('E');
        hashSet.remove('H');
        System.out.println("Contents after deleting E and H: " + hashSet);

        //Adiciona E novamente
        hashSet.add('E');
        System.out.println("Contents after adding E: " + hashSet);

        //Adiciona uma coleção de elementos ao conjunto hash
        ArrayList<Character> characters = new ArrayList<>();
        characters.add('X');
        characters.add('Y');
        characters.add('Z');
        characters.add('X');
        hashSet.addAll(characters);

        System.out.println("Contents after adding collection: " + hashSet);
    }
}
