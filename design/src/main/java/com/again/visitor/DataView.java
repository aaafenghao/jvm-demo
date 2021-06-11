package com.again.visitor;

import java.util.ArrayList;
import java.util.List;

public class DataView {

   List<User> users = new ArrayList<>();
  public DataView(){
      users.add(new Student("","",""));
      users.add(new Student("","",""));
      users.add(new Student("","",""));
      users.add(new Student("","",""));
      users.add(new Student("","",""));
      users.add(new Teacher("","",""));
      users.add(new Teacher("","",""));
      users.add(new Teacher("","",""));
      users.add(new Teacher("","",""));
      users.add(new Teacher("","",""));
  }

  public void show(Vistior vistior){
      for (User user : users) {
          user.accept(vistior);
      }
  }
}
