package com.pinnacle.bus_booking.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.pinnacle.bus_booking.model.Locations;
import com.pinnacle.bus_booking.model.Route;

@Service
public class RouteService {

    @Autowired
    @Qualifier("postgresqlJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public List<Route> getAllRoutes() {

        String sql = " SELECT * FROM route";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Route.class));
    }

    public Route SaveRoutes(Route route) {
        String sql = "INSERT INTO route (source, destination, distance, duration) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, route.getSource(), route.getDestination(), route.getDistance(),route.getDuration());
        return route; 
    }

    public Route updateLocations(Route route) {
        String sql = "UPDATE route SET source = ?, destination = ?, distance = ?, duration = ? WHERE id = ?";
        jdbcTemplate.update(sql, route.getSource(), route.getDestination(), route.getDistance(),route.getDuration(),route.getId());
        return route;  
    }

    public void deleteLocations(int id) {
        String sql = "DELETE FROM route WHERE id = ?";
        jdbcTemplate.update(sql, id);  
    }
    
}
