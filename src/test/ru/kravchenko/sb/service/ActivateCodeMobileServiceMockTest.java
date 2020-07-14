package ru.kravchenko.sb.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.kravchenko.sb.api.repository.ActivateCodeMobileRepository;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ActivateCodeMobileServiceMockTest {

    @Mock
    private ActivateCodeMobileRepository activateCodeMobileRepository;

    @InjectMocks
    private ActivateCodeMobileService activateCodeMobileService;

    @Test
    public void getActivateCode(){
        when(activateCodeMobileRepository.getAllActivateCodeMobile()).thenReturn(Arrays.asList("1234", "4321"));
        System.out.println(activateCodeMobileService.generateActivateCode());
    }

    @Test
    public void testContains(){
        List<String> list = Arrays.asList("1", "2", "3");
        Assert.assertTrue(list.contains("1"));
        Assert.assertTrue(list.contains("2"));
        Assert.assertFalse(list.contains("4"));
        Assert.assertFalse(list.contains("5"));
    }

}
