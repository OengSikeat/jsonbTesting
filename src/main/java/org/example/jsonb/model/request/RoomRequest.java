package org.example.jsonb.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.jsonb.model.ImageData;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomRequest {
    private Map<String, ImageDataRequest> images;
}
