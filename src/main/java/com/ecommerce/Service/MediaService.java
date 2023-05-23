package com.ecommerce.Service;

import com.ecommerce.DTO.MediaDTO;
import com.ecommerce.Entity.Media;

import java.util.List;

public interface MediaService {
    public void save(MediaDTO mediaDTO);
    public void findByProductName(String name);
    public List<Media> findAll();
}
