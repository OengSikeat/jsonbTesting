package org.example.jsonb.service;

import org.example.jsonb.model.Room;
import org.example.jsonb.model.request.RoomRequest;

import java.util.List;

public interface RoomService {
    Room createRoom(RoomRequest request);


    List<Room> getAllRoom();
}
