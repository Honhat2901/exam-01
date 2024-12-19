package com.cg.repository;

import com.cg.model.Truong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TruongRepository extends JpaRepository<Truong, Long> {
    List<Truong> searchAllByTenTruongLikeOrDiaChiLikeOrSoDTLike(String tenTruong, String diaChi, String soDT);


    @Query(value = "SELECT tr FROM Truong AS tr " +
            "WHERE tr.tenTruong " +
            "LIKE :keyWord OR tr.diaChi " +
            "LIKE :keyWord OR tr.SoDT " +
            "LIKE :keyWord",
            nativeQuery = true
    )
    List<Truong> searchAllByKeyword(@Param("keyWord") String keyWord);
}
