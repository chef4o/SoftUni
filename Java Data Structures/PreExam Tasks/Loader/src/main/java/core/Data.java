package core;

import interfaces.Entity;
import interfaces.Repository;

import java.util.*;
import java.util.stream.Collectors;

public class Data implements Repository {

    List<Entity> data;

    public Data() {
        this.data = new ArrayList<>();
    }

    @Override
    public void add(Entity entity) {
        this.data.add(entity);
    }

    @Override
    public Entity getById(int id) {
        return this.data.stream()
                .filter(e -> e.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Entity> getByParentId(int id) {
        return this.data.stream()
                .filter(e -> e.getParentId() == id)
                .collect(Collectors.toList());
    }

    @Override
    public List<Entity> getAll() {
        return new ArrayList<>(this.data);
    }

    @Override
    public Repository copy() {
        Data copy = this;
        return copy;
    }

    @Override
    public List<Entity> getAllByType(String type) {
        String[] types = new String[] {"Invoice", "StoreClient", "User"};
        if (!Arrays.asList(types).contains(type)) {
            throw new IllegalArgumentException("Illegal type: " + type);
        }
        return this.data.stream()
                .filter(e -> e.getClass().getSimpleName().equals(type))
                .collect(Collectors.toList());
    }

    @Override
    public Entity peekMostRecent() {
        return this.data.stream()
                .max(Comparator.comparing(Entity::getId))
                .orElseThrow(() -> new IllegalStateException("Operation on empty Data"));
    }

    @Override
    public Entity pollMostRecent() {
        Entity toRemove = this.data.stream()
                .max(Comparator.comparing(Entity::getId))
                .orElseThrow(() -> new IllegalStateException("Operation on empty Data"));
        this.data.remove(toRemove);
        return toRemove;
    }

    @Override
    public int size() {
        return this.data.size();
    }
}
