package ru.syn.quotes.models;

import jakarta.persistence.*;

@Entity
@Table(name = "chats")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "chatId", nullable = false)
    private Long chatId;

    @Column(name = "lastId", nullable = false)
    private Long lastId;

    public Chat() {
    }

    public Chat(Long id, Long chatId, Long lastId) {
        this.id = id;
        this.chatId = chatId;
        this.lastId = lastId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public Long getLastId() {
        return lastId;
    }

    public void setLastId(Long lastId) {
        this.lastId = lastId;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", chatId=" + chatId +
                ", lastId=" + lastId +
                '}';
    }
}
