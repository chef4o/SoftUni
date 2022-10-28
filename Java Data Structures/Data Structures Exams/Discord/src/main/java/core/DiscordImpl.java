package core;

import models.Message;

import java.util.*;
import java.util.stream.Collectors;

public class DiscordImpl implements Discord {

    public Map<String, Message> messages;
    public Map<String, List<Message>> messagesByChannel;

    public DiscordImpl() {
        this.messages = new LinkedHashMap<>();
        this.messagesByChannel = new LinkedHashMap<>();
    }

    @Override
    public void sendMessage(Message message) {
        this.messages.put(message.getId(), message);

        this.messagesByChannel.putIfAbsent(message.getChannel(), new ArrayList<>());
        this.messagesByChannel.get(message.getChannel()).add(message);
    }

    @Override
    public boolean contains(Message message) {
        return this.messages.containsKey(message.getId());
    }

    @Override
    public int size() {
        return this.messages.size();
    }

    @Override
    public Message getMessage(String messageId) {
        getIfPresent(messageId);
        return this.messages.get(messageId);
    }

    @Override
    public void deleteMessage(String messageId) {
        getIfPresent(messageId);
        this.messages.remove(messageId);
    }

    @Override
    public void reactToMessage(String messageId, String reaction) {
        getIfPresent(messageId);
        Message presentMessage = this.messages.get(messageId);
        presentMessage.getReactions().add(reaction);
    }

    @Override
    public Iterable<Message> getChannelMessages(String channel) {
        List<Message> allMessages = this.messagesByChannel.get(channel);
        if (allMessages.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return allMessages;
    }

    @Override
    public Iterable<Message> getMessagesByReactions(List<String> reactions) {
        return this.messages.values().stream()
                .filter(r -> r.getReactions().containsAll(reactions))
                .sorted((a,b) -> {
                    int comparator = b.getReactions().size() - a.getReactions().size();
                    if (comparator == 0) {
                        return a.getTimestamp() - b.getTimestamp();
                    }
                    return comparator;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Message> getMessageInTimeRange(Integer lowerBound, Integer upperBound) {
        return this.messages.values().stream()
                .filter(m -> m.getTimestamp() >= lowerBound && m.getTimestamp() <= upperBound)
                .sorted((a,b) ->
                    this.messagesByChannel.get(b.getId()).size() - this.messagesByChannel.get(a.getId()).size())
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Message> getTop3MostReactedMessages() {
        return this.messages.values().stream()
                .sorted((a,b) -> b.getReactions().size() - a.getReactions().size())
                .limit(3)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Message> getAllMessagesOrderedByCountOfReactionsThenByTimestampThenByLengthOfContent() {
        return this.messages.values().stream()
                .sorted((a,b) -> {
                    int comparator = Integer.compare(b.getReactions().size(), a.getReactions().size());
                    if (comparator == 0) {
                        comparator = Integer.compare(a.getTimestamp(), b.getTimestamp());
                    }
                    if (comparator == 0) {
                        comparator = Integer.compare(a.getContent().length(), b.getContent().length());
                    }
                    return comparator;
                })
                .collect(Collectors.toList());
    }

    public void getIfPresent(String messageId) {
        Message present = this.messages.get(messageId);
        if (present == null) {
            throw new IllegalArgumentException("Message not present");
        }
    }

}
