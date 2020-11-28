package com.igor.simulatedtestdevdojo.services;

import com.igor.simulatedtestdevdojo.models.Client;
import com.igor.simulatedtestdevdojo.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientDetailsService implements UserDetailsService {
    private final ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username){
        return Optional.ofNullable(clientRepository.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException("Client not found"));
    }

}
