package com.koyama.nameapp;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface NameMapper {

    @Select("SELECT * FROM names")
    List<Name> findAll();

    @Select("SELECT * FROM names WHERE name LIKE CONCAT(#{startsWith}, '%')")
    List<Name> findByNameStartingWith(String startsWith);

    @Select("SELECT * FROM names WHERE id = #{id}")
    Optional<Name> findById(Integer id);
}
