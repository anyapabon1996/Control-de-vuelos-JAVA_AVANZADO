package com.session.three.fly.Fly.flyServiceTest;

import com.session.three.fly.Fly.Model.Entity.Fly;
import com.session.three.fly.Fly.Repository.FlyRepository;
import com.session.three.fly.Fly.Service.FlyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class FlyServiceTest {

    @InjectMocks
    private FlyService flyService;

    @Mock
    FlyRepository flyRepository;

    @Test
    void createNewFlyTest(){
        Fly fly = mock(Fly.class);
        when(this.flyRepository.save(fly)).thenReturn(fly);
        Fly flyCompare =flyService.createNewFly(fly);
        assertThat(fly).isEqualTo(flyCompare);
    }

    @Test
    void getFlyByCodeTest(){
        Fly fly = mock(Fly.class);
        String flyCode = "1A";
        when(this.flyRepository.getFlyByCode(flyCode)).thenReturn(fly);
        Fly flyCompare = flyService.getFlyByCode(flyCode);
        assertThat(fly).isEqualTo(flyCompare);
    }

    @Test
    void changeDatesTest(){
        LocalDate departure = LocalDate.now();
        LocalDate arraving = LocalDate.now();
        String flyCode = "1A";
        Fly fly = mock(Fly.class);

        when(this.flyRepository.getFlyByCode(flyCode)).thenReturn(fly);
        boolean result = flyService.changeDates(departure, arraving, flyCode);;
        assertTrue(result);
    }
}
