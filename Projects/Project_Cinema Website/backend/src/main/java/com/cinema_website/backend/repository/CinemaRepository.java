package com.cinema_website.backend.repository;

import com.cinema_website.backend.dto.CinemaDTO;
import com.cinema_website.backend.mapper.CinemaMapper;
import com.cinema_website.backend.model.Cinema;
import com.cinema_website.backend.util.CinemaUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
@Repository
public class CinemaRepository {

    private final CinemaMapper cinemaMapper;

    public CinemaRepository(CinemaMapper cinemaMapper) {
        this.cinemaMapper = cinemaMapper;
    }

    // SELECT
    public CinemaDTO getCinemaById(int cinemaId) {
        Cinema cinema = cinemaMapper.getCinemaById(cinemaId);
        System.out.println(cinema);
        return CinemaUtils.toCinemaDTO(cinema);
    }

    public List<CinemaDTO> getAllCinemas() {
        try {
            List<Cinema> cinemas = cinemaMapper.getAllCinemas();
            List<CinemaDTO> cinemaDTOS = new ArrayList<>();

            for (Cinema cinema : cinemas) {
                CinemaDTO element = CinemaUtils.toCinemaDTO(cinema);
                cinemaDTOS.add(element);
            }
            System.out.println(cinemaDTOS);

            return cinemaDTOS;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // INSERT
    public boolean addCinema(CinemaDTO cinema) {
        try {
            return cinemaMapper.addCinema(CinemaUtils.toCinema(cinema));
        } catch (Exception e) {
            e.printStackTrace();
            return false; // 返回false表示插入失败
        }
    }

    // UPDATE
    public boolean updateCinemaById(int cinemaId, CinemaDTO updatedCinema) {
        try {
            return cinemaMapper.updateCinemaById(cinemaId, CinemaUtils.toCinema(updatedCinema));
        } catch (Exception e) {
            e.printStackTrace();
            return false; // 返回false表示更新失败
        }
    }

    // DELETE
    public boolean deleteCinemaById(int cinemaId) {
        try {
            return cinemaMapper.deleteCinemaById(cinemaId);
        } catch (Exception e) {
            e.printStackTrace();
            return false; // 返回false表示删除失败
        }
    }
}
