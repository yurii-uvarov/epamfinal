package ua.nure.uvarov.Practice8.db.entity;

public class Group {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }

  public static  Group createGroup(String name){
        Group group = new Group();
        group.setName(name);
        return group;
  }


}
