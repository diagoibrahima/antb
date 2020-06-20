package com.atnb.africathenextbrain.dao;

import com.atnb.africathenextbrain.entities.Contribution;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.web.SortDefault;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RepositoryRestResource
public interface ContributionRepository extends JpaRepository<Contribution, Long > {

    @RestResource(path = "/byMessage")
    public List<Contribution> findByMessageContains(@Param("mc") String cont);

    @RestResource(path = "/byMessagePage")
    public Page<Contribution> findByMessageContains(@Param("mc") String cont, Pageable pageable);

   // @Secured("ROLE_MANAGER")
   // @RestResource(path = "/byDomainePage")
    public Page<Contribution> findByDomaineContains(@Param("mc") String cont,
                                                    @SortDefault(sort = "date_contrib", direction = Sort.Direction.ASC)
                                                    Pageable pageable);

    public Page<Contribution> findByIdUserContains(@Param("mc") String cont,
                                                    @SortDefault(sort = "date_contrib", direction = Sort.Direction.ASC)
                                                            Pageable pageable);


}
