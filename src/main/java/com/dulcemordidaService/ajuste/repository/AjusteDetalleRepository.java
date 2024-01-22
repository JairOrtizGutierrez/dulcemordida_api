package com.dulcemordidaService.ajuste.repository;

import com.dulcemordidaService.ajuste.entity.AjusteDetalle;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AjusteDetalleRepository extends JpaRepository<AjusteDetalle, Integer> {
    @Query(value = "select AD.id, P.id as productoId, P.nombre as productoNombre, M.nombre as productoMedida, AD.cantidad, ATP.nombre as tipo, AD.creadoPor\n" +
            "from ajustedetalle AD\n" +
            "inner join ajusteTipo ATP on ATP.id = AD.ajusteTipoId\n" +
            "inner join ajuste A on A.id = AD.ajusteId\n" +
            "inner join producto P on P.id = AD.productoId\n" +
            "inner join medida M on M.id = P.medidaId\n" +
            "where AD.ajusteId = :ajusteId", nativeQuery = true)
    List<Tuple> findByAjusteId(@Param("ajusteId") int ajusteId);

    @Query(value = "select AD.id, P.id as productoId, P.nombre as productoNombre, M.nombre as productoMedida, AD.cantidad, ATP.nombre as tipo, AD.creadoPor\n" +
            "from ajustedetalle AD\n" +
            "inner join ajusteTipo ATP on ATP.id = AD.ajusteTipoId\n" +
            "inner join ajuste A on A.id = AD.ajusteId\n" +
            "inner join producto P on P.id = AD.productoId\n" +
            "inner join medida M on M.id = P.medidaId\n" +
            "where AD.ajusteId = :ajusteId and P.nombre like %:productoNombre%", nativeQuery = true)
    List<Tuple> findByAjusteIdAndProductName(@Param("ajusteId") int ajusteId, @Param("productoNombre") String productoNombre);

    AjusteDetalle findById(@Param("ajusteDetalleId") int ajusteDetalleId);
}