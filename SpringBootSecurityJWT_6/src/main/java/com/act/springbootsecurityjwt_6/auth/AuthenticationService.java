package com.act.springbootsecurityjwt_6.auth;


import com.act.springbootsecurityjwt_6.config.JwtService;
import com.act.springbootsecurityjwt_6.repository.UserRepository;
import com.act.springbootsecurityjwt_6.user.Role;
import com.act.springbootsecurityjwt_6.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {

        String email = request.getEmail();
        String password = request.getPassword();
        String firstname = request.getFirstname();
        String lastname = request.getLastname();

//        Checking all fields are not empty before saving

        if (email.isEmpty() && password.isEmpty() && firstname.isEmpty() && lastname.isEmpty()) {
            return AuthenticationResponse.builder()
                    .message("All filed are Required")
                    .status(false)
                    .build();

        } else if (firstname.isEmpty()) {
            return AuthenticationResponse.builder()
                    .message("First name is Required")
                    .status(false)
                    .build();
        } else if (lastname.isEmpty()) {

            return AuthenticationResponse.builder()
                    .message("Lastname is Required")
                    .status(false)
                    .build();
        } else if (password.isEmpty()) {
            return AuthenticationResponse.builder()
                    .message("Password is Required")
                    .status(false)
                    .build();

        } else if (email.isEmpty()) {
            return AuthenticationResponse.builder()
                    .message("Email is Required")
                    .status(false)
                    .build();
        } else if (repository.existsByEmail(email)) {
            return AuthenticationResponse.builder()
                    .message("Email ID with " + email + " is already taken. Try another email to register!.")
                    .status(false)
                    .build();
        } else {

            var user = User.builder()
                    .firstname(request.getFirstname())
                    .lastname(request.getLastname())
                    .email(email)
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(Role.USER)
                    .build();
            repository.save(user);
            var jwtToken = jwtService.generateToken(user);
            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .message("Registration success!. you can login now, by using your email as username and password as password")
                    .status(true)
                    .build();

        }
    }


//    Login Method

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        String email = request.getEmail();
        String password = request.getPassword();

        // Check if email and password are empty
        if (email.isEmpty() && password.isEmpty()) {
            return AuthenticationResponse.builder()
                    .message("Username and password are required. Please enter your email and password.")
                    .status(false)
                    .build();
        } else if (email.isEmpty()) {
            return AuthenticationResponse.builder()
                    .message("Username is required. Please enter your email.")
                    .status(false)
                    .build();
        } else if (password.isEmpty()) {
            return AuthenticationResponse.builder()
                    .message("Password is required. Please enter your password.")
                    .status(false)
                    .build();
        }

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            email,
                            password
                    )
            );
        } catch (BadCredentialsException ex) {
            return AuthenticationResponse.builder()
                    .message("Invalid password. Please enter the correct password.")
                    .status(false)
                    .build();
        } catch (UsernameNotFoundException ex) {
            return AuthenticationResponse.builder()
                    .message("Username not found. Please enter a valid email.")
                    .status(false)
                    .build();
        }

        var user = repository.findByEmail(email)
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .status(true)
                .message("Login success!")
                .build();
    }

        }
