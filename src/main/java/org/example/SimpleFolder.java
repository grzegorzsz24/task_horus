package org.example;

public record SimpleFolder(String name, String size) implements Folder {

    @Override
    public String toString() {
        return "SimpleFolder{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
