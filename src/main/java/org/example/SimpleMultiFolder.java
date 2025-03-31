package org.example;

import java.util.List;

public class SimpleMultiFolder implements MultiFolder {
    private final String name;
    private final String size;
    private final List<Folder> subFolders;

    public SimpleMultiFolder(String name, String size, List<Folder> subFolders) {
        this.name = name;
        this.size = size;
        this.subFolders = subFolders;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String size() {
        return size;
    }

    @Override
    public List<Folder> getFolders() {
        return subFolders;
    }

    @Override
    public String toString() {
        return "SimpleMultiFolder{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", subFolders=" + subFolders +
                '}';
    }
}
