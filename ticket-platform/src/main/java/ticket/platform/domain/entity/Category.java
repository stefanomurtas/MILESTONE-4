package ticket.platform.domain.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import ticket.platform.domain.AbstractEntityStatus;

@Entity
@Table (name = "categories")
public class Category extends AbstractEntityStatus {

@Id
@GeneratedValue (strategy =GenerationType.IDENTITY)
private Integer id;
@Column(name = "type", nullable = false)
private String name;

@OneToMany(mappedBy = "category")
private List<Ticket>tickets;
   

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

    public List<Ticket> getTickets() {
        return this.tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
    
}
