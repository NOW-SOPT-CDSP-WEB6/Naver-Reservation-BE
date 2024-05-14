package sopt.seminar.sopt.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.seminar.sopt.store.entity.Store;

public interface StoreJpaRepository extends JpaRepository<Store, Long> {

}
