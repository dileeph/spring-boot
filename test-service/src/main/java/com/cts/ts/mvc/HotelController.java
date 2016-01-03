package com.cts.ts.mvc;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ts.domain.Hotel;
import com.cts.ts.repo.HotelRepository;

@RestController
@RequestMapping(value = "/hotels")
public class HotelController {

	@Autowired
	HotelRepository hotelRepository;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public com.cts.ts.dto.HotelDto getHotelById(@PathVariable Long id) {
		Hotel hotel =  hotelRepository.getOne(id);
		com.cts.ts.dto.HotelDto hotelDto = new com.cts.ts.dto.HotelDto();
		hotelDto.setAddress(hotel.getAddress());
		hotelDto.setName(hotel.getName());
		return hotelDto;
				
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void addHotel(@RequestBody com.cts.ts.dto.HotelDto hotel) {
		Hotel h = new Hotel();
		h.setAddress(hotel.getAddress());
		h.setName(hotel.getName());
		hotelRepository.save(h);
	}

	@RequestMapping(value = "/byname/{name}/page/{page}/size/{size}", method = RequestMethod.GET)
	@ResponseBody
	public Page<Hotel> searchByName(@NotBlank @PathVariable String name, @PathVariable Integer page,
			@PathVariable Integer size) {
		Pageable pageable = new PageRequest(page, size);

		return hotelRepository.findByNameLikeIgnoreCase(name, pageable);
	}

}
