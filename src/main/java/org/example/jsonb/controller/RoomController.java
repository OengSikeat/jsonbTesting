package org.example.jsonb.controller;


import lombok.RequiredArgsConstructor;
import org.example.jsonb.model.Room;
import org.example.jsonb.model.request.RoomRequest;
import org.example.jsonb.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/room")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @GetMapping
    public List<Room> getAllRoom(){
        List <Room> rooms = roomService.getAllRoom();
        return rooms;
    }


    @PostMapping
    public Room createRoom(@RequestBody RoomRequest request){
        Room room = roomService.createRoom(request);
        return room;
    }
}
