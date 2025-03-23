package ticket.platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ticket.platform.domain.entity.Ticket;
import ticket.platform.domain.enums.TicketStatus;

public interface  TicketRepository extends JpaRepository<Ticket, Integer>{
    // public List<Ticket> findAll();
    public List<Ticket> findAllByCategoryId(Integer categoryId);
    public List<Ticket> findAllByStatus(TicketStatus ticketStatus);
    public List<Ticket> findByTitleContaining(String title);
    public List<Ticket> findByDetailsContaining(String details);
    public List<Ticket> findByTitleContainingAndDetailsContaining(String title, String details);
    // Ticket getById(Integer id);
   
    

    
}
