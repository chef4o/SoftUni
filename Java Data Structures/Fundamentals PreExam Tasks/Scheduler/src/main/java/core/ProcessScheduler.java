package core;

import model.Task;
import shared.Scheduler;

import java.util.*;

public class ProcessScheduler implements Scheduler {

    Deque<Task> tasks = new ArrayDeque<>();

    @Override
    public void add(Task task) {
        this.tasks.add(task);
    }

    @Override
    public Task process() {
        return this.tasks.removeFirst();
    }

    @Override
    public Task peek() {
        return this.tasks.peekFirst();
    }

    @Override
    public Boolean contains(Task task) {
        return this.tasks.contains(task);
    }

    @Override
    public int size() {
        return this.tasks.size();
    }

    @Override
    public Boolean remove(Task task) {
        if (!this.tasks.contains(task)) {
            throw new IllegalArgumentException();
        }
        this.tasks.remove(task);
        return true;
    }

    @Override
    public Boolean remove(int id) {
        Task toRemove = this.tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
        this.tasks.remove(toRemove);
        return true;
    }

    @Override
    public void insertBefore(int id, Task task) {
        checkIfPresent(id);
        int steps = this.tasks.size();
        while (!this.tasks.isEmpty() && steps > 0) {
            if (this.tasks.peekFirst().getId() == id) {
                this.tasks.addLast(task);
                this.tasks.addLast(this.tasks.pollFirst());
            } else {
                this.tasks.addLast(this.tasks.pollFirst());
            }
            steps--;
        }
    }

    @Override
    public void insertAfter(int id, Task task) {
        checkIfPresent(id);
        int steps = this.tasks.size();
        while (!this.tasks.isEmpty() && steps > 0) {
            if (this.tasks.peekFirst().getId() == id) {
                this.tasks.addLast(this.tasks.pollFirst());
                this.tasks.addLast(task);
            } else {
                this.tasks.addLast(this.tasks.pollFirst());
            }
            steps--;
        }
    }

    @Override
    public void clear() {
        this.tasks.clear();
    }

    @Override
    public Task[] toArray() {
        return this.tasks.toArray(Task[]::new);
    }

    @Override
    public void reschedule(Task first, Task second) {
        validate(this.tasks.contains(first) && this.tasks.contains(second));
        validate(first.getId() != second.getId());
        List<Task> tempTasks = new ArrayList<>();
        int firstIndex = -1;
        int secondIndex= -1;
        int currentIndex = 0;

        while (!this.tasks.isEmpty()) {
            Task current = this.tasks.pollFirst();
            if (current.getId() == first.getId()) {
                firstIndex = currentIndex;
            } else if (current.getId() == second.getId()) {
                secondIndex = currentIndex;
            }
            tempTasks.add(current);
            currentIndex++;
        }
        Collections.swap(tempTasks, firstIndex, secondIndex);
        this.tasks = new ArrayDeque<>(tempTasks);
        tempTasks.clear();
    }

    @Override
    public List<Task> toList() {
        return new ArrayList<>(this.tasks);
    }

    @Override
    public void reverse() {
        Deque<Task> reversed = new ArrayDeque<>();
        Iterator<Task> rev = this.tasks.descendingIterator();

        while (rev.hasNext()) {
            reversed.add(rev.next());
        }

        this.tasks = reversed;
    }

    @Override
    public Task find(int id) {
        return this.tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public void checkIfPresent(int id) {
        this.tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Task find(Task task) {
        validate(this.tasks.contains(task));
        return task;
    }

    private void validate(Boolean isTrue) {
        if (!isTrue) {
            throw new IllegalArgumentException();
        }
    }

}
