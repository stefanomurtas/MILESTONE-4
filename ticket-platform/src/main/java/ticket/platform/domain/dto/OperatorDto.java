package ticket.platform.domain.dto;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import ticket.platform.domain.AbstractEntityStatusDto;


public class OperatorDto extends AbstractEntityStatusDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;


    private Integer id;


    private String email;

    private String username;

    private String password;

    private Boolean active;

    public OperatorDto(){}

    public OperatorDto(Integer id,String email,  String username, String password, Boolean active,LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(createdAt, updatedAt);
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}

