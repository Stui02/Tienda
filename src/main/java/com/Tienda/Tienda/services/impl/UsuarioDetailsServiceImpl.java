/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda.Tienda.services.impl;

import com.Tienda.Tienda.dao.UsuarioDao;
import com.Tienda.Tienda.domain.Rol;
import com.Tienda.Tienda.domain.Usuario;
import com.Tienda.Tienda.services.UsuarioDetailsService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author stu22
 */
@Service("userDetailsService")
public class UsuarioDetailsServiceImpl 
        implements UsuarioDetailsService, UserDetailsService {
    
    @Autowired
    private UsuarioDao usuarioDao;
    
    @Autowired
    private HttpSession session;
    
    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Usuario usuario = usuarioDao.findByUsername(username);
        if (usuario==null){
            throw new UsernameNotFoundException(username);
        }
        session.removeAttribute("imagenUsuario");
        session.setAttribute("imagenUsuario", usuario.getRutaImagen());
        
        var roles = new ArrayList<GrantedAuthority>();
        
        for(Rol r: usuario.getRoles()){
           roles.add(new SimpleGrantedAuthority(r.getNombre()));
        }
        
        return new User(usuario.getUsername(),usuario.getPassword(),roles);
    }
    
}
