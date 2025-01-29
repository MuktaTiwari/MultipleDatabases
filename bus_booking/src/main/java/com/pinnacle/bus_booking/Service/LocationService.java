package com.pinnacle.bus_booking.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.pinnacle.bus_booking.model.Locations;

@Service
public class LocationService {

    @Autowired
    @Qualifier("mysqlJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public List<Locations> getAllLocation() {
        
        String sql = "SELECT * FROM locations";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Locations.class));
    }

    public Locations saveLocation (Locations locations) {
        String sql = "INSERT INTO locations (name) VALUES (?)";
        jdbcTemplate.update(sql, locations.getName(), locations.getId());
        return locations; 
    }

    public Locations updateLocations(Locations locations) {
        String sql = "UPDATE locations SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, locations.getName(), locations.getId());
        return locations;  
    }

    public void deleteLocations(int id) {
        String sql = "DELETE FROM locations WHERE id = ?";
        jdbcTemplate.update(sql, id);  // Pass the id as the parameter to the query
    }


    
}
