package com.lab_admin.lab_admin.respository;

import com.lab_admin.lab_admin.Bean.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRespository extends JpaRepository<Member,Integer> {
}
