package com.lab_admin.lab_admin.respository;

import com.lab_admin.lab_admin.Bean.Paper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaperRespository extends JpaRepository<Paper,Integer> {
}
