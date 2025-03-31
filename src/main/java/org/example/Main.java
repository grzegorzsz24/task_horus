package org.example;

import java.util.List;

public class Main {

    public static final String SMALL_SIZE = "SMALL";
    public static void main(String[] args) {
        Folder folder1 = new SimpleFolder("Documents", "MEDIUM");
        Folder folder2 = new SimpleFolder("Pictures", "LARGE");
        MultiFolder multiFolder = new SimpleMultiFolder("Music", SMALL_SIZE,
                List.of(
                        new SimpleFolder("Rock", SMALL_SIZE),
                        new SimpleFolder("Pop", SMALL_SIZE)
                )
        );

        FileCabinet fileCabinet = new FileCabinet(List.of(folder1, folder2, multiFolder));

        System.out.println("findFolderByName(\"Pictures\") = "
                + fileCabinet.findFolderByName("Pictures"));

        System.out.println("findFoldersBySize(\"SMALL\") = "
                + fileCabinet.findFoldersBySize(SMALL_SIZE));

        System.out.println("count() = " + fileCabinet.count());
    }
}
