package ticket.platform.domain.dto;

import java.io.Serial;
import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import ticket.platform.domain.enums.TicketStatus;


public class TicketDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @NotNull(message = "can't be null or blank")
    private Integer id;

    @NotNull(message = "can't be null or blank")
    private TicketStatus state;

    @NotNull(message = "can't be null or blank")
    private String title;
    private String details;
    

    public TicketDto(Integer id, TicketStatus state, String title, String details) {
        this.id = id;
        this.state = state;
        this.title = title;
        this.details = details;
      
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TicketStatus getState() {
        return state;
    }

    public void setState(TicketStatus state) {
        this.state = state;
    }
}
