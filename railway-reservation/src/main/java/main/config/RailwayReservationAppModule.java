package main.config;

import com.google.inject.AbstractModule;
import main.app.service.RailwayServiceImpl;
import main.app.service.RailwayService;

public class RailwayReservationAppModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(RailwayService.class).to(RailwayServiceImpl.class);
    }
}
