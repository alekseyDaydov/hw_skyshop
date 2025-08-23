package org.skypro.skyshop;

public interface Searchable {
    String searchTerm(String findText);

    String getContent();

   default void getStringRepresentation(){
       System.out.println("Searchable.getStringRepresentation");;
    }
}
