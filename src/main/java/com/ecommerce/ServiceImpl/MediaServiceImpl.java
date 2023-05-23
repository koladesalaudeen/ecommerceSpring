package com.ecommerce.ServiceImpl;

import com.ecommerce.DTO.MediaDTO;
import com.ecommerce.Entity.Media;
import com.ecommerce.Repository.MediaRepository;
import com.ecommerce.Service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MediaServiceImpl implements MediaService {
    MediaRepository mediaRepository;
    @Autowired
    MediaServiceImpl(MediaRepository mediaRepository){
        this.mediaRepository = mediaRepository;
    }
    @Override
    public void save(MediaDTO mediaDTO) {
        Media media = new Media(mediaDTO);
        mediaRepository.save(media);
    }

    @Override
    public void findByProductName(String name) {
        List<Media> media = mediaRepository.findByProductName(name);
        System.out.println(media);
    }

    @Override
    public List<Media> findAll() {
        return mediaRepository.findAll();
    }
}
