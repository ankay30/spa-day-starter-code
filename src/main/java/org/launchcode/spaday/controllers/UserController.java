package org.launchcode.spaday.controllers;
import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("user")
public class UserController {
    //    @GetMapping
//    public String displayAllEvents(Model model) {
//        model.addAttribute("title", "All Events");
//        model.addAttribute("users", UserData.getAll());
//        return "user/index";
//    }
    @GetMapping("add")
    public String displayAddUserForm(){
        return "user/add";
    }
    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        // add form submission handling code here
        //System.out.println(user.getPassword());
        //System.out.println(verify);

        if((user.getPassword()).equals(verify)){
            model.addAttribute("user", user);
            model.addAttribute("verify", verify);
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());

            model.addAttribute("title","Welcome "+user.getUsername()+"!");
            model.addAttribute("users", UserData.getAll());
            return "user/index";

        }
        else {

            model.addAttribute("error", "Passwords do not match");
            model.addAttribute("userName",user.getUsername());
            model.addAttribute("emailID",user.getEmail());
            return "user/add";
        }
    }
    @GetMapping("details/{userId}")
    public String displayUser(Model model , @PathVariable int userId ){
        User user = UserData.getById(userId);
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String strDate = dateFormat.format(user.getJoinedDate());
        model.addAttribute("joined",strDate);
        return "user/details";
    }

}

