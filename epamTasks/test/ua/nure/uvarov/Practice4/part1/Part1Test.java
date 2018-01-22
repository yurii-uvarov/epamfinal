package ua.nure.uvarov.Practice4.part1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class Part1Test {
  private Part1 part1;
  @Before
    public void init(){
      part1 = new Part1();
  }
  @After
    public void tearDown(){
        part1 = null;
  }
  @Test
    public void upperThreeTest(){
      Assert.assertTrue(part1.upperThree("Oracle").equals("ORACLE"));
      Assert.assertTrue(part1.upperThree("on").equals("on"));
    }
    }





