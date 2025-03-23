package ticket.platform.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ticket.platform.domain.dto.TicketDto;
import ticket.platform.domain.entity.Ticket;
import ticket.platform.domain.enums.TicketStatus;
import ticket.platform.repository.TicketRepository;
import ticket.platform.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }


    @Override
    public List<TicketDto> getAll() {
        return ticketRepository.findAll().stream()
                .map(item -> new TicketDto(item.getId(), item.getStatus(), item.getTitle(), item.getDetails(),null,null,item.getCreatedAt(), item.getUpdateAt()))
                .collect(Collectors.toList());
    }

    @Override
    public List<TicketDto> getAllByCategoryId(Integer categoryId) {
        return ticketRepository.findAllByCategoryId(categoryId).stream()
                .map(item -> new TicketDto(item.getId(), item.getStatus(), item.getTitle(), item.getDetails(),null,null,item.getCreatedAt(), item.getUpdateAt()))
                .collect(Collectors.toList());
    }

    @Override
    public List<TicketDto> getAllByStatus(TicketStatus ticketStatus) {
        return ticketRepository.findAllByStatus(ticketStatus).stream()
                .map(item -> new TicketDto(item.getId(), item.getStatus(), item.getTitle(), item.getDetails(),null,null,item.getCreatedAt(), item.getUpdateAt()))
                .collect(Collectors.toList());
    }

    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    public Ticket getById(Integer id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        if (ticket.isEmpty()) {
            throw new IllegalArgumentException("Nessun ticket con questo" + id);
        }
        return ticket.get();
    }

    public List<Ticket> findByQuery(String query) {
        return ticketRepository.findByTitleContainingAndDetailsContaining(query, query);
    }


    public Optional<Ticket> findById(Integer id) {
        return ticketRepository.findById(id);
    }

    public List<Ticket> findAllSortByName() {
        return ticketRepository.findAll(Sort.by("title"));
    }

    public Ticket createOrUpdate(Ticket ticket) {
        if (ticket.getId() == null) {
            return ticketRepository.save(ticket);
        } else {
            Optional<Ticket> existingTicket = ticketRepository.findById(ticket.getId());
            if (existingTicket.isPresent()) {
                Ticket updatedTicket = existingTicket.get();

                updatedTicket.setTitle(ticket.getTitle());
                updatedTicket.setDetails(ticket.getDetails());

                return ticketRepository.save(updatedTicket);
            } else {

                return ticketRepository.save(ticket);
            }
        }
    }

    public void deleteById(Integer id) {
        ticketRepository.deleteById(id);
    }

    public void delete(Ticket ticket) {
        ticketRepository.delete(ticket);
    }

    public boolean exists(Ticket ticket) {
        return ticketRepository.existsById(ticket.getId());
    }

    public boolean existsById(Integer id) {
        return ticketRepository.existsById(id);
    }

    public List<Ticket> findByTitle(String title) {
        return ticketRepository.findByTitleContaining(title);
    }

    public List<Ticket> findByDetails(String details) {
        return ticketRepository.findByDetailsContaining(details);
    }

    public Ticket createOrUpdateAt(Ticket ticket) {
        LocalDateTime now = LocalDateTime.now();
        if (ticket.getId() == null) {
            ticket.setCreatedAt(now); // solo se nuovo
        }
        ticket.setUpdatedAt(now); // sempre aggiornato

        return ticketRepository.save(ticket);
    }
}
 

    
    

