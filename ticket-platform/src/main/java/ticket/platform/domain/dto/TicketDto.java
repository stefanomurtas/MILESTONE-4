package ticket.platform.domain.dto;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import ticket.platform.domain.AbstractEntityStatusDto;
import ticket.platform.domain.enums.TicketStatus;


public class TicketDto extends AbstractEntityStatusDto implements Serializable  {
    @Serial
    private static final long serialVersionUID = 1L;
    @NotNull(message = "can't be null or blank")
    private Integer id;

    @NotNull(message = "can't be null or blank")
    private TicketStatus status;

    @NotNull(message = "can't be null or blank")
    private String title;
    private String details;

    private OperatorDto operatorDto;
    private CategoryDto categoryDto;

    public TicketDto() {

    }

    public TicketDto( Integer id, TicketStatus status, String title, String details, OperatorDto operatorDto, CategoryDto categoryDto,LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(createdAt, updatedAt);
        this.id = id;
        this.status = status;
        this.title = title;
        this.details = details;
        this.operatorDto = operatorDto;
        this.categoryDto = categoryDto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public OperatorDto getOperatorDto() {
        return operatorDto;
    }

    public void setOperatorDto(OperatorDto operatorDto) {
        this.operatorDto = operatorDto;
    }

    public CategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }
}
