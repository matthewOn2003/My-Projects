package com.cinema_website.backend.service;

import com.cinema_website.backend.dto.CinemaDTO;
import com.cinema_website.backend.mapper.CinemaMapper;
import com.cinema_website.backend.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@SuppressWarnings("all")
@Service
public class CinemaService {

    private final CinemaRepository cinemaRepository;
    private final CinemaMapper cinemaMapper;

    @Autowired
    public CinemaService(CinemaRepository cinemaRepository, CinemaMapper cinemaMapper) {
        this.cinemaRepository = cinemaRepository;
        this.cinemaMapper = cinemaMapper;
    }

    // GET
    public CinemaDTO getCinema(int cinemaId) {
        return cinemaRepository.getCinemaById(cinemaId);
    }

    public List<CinemaDTO> getAllCinemas() {
        return cinemaRepository.getAllCinemas();
    }

    // INSERT
    public boolean addCinema(CinemaDTO cinema) {
        return cinemaRepository.addCinema(cinema);
    }

    // UPDATE
    public boolean updateCinema(int cinemaId, CinemaDTO updatedCinema) {
        return cinemaRepository.updateCinemaById(cinemaId, updatedCinema);
    }

    // DELETE
    public boolean deleteCinema(int cinemaId) {
        return cinemaRepository.deleteCinemaById(cinemaId);
    }

}
