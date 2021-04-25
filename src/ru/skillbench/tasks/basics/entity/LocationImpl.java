package ru.skillbench.tasks.basics.entity;

public class LocationImpl implements Location{

    private Type type;
    private String name;
    private Location parent;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public void setParent(Location parent) {
        this.parent = parent;
    }

    @Override
    public String getParentName() {
        if(parent == null)
            return "--";
        return parent.getName();
    }

    @Override
    public Location getTopLocation() {
        if(parent == null)
            return this;
        return parent.getTopLocation();
    }

    @Override
    public boolean isCorrect() {
        if(parent == null)
            return true;
        if(type.compareTo(parent.getType()) > 0)
            return parent.isCorrect();
        return false;
    }

    private String curAddr(){
        String[] splited = name.split(" ");
        if(splited[0].charAt(splited[0].length() - 1) == '.' || name.charAt(name.length()-1) == '.'){
            return name;
        }
        return type.getNameForAddress() + name;
    }
    @Override
    public String getAddress() {
        if(parent == null)
            return curAddr();

        return curAddr() + ", " + parent.getAddress();
    }

    @Override
    public String toString() {
        return name + " (" + type.toString() + ")";
    }
}
