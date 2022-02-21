package com.technews.repository;
import com.technews.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**An interface in Java is an abstract class that groups related empty methods.
 * To access these methods, one of the classes has to use the implement keyword
 * (instead of a keyword like extends that indicates inherited behavior).*/

/**A repository in Java is any class that fulfills the role of a data access object (DAO)—in other words,
it contains data retrieval, storage, and search functionality.*/
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByEmail(String email) throws Exception;

}
