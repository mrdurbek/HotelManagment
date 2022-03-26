package uz.hotel.springboothotel.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uz.hotel.springboothotel.entity.Hotel;
import uz.hotel.springboothotel.repository.HotelRepository;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	HotelRepository hotelRepository;
	
	@GetMapping
	public List<Hotel> getHotels(){
		return hotelRepository.findAll();
	}
	
	@PostMapping
	public String addHotel(@RequestBody Hotel hotel) {
		if(hotelRepository.existsByName(hotel.getName())) {
			return "This hotel is already existed";
		}	
		hotelRepository.save(hotel);
		return "Succesfully existed";
	}
	
	@DeleteMapping("/{id}")
	public String deleteHotel(@PathVariable Integer id) {
		hotelRepository.deleteById(id);
		return "Succesfully deleted";
	}
	
	@PutMapping("/{id}")
	public String updateHotel(@PathVariable Integer id , @RequestBody Hotel hotel) {
		Optional<Hotel> optionalHotel = hotelRepository.findById(id);
		if(optionalHotel.isPresent()) {
			Hotel updatedHotel = optionalHotel.get();
			updatedHotel.setName(hotel.getName());
			hotelRepository.save(updatedHotel);
			return "Hotel is updated";
		}
		
		return "Error";
	}
}
