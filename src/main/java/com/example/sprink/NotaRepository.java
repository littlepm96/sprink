package com.example.sprink;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.sprink.domain.Nota;

import java.util.Optional;

public interface NotaRepository extends JpaRepository<Nota, Integer> {

}





// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

