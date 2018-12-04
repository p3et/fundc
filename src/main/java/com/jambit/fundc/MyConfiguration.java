package com.jambit.fundc;

import com.jambit.fundc.picture.SavePicture;
import com.jambit.fundc.picture.SavePicturesDefault;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.jambit.fundc" })
public class MyConfiguration {

    @Bean
    public SavePicture savePicture() {
        return new SavePicturesDefault();
    }
}
