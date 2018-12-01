package com.ddlab.rnd.spring.txn;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;

public class WithResultTransactionCallbackImpl implements TransactionCallback<Person> {
	
	private String queryString;
	private Object[] params;
	private JdbcTemplate jdbcTemplate;
	
	public WithResultTransactionCallbackImpl( String queryString ,Object[] params , JdbcTemplate jdbcTemplate ) {
		
		this.queryString = queryString;
		this.params = params;
		this.jdbcTemplate = jdbcTemplate;
		
	}

	public Person doInTransaction( TransactionStatus txnStatus ) {
		
		Person p = jdbcTemplate.queryForObject(queryString, params , new PersonMapper() );

		return p;
	}
	
	//RowMapper implementation
		private class PersonMapper implements RowMapper {

			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				Person p = new Person();
				p.setId(rs.getInt("ID"));
				p.setFirstName(rs.getString("FIRSTNAME"));
				p.setLastName(rs.getString("LASTNAME"));
				return p;
			}
		}

}
