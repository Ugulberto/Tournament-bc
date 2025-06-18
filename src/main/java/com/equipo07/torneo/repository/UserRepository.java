package com.equipo07.torneo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.equipo07.torneo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Busca si el ID del User está contenida dentro de una lista de IDs proporcionada.
     * 
     * @param List<Integer> list la lsita con las IDs de uno o múltiples usuarios.
     * @return Devuelve un Optional con el usuario si estaba contenido en la lista, o un Optional vacio en caso contrario.
     */
    Optional<List<User>> findByIdInList(List<Integer> list);
    
    /**
     * Busca un usuario a partir de su email y de su nombre de usuario.
     * 
     * @param String email es el correo electrónico del usuario a buscar.
     * @param String username es el nombre de usuario del User a buscar.
     * @return devuelve un Optional con el usuario si se encuentra, o un Optional vacio en caso contrario.
     */
    Optional<User> findByEmailAndName(String email, String username);
    
    /**
     * Busca un usuario a partir de su dirección de correo electronico.
     * 
     * @param String email es el email o correo electrónico del usuario que se desea buscar.
     * @return devuelve un Optional con el User si es que se ha encontrado o un Optional vacio si no se ha encontrado.
     */
    Optional<User> findByEmail(String email);
}
