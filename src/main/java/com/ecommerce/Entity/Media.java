package com.ecommerce.Entity;

import com.ecommerce.DTO.MediaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String productName;
    private String image1;
    private String image2;
    private String image3;
    private String image4;
    private String image5;
    @OneToOne(mappedBy = "media")
    private ProductDetails productDetails;

    public Media(MediaDTO mediaDTO){
        this.image1 = mediaDTO.getImage1();
        this.image2 = mediaDTO.getImage2();
        this.image3 = mediaDTO.getImage3();
        this.image4 = mediaDTO.getImage4();
        this.image5 = mediaDTO.getImage5();
        this.productName = mediaDTO.getProductName();
    }
    public Media(String productName){
        this.productName = productName;
    }
    public Media(Long id){
        this.id = id;
    }
}
