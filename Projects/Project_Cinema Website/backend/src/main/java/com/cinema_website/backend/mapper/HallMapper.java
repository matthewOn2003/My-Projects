package com.cinema_website.backend.mapper;

import com.cinema_website.backend.model.Hall;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HallMapper {
    Hall getHallById(int hallId);
    List<Hall> getAllHalls();
    List<Hall> getHallsByCinemaId(int cinemaId);

    boolean addHall(Hall hall);
    boolean updateHallById(@Param("hallId") int hallId, @Param("hall") Hall hall);
    boolean deleteHallById(int hallId);
}
