package com.usermanagement.controller;

//package com.usermanagement.controller;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.usermanagement.model.*;
//import com.usermanagement.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//
//@WebServlet("/")
//
//public class UserController extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    private UserService userService;
//
//    @Autowired
//    public UserController(UserService userService){
//        this.userService = userService;
//
//    }
//
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        doGet(request, response);
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String action = request.getServletPath();
//
////		Create switch statement for the actions
//        try {
//            switch (action) {
//                case "/new":
//                    showNewForm(request, response);
//                    break;
//                case "/insert":
//                    insertUser(request, response);
//                    break;
//                case "/delete":
//                    deleteUser(request, response);
//                    break;
//                case "/edit":
//                    showEditForm(request, response);
//                    break;
//                case "/update":
//                    updateUser(request, response);
//                    break;
//                default:
//                    listUser(request, response);
//                    break;
//            }
//        } catch (SQLException ex) {
//            throw new ServletException(ex);
//        }
//    }
//
//    private void insertUser(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException {
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String university = request.getParameter("university");
//        User newUser = new User(name, email, university);
//        userService.saveUser(newUser);
//        response.sendRedirect("list");
//    }
//
//    private void updateUser(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String university = request.getParameter("university");
//
//        User book = new User(id, name, email, university);
//        userService.updateUser(book);
//        response.sendRedirect("list");
//    }
//
//    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        userService.deleteUser(id);
//        response.sendRedirect("list");
//
//    }
//
//    private void listUser(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ServletException {
//        List<User> listUser = userService.getAllUser();
//        request.setAttribute("listUser", listUser);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
//        dispatcher.forward(request, response);
//    }
//
//
//    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        User existingUser = userService.getUser(id);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
//        request.setAttribute("user", existingUser);
//        dispatcher.forward(request, response);
//
//    }
//
//
//}



import java.util.List;

import com.usermanagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.usermanagement.service.UserService;


@Controller
@RequestMapping("/")
public class  UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;

    }

//    @Autowired
//    private UserService userService;

    @GetMapping("/list")
    public String listUser(Model theModel) {
        List<User> listUser = userService.getAllUser();
        theModel.addAttribute("listUser", listUser);
        return "user-list";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/user/list";
    }

    @GetMapping("/update")
    public String updateUser(@RequestParam("id") int id, Model theModel) {
        User updateUser = userService.getUser(id);
        theModel.addAttribute("user", updateUser);
        return "user-list";
    }


    @PostMapping("/insert")
    public String insertUser(@ModelAttribute("insert") User user) {
        userService.saveUser(user);
        return "redirect:/user/list";
    }


}
