package hexagonal.architecture.adapter.persistence;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BankAccountRepository extends JpaRepository<BankAccountEntity, Long> {

	@Modifying
	 @Query(
		        value = ""
		            + "UPDATE account a "
		            + "a.balance = :balance "
		            + "WHERE a.id = :id "
		            + "RETURNING id",
		        nativeQuery = true
		    )
	Long update(@Param("id") Long id, BigDecimal balance); 
	
}

