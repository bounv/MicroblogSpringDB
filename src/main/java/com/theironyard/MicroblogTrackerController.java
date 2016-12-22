package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by boun on 12/21/16.
 */

@Controller
public class MicroblogTrackerController {

    @Autowired
    MessageRepository messages;

    public static HashMap<String, User> users = new HashMap<>();

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        model.addAttribute("name", session.getAttribute("userName"));

        List<Message> messageList = (List<Message>) messages.findAll();
        model.addAttribute("messages", messageList);
        return "home";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName) {
        session.setAttribute("userName", userName);
        return "redirect:/";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String message(Model model, String userMessage) {

        Message m = new Message (userMessage);
        messages.save(m);

        return "redirect:/";
    }

    @RequestMapping(path = "/delete-message", method = RequestMethod.POST)
    public String messageDelete(Model model, int id) {

        messages.delete(id);

        return "redirect:/";
    }

    @RequestMapping(path = "/edit-message", method = RequestMethod.POST)
    public String messageEdit(Model model, int id, String message) {
        Message m = messages.findOne(id);

        m.text = message;
        messages.save(m);

        return "redirect:/";
    }


}