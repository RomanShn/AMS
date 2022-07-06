package com.sb.project.sbromanshabalin.repositories;

import com.sb.project.sbromanshabalin.entities.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ContentRepository extends JpaRepository<Content, UUID>
{
    @Query(value = "select Cast(c.id as varchar) FROM content c " +
            "JOIN content_page cp on c.id = cp.content_id " +
            "JOIN page p on cp.page_id = p.id " +
            "WHERE p.name = ?1",
            nativeQuery = true)
    List<UUID> getAllContentsByPage(String name);
}