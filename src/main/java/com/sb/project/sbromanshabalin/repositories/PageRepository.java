package com.sb.project.sbromanshabalin.repositories;

import com.sb.project.sbromanshabalin.entities.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PageRepository extends JpaRepository<Page, UUID>
{
    @Query(value = "SELECT DISTINCT name FROM PAGE",
            nativeQuery = true)
    List<String> findDistinctNames();
}
