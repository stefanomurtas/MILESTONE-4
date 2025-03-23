package ticket.platform.domain.dto;



import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import ticket.platform.domain.AbstractEntityStatusDto;

public class CategoryDto extends AbstractEntityStatusDto  implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private Integer id;

    private String name;

    public CategoryDto(){}

    public CategoryDto(Integer id, String name, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super (createdAt, updatedAt);
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
