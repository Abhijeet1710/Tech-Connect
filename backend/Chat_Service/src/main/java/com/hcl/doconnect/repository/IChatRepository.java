package com.hcl.doconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.doconnect.entity.Chat;

@Repository
public interface IChatRepository extends JpaRepository<Chat, Integer> {

	@Query("SELECT m FROM Chat m WHERE (m.sender=:sender OR m.sender=:receiver) AND (m.receiver=:sender OR m.receiver=:receiver)")
	List<Chat> findMessages(@Param("sender") String sender, @Param("receiver") String receiver);

}
