package com.ecommerce.Controller;

import com.ecommerce.DTO.UserDTO;
import com.ecommerce.Entity.Product;
import com.ecommerce.Entity.User;
import com.ecommerce.Repository.UserRepository;
import com.ecommerce.Service.ProductService;
import com.ecommerce.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Data
@RequiredArgsConstructor
public class UserController {
    private UserRepository userRepository;
    private UserService userService;
    private ProductService productService;

    @Autowired
    public UserController(UserService userService,ProductService productService){
        this.userService = userService;
        this.productService = productService;
    }

    @GetMapping("/login")
    public String signIn(Model model){
        model.addAttribute("user", new UserDTO());
        model.addAttribute("registerUser",new UserDTO());
        return "login";
    }
    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("user") UserDTO userDTO, HttpServletRequest httpServletRequest, Model model){
        User user = userService.findUser(userDTO);
        ModelAndView modelAndView = new ModelAndView();

        if(user != null){
            UserDTO userDto = userService.usermapToUserDTO(user);
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("userId",userDto.getId());

            Page<Product> allProducts = productService.displayAllProducts();

            modelAndView.addObject("products",allProducts);
            modelAndView.setViewName("home");
            return modelAndView;
        }
        modelAndView.addObject("errorMessage","email or username does not exist");
        modelAndView.setViewName("login");

        return modelAndView;
    }

    @PostMapping("/registerUser")
    public String registerUser(@ModelAttribute("user")UserDTO userDTO,HttpServletRequest httpServletRequest,Model model){
        User user = userService.findUser(userDTO);

        if(user != null){
            model.addAttribute("errorMessage","User Exists");
            return "login";
        }
        UserDTO newUserDTO = userService.save(userDTO);
        HttpSession session = httpServletRequest.getSession(true);
        session.setAttribute("userId",newUserDTO.getId());
        model.addAttribute("successMessage","User successfully added");

        return "home";
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest httpServletRequest){
        ModelAndView modelAndView = new ModelAndView();
        Page<Product> allProducts = productService.displayAllProducts();

        HttpSession session = httpServletRequest.getSession();
        session.removeAttribute("userId");

        modelAndView.setViewName("home");
        modelAndView.addObject("product",allProducts);

        return modelAndView;
    }
}
