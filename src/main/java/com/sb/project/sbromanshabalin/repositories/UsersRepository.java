package com.sb.project.sbromanshabalin.repositories;

import com.sb.project.sbromanshabalin.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsersRepository extends JpaRepository<Users, UUID>
{
}
