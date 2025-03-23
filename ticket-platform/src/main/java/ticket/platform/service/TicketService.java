package ticket.platform.service;

import java.util.List;

import ticket.platform.domain.dto.TicketDto;
import ticket.platform.domain.enums.TicketStatus;

public interface TicketService {

    List<TicketDto> getAll();
    List<TicketDto> getAllByCategoryId(Integer categoryId);
    List<TicketDto> getAllByStatus(TicketStatus ticketStatus);
    
}
