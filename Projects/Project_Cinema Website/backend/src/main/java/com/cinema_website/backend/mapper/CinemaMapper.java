package com.cinema_website.backend.mapper;

import com.cinema_website.backend.model.Cinema;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CinemaMapper {
    Cinema getCinemaById(int cinemaId);
    List<Cinema> getAllCinemas();
    boolean addCinema(Cinema cinema);
    boolean updateCinemaById(@Param("cinemaId") int cinemaId, @Param("cinema") Cinema cinema);
    boolean deleteCinemaById(int cinemaId);
}
