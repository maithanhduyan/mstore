/**
 * @author Mai Thành Duy An
 */
package com.mstore.repositories.humanresource;

import org.springframework.data.repository.CrudRepository;

import com.mstore.entities.User;

public interface UserRepository extends CrudRepository<User, String> {

}
