package ticket.platform.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ticket.platform.domain.dto.TicketDto;
import ticket.platform.domain.enums.TicketStatus;
import ticket.platform.service.TicketService;

@RestController
@CrossOrigin
@RequestMapping("api/tickets")
public class TicketRestController {
    private final TicketService ticketService;

    public TicketRestController(TicketService ticketService) {
        this.ticketService = ticketService;
    }


    @GetMapping
    public ResponseEntity<List<TicketDto>> getAll(){
        return ResponseEntity.ok(ticketService.getAll());
    }

    @GetMapping(value = "/all-by-category")
    public ResponseEntity<List<TicketDto>> getAllByCategory(@RequestParam String category){
        return ResponseEntity.ok(ticketService.getAllByCategory(category));
    }

    @GetMapping(value = "/all-by-status")
    public ResponseEntity<List<TicketDto>> getAllByStatus(@RequestParam TicketStatus status){
        return ResponseEntity.ok(ticketService.getAllByStatus(status));
    }
}
