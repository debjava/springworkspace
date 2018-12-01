/**
 * 
 */
package com.ddlab.rnd.spring.txn;

import com.ddlab.rnd.entities.Person;

/**
 * @author Debadatta Mishra (Piku)
 *
 */
public interface PersonDAO {
	
	public void create(Person person);
	
	public void update(Person person);
	
	public void delete(Person person);
	
	public Person getPersonById( int id );

}
