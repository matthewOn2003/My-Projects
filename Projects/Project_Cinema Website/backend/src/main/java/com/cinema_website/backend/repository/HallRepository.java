package com.cinema_website.backend.repository;

import com.cinema_website.backend.dto.HallDTO;
import com.cinema_website.backend.mapper.HallMapper;
import com.cinema_website.backend.model.Hall;
import com.cinema_website.backend.util.HallUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HallRepository {

    private final HallMapper hallMapper;

    public HallRepository(HallMapper hallMapper) {
        this.hallMapper = hallMapper;
    }

    // SELECT
    public HallDTO getHallById(int hallId) {
        try {
            Hall hall = hallMapper.getHallById(hallId);
            return HallUtils.toHallDTO(hall);
        } catch (Exception e) {
            System.out.println("ERORRRRRRR...");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public List<HallDTO> getAllHalls() {
        try {
            List<Hall> halls = hallMapper.getAllHalls();
            List<HallDTO> hallDTOs = new ArrayList<>();

            for (Hall hall : halls) {
                HallDTO element = HallUtils.toHallDTO(hall);
                hallDTOs.add(element);
            }

            return hallDTOs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<HallDTO> getHallsByCinemaId(int cinemaId) {
        try {
            List<Hall> halls = hallMapper.getHallsByCinemaId(cinemaId);
            List<HallDTO> hallDTOs = new ArrayList<>();

            for (Hall hall : halls) {
                HallDTO element = HallUtils.toHallDTO(hall);
                hallDTOs.add(element);
            }

            return hallDTOs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // INSERT
    public boolean addHall(HallDTO hall) {
        try {
            return hallMapper.addHall(HallUtils.toHall(hall));
        } catch (Exception e) {
            e.printStackTrace();
            return false; // return false indicates insertion failure
        }
    }

    // UPDATE
    public boolean updateHallById(int hallId, HallDTO updatedHall) {
        try {
            return hallMapper.updateHallById(hallId, HallUtils.toHall(updatedHall));
        } catch (Exception e) {
            e.printStackTrace();
            return false; // return false indicates update failure
        }
    }

    // DELETE
    public boolean deleteHallById(int hallId) {
        try {
            return hallMapper.deleteHallById(hallId);
        } catch (Exception e) {
            e.printStackTrace();
            return false; // return false indicates deletion failure
        }
    }
}
