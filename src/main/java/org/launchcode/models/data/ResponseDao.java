package org.launchcode.models.data;

import org.launchcode.models.Response;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Tracey Cannon Liftoff 0519
 */

@Repository
@Transactional
public interface ResponseDao extends CrudRepository<Response, Integer> {
}