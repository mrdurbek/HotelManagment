package uz.hotel.springboothotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uz.hotel.springboothotel.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {
	
}
