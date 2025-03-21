package ticket.platform.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import ticket.platform.domain.entity.Ticket;
import ticket.platform.domain.enums.TicketStatus;
import ticket.platform.service.impl.TicketServiceImpl;

@Controller
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketServiceImpl ticketServiceImpl;

    @GetMapping
    public String index(Model model) {
        List<Ticket> ticketss = ticketServiceImpl.findAll();
        model.addAttribute("tickets", ticketss);
        return "ticket/index";
    }

    @GetMapping("/home")
    public String home() {
        return "ticket/home";
    }

    @GetMapping("/show/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("tickets", ticketServiceImpl.getById(id));
        return "ticket/show";

    }

    @GetMapping("/search")
    public String searchPage() {
        return "ticket/search";
    }

    @GetMapping("/search/title")
    public String findByTitle(@RequestParam(name = "query") String title, Model model) {
        List<Ticket> tickets = ticketServiceImpl.findByTitle(title);
        model.addAttribute("tickets", tickets);
        return "ticket/index";
    }

    @GetMapping("/search/details")
    public String findByDetails(@RequestParam(name = "query") String details, Model model) {
        List<Ticket> tickets = ticketServiceImpl.findByDetails(details);
        model.addAttribute("tickets", tickets);
        return "ticket/index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        Ticket ticket = new Ticket(); 
        ticket.setState(TicketStatus.TO_DO);  // Imposta uno stato di default, se desiderato
        model.addAttribute("ticket", ticket);
        model.addAttribute("ticketStatuses", TicketStatus.values());
        return "ticket/create";
    }
 @PostMapping("/create")
 public String create(@Valid @ModelAttribute("ticket")Ticket formTicket,BindingResult bindingResult ,Model model, RedirectAttributes redirectAttributes){
    if (bindingResult.hasErrors()) {
      model.addAttribute("create", true);
      model.addAttribute("ticketStatuses", TicketStatus.values());
        return "ticket/create";
    }
    ticketServiceImpl.createOrUpdate(formTicket);
    redirectAttributes.addFlashAttribute("message", String.format("\"%s\" è stato salvato correttamente",formTicket.getTitle()));
redirectAttributes.addFlashAttribute("messageClass", ("alert-danger"));
    return "redirect:/ticket";
 }
 @GetMapping ("/edit/{id}")
 public String create (@PathVariable("id") Integer id,Model model){
    model.addAttribute("ticket", ticketServiceImpl.getById(id));
    return "ticket/edit";
}
@PostMapping("/edit/{id}")
 public String edit(@Valid @ModelAttribute("ticket")Ticket formTicket,BindingResult bindingResult ,Model model, RedirectAttributes redirectAttributes){
    if (bindingResult.hasErrors()) {

        return "ticket/edit";
}
ticketServiceImpl.createOrUpdate(formTicket);
redirectAttributes.addFlashAttribute("message", String.format("\"%s\" è stato salvato correttamente",formTicket.getTitle()));
redirectAttributes.addFlashAttribute("messageClass", ("alert-success"));
return "redirect:/ticket";

 }
 @PostMapping("/delete/{id}")
 public String delete(@PathVariable Integer id , RedirectAttributes redirectAttributes){
   Ticket ticket = ticketServiceImpl.getById(id);
    ticketServiceImpl.delete(ticket);
redirectAttributes.addFlashAttribute("message", String.format("\"%s\" è stato cancellato correttamente",ticket.getTitle()));
redirectAttributes.addFlashAttribute("messageClass", ("alert-danger"));
    return "redirect:/ticket";
 }



    @GetMapping("/ticket/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Optional<Ticket> optionalTicket = ticketServiceImpl.findById(id);
        if (optionalTicket.isPresent()) {
            model.addAttribute("ticket", optionalTicket.get());}
            model.addAttribute("ticketStatus", TicketStatus.values());
        return "ticket/edit";
    }
}
