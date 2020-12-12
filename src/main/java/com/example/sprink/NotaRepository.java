package com.example.sprink;

import org.springframework.data.repository.CrudRepository;
import com.example.sprink.Nota;
public interface NotaRepository extends CrudRepository<Nota, Long> {

        }





// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

