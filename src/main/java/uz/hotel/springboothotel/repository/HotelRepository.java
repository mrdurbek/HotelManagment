package uz.hotel.springboothotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uz.hotel.springboothotel.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer>{

}
