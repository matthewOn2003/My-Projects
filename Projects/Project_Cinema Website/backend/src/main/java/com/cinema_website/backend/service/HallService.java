package com.cinema_website.backend.service;

import com.cinema_website.backend.dto.HallDTO;
import com.cinema_website.backend.mapper.HallMapper;
import com.cinema_website.backend.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallService {

    private final HallRepository hallRepository;
    private final HallMapper hallMapper;

    @Autowired
    public HallService(HallRepository hallRepository, HallMapper hallMapper) {
        this.hallRepository = hallRepository;
        this.hallMapper = hallMapper;
    }

    // GET
    public HallDTO getHall(int hallId) {
        return hallRepository.getHallById(hallId);
    }

    public List<HallDTO> getAllHalls() {
        return hallRepository.getAllHalls();
    }

    public List<HallDTO> getHallsByCinemaId(int cinemaId) {
        return hallRepository.getHallsByCinemaId(cinemaId);
    }



    // INSERT
    public boolean addHall(HallDTO hall) {
        return hallRepository.addHall(hall);
    }

    // UPDATE
    public boolean updateHall(int hallId, HallDTO updatedHall) {
        return hallRepository.updateHallById(hallId, updatedHall);
    }

    // DELETE
    public boolean deleteHall(int hallId) {
        return hallRepository.deleteHallById(hallId);
    }
}
