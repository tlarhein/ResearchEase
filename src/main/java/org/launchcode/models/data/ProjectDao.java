package org.launchcode.models.data;

import org.launchcode.models.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;



/**
 * created by Tracey Cannon Liftoff 0519
 */

@Repository
@Transactional
//keys to the dao interface are stored as integers, thus <Project, Integer>
public interface ProjectDao extends CrudRepository<Project, Integer> {
}
