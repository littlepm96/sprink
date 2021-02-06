package com.example.sprink;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.sprink.domain.Nota;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotaRepository extends JpaRepository<Nota, Integer> {
    @Query("SELECT n FROM Nota n WHERE n.idUser =?1")
   List<Nota>findByuser(String user);

    @Query("SELECT n FROM Nota n WHERE n.idUser =?1 and n.id=?2")
    Nota findUserNota(String user,Integer id);

}





// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

