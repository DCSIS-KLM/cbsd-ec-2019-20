package com.red30tech.backend;

import com.red30tech.database.api.Database;
import com.red30tech.database.api.DatabaseFactory;

public class Processor {

  public static void main(String... args) {
     Database database = DatabaseFactory.getDatabase();

     database.create("Hello", "There");
     System.out.println(database.get("Hello"));
     database.update("Hello", "Bye");    
     System.out.println(database.get("Hello"));
     database.delete("Hello");
     System.out.println(database.get("Hello"));
  }
}
