package ticket.platform.domain;
import java.time.LocalDateTime;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.PastOrPresent;


@MappedSuperclass
public class  AbstractEntityStatus{
    @PastOrPresent(message="non può essere creata in futuro")
    private LocalDateTime createdAt;

    @PastOrPresent(message="non può essere creata in futuro")
    private LocalDateTime updatedAt;


    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}