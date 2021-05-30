package com.umer.simplefakebank.repsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import com.umer.simplefakebank.entities.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {

	Optional<List<Operation>> findAllBySenderAccount_IdOrReceiverAccount_IdOrderByOperationDateTimeDesc(
			long senderAccount, long RecieverAccount);

}
