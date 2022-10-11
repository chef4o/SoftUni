package core;

import model.Message;
import shared.DataTransferSystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MessagingSystem implements DataTransferSystem {

    List<Message> messages = new ArrayList<>();

    @Override
    public void add(Message message) {
        validate(!this.messages.contains(message));
        this.messages.add(message);
    }

    @Override
    public Message getByWeight(int weight) {
        return this.messages.stream()
                .filter(m -> m.getWeight() == weight)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Message getLightest() {
        return this.messages.stream()
                .min(Comparator.comparingInt(Message::getWeight))
                .orElseThrow(IllegalStateException::new);
    }

    @Override
    public Message getHeaviest() {
        return this.messages.stream()
                .max(Comparator.comparingInt(Message::getWeight))
                .orElseThrow(IllegalStateException::new);
    }

    @Override
    public Message deleteLightest() {
        Message current = this.getLightest();
        this.messages.remove(current);
        return current;
    }

    @Override
    public Message deleteHeaviest() {
        Message current = this.getHeaviest();
        this.messages.remove(current);
        return current;
    }

    @Override
    public Boolean contains(Message message) {
        return this.messages.contains(message);
    }

    @Override
    public List<Message> getOrderedByWeight() {
        return this.messages.stream()
                .sorted(Comparator.comparing(Message::getWeight))
                .collect(Collectors.toList());
    }

    @Override
    public List<Message> getPostOrder() {
        return null;
    }

    @Override
    public List<Message> getPreOrder() {
        return null;
    }

    @Override
    public List<Message> getInOrder() {
        return null;
    }

    @Override
    public int size() {
        return this.messages.size();
    }

    private void validate(Boolean isTrue) {
        if (!isTrue) {
            throw new IllegalArgumentException();
        }
    }
}
