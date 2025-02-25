package belajarspringwebmvc.belajarspringwebmvc.controller;

import belajarspringwebmvc.belajarspringwebmvc.model.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @PostMapping(path = "/auth/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> login (
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password,
            HttpServletResponse servletResponse,
            HttpServletRequest servletRequest
    ) {
        if (username.equals("Reqi") && password.equals("admin")) {
            HttpSession session = servletRequest.getSession(true);
            session.setAttribute("username", new User(username));
            Cookie cookie = new Cookie("username", username);
            cookie.setPath("/");
            servletResponse.addCookie(cookie);

            return ResponseEntity.status(HttpStatus.OK).body("Login Success");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login Failed");
        }
    }

    @GetMapping (path = "/auth/login")
    public ResponseEntity<String> getUser(@CookieValue("username") String username) {
        //@cookievalue digunakan untuk menerima cookie yang diberikan oleh browser
        return new ResponseEntity<>("Hello " + username, HttpStatus.OK);
    }
}
