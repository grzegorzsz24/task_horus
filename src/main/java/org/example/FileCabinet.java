package org.example;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class FileCabinet implements Cabinet {
    private final List<Folder> folders;

    public FileCabinet(List<Folder> folders) {
        this.folders = folders;
    }

    @Override
    public Optional<Folder> findFolderByName(String name) {
        return getAllFolders().filter(f -> f.name().equals(name))
                .findAny();
    }

    @Override
    public List<Folder> findFoldersBySize(String size) {
        return getAllFolders().filter(f -> f.size().equals(size))
                .toList();
    }

    @Override
    public int count() {
        return (int) getAllFolders().count();
    }

    private Stream<Folder> getAllFolders() {
        return folders.stream()
                .flatMap(this::flattenFolder);
    }

    private Stream<Folder> flattenFolder(Folder folder) {
        if (folder instanceof MultiFolder multi) {
            return Stream.concat(
                    Stream.of(folder),
                    multi.getFolders().stream().flatMap(this::flattenFolder)
            );
        } else {
            return Stream.of(folder);
        }
    }
}

