package se2034jv_thanhdhhe194260_carrentingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se2034jv_thanhdhhe194260_carrentingsystem.entities.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {

    Customer findByEmail(String email);

    @Query("""
    SELECT C FROM Customer C WHERE (C.email = :email or C.account.accountName = :email) and C.password = :password
""")
    Customer findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
