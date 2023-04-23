package org.example.ex08;

import org.assertj.core.api.Assertions;
import org.example.ex01.BmiCalculator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

public class MockitoTest {

    @Test
    void verifyMock(){
        List mockedList = mock();

        mockedList.add("John");

        verify(mockedList).add("John");
    }

    @Test
    void returnValue() {
        List mockedList = mock();
        when(mockedList.get(0)).thenReturn("Johny");

        Assertions.assertThat(mockedList.get(0)).isEqualTo("Johny");
    }

    @Test
    void throwException() {
        List<String> mockedList = mock();
        when(mockedList.get(0)).thenThrow(new RuntimeException());

        Assertions.assertThatThrownBy(() ->  BmiCalculator.calculateBmi(0, 0))
                .isInstanceOf(RuntimeException.class);
    }
}
