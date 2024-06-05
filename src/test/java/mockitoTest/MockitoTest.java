package mockitoTest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

//@ExtendWith(MockitoExtension.class)
public class MockitoTest {
    @Mock
    List<String> mocklist;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName(value = "test")
    void test() {
        //1 cпособ
        when(mocklist.get(anyInt())).thenReturn("test 3");
        //2 способ
        //doReturn("test 4").when(mocklist).get(anyInt());
        Assertions.assertEquals("test 4", mocklist.get(3));
    }

    @Test
    void doThrowTest() {
        //   when(mocklist.add(anyString())).thenThrow(IllegalAccessError.class);
        //when(mocklist.set(anyInt(),anyString())).thenReturn("test3");
        //Assertions.assertThrows(NullPointerException.class , ()-> mocklist.add(anyString()));
        doThrow(IllegalAccessError.class).when(mocklist).set(anyInt(), anyString());
        Assertions.assertThrows(IllegalAccessError.class, () -> mocklist.set(anyInt(), anyString()));
    }

    @Test
    void answer() {
        doAnswer(invocation -> {
            Integer argument = invocation.getArgument(0);
            return argument * argument;
        }).when(mocklist).get(anyInt());
        Assertions.assertEquals(200, mocklist.get(10));
    }

    @Test
    void verify1() {
     /*   mocklist.add(anyString());
        mocklist.set(anyInt(), anyString());
        mocklist.clear();
        mocklist.clear();
        mocklist.clear();
        verify(mocklist, times(1)).add(anyString());
        verify(mocklist, times(1)).set(anyInt(), anyString());
        verify(mocklist,times(2)).clear();*/
        Mockito.verifyNoMoreInteractions(mocklist);

    }

    @Test
    void inoderTest(){
        mocklist.get(anyInt());
        mocklist.clear();
        mocklist.size();
        mocklist.hashCode();
        InOrder inOrder = inOrder(mocklist);
        inOrder.verify(mocklist).get(anyInt());
        inOrder.verify(mocklist).clear();
        inOrder.verify(mocklist).size();
        inOrder.verify(mocklist).hashCode();


    }
}
