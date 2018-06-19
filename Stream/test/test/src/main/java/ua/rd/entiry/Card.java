package ua.rd.entiry;

import java.util.Objects;
import java.util.UUID;

public class Card {
    private UUID id;
    private UUID userId;
    private String description;

    public Card(UUID id, UUID userId, String description) {
        this.id = id;
        this.userId = userId;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(id, card.id) &&
                Objects.equals(userId, card.userId) &&
                Objects.equals(description, card.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, description);
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", userId=" + userId +
                ", description='" + description + '\'' +
                '}';
    }
}
