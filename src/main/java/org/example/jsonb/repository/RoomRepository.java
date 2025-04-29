package org.example.jsonb.repository;

import org.apache.ibatis.annotations.*;
import org.example.jsonb.AppConfig.JSONBTypeHandler;
import org.example.jsonb.model.Room;
import org.example.jsonb.model.request.RoomRequest;

import java.util.List;


@Mapper
public interface RoomRepository {




    @Results(id = "roomMapper", value = {
            @Result(property = "images",column = "images",typeHandler = org.example.jsonb.AppConfig.JSONBTypeHandler.class)
    })
    @Select("""
        select * from pic;
    """)
    List<Room> getAllRoom();


    @ResultMap("roomMapper")
    @Select("""
        INSERT INTO pic (images)
        VALUES (#{images, typeHandler=org.example.jsonb.AppConfig.JSONBTypeHandler})
        RETURNING *;
    """)
    Room createRoom(RoomRequest request);
}
