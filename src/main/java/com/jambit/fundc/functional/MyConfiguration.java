package com.jambit.fundc.functional;

import com.jambit.fundc.functional.picture.SavePicture;
import com.jambit.fundc.functional.picture.SavePicturesDefault;
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
