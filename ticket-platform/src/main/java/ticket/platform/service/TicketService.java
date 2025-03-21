package ticket.platform.service;

import java.util.List;

import ticket.platform.domain.dto.TicketDto;
import ticket.platform.domain.enums.TicketStatus;

public interface TicketService {

    List<TicketDto> getAll();
    List<TicketDto> getAllByCategory(String category);
    List<TicketDto> getAllByStatus(TicketStatus ticketStatus);
    
}
