package ru.mirea;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class HashTable<T> {
    TreeMap<Integer, Set<T>> hashtable;
    HashTable(){
        hashtable=new TreeMap<>();
    }
    public void add(T word){
        System.out.println("Добавляем "+ word);
        int hashCode=hash(word);

        if(hashtable.containsKey(hashCode) &&!hashtable.get(hashCode).contains(word)) {
            System.out.println("Обранужена коллизиция при добавлении " + word);
            hashtable.get(hashCode).add(word);
        }
        else{
            Set<T>temp= new TreeSet<>();
            temp.add(word);
            hashtable.put(hashCode,temp);
        }


    }

    public void show(){
        for (int t:hashtable.keySet()
        ) {
            System.out.print("Key "+ t+" Values:  ");
            Set<T> words= hashtable.get(t);
            for (T g:words
            ) {
                System.out.print(" "+g);

            }
            System.out.println();

        }
        System.out.println();

    }
    public void remove(T word){
            for (int t:hashtable.keySet()
            ) {
                Set<T> words= hashtable.get(t);
                for (T g:words
                ) {
                  if(g.equals(word)){
                      words.remove(g);
                      if(words.isEmpty()) hashtable.remove(t);
                      return;
                  }
                }
            }

    }
    public void find(T word){
        int hash=hash(word);
        System.out.print("Выполним поиск " + word+". ");
        if(hashtable.containsKey(hash)){
            for (T t:hashtable.get(hash)
                 ) {
                if(t==word){
                    System.out.println("Содержится слово " + word) ;
                    return;
                }
            }
            }

            System.out.println("Не содержится слово " + word) ;


    }
    private int hash(T word){
        if(word.getClass() ==new String().getClass()){
            return hashString((String) word);
        }
        else{
            return hashDefault(word);
        }
    }


    private int hashString(String word) {//хэш функция для типа String
        int hashCode=0;
        for (int i = 0; i <word.length(); i++) {
            hashCode+=(int)word.charAt(i);
        }
        System.out.println("Key: "+word + " Value: "+hashCode); // Value - хэш функции
        return hashCode;
    }
    private int hashDefault(T word) {//хэш функция
        int hashCode=word.hashCode();
        return hashCode;
    }

}
