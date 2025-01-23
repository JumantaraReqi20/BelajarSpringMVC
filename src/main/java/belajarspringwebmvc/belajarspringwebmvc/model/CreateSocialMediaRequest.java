package belajarspringwebmvc.belajarspringwebmvc.model;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
public class CreateSocialMediaRequest {
    private String name;
    private String location;
}
