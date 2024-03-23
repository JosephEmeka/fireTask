import enumReflection.GeopoliticalZones;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class GeopoliticalZoneTest {
    @Test
    public void testGeopoliticalZonesExist() {
        GeopoliticalZones  myZone = GeopoliticalZones.NORTH_CENTRAL;
        System.out.println(Arrays.toString(myZone.getStates()));
    }

    @Test
    public void testThatStatesCanBegottenFromEnum(){
        String[] expected = {"NORTH_CENTRAL", "NORTHEAST", "NORTHWEST", "SOUTHEAST", "SOUTH_SOUTH", "SOUTHWEST"};
        GeopoliticalZones[] allZone;
        System.out.println(Arrays.toString( allZone = GeopoliticalZones.values()));

    }
}
