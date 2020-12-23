package ru.stqa.software_testing.soap;

import com.lavasoft.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class GeoIpServiceTests {

  @Test
  public void  testMyIp(){

    String geoIp = new GeoIPService().getGeoIPServiceSoap12().getIpLocation20("109.252.14.154");
    System.out.println(geoIp);
    assertTrue(geoIp.contains("RU"));
  }

  @Test
  public void  testInvalidMyIp(){

    String geoIp = new GeoIPService().getGeoIPServiceSoap12().getIpLocation20("109.252.14.154");
    System.out.println(geoIp);
    assertFalse(geoIp.contains("UA"));

  }
}
