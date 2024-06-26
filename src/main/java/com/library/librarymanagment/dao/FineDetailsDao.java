package com.library.librarymanagment.dao;

import com.library.librarymanagment.model.FineDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FineDetailsDao extends JpaRepository<FineDetails, Integer> {
}
