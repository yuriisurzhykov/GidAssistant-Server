package com.yuriysurzhikov.gidassistant.di;

import com.sun.istack.NotNull;
import com.yuriysurzhikov.gidassistant.auth.LoginInitializer;
import com.yuriysurzhikov.gidassistant.controllers.city.CityEntityMapper;
import com.yuriysurzhikov.gidassistant.controllers.interests.InterestsEntityMapper;
import com.yuriysurzhikov.gidassistant.controllers.place.PlaceEntityMapper;
import com.yuriysurzhikov.gidassistant.controllers.routes.RouteEntityMapper;
import com.yuriysurzhikov.gidassistant.controllers.user.UserEntityMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class InjectionProvider {

    @Bean
    public static @NotNull
    UserEntityMapper getUserEntityMapper() {
        return new UserEntityMapper();
    }

    @Bean
    public static @NotNull
    InterestsEntityMapper getInterestsEntityMapper() {
        return new InterestsEntityMapper();
    }

    @Bean
    public static @NotNull
    CityEntityMapper getCityEntityMapper() {
        return new CityEntityMapper();
    }

    @Bean
    public static @NotNull
    RouteEntityMapper getRouteEntityMapper() {
        return new RouteEntityMapper();
    }

    @Bean
    public static @NotNull
    PlaceEntityMapper getPlaceEntityMapper() {
        return new PlaceEntityMapper();
    }

    @Bean
    public static @NotNull
    LoginInitializer getLoginInitializer() {
        return new LoginInitializer();
    }

}
