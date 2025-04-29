package org.example.jsonb.service.impl;


import lombok.RequiredArgsConstructor;
import org.example.jsonb.model.Room;
import org.example.jsonb.model.request.RoomRequest;
import org.example.jsonb.repository.RoomRepository;
import org.example.jsonb.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    @Override
    public Room createRoom(RoomRequest request) {
        return roomRepository.createRoom(request);
    }

    @Override
    public List<Room> getAllRoom() {
        return roomRepository.getAllRoom();
    }


}
