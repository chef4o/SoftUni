package core;

import interfaces.Buffer;
import interfaces.Entity;
import model.BaseEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Loader implements Buffer {

    private List<Entity> entities;

    public Loader() {
        this.entities = new ArrayList<>();
    }

    @Override
    public void add(Entity entity) {
        this.entities.add(entity);
    }

    @Override
    public Entity extract(int id) {
        Entity removed = this.entities.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);

        if (removed != null) {
            this.entities.remove(removed);
        }
        return removed;
    }

    @Override
    public Entity find(Entity entity) {
        return this.entities.stream()
                .filter(e -> e.equals(entity))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean contains(Entity entity) {
        return this.entities.contains(entity);
    }

    @Override
    public int entitiesCount() {
        return this.entities.size();
    }

    @Override
    public void replace(Entity oldEntity, Entity newEntity) {
        checkIfPresent(oldEntity);
        this.entities.set(this.entities.indexOf(oldEntity), newEntity);
    }

    @Override
    public void swap(Entity first, Entity second) {
        checkIfPresent(first);
        checkIfPresent(second);
        Collections.swap(this.entities, this.entities.indexOf(first),this.entities.indexOf(second));
    }

    @Override
    public void clear() {
        this.entities.clear();
    }

    @Override
    public Entity[] toArray() {
        return this.entities.toArray(Entity[]::new);
    }

    @Override
    public List<Entity> retainAllFromTo(BaseEntity.Status lowerBound, BaseEntity.Status upperBound) {
        return this.entities.stream()
                .filter(e -> e.getStatus().ordinal() >= lowerBound.ordinal())
                .filter(e -> e.getStatus().ordinal() <= upperBound.ordinal())
                .collect(Collectors.toList());
    }

    @Override
    public List<Entity> getAll() {
        return this.entities;
    }

    @Override
    public void updateAll(BaseEntity.Status oldStatus, BaseEntity.Status newStatus) {
        for (Entity entity : this.entities) {
            if (entity.getStatus() == oldStatus) {
                entity.setStatus(newStatus);
            }
        }
    }

    @Override
    public void removeSold() {
        this.entities.removeIf(e -> e.getStatus() == BaseEntity.Status.SOLD);
    }

    @Override
    public Iterator<Entity> iterator() {
        return this.entities.iterator();
    }

    private void checkIfPresent(Entity entity) {
        int index = this.entities.indexOf(entity);
        if (index == -1) {
            throw new IllegalStateException("Entity not found");
        }
    }
}
