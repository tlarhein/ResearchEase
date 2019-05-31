package org.launchcode.models.data;

import org.launchcode.models.Instrument;
import org.springframework.data.repository.CrudRepository; //specifies methods that allow input and extraction of data from the database
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Tracey Cannon Liftoff 0519
 */

@Repository
@Transactional  //emphasizes that every method should be wrapped in a database transaction
public interface InstrumentDao extends CrudRepository<Instrument, Integer> {
}