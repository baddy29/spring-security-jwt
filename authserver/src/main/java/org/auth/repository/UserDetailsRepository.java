package org.auth.repository;

/**
 * Dummy jpa-repository , can be used
 * to interact with database*/
public interface UserDetailsRepository /* extends JpaRepository<UserEntity, String> */{

	/*
	 * @Query("Select u from USER u where u.emailId=:emailId") List<UserEntity>
	 * findByEmailId(@Param("emailId") String emailId);
	 */
	
}
