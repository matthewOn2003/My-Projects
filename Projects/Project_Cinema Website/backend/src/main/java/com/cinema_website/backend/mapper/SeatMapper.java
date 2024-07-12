package com.cinema_website.backend.mapper;

import com.cinema_website.backend.model.Seat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SeatMapper {
    Seat getSeatById(int seatId);
    List<Seat> getAllSeats();
    List<Seat> getSeatsByHallId(int hallId);
    boolean addSeat(Seat seat);
    boolean updateSeatById(@Param("seatId") int seatId, @Param("seat") Seat seat);
    boolean deleteSeatById(int seatId);
}
